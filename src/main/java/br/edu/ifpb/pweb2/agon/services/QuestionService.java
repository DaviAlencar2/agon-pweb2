package br.edu.ifpb.pweb2.agon.services;

import br.edu.ifpb.pweb2.agon.dto.QuestionDto;
import br.edu.ifpb.pweb2.agon.models.Question;
import br.edu.ifpb.pweb2.agon.models.Race;
import br.edu.ifpb.pweb2.agon.repository.QuestionRepository;
import br.edu.ifpb.pweb2.agon.repository.RaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Question> findByRace(Race race) {
        return questionRepository.findByRace(race);
    }

    public void saveQuestion(QuestionDto dto, Long raceId) {

    }
}
