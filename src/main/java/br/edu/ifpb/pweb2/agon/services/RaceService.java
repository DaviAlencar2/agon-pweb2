package br.edu.ifpb.pweb2.agon.services;

import br.edu.ifpb.pweb2.agon.dto.RaceDto;
import br.edu.ifpb.pweb2.agon.models.Race;
import br.edu.ifpb.pweb2.agon.repository.RaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Race> allActiveRaces(){
        return raceRepository.findByActiveTrue();
    }

    public Race saveRace(RaceDto dto){

        Race race = modelMapper.map(dto, Race.class);
        raceRepository.save(race);

        return race;
    }

}
