package br.edu.ifpb.pweb2.agon.session;

import java.time.Instant;
import java.util.List;

import br.edu.ifpb.pweb2.agon.models.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaceSession {
    private Long raceId;
    private List<Question> questions;
    private int currentIndex;
    private int correctAnswers;
    private Instant raceStartedAt;

    public RaceSession(Long raceId, List<Question> questions, int currentIndex, int correctAnswers, Instant raceStartedAt) {
        this.raceId = raceId;
        this.questions = questions;
        this.currentIndex = currentIndex;
        this.correctAnswers = correctAnswers;
        this.raceStartedAt = raceStartedAt;
    }
}
