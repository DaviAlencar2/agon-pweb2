package br.edu.ifpb.pweb2.agon.controllers;

import br.edu.ifpb.pweb2.agon.models.Race;
import br.edu.ifpb.pweb2.agon.repository.RaceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller()
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @GetMapping("/create")
    public String showCreateRace(Model model) {
        model.addAttribute("race", new Race());
        return "race/createRace";
    }

    @PostMapping("/create")
    public String saveNewRace(@Valid @ModelAttribute Race race, BindingResult result, Model model){

        if (result.hasErrors()){
            return "race/createRace";
        }

        raceRepository.save(race);
        return "redirect:/";
    }

}
