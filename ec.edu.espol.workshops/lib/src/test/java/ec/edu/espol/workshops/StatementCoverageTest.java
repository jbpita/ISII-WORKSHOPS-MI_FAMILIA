package ec.edu.espol.workshops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementCoverageTest {
	CarInsurance myInsurance = new CarInsurance();
	@Test void SC_00() {
		 myInsurance.setAll(81, 'M', true);
		 Assertions.assertEquals(myInsurance.computePremium(),-1);//CASE-ID: C01-T001
	}
	@Test void SC_01() {
		 myInsurance.setAll(21, 'M', false);
		 Assertions.assertEquals(myInsurance.computePremium(),2000);//CASE-ID: C01-T001
	}
	@Test void SC_02() {
		 myInsurance.setAll(50, 'F', true);
		 Assertions.assertEquals(myInsurance.computePremium(),200);//CASE-ID: C01-T001
	}

}
