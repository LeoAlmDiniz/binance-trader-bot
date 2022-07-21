package com.br.leoalmdiniz.binancetraderbot.model.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.br.leoalmdiniz.binancetraderbot.model.OpenTradeStrategyModel;
import com.br.leoalmdiniz.binancetraderbot.model.constraint.OpenTradeStrategyConstraint;

public class OpenTradeStrategyValidator implements ConstraintValidator<OpenTradeStrategyConstraint, OpenTradeStrategyModel> {

	@Override
	public void initialize(OpenTradeStrategyConstraint tradeStrategy) {
	}

	@Override
	public boolean isValid(OpenTradeStrategyModel tradeStrategy, ConstraintValidatorContext cxt) {
		if (tradeStrategy == null) {
			return true;
		}
		if (Objects.isNull(tradeStrategy.getReinforceBehavior())) {
			return true;
		}
		if (!tradeStrategy.isCloseWhenConditionsRevert() && Objects.isNull(tradeStrategy.getStopLoss())) {
			return true;
		}
		return false;
	}

}