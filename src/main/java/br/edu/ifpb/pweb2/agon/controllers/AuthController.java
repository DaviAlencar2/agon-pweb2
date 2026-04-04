package br.edu.ifpb.pweb2.agon.controllers;

import br.edu.ifpb.pweb2.agon.dto.PlayerDto;
import br.edu.ifpb.pweb2.agon.models.Player;
import br.edu.ifpb.pweb2.agon.repository.PlayerRepository;
import br.edu.ifpb.pweb2.agon.services.PlayerService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/login")
    public String showLogin(Model model){
        model.addAttribute("playerDto", new PlayerDto());
        return "login";
    }

    // usa a funcao do service que retorna um player e injeta o nome dele na sessao http
    @PostMapping("/login")
    public String loginOrRegister(@Valid @ModelAttribute PlayerDto player, BindingResult result, Model model, HttpSession session){
        if (result.hasErrors()) return "login";

        Player playerLogged = playerService.loginOrRegisterPlayer(player);
        session.setAttribute("player", playerLogged);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
