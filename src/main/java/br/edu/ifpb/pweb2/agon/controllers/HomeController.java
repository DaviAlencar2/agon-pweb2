package br.edu.ifpb.pweb2.agon.controllers;

import br.edu.ifpb.pweb2.agon.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private RaceRepository raceRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("races", raceRepository.findAll());

        System.out.println(raceRepository.findAll());

        return "index";
    }
}