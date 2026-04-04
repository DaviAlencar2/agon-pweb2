package br.edu.ifpb.pweb2.agon.controllers;

import br.edu.ifpb.pweb2.agon.dto.RaceDto;
import br.edu.ifpb.pweb2.agon.models.Race;
import br.edu.ifpb.pweb2.agon.repository.RaceRepository;
import br.edu.ifpb.pweb2.agon.repository.QuestionRepository;
import br.edu.ifpb.pweb2.agon.services.RaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private RaceService raceService;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private QuestionRepository questionRepository;

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

       Race race = raceService.saveRace(raceDto);

        return "redirect:/race/" + race.getId() + "/questions/create";
    }

    @GetMapping("/{raceId}/details")
    public String showRaceDetails(@PathVariable Long raceId,Model model){
        Race race = raceRepository.findById(raceId).orElseThrow();
        model.addAttribute("race", race);
        model.addAttribute("questions", questionRepository.findByRace(race));
        return "race/raceDetails";
    };
}
