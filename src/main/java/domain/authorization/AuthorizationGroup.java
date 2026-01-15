package domain.authorization;

import java.util.List;

import domain.money.Money;

public class AuthorizationGroup implements AuthorizationItem {

	private final String description;
	private final List<AuthorizationItem> items;
	
	public AuthorizationGroup(
			final String description,
			final List<AuthorizationItem> items) {
		this.description = description;
		this.items = List.copyOf(items);
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public Money total() {
		Money total = Money.zero();
		for(AuthorizationItem item : this.items) 
			total = total.add(item.total());
		return total;
	}

}
