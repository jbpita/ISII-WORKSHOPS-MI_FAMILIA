package ec.edu.espol.workshops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathCoverageTest {
	CarInsurance myInsurance = new CarInsurance();
	
	@Test void PC_03() {
		 myInsurance.setAll(20, 'M', false);
		 Assertions.assertEquals(myInsurance.computePremium(),2000);//CASE-ID: C01-T001
	 }
	
	@Test void PC_04() {
		 myInsurance.setAll(50, 'F', true);
		 Assertions.assertEquals(myInsurance.computePremium(),200);//CASE-ID: C01-T001
	 }
	
	@Test void PC_05() {
		 myInsurance.setAll(79, 'F', true);
		 Assertions.assertEquals(myInsurance.computePremium(),300);//CASE-ID: C01-T001
	 }
	
	@Test void PC_06() {
		 myInsurance.setAll(50, 'M', false);
		 Assertions.assertEquals(myInsurance.computePremium(),400);//CASE-ID: C01-T001
	 }
	
	@Test void PC_07() {
		 myInsurance.setAll(79, 'M', false);
		 Assertions.assertEquals(myInsurance.computePremium(),500);//CASE-ID: C01-T001
	 }
	
	@Test void PC_08() {
		 myInsurance.setAll(81, 'M', true);
		 Assertions.assertEquals(myInsurance.computePremium(),-1);//CASE-ID: C01-T001
	 }

}
