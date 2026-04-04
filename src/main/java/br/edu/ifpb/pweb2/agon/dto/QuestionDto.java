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
    private Integer answer;
}
