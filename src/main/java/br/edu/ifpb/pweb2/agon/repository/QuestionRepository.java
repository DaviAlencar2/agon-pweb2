package br.edu.ifpb.pweb2.agon.repository;

import br.edu.ifpb.pweb2.agon.models.Question;
import br.edu.ifpb.pweb2.agon.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByRace(Race race);
}