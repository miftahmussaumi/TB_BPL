import java.util.Scanner;
public class penjualan {
	
	int tanggal;
	String noresi, username;
	Scanner sc= new Scanner(System.in);
	
	public penjualan () {
		
	}
	
    public void setnoresi(String noresi) {
        this.noresi = noresi;
    }

	public String noresi() {
		System.out.print("noresi penjualan\t: ");
		noresi = sc.nextLine();
		return noresi;
	}
	
	public void settanggal(Integer tanggal) {
	       this.tanggal = tanggal;
	    }

		public Integer tanggal() {
			System.out.print("Tanggal penjualan\t: ");
			tanggal = sc.nextInt();
			return tanggal;
		}

	public void setusername(String username) {
		    this.username = username;
		}
	
	public String username() {
		System.out.print("Username penjualan\t: ");
		username = sc.nextLine();
		return username;
	}
	
	public penjualan (Integer id , Integer hj, String sku, String noresi, Integer jumlah) {
        this.setnoresi(noresi);
        this.settanggal(tanggal);
        this.setusername(username);
     
    }
}
