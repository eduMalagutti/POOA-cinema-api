package br.ufscar.pooa.cinema_api.application.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.stream.Stream;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, Object> {
    private List<String> acceptedValues;
    private String errorMessage;

    @Override
    public void initialize(ValueOfEnum annotation) {
        this.acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .toList();

        this.errorMessage = "Invalid value. Accepted values are: [" +
                String.join(", ", acceptedValues) + "]";
    }

    @SuppressWarnings("IfCanBeSwitch")
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // deixa @NotNull lidar com nulos
        }

        if (value instanceof Enum) {
            return acceptedValues.contains(((Enum<?>) value).name());
        }

        if (value instanceof String) {
            return acceptedValues.contains(value.toString().toUpperCase());
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(this.errorMessage)
                .addConstraintViolation();

        return false;
    }
}
