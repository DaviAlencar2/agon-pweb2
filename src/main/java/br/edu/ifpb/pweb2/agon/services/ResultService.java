package br.edu.ifpb.pweb2.agon.services;

import br.edu.ifpb.pweb2.agon.dto.ResultDto;
import br.edu.ifpb.pweb2.agon.models.Result;
import org.modelmapper.ModelMapper;
import br.edu.ifpb.pweb2.agon.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Result saveResult(ResultDto dto){
        try {
            Result result = modelMapper.map(dto, Result.class);
            return resultRepository.save(result);
        }
        catch (Exception e) {
            throw new RuntimeException("Erro a salvar corrida:" + e.getMessage());
        }
    }

}
