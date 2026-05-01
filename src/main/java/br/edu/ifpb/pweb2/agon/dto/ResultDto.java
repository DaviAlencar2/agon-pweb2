package br.edu.ifpb.pweb2.agon.dto;

import br.edu.ifpb.pweb2.agon.models.Player;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ResultDto {

    private Player player;
    private BigDecimal score;
    private LocalDateTime createdAt;

}
