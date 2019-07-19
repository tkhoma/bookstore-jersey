package com.tutorial.json.entity.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { LettersOnly.Validator.class })
public @interface LettersOnly {
	String message()

    default "Fruit serial number is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
	public static class Validator implements ConstraintValidator<LettersOnly, String> {
		@Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
//			if (value has number)
//				return false
			System.out.println("LettersOnly");
			return true;
		}
	}
}
