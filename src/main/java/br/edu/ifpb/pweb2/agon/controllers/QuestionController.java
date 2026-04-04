package br.edu.ifpb.pweb2.agon.controllers;


import br.edu.ifpb.pweb2.agon.dto.QuestionDto;
import br.edu.ifpb.pweb2.agon.repository.RaceRepository;
import br.edu.ifpb.pweb2.agon.services.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/race/{raceId}/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private RaceRepository raceRepository;

    @GetMapping("/create")
    public String showCreateQuestion(@PathVariable Long raceId, Model model) {
        model.addAttribute("question", new QuestionDto());
        model.addAttribute("race", raceRepository.findById(raceId).orElseThrow());
        return "question/createQuestion";
    }

}