package ec.edu.espol.workshops;
import java.util.Scanner;

public class CarInsurance {
	//Class Attributes
	private int age;
	private String genre;
	private boolean isMarried;
	
	//Class constructor
	public CarInsurance(int age, String genre, boolean isMarried) {
		this.age = age;
		this.genre = genre;
		this.isMarried = isMarried;
	}
	
	//Class Getters
	public int getAge() {
		return this.age;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public boolean getMaritalIsMarried() {
		return this.isMarried;
	}
	
	//Class Setters
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setMaritalIsMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	//toString Method
	@Override
	public String toString() {
		String st = "cliente con edad: " + age + ", genero: ";
		if(this.genre.equals("M")) {
			st = st + "Masculino, ";
		}else {
			st = st +  "Femenino, ";
		}
		st = st + "y estado civil: ";
		if(this.isMarried) {
			st = st + "Casado.";
		}else {
			st = st + "Soltero.";
		}
		
		return st;
	}
	
	//Premium computation Method
	public int computePremium() {
		if(this.age > 80) {
			return -1;
		}
		int price = 500;
		if(this.genre == "M" && !this.isMarried && this.age <25) {
			price = price + 1500;
		}
		if(this.genre == "F" || this.isMarried) {
			price = price - 200;
		}
		if(this.age > 45 && this.age < 65) {
			price = price - 100;
		}
		return price;
	}
	
	//Executable main function with user-inputs validations
	public static void main(String[] args) {
		//INCLUDE MAIN LOGIC HERE

        
    }
}
