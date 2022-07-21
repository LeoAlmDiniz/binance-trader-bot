package com.br.leoalmdiniz.binancetraderbot.model.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import com.br.leoalmdiniz.binancetraderbot.model.validator.OpenTradeStrategyValidator;
import com.br.leoalmdiniz.binancetraderbot.model.validator.TrailingStopValidator;

@Documented
@Constraint(validatedBy = TrailingStopValidator.class)
@Target( { ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TrailingStopConstraint {
    String message() default "The proposed trailing stop violates a constraint. "
    		+ "The percent gain activation value should be greater than correction percentage to exit."
    ;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}