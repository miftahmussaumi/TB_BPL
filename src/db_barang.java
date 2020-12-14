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
		String sql = " SELECT * FROM barang ";
		result = stmt.executeQuery(sql);
		
		System.out.println("\n\t\t\tDATA BARANG SUPERMARKET SI");
		System.out.println("+===========================================================================+");
		String format1 = "|%-3s| %-15s| %-15s| %-13s |%-13s | %-5s|\n";
		System.out.printf(format1, "SKU", " Nama Barang", "Departement", "Harga Beli", "  Harga Jual", "Stok" );
		System.out.println("+===========================================================================+");
		while (result.next()) {
			Integer SKU = result.getInt("sku");
			String nama_brg = result.getString("nama_brg");
			String depart = result.getString("depart");
			Integer h_beli = result.getInt("h_beli");
			Integer h_jual = result.getInt("h_jual");
			Integer stok = result.getInt("stok");
				
			String format = "|%-3s| %-15s| %-15s| Rp%-11s | Rp%-11s| %-5s| \n";
			System.out.printf(format, SKU, nama_brg, depart, h_beli, h_jual , stok);
			System.out.println("+---------------------------------------------------------------------------+");
		}
		System.out.println();
	}
	
	public static void tambah() throws SQLException {
		conn();
		Barang brg = new Barang();
		System.out.println("<< TAMBAH DATA BARANG >>");
		System.out.println("\n____________________________");
		brg.sku();
		brg.nama();
		brg.depart();
		brg.hb();
		brg.hj();
		brg.stok();
		
		String sql = "INSERT INTO barang VALUES " + 
		"('"+brg.sku+"','"+brg.nama+"','"+brg.depart+"','"+brg.hb+"','"+brg.hj+"','"+brg.stok+"')";
		
		try {
			stmt= conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("____________________________");
			System.out.println("[Data BERHASIL di SIMPAN !]\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void edit () throws SQLException {
		conn();
		Barang brg = new Barang();
		Scanner sc= new Scanner (System.in);
		System.out.println("\nKet : Input SKU barang yang ingin diedit");
		System.out.println("<< EDIT DATA BARANG >>");
		System.out.println("__________________________");
		System.out.print  ("SKU Barang\t: ");
		int id = sc.nextInt();
		brg.nama();
		brg.depart();
		brg.hb();
		brg.hj();
		brg.stok();
		
		String sql = "UPDATE barang SET " + "nama_brg = '"+brg.nama+"', "
										+ "depart='"+brg.depart+"',"
										+ "h_beli='"+brg.hb+"',"
										+ "h_jual='"+brg.hj+"',"
										+ "stok='"+brg.stok+"'"
					+ "WHERE sku = '"+id+"'";
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("__________________________");
			System.out.println("[Data BERHASIL di EDIT !]\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void hapus () throws SQLException{
		conn();
		Scanner sc= new Scanner (System.in);
		System.out.println("\nKet : Input SKU barang yang ingin dihapus");
		System.out.println("<< HAPUS DATA BARANG >>");
		System.out.println("___________________________");
		System.out.print("SKU Barang\t: ");
		int hapus = sc.nextInt();

		String sql = "DELETE FROM barang WHERE sku = '"+hapus+"'";
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("___________________________");
			System.out.println("[Data BERHASIL di HAPUS !]\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList <Barang> cari (String find){
		conn();
		ArrayList <Barang> listbarang = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM barang WHERE sku ='"+find+"'";
			stmt=conn.createStatement();
			result=stmt.executeQuery(sql);
				
			while (result.next()) {
				Barang barang = new Barang (
					result.getString("sku"),
					result.getString("nama_brg"),
					result.getString("depart"),
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
	
	public static void tbstock() throws SQLException{
		conn();
		Scanner sc = new Scanner (System.in);
		System.out.println("\nKet : Input SKU barang yang ingin diedit");
		System.out.println("<< RE-STOCK BARANG >>");
		System.out.println("___________________________");
		System.out.print  ("SKU Barang\t: ");
		int sku = sc.nextInt();
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM barang WHERE sku = '"+sku+"'";
			result = stmt.executeQuery(sql);
			if (result.next()) {
				String id = result.getString(sku);
				Integer stok_db = result.getInt("stok");
				System.out.print("Penambahan\t : ");
				Integer tambah = sc.nextInt();
				int newstock = Integer.valueOf(stok_db)+Integer.valueOf(tambah);
				String sql2 = "UPDATE barang SET stok = '"+newstock+"' WHERE sku='"+sku+"'";
				stmt.execute(sql2);
				stmt.close();
			}
			System.out.println("___________________________");
			System.out.println("[Barang BERHASIL di TAMBAH !]\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
