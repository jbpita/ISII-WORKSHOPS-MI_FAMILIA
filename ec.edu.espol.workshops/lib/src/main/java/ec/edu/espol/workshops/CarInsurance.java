package ec.edu.espol.workshops;

import java.util.Scanner;

/**
* Javadoc. Class CarInsurance
*/
public class CarInsurance {
  //Class Attributes
  private int age;
  private char genre;
  private boolean isMarried;

  /**
  * Javadoc. Consructor CarInsurance
  */
  public CarInsurance(int age, char genre, boolean isMarried) {
    this.age = age;
    this.genre = genre;
    this.isMarried = isMarried;
  }
  
  public CarInsurance() {
	  
  }

  //Class Getters
  public int getAge() {
    return this.age;
  }

  public char getGenre() {
    return this.genre;
  }

  public boolean getMaritalIsMarried() {
    return this.isMarried;
  }

  //Class Setters
  public void setAge(int age) {
    this.age = age;
  }

  public void setGenre(char genre) {
    this.genre = genre;
  }
  
  public void setAll(int age, char genre, boolean isMarried) {
	  this.age = age;
	  this.genre = genre;
	  this.isMarried = isMarried;
  }

  public void setMaritalIsMarried(boolean isMarried) {
    this.isMarried = isMarried;
  }

  //toString Method
  @Override
  public String toString() {
    String st = "cliente con edad: " + age + ", genero: ";
    if (this.genre == 'M') {
      st = st + "Masculino, ";
    } else {
      st = st +  "Femenino, ";
    }
    st = st + "y estado civil: ";
    if (this.isMarried) {
      st = st + "Casado.";
    } else {
      st = st + "Soltero.";
    }
    return st;
  }

  /**
  * Javadoc. Premium computation method
  */
  public int computePremium() {
    if (this.age > 80) {
      return -1;
    }
    int price = 500;
    if (this.genre == 'M' && !this.isMarried && this.age < 25) {
      price = price + 1500;
    }
    if (this.genre == 'F' || this.isMarried) {
      price = price - 200;
    }
    if (this.age > 45 && this.age < 65) {
      price = price - 100;
    }
    return price;
  }
  
  /**
   * Javadoc. icheckAgeInput: Comprueba que la edad ingresada sea un numero positivo.
   * Si la entrada es v�lida retorna la edad como int; caso contrario retorna -1
   */
  public static int checkAgeInput(String input) {
	  int age;
	try {
	  age = Integer.parseInt(input);
	  if(age <= 0) {
		  return -1;
	  }
	  return age;
	} catch (NumberFormatException ex) {
	  return -1;
	}
  }
  
  /**
   * Javadoc. checkGenreInput: Comprueba que el genero ingresado corresponda a un
   * genero v�lido// Salida M|F
   */
  public static Character checkGenreInput(String input) {
	  if(input.length() > 1) {
		  return null;
	  }
	char genre = input.toUpperCase().charAt(0);
    if(genre != 'M' && genre != 'F') {
      return null;
    }else {
    	return input.toUpperCase().charAt(0);
    }
  }
  
  /**
   * Javadoc. checkYesNoInput: Comprueba si la entrada es S o N, retorna true y false respectivamente
   * retorna null si no corresponde a una a una entrada valida 
   */
  public static Boolean checkYesNoInput(String input) {
	  if(input.length() > 1) {
		 return null;
	  }
	  char charInput = input.toUpperCase().charAt(0);
	  if(charInput == 'S') {
		  return true;
	  }else if(charInput == 'N') {
		  return false;
	  }else {
		  return null;
	  }
  }
  
  
  
  /**
  * Javadoc. Executable main function with user-inputs validations
  */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int age = 0;
    String genre = "";
    boolean isMarried = false;
    boolean validLicense = false;
    
    
    System.out.println("Introducir la edad del cliente: ");
    int edad = -1;
    while (edad < 0) {
      age = checkAgeInput(sc.nextLine());
      if(age > 0) {
    	  break;
      }
      System.out.println("La edad solo puede contener caracteres numericos."
        + "Vuelva a intentarlo:");
    }
    
    
    System.out.println("Introducir el genero del cliente."
        + "Intruzca M para masculino y F para femenino:");
    Character genero = null;
    while (genero == null) {
      genero = checkGenreInput(sc.nextLine());
      if (genero != null) {
    	  break;
      }
    System.out.println("Entrada invalida, vuelva a intentarlo.\n Intruzca M para masculino y"
      + "F para femenino:");
    }
    
    
    System.out.println("El cliente es casado? Introduzca S para si, N para no: ");
    Boolean esCasado = null;
    while (esCasado == null) {
      esCasado = checkYesNoInput(sc.nextLine());
      if(esCasado != null) {
    	  break;
      }
      System.out.println("Entrada invalida, vuelva a intentarlo."
          + "\nIntruzca S si el cliente es casado, N si no es casado: ");
    }
    
    
    System.out.println("Solicite la licencia de conducir del cliente y verifique su validez."
        + "\nSi la licencia es valida introduzca S para si, N para no: ");
    Boolean licenciaValida = null;
    while (licenciaValida == null) {
      licenciaValida = checkYesNoInput(sc.nextLine());
      if(licenciaValida != null) {
    	  break;
      }
      System.out.println("Entrada invalida, vuelva a intentarlo."
        + "\nIntruzca S si la licencia del cliente es valida, N si no es valida: ");
    }
    
    
    if (true) {
      CarInsurance cs = new CarInsurance(edad, genero, esCasado);
      System.out.println("Calculando el monto para el cliente con" + cs.toString());
      int premium = cs.computePremium();
      if (premium > 0) {
        System.out.println("Monto final del seguro Premium: $" + premium);
      } else {
        System.out.println("El cliente no aplica para este seguro.");
      }
    } else {
      System.out.println("De acuerdo a la ley nacional, el cliente requiere una licencia"
          + "de conducir valida para comprar un seguro de auto.");
    }
    sc.close();
  }
}