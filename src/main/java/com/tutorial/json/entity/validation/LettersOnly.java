package com.tutorial.json.entity.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/**
 * This is the custom validation. Field should contain only letters and no other symbols.
 * @author jreyb
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { LettersOnly.Validator.class })
public @interface LettersOnly {
	String message()

    default "Value should be letters only";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
	public static class Validator implements ConstraintValidator<LettersOnly, String> {
		@Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
			return value.chars().allMatch(Character::isLetter);
		}
	}
}
