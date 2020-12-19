import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class db_transaksi extends connection {
	
	public static void tampil1() throws SQLException {
		conn();
		stmt = conn.createStatement();
		String sql = " SELECT * FROM transaksi_detail ";
		result = stmt.executeQuery(sql);
		
		System.out.println("\n\t\t\tDATA TRANSAKSI DETAIL SUPERMARKET SI");
		System.out.println("+====================================================================+");
		String format1 = "|%-3s| %-15s| %-15s| %-13s |%-13s |\n";
		System.out.printf(format1, "ID", " SKU", "No Resi", "Jumlah", " Harga");
		System.out.println("+====================================================================+");
		while (result.next()) {
			
			Integer ID = result.getInt("id");
			String SKU = result.getString("sku");
			String noresi = result.getString("noresi");
			Integer jumlah = result.getInt("jumlah");
			Integer harga = result.getInt("harga");
				
			String format = "|%-3s| %-15s| %-15s| Rp%-11s | Rp%-11s| \n";
			System.out.printf(format, ID, SKU, noresi, jumlah, harga );
			System.out.println("+--------------------------------------------------------------------+");
		}
		System.out.println();
	}
	
	public static void tambah1() throws SQLException {
		conn();
		stmt = conn.createStatement();
		String sql = " SELECT * FROM transaksi";
		result = stmt.executeQuery(sql);
		penjualan penj = new penjualan();
		System.out.println("<< TAMBAH DATA TRANSAKSI BARANG >>");
		System.out.println("\n____________________________");
		penj.noresi();
		penj.tanggal();
		penj.username();
		
		
		
		String sql1 = "INSERT INTO transaksi VALUES " + 
		"('"+penj.noresi+"','"+penj.tanggal+"','"+penj.username+"' )";
		
		try {
			stmt= conn.createStatement();
			stmt.execute(sql1);
			stmt.close();
			System.out.println("____________________________");
			System.out.println("[Data BERHASIL di SIMPAN !]\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\t\t\tDATA TRANSAKSI SUPERMARKET SI");
		System.out.println("+=================================================+");
		String format2 = "| %-15s| %-15s| %-13s |\n";
		System.out.printf(format2, "noresi", " tanggal", "username");
		System.out.println("+=================================================+");
		while (result.next()) {
			
			Integer noresi = result.getInt("noresi");
			String tanggal = result.getString("tanggal");
			String username = result.getString("username");
				
			String format = "| %-15s| %-15s| %-13s | \n";
			System.out.printf(format, noresi, tanggal, username );
			System.out.println("+-------------------------------------------------+");
		}
		System.out.println();
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
