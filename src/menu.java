import java.sql.SQLException;
import java.util.Scanner;
public class menu {
	static void utama() throws SQLException {
		Scanner sc = new Scanner (System.in);
		System.out.println("+---SELAMAT DATANG DI SUPERMARKET SI---+");
		System.out.println("| Silahkan pilih menu dibawah berikut  |");
		System.out.println("| [1] Data Barang                      |");
		System.out.println("| [2] Re-Stock Barang                  |");
		System.out.println("+--------------------------------------+");
		System.out.print  ("Masukkan Pilihan : ");
		int utama = sc.nextInt();
		if (utama == 1) {
			menu1();
		} else if (utama ==2 ) {
			menu2();
		}
	}
	static void menu1 () throws SQLException {
		Scanner sc = new Scanner (System.in);
		boolean jalan=true;
		System.out.println("+-----------------------------------------------+");
		System.out.println("| SELAMAT DATANG DI DATA BARANG SUPERMARKET SI  |");
		System.out.println("| 1. Lihat Data Barang                          |");
		System.out.println("| 2. Tambah Barang Baru                         |");
		System.out.println("| 3. Edit Barang                                |");
		System.out.println("| 4. Hapus Barang                               |");
		System.out.println("| 5. Menu Utama                                 |");
		System.out.println("| 6. Keluar                                     |");
		System.out.println("+-----------------------------------------------+");
		while (jalan==true) {
			System.out.print("Masukkan pilihan : ");
			int menu1 = sc.nextInt();
			if (menu1==1) {
				db_barang.tampil();
			} else if (menu1 == 2) {
				db_barang.tambah();	
			} else if (menu1 == 3) {
				db_barang.edit();
			} else if (menu1 == 4) {
				db_barang.hapus();	
			} else if (menu1 == 5) {
				utama();
			} else if (menu1 == 6) {
				System.out.println("----PROGRAM SELESAI----");
				System.exit(0);
			} else {
				System.out.print("!!! Pilihan Tidak Tersedia !!!");
				System.out.println(" Masukkan pilihan [1-6]");
			}
		}
	}
	
	static void menu2 () {
		System.out.println("Menu2");
	}
}
