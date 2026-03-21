package br.edu.ifpb.pweb2.agon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("nome", "João");
        return "index"; // abre templates/index.html
    }
}