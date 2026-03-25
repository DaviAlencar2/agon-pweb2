package br.edu.ifpb.pweb2.agon.repository;

import br.edu.ifpb.pweb2.agon.models.Result;
import br.edu.ifpb.pweb2.agon.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findAllByOrderByScoreDesc();
    List<Result> findByPlayer(Player player);
}