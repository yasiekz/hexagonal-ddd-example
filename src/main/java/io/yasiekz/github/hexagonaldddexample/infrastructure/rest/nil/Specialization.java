package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.nil;

import java.util.List;
import java.util.Random;

/**
 * example specializations returned by external API
 */
public enum Specialization {

    B55,
    B12,
    B66;


    /**
     * Only for random response purposes
     */
    private static final List<Specialization> VALUES = List.of(values());
    private static final int SIZE = values().length;
    private static final Random RANDOM = new Random();

    public static Specialization random() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
