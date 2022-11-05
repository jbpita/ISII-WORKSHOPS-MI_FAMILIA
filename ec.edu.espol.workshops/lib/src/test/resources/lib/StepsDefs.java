package lib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
public class StepsDefs {
 private String today;
 private String actualAnswer;
 @Given("today is Sunday")
 public void today_is_Sunday() {
 today = "Sunday";
 }
 @Given("today is {string}")
 public void today_is(String today) {
 this.today = today;
 }
 @Then("I should be told {string}")
 public void i_should_be_told(String expectedAnswer) {
 assertEquals(expectedAnswer, actualAnswer);
 }
}
