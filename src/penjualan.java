import java.util.Scanner;
public class penjualan {
	int jml;
	String noresi,sku,nama_brg;
	Scanner sc= new Scanner(System.in);
	
	public penjualan () {
		
	}
	
    public void setnoresi(String noresi) {
        this.noresi = noresi;
    }

	public String noresi() {
		System.out.print("Noresi penjualan\t: ");
		noresi = sc.nextLine();
		return noresi;
	}
	
	public void setsku(String sku) {
        this.sku = sku;
    }
	
	public void setnama_brg(String nama_brg) {
        this.nama_brg = nama_brg;
    }
	
    public void setjumlah(int jml) {
        this.jml = jml;
    }

	public int jumlah() {
		System.out.print("Jumlah\t\t: ");
		jml = sc.nextInt();
		return jml;
	}
	
	public penjualan (String tgl, String noresi, String sku, String nama_brg,Integer jml) {
		this.setnoresi(noresi);
		this.setsku(sku);
        this.setnama_brg(nama_brg);
        this.setjumlah(jml);
    }
}
