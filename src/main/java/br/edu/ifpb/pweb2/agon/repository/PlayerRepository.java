package br.edu.ifpb.pweb2.agon.repository;

import br.edu.ifpb.pweb2.agon.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByName(String name);
}