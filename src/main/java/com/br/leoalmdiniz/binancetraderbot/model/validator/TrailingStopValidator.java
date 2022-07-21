package com.br.leoalmdiniz.binancetraderbot.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.br.leoalmdiniz.binancetraderbot.model.TrailingStopModel;
import com.br.leoalmdiniz.binancetraderbot.model.constraint.TrailingStopConstraint;

public class TrailingStopValidator implements ConstraintValidator<TrailingStopConstraint, TrailingStopModel> {

	@Override
	public void initialize(TrailingStopConstraint trailingStop) {
	}

	@Override
  public boolean isValid(TrailingStopModel trailingStop, ConstraintValidatorContext cxt) {
      if (trailingStop == null) {
    	  return true;
      }
      if (trailingStop.getPercentGainToActivate().compareTo(trailingStop.getPercentCorrectionToClose()) > 0) {
    	  return true;
      }
      return false;
}

}