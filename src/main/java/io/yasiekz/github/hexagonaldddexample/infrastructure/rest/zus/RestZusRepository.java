package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.zus;

import java.time.LocalDate;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RestZusRepository implements ZusRepository {

    private static final Random random = new Random();
    private static final int MIN = 1;
    private static final int MAX = 100;

    public ZusInsuranceResponse getData(final String id) {

        return ZusInsuranceResponse.builder()
            .withId(id)
            .withInsuranceLvl(generateRandomNumberFromMintoMax())
            .withCreatedAt(LocalDate.of(2010, 10, 13))
            .build();
    }

    private int generateRandomNumberFromMintoMax() {
        return random.nextInt(MAX - MIN + 1) + MIN;
    }
}
