package com.br.leoalmdiniz.binancetraderbot.model.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.br.leoalmdiniz.binancetraderbot.model.validator.OpenTradeStrategyValidator;

@Documented
@Constraint(validatedBy = OpenTradeStrategyValidator.class)
@Target( { ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenTradeStrategyConstraint {
    String message() default "The proposed trade strategy violates a constraint. "
    		+ "The strategy should either:\n"
    		+ "1) not have any reinforce behavior;"
    		+ "2) if it has reinforce behavior, it should have no stop-loss and do not close when conditions revert."
    ;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}