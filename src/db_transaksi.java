import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class db_transaksi extends connection {
	
	public static void laporan_penjualan () throws SQLException {
		conn();
		boolean lap = true;
		Scanner in = new Scanner (System.in);
		System.out.println("\n+================================================+");
		System.out.println("   LAPORAN PENJUALAN SUPERMARKET SI");
		System.out.println("+=================================================+");
		System.out.print  ("Masukkan Tanggal [dd-mm-yyyy] : ");
		String tgl = in.nextLine();
		stmt = conn.createStatement();
		String sql = "SELECT transaksi.tanggal,transaksi_detail.noresi,"
				+ "transaksi_detail.sku,barang.nama_brg,"
				+ "transaksi_detail.jumlah FROM barang "
				+ "INNER JOIN transaksi_detail "
				+ "ON barang.sku=transaksi_detail.sku "
				+ "JOIN transaksi "
				+ "ON transaksi_detail.noresi=transaksi.noresi WHERE tanggal ='"+tgl+"'";
		result = stmt.executeQuery(sql);
		
		while (result.next()) {
			String noresi = result.getString("noresi");
			String sku = result.getString("sku");
			String nama_brg = result.getString("nama_brg");
			Integer jumlah = result.getInt("jumlah");
			
			System.out.println("+----------------------------------------------------------+");
			System.out.println("No.Resi        : "+noresi);
			System.out.println("SKU Barang     : "+sku);
			System.out.println("Nama Barang    : "+nama_brg);
			System.out.println("Jumlah Terjual : "+jumlah);
			System.out.println("+----------------------------------------------------------+");
		} 
		System.out.println();
	}
	
	public static void penjualan() throws SQLException {
		conn();
		penjualan penj = new penjualan();
		Scanner sc = new Scanner (System.in);
		System.out.println("\n+==========================================================+");
		System.out.println("\t\tTRANSAKSI PENJUALAN SUPERMARKET SI");
		System.out.println("+==========================================================+");
		penj.noresi();
		
		//tanggal otomatis terbuat
		Date tgl = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Tanggal Transaksi : "+format.format(tgl));
		String tanggal = String.valueOf(format.format(tgl));
		
		System.out.println("---Transaksi Penjualan---");
		System.out.print("SKU Barang\t : ");
		String sku_brg = sc.nextLine();
		
		String sql = "SELECT * FROM barang WHERE sku = '"+sku_brg+"'";
		stmt=conn.createStatement();
		result=stmt.executeQuery(sql);
		
		int sisabarang = 0;
		int total=0;
		while (result.next()) {
			String sku = result.getString("sku");
			String nama_brg = result.getString("nama_brg");
			Integer stok_brg = result.getInt("stok");
			Integer harga_jual = result.getInt("h_jual");
			System.out.println("Nama Barang\t : "+nama_brg);
			
			if (stok_brg>0) {
				System.out.println("Harga Barang : Rp "+harga_jual);
				penj.jumlah();
				sisabarang = Integer.valueOf(stok_brg)-Integer.valueOf(penj.jml);
				total = Integer.valueOf(harga_jual)*Integer.valueOf(penj.jml);
				System.out.println("Total Belanja : Rp "+total);
				String sql2="INSERT INTO transaksi_detail (sku,noresi,jumlah,harga) VALUES "
						+ "('"+sku_brg+"','"+penj.noresi+"','"+penj.jml+"','"+total+"')";
				String sql3="INSERT INTO transaksi VALUES ('"+penj.noresi+"','"+tanggal+"','"+User.username+"')";
				String sql4="UPDATE barang SET stok='"+stok_brg+"'";
				try {
					stmt= conn.createStatement();
					stmt.execute(sql2);
					stmt.execute(sql3);
					stmt.execute(sql4);
					stmt.close();
					System.out.println("\n        TRANSAKSI BERHASIL      ");
					System.out.println("+---------------------------------------+");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				System.out.println("__________________________________________________________________");
				System.out.println("!!-----------------Stock Barang telah habis---------------------!!");
				System.out.println("Silahkan melakukan re-stock barang ["+nama_brg+"] dahulu");
				System.out.println("------------------------------------------------------------------");
				menu.menu1();
			}
		}
		
		
		
		
		
		
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
