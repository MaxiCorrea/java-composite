package application.usecase;

import domain.authorization.Authorization;
import domain.money.Money;

public class CalculatedAuthorizedAmountUseCase {

	public Money execute(
			final Authorization authorization) {
		return authorization.totalAuthorizationAmount();
	}
}
