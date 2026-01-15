package domain.authorization;

import domain.money.Money;

public class MedicalService implements AuthorizationItem {

	private final String code;
	private final Money amount;
	
	public MedicalService(
			final String code,
			final Money amount) {
		this.code = code;
		this.amount = amount;
	}
	
	public String getCode() {
		return code;
	}
	
	@Override
	public Money total() {
		return amount;
	}

}
