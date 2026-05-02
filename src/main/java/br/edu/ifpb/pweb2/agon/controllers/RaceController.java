package br.edu.ifpb.pweb2.agon.controllers;

import br.edu.ifpb.pweb2.agon.models.Player;
import br.edu.ifpb.pweb2.agon.models.Question;
import br.edu.ifpb.pweb2.agon.models.Result;
import br.edu.ifpb.pweb2.agon.repository.ResultRepository;
import br.edu.ifpb.pweb2.agon.session.RaceSession;
import br.edu.ifpb.pweb2.agon.dto.RaceDto;
import br.edu.ifpb.pweb2.agon.dto.AnswerDto;
import br.edu.ifpb.pweb2.agon.models.Race;
import br.edu.ifpb.pweb2.agon.repository.RaceRepository;
import br.edu.ifpb.pweb2.agon.repository.QuestionRepository;
import br.edu.ifpb.pweb2.agon.services.RaceService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;

@Controller()
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private RaceService raceService;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/create")
    public String showCreateRace(Model model) {
        model.addAttribute("raceDto", new RaceDto());
        return "race/createRace";
    }

    @PostMapping("/create")
    public String saveNewRace(@Valid @ModelAttribute RaceDto raceDto, BindingResult result, Model model){

        if (result.hasErrors()){
            return "race/createRace";
        }

        try {
            Race race = raceService.saveRace(raceDto);
            return "redirect:/race/" + race.getId() + "/questions/create";
        }

        catch (Exception e){
            result.reject("globalError",e.getMessage());
            return "race/createRace";
        }
    }

    @GetMapping("/{raceId}/details")
    public String showRaceDetails(@PathVariable Long raceId,Model model){
        Race race = raceRepository.findById(raceId).orElseThrow();
        model.addAttribute("race", race);
        model.addAttribute("questions", questionRepository.findByRace(race));
        return "race/raceDetails";
    };

    @GetMapping("/{raceId}/play")
    public String showPlayRace(@PathVariable Long raceId, Model model, HttpSession s, RedirectAttributes redirectAttributes){
        // TODO: Pensar em alguma maneira de nao ter que consultar o banco toda requisicao
        Race race = raceRepository.findById(raceId).orElseThrow();
        RaceSession raceSession = (RaceSession) s.getAttribute("raceSession");

        if (raceSession == null || !raceSession.getRaceId().equals(raceId)) {
            raceSession = new RaceSession(
                    race.getId(), race.getQuestions(), 0, 0, Instant.now()
            );
            s.setAttribute("raceSession", raceSession);
        }

        if (raceSession.getCurrentIndex() >= race.getQuestions().size()) {
            s.removeAttribute("raceSession");
            Result result = new Result();
            Player player = (Player) s.getAttribute("player");
            result.setPlayer(player);
            result.setRace(race);
            result.setCorrectAnswers(raceSession.getCorrectAnswers());
            result.setScore(raceSession.getCorrectAnswers());
            Result saved = resultRepository.save(result);
            return "redirect:/result/" + saved.getId();
        }

        model.addAttribute("currentQuestion", race.getQuestions().get(raceSession.getCurrentIndex()));
        model.addAttribute("raceTitle", race.getTitle());

        return "race/playRace";
    }

    @PostMapping("/{raceId}/play")
    public String playRace(@Valid @ModelAttribute AnswerDto answerDto,@PathVariable Long raceId, Model model, HttpSession s){
        Race race = raceRepository.findById(raceId).orElseThrow();

        RaceSession raceSession = (RaceSession) s.getAttribute("raceSession");
        Question question = race.getQuestions().get(raceSession.getCurrentIndex());

        if (answerDto.getAnswer() == question.getAnswer()) {
            int currentCorrectAnswers = raceSession.getCorrectAnswers();
            raceSession.setCorrectAnswers(currentCorrectAnswers + 1);
        }

        raceSession.setCurrentIndex(raceSession.getCurrentIndex() + 1 );

        return "redirect:/race/{raceId}/play";
    }
}
