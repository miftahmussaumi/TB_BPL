import java.util.Scanner;
public class Barang {
	int hb,hj,stok,id_kate;
	String sku,nama,kategori;
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
	
	public void setkodekat (int id_kate) {
        this.id_kate = id_kate;
    }
	
	//method dari implementasi class buku
	public int kode_kate() {
		boolean next = true;
		System.out.println("+---Id Kategori Buku---+");
		System.out.println("| 1. Food              |");
		System.out.println("| 2. Non Food          |");
		System.out.println("| 3. House Hold        |");
		System.out.println("+----------------------+");
		Scanner a2 = new Scanner(System.in);
		while (next == true) {
			System.out.print("Kode Kategori\t: ");
			id_kate = a2.nextInt();
			if (id_kate == 1){
				kategori="Food";
				next=false;
			} else if (id_kate == 2) {
				kategori="Non Food";
				next=false;
			} else if (id_kate == 3) {
				kategori="House Hold";
				next=false;
			} else {
				System.out.println("-----------------------------------");
				System.out.println("\t\tERROR !!");
				System.out.println("--Id kategori tidak tersedia--");
				System.out.println("--Masukkan kembali id yang benar!--");
				System.out.println("-----------------------------------");
			}
		}
		return id_kate;
	}
	
	public void setkat (String kategori) {
        this.kategori = kategori;
    }
	
	//method dari implementasi class buku
	public String kategori() {
		System.out.print("Kategori\t: "+kategori);
		System.out.println();
		return kategori;
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
	
	public Barang (String sku, String nama, Integer hb , Integer hj, Integer stok) {
        this.setsku(sku);
        this.setnama(nama);
        this.sethj(hj);
        this.sethb(hb);
        this.setstok(stok);
    }


}
