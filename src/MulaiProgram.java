import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;

public class MulaiProgram {

	static Scanner scn = new Scanner(System.in);
	static User user = new User();
	static Date date = new Date();
	
	public static void mulai() throws Exception{
//		int pilihan=0; 		
		switch (Login.landingPage()) {
		case 1:
			user.login();
			break;

		case 2:
			user.Register();
			break;
			
		default:
  			System.out.println("Pilihan Tidak Tersedia");
  			mulai();	
  				break;
		
			}
		}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		mulai();

	}

}
