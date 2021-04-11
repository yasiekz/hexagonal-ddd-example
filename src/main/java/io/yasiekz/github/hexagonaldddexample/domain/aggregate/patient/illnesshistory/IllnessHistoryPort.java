package io.yasiekz.github.hexagonaldddexample.domain.aggregate.patient.illnesshistory;

import java.util.List;

public interface IllnessHistoryPort {

    List<Illness> getIllnessHistory();

}
