package br.edu.ifpb.pweb2.agon.controllers;

import br.edu.ifpb.pweb2.agon.models.Result;
import br.edu.ifpb.pweb2.agon.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/{resultId}")
    public String showResult(@PathVariable Long resultId, Model model) {
        Result result = resultRepository.findById(resultId).orElseThrow();
        model.addAttribute("result", result);
        return "race/raceResult";
    }
}
