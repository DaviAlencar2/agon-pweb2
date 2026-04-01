package br.edu.ifpb.pweb2.agon.services;

import br.edu.ifpb.pweb2.agon.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;



}
