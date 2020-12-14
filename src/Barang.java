import java.util.Scanner;
public class Barang {
	int hb,hj,stok;
	String sku,nama,depart;
	Scanner sc= new Scanner(System.in);
	
	public Barang () {
		
	}
	
    public void setsku(String sku) {
        this.sku = sku;
    }

	public String sku() {
		System.out.print("SKU Barang\t: ");
		sku = sc.nextLine();
		return sku;
	}
	
	public void setnama(String nama) {
        this.nama = nama;
    }
	
	public String nama() {
		Scanner sc1= new Scanner(System.in);
		System.out.print("Nama Barang\t: ");
		nama = sc1.nextLine();
		return nama;
	}
	
	public void setdepart(String depart) {
        this.depart = depart;
    }
	
	public String depart() {
		Scanner sc2= new Scanner(System.in);
		System.out.print("Departement\t: ");
		depart = sc2.nextLine();
		return depart;
	}
	
	public void sethb(Integer hb) {
        this.hb = hb;
    }
	
	public int hb() {
		System.out.print("Harga Beli\t: Rp ");
		hb = sc.nextInt();
		return hb;
	}
	
	public void sethj(Integer hj) {
        this.hj = hj;
    }
	
	public int hj() {
		System.out.print("Harga Jual\t: Rp ");
		hj = sc.nextInt();
		return hj;
	}
	
	public void setstok(Integer stok) {
        this.stok = stok;
    }
	
	public int stok() {
		System.out.print("Stok\t\t: ");
		stok = sc.nextInt();
		return stok;
	}
	
	public Barang (String sku, String nama, String depart, Integer hb , Integer hj, Integer stok) {
        this.setsku(sku);
        this.setnama(nama);
        this.setdepart(depart);
        this.sethj(hj);
        this.sethb(hb);
        this.setstok(stok);
    }


}
