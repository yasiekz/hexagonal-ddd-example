package io.yasiekz.github.hexagonaldddexample.domain.phonenumber;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@EqualsAndHashCode
@ToString
public class PhoneNumber {

    String value;

    private PhoneNumber(final String value) {

        if (!isValid(value)) {
            throw new IllegalArgumentException(String.format("Phone number %s is invalid", value));
        }

        this.value = value;
    }

    public static PhoneNumber of(final String phoneNumber) {
        return new PhoneNumber(phoneNumber);
    }

    private boolean isValid(final String phoneNumber) {

        final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            final Phonenumber.PhoneNumber parse = phoneUtil.parse(phoneNumber, null);
            return phoneUtil.isValidNumber(parse);
        } catch (NumberParseException e) {
            return false;
        }
    }
}
