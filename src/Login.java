import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
	

	static Date date = new Date();
	static Scanner sc = new Scanner(System.in);
	
	public static int landingPage() {
		
		
		Integer pil = 0;
  		System.out.println("+============================================+");
  		System.out.println("+''''''''''''''''''''''''''''''''''''''''''''+");
  		System.out.println("|             SELAMAT DATANG DI              |");
  		System.out.println("|               SUPERMARKET SI               |");
  		System.out.println("+____________________________________________+");
  		System.out.println("+============================================+");
		System.out.println("|        "+date+"                            |");
		
	
		try {
	  		System.out.println("+============================================+");
	  		System.out.println("|            '' DAFTAR MENU ''               |");
	  		System.out.println("|____________________________________________|");
			System.out.println("| [1] Login                                  |");
	  		System.out.println("|____________________________________________|");
			System.out.println("| [2] Register                               |");
	  		System.out.println("|____________________________________________|");
			System.out.println("+============================================+");
			System.out.print("Pilih : ");

			pil = sc.nextInt();
		} 
		catch (InputMismatchException e) {
			System.out.println("Input yang anda masukkan salah");
		}
		
		return pil;
	}

}
