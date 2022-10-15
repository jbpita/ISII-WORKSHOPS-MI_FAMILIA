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
		if(this.genre.equals("M") && !this.isMarried && this.age <25) {
	         price = price + 1500;
		}
		if(this.genre.equals("F") || this.isMarried) {
			price = price - 200;

		}
		if(this.age > 45 && this.age < 65) {
			price = price - 100;
	
		}
		return price;
	}
	
	//Executable main function with user-inputs validations
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int age = 0;
		String genre = "";
		boolean isMarried = false;
		boolean validLicense = false;
		
        System.out.println("Introducir la edad del cliente: ");
        boolean validAge = false;
        while(!validAge) {
        	try {
        		age = Integer.parseInt(sc.nextLine());
        		validAge = true;
        	}catch(NumberFormatException ex) {
        		System.out.println("La edad solo puede contener caracteres numéricos. Vuelva a intentarlo: ");
        	}
        }
        
        System.out.println("Introducir el genero del cliente. Intruzca M para masculino y F para femenino: ");
        boolean validGenre = false;
        while(!validGenre) {
        	genre = sc.nextLine();
        	if(genre.equals("M") || genre.equals("F")) {
        		validGenre = true;
        	}else {
        		System.out.println("Entrada inválida, vuelva a intentarlo.\nIntruzca M para masculino y F para femenino:");
        	}
        }
        
        System.out.println("¿El cliente está casado? Introduzca S para sí, N para no: ");
        boolean validMarital = false;
        while(!validMarital) {
        	String marital = sc.nextLine();
        	if(marital.equals("S")) {
        		isMarried = true;
        		validMarital = true;
        	}else if(marital.equals("N")){
        		isMarried = false;
        		validMarital = true;
        	}else {
        		System.out.println("Entrada inválida, vuelva a intentarlo.\nIntruzca S si el cliente es casado, N si no es casado: ");
        	}
        }
        
        
        System.out.println("Solicite la licencia de conducir del cliente y verifique su validez.\nSi la licencia es válida introduzca S para sí, N para no: ");
        boolean validInputLicense = false;
        while(!validInputLicense) {
        	String input = sc.nextLine();
        	if(input.equals("S")) {
        		validLicense = true;
        		validInputLicense = true;
        	}else if(input.equals("N")){
        		validLicense = false;
        		validInputLicense = true;
        	}else {
        		System.out.println("Entrada inválida, vuelva a intentarlo.\nIntruzca S si la licencia del cliente es válida, N si no es válida: ");
        	}
        }
        
        if(validLicense) {
        	CarInsurance cs = new CarInsurance(age, genre, isMarried);
            System.out.println("Calculando el monto para el cliente con" + cs.toString());
            int premium = cs.computePremium();
            if(premium > 0) {
            	System.out.println("Monto final del seguro Premium: $"+premium);
            }else {
            	System.out.println("El cliente no aplica para este seguro.");
            }
        }else {
        	System.out.println("De acuerdo a la ley nacional, el cliente requiere una licencia de conducir válida para comprar un seguro de auto.");
        }
        
    }
}
