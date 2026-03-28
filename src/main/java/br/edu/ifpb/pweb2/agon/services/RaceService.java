package br.edu.ifpb.pweb2.agon.services;

import br.edu.ifpb.pweb2.agon.models.Race;
import br.edu.ifpb.pweb2.agon.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;

    public List<Race> allActiveRaces(){
        return raceRepository.findByActiveTrue();
    }

    public void saveRace(Race race){
        raceRepository.save(race);
    }

}
