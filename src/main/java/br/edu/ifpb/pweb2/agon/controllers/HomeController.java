package br.edu.ifpb.pweb2.agon.controllers;

import br.edu.ifpb.pweb2.agon.repository.RaceRepository;
import br.edu.ifpb.pweb2.agon.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private RaceService raceService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("races", raceService.allActiveRaces());
        return "index";
    }
}