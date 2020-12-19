import java.sql.SQLException;
import java.util.Scanner;
public class menu {
	private static String anotherString;
	static User user = new User();
	static void utama() throws SQLException {
		Scanner sc = new Scanner (System.in);
		System.out.println("+--------------------------------------+");
		System.out.println("| Silahkan pilih menu dibawah berikut  |");
		System.out.println("| [1] Lihat Data Barang                |");
		System.out.println("| [2] Re-Stock Barang                  |");
		System.out.println("| [3] Transaksi Penjualan              |");
		System.out.println("| [4] Ke Menu Utama                    |");
		System.out.println("| [5] Logout                           |");
		System.out.println("+--------------------------------------+");
		System.out.print  ("Masukkan Pilihan : ");
		int utama = sc.nextInt();
		if (utama == 1) {
			menu1();
		} else if (utama ==2 ) {
			db_barang.tbstock();
		} else if (utama ==3 ) {
			menu2();
		} else if (utama ==4) {
			user.user_menu();
		} else if (utama==5) {
			user.logout();
		}
	}
	static void menu1 () throws SQLException {
		Scanner sc = new Scanner (System.in);
		Scanner sc2 = new Scanner (System.in);
		boolean jalan=true;
		while (jalan==true) {
			System.out.println("\n DATA BARANG SUPERMARKET SI");
			System.out.println("+--------------------------+");
			System.out.println("| 1. Lihat Data Barang     |");
			System.out.println("| 2. Tambah Barang Baru    |");
			System.out.println("| 3. Edit Barang           |");
			System.out.println("| 4. Hapus Barang          |");
			System.out.println("| 5. Cari Barang           |");
			System.out.println("| 6. Menu Utama Barang     |");
			System.out.println("| 7. Logout                |");
			System.out.println("+--------------------------+");
			System.out.print("Masukkan pilihan : ");
			int menu1 = sc.nextInt();
			switch (menu1) {
			case 1:
				db_barang.tampil();
				break;
			case 2:
				db_barang.tambah();	
				break;
			case 3:
				db_barang.edit();
				break;
			case 4:
				db_barang.hapus();
				break;
			case 5:
				cariBarang.cari();
				break;
			case 6:
				utama();
				break;
			case 7:
				user.logout();
				break;
			default :
			}
			System.out.print("Apakah anda ingin melanjutkan? [y/n]  ");
			String next = sc2.nextLine();
			String lanjut = "y";
			jalan = next.equalsIgnoreCase(lanjut);
			if (jalan==false) {
				user.user_menu();
			}
		}
	}
	
	static void menu2 () throws SQLException {
		Scanner sc3 = new Scanner (System.in);
		Scanner sc4 = new Scanner (System.in);
		boolean jalan2=true;
		while (jalan2==true) {
			System.out.println("\n DATA BARANG SUPERMARKET SI");
			System.out.println("+--------------------------+");
			System.out.println("| 1. Input Transaksi       |");
			System.out.println("| 2. Lihat Transaksi Detail|");
			System.out.println("| 3. Menu Utama            |");
			System.out.println("| 4. Keluar                |");
			System.out.println("+--------------------------+");
			System.out.print("Masukkan pilihan : ");
			int menu2 = sc3.nextInt();
			switch (menu2) {
			case 1:
				db_transaksi.tambah1();
				break;
			case 2:
				db_transaksi.tampil1();
				break;
			case 3:
				utama();
				break;
			case 4:
				System.out.println("----PROGRAM SELESAI----");
				System.exit(0);
				break;
			default :
			}
			System.out.print("Apakah anda ingin melanjutkan? [y/n]  ");
			String next = sc4.nextLine();
			String lanjut = "y";
			jalan2 = next.equalsIgnoreCase(lanjut);
			if (jalan2==false) {
				System.out.println("=======================================");
				System.out.println("            PROGRAM KELUAR             ");
				System.out.println("=======================================");
			}
		}
	}
}

