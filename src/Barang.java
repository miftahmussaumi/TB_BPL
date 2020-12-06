import java.util.Scanner;
public class Barang {
	int id,hb,hj,stok;
	String nama;
	Scanner sc= new Scanner(System.in);
	
	public int id() {
		System.out.print("Id Barang\t: ");
		id = sc.nextInt();
		return id;
	}
	
	public String nama() {
		Scanner sc1= new Scanner(System.in);
		System.out.print("Nama Barang\t: ");
		nama = sc1.nextLine();
		return nama;
	}
	
	public int hb() {
		System.out.print("Harga Beli\t: Rp ");
		hb = sc.nextInt();
		return hb;
	}
	
	public int hj() {
		System.out.print("Harga Jual\t: Rp ");
		hj = sc.nextInt();
		return hj;
	}
	
	public int stok() {
		System.out.print("Stok\t\t: ");
		stok = sc.nextInt();
		return stok;
	}
}
