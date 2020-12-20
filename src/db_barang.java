import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class db_barang extends connection {
	
	public static void tampil() throws SQLException {
		conn();
		stmt = conn.createStatement();
		String sql = " SELECT *,kategori FROM barang INNER JOIN kategori ON barang.id_kate = kategori.id_kate";
		result = stmt.executeQuery(sql);
		
		System.out.println("\n+==========================================================+");
		System.out.println("\t\tDATA BARANG SUPERMARKET SI");
		System.out.println("+==========================================================+");
		while (result.next()) {
			String SKU = result.getString("sku");
			String nama_brg = result.getString("nama_brg");
			String kate = result.getString("kategori");
			Integer h_beli = result.getInt("h_beli");
			Integer h_jual = result.getInt("h_jual");
			Integer stok = result.getInt("stok");
				
			System.out.println("SKU Barang  : "+SKU);
			System.out.println("Nama Barang : "+nama_brg);
			System.out.println("Kategori    : "+kate);
			System.out.println("Harga Beli  : Rp "+h_beli);
			System.out.println("Harga Jual  : Rp "+h_jual);
			System.out.println("Jumlah Stok : "+stok);
			System.out.println("+----------------------------------------------------------+");
		}
		System.out.println();
	}
	
	public static void tambah() throws SQLException {
		conn();
		Barang brg = new Barang();
		System.out.println("\n+==========================================================+");
		System.out.println("\t\tDTAMBAH ATA BARANG SUPERMARKET SI");
		System.out.println("+==========================================================+");
		brg.sku();
		brg.nama();
		brg.kode_kate();
		brg.kategori();
		brg.hb();
		brg.hj();
		brg.stok();
		
		String sql = "INSERT INTO barang VALUES " + 
		"('"+brg.sku+"','"+brg.nama+"','"+brg.id_kate+"','"+brg.hb+"','"+brg.hj+"','"+brg.stok+"')";
		
		try {
			stmt= conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("\n       BARANG BERHASIL DITAMBAHKAN       ");
			System.out.println("+---------------------------------------+");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void edit () throws SQLException {
		conn();
		Barang brg = new Barang();
		Scanner sc= new Scanner (System.in);
		System.out.println("\n+==========================================================+");
		System.out.println("\t\tEDIT DATA BARANG SUPERMARKET SI");
		System.out.println("+==========================================================+");
		System.out.print  ("SKU Barang\t: ");
		String id = sc.nextLine();
		brg.nama();
		brg.kode_kate();
		brg.kategori();
		brg.hb();
		brg.hj();
		brg.stok();
		
		String sql = "UPDATE barang SET " + "nama_brg = '"+brg.nama+"', "
										+ "id_kate='"+brg.id_kate+"',"
										+ "h_beli='"+brg.hb+"',"
										+ "h_jual='"+brg.hj+"',"
										+ "stok='"+brg.stok+"'"
					+ "WHERE sku = '"+id+"'";
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("\n        BARANG BERHASIL DIEDIT       ");
			System.out.println("+---------------------------------------+");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void hapus () throws SQLException{
		conn();
		Scanner sc= new Scanner (System.in);
		System.out.println("\n+==========================================================+");
		System.out.println("\t\tHAPUS DATA BARANG SUPERMARKET SI");
		System.out.println("+==========================================================+");
		System.out.print("SKU Barang\t: ");
		String hapus = sc.nextLine();

		String sql = "DELETE FROM barang WHERE sku = '"+hapus+"'";
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("\n       BARANG BERHASIL DIHAPUS       ");
			System.out.println("+---------------------------------------+");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList <Barang> cari (int find){
		conn();
		ArrayList <Barang> listbarang = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM barang WHERE id_kate ='"+find+"'";
			stmt=conn.createStatement();
			result=stmt.executeQuery(sql);
				
			while (result.next()) {
				Barang barang = new Barang (
					result.getString("sku"),
					result.getString("nama_brg"),
					result.getInt("h_beli"),
					result.getInt("h_jual"),
					result.getInt("stok")
				);
			listbarang.add(barang);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listbarang;
	}
	
	static db_barang db_cari = new db_barang ();
	public static void cari() throws SQLException {
		conn();
		Scanner in = new Scanner (System.in);
		System.out.println("\n+=======================================+");
		System.out.println("   CARI DATA BUKU PERPUSTAKAAN CORON");
		System.out.println("+=======================================+");
		System.out.println("+---Id Kategori Buku---+");
		System.out.println("| 1. Food              |");
		System.out.println("| 2. Non Food          |");
		System.out.println("| 3. House Hold        |");
		System.out.println("+----------------------+");
		System.out.print  ("Kode Kategori : ");
		int find = in.nextInt();
		System.out.println("============================================================");
		if (find == 1){
			System.out.println("\t\tKategori : Food");
		} else if (find == 2) {
			System.out.println("\t\tKategori : Non Food");
		} else if (find == 3) {
			System.out.println("\t\tKategori : House Hold");
		} else {
			System.out.println("\t\tKode Kategori tidak valid!");
		}
		System.out.println("============================================================");
		
		ArrayList<Barang>listbarang = db_cari.cari(find);
		
		for(Barang barang : listbarang){
			System.out.println("SKU Barang  : "+barang.sku);
            System.out.println("Nama Barang : "+barang.nama);
            System.out.println("Harga Beli  : Rp "+barang.hb);
            System.out.println("Harga Jual  : Rp "+barang.hj);
            System.out.println("Stok        : "+barang.stok);
            System.out.println("+----------------------------------------------------------+");
        }
		
	}
	
	public static void tbstock() throws SQLException{
		conn();
		Scanner sc = new Scanner (System.in);
		System.out.println("\n+==========================================================+");
		System.out.println("\t\tTAMBAH STOCK BARANG SUPERMARKET SI");
		System.out.println("+==========================================================+");
		System.out.print  ("SKU Barang\t: ");
		String sku = sc.nextLine();
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM barang WHERE sku = '"+sku+"'";
			result = stmt.executeQuery(sql);
			if (result.next()) {
				String id = result.getString("sku");
				Integer stok_db = result.getInt("stok");
				System.out.print("Penambahan\t : ");
				Integer tambah = sc.nextInt();
				int newstock = Integer.valueOf(stok_db)+Integer.valueOf(tambah);
				String sql2 = "UPDATE barang SET stok = '"+newstock+"' WHERE sku='"+sku+"'";
				stmt.execute(sql2);
				stmt.close();
			}
			System.out.println("\n      STOCK BERHASIL DITAMBAHKAN       ");
			System.out.println("+---------------------------------------+");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
