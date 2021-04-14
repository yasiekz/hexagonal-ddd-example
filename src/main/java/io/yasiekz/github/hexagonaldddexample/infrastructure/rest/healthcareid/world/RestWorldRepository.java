package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.healthcareid.world;

import java.time.LocalDate;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RestWorldRepository implements WorldRepository {

    private static final Random random = new Random();

    public WorldInsuranceResponse getData(final String id) {

        return WorldInsuranceResponse.builder()
            .withId(id)
            .withDateOfBirth(
                LocalDate.of(generateRandomNumberFromMintoMax(1900, 2021), 6, generateRandomNumberFromMintoMax(1, 25)))
            .build();
    }

    private int generateRandomNumberFromMintoMax(final int min, final int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
