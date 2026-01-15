package domain.authorization;

import java.util.List;

import domain.money.Money;

public class Authorization {

	private final List<AuthorizationItem> items;
	
	public Authorization(
			final List<AuthorizationItem> items) {
		this.items = List.copyOf(items);
	}
	
	public Money totalAuthorizationAmount() {
		Money total = Money.zero();
		for(AuthorizationItem item : this.items) 
			total = total.add(item.total());
		return total;
	}
	
}
