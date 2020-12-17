import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;

public class MulaiProgram {

	static Scanner scn = new Scanner(System.in);
	static User user = new User();
	static Date date = new Date();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean jalan=true;
		while (jalan==true) {
		int pilihan; 		
		switch (Login.landingPage()) {
		case 1:
			user.login();
			break;

		case 2:
			user.Register();
			break;
			
		default:
			Scanner scn2 = new Scanner(System.in);
  			System.out.println("Pilihan Tidak Tersedia");
  			System.out.print("Apakah anda ingin melanjutkan? [y/n]  ");
			String next = scn2.nextLine();
			String lanjut = "y";
			System.out.println();
			jalan = next.equalsIgnoreCase(lanjut);
			if (jalan==false) {
				user.user_menu();
			}
  				break;
		}
		}
	}

}
