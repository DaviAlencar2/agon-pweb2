package br.edu.ifpb.pweb2.agon.services;

import br.edu.ifpb.pweb2.agon.models.Player;
import br.edu.ifpb.pweb2.agon.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // Vai retornar um player seja um existente ou o novo criado
    public Player loginOrRegisterPlayer(Player player) {
        Player existingPlayer = playerRepository.findByName(player.getName());
        if (existingPlayer != null) return existingPlayer;

        return playerRepository.save(player);
    }
}
