package domain.money;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

	public static Money zero() {
		return new Money(BigDecimal.ZERO);
	}

	public static Money of(
			final BigDecimal value) {
		return new Money(value);
	}
	
	private final BigDecimal amount;
	
	public Money(
			final BigDecimal amount) {
		this.amount = amount;
	}
		
	public Money add(
			final Money other) {
		return new Money(this.amount.add(other.amount));
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return Objects.equals(amount, other.amount);
	}
	
}
