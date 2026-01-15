package domain.authorization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.money.Money;

class AuthorizationTest {

	@Test
	void shouldCalculateAuthorizedAmountForComplexMedicalAuthorization() {
		MedicalService consultation = new MedicalService("CONSULT", Money.of(new BigDecimal("500")));
		MedicalService surgery = new MedicalService("SURGERY", Money.of( new BigDecimal("10000")));
		MedicalService medication = new MedicalService("MED", Money.of( new BigDecimal("1200")));
		MedicalService control = new MedicalService("CONTROL", Money.of(new BigDecimal("400")));
		AuthorizationGroup surgeryPackage = new AuthorizationGroup("Ambulatory Surgery", List.of(surgery, medication, control));
		Authorization authorization = new Authorization(List.of(consultation, surgeryPackage));
		Money total = authorization.totalAuthorizationAmount();
		Money expected = Money.of(new BigDecimal("12100"));
		assertEquals(expected, total);
	}

}
