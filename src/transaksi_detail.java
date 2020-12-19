import java.util.Scanner;

public class transaksi_detail {
	int id, hj, jumlah;
	String sku, noresi;
	Scanner sc= new Scanner(System.in);
	
	public transaksi_detail () {
		
	}
	
    public void setid(Integer id) {
        this.id = id;
    }

	public Integer id() {
		System.out.print("ID Barang\t: ");
		id = sc.nextInt();
		return id;
	}
	
	public void setsku(String sku) {
	       this.sku = sku;
	    }

		public String sku() {
			System.out.print("SKU Barang\t: ");
			sku = sc.nextLine();
			return sku;
		}

	public void setnoresi(String noresi) {
		    this.noresi = noresi;
		}
	
	public String noresi() {
		System.out.print("No Resi Barang\t: ");
		noresi = sc.nextLine();
		return noresi;
	}
	
	public void sethj(Integer hj) {
        this.hj = hj;
    }
	
	public int hj() {
		System.out.print("Harga Jual\t: Rp ");
		hj = sc.nextInt();
		return hj;
	}
	
	public void setjumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
	
	public int jumlah() {
		System.out.print("Jumlah\t\t: ");
		jumlah = sc.nextInt();
		return jumlah;
	}
	
	public transaksi_detail (Integer id , Integer hj, String sku, String noresi, Integer jumlah) {
        this.setid(id);
        this.setsku(sku);
        this.setnoresi(noresi);
        this.setjumlah(jumlah);
        this.sethj(hj);
     
    }
}
