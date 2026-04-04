package br.edu.ifpb.pweb2.agon.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDto {

    @NotBlank
    private String statement;

    // 4 opções fixas como campos separados — mais simples de bindá com Thymeleaf
    @NotBlank
    private String option1;
    @NotBlank
    private String option2;
    @NotBlank
    private String option3;
    @NotBlank
    private String option4;

    @NotNull
    @Min(0) @Max(3)
    private Integer answer; // índice da opção correta (0 a 3)
}
