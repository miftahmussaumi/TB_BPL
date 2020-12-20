import java.util.Scanner;
public class penjualan {
	int jml;
	String noresi,sku;
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
	
    public void setjumlah(int jml) {
        this.jml = jml;
    }

	public int jumlah() {
		System.out.print("Jumlah\t\t: ");
		jml = sc.nextInt();
		return jml;
	}
	
	public penjualan (Integer id , String sku, String noresi, Integer jumlah,Integer harga) {

    }
}
