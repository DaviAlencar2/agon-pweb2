package br.edu.ifpb.pweb2.agon.repository;

import br.edu.ifpb.pweb2.agon.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RaceRepository extends JpaRepository<Race, Long> {

    List<Race> findByActiveTrue();
}