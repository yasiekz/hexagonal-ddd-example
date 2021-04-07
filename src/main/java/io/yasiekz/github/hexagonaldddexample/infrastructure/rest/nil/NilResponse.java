package io.yasiekz.github.hexagonaldddexample.infrastructure.rest.nil;

import lombok.Builder;
import lombok.Value;

/**
 * Class represents example rest response from NIL (https://nil.org.pl/)
 */
@Value
@Builder(setterPrefix = "with")
public class NilResponse {

    long id;
    String name;
    Specialization specialization;
    String licenseNumber;
    String education;
}
