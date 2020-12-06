import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class db_barang {
	//parameter JDBC untuk koneksi ke DB
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tb_bpl";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	//menyiapkan objek
	static Connection conn;
	static Statement stmt;
	static ResultSet result;
		
	public static void connection () {
		try {
		       conn=(Connection) DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void tampil() throws SQLException {
		connection();
		stmt = conn.createStatement();
		String sql = " SELECT * FROM barang ";
		result = stmt.executeQuery(sql);
		
		System.out.println("\n\t\tDATA BARANG SUPERMARKET SI");
		System.out.println("+===========================================================+");
		String format1 = "|%-3s| %-15s| %-13s | %-13s | %-5s|\n";
		System.out.printf(format1, "Id", " Nama Barang", " Harga Beli", "  Harga Jual", "Stok" );
		System.out.println("+===========================================================+");
		while (result.next()) {
			Integer id = result.getInt("id_brg");
			String nama_brg = result.getString("nama_brg");
			Integer h_beli = result.getInt("h_beli");
			Integer h_jual = result.getInt("h_jual");
			Integer stok = result.getInt("stok");
				
			String format = "|%-3s| %-15s| Rp%-11s | Rp%-11s | %-5s| \n";
			System.out.printf(format, id, nama_brg, h_beli, h_jual , stok);
			System.out.println("+-----------------------------------------------------------+");
		}
		System.out.println();
	}
	
	public static void tambah() throws SQLException {
		connection();
		Barang brg = new Barang();
		System.out.println("\n.......................");
		System.out.println("^^ TAMBAH DATA BARANG ^^");
		brg.id();
		brg.nama();
		brg.hb();
		brg.hj();
		brg.stok();
		System.out.println(".......................");
		
		String sql = "INSERT INTO barang VALUES " + 
		"('"+brg.id+"','"+brg.nama+"','"+brg.hb+"','"+brg.hj+"','"+brg.stok+"')";
		
		try {
			stmt= conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("____________________________");
			System.out.println("~~ DATA BERHASIL DISIMPAN ~~\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void edit () throws SQLException {
		connection();
		Barang brg = new Barang();
		Scanner sc= new Scanner (System.in);
		System.out.println("\nKet : Input Id barang yang ingin diedit");
		System.out.println(".......................");
		System.out.println("^^ EDIT DATA BARANG ^^");
		System.out.print  ("Id Barang\t: ");
		int id = sc.nextInt();
		System.out.println(".......................");
		brg.nama();
		brg.hb();
		brg.hj();
		brg.stok();
		
		String sql = "UPDATE barang SET " + "nama_brg = '"+brg.nama+"', "
										+ "h_beli='"+brg.hb+"',"
										+ "h_jual= '"+brg.hj+"',"
										+ "stok='"+brg.stok+"'"
					+ "WHERE id_brg = '"+id+"'";
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("__________________________");
			System.out.println("~~ DATA BERHASIL DIEDIT ~~\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void hapus () throws SQLException{
		connection();
		Scanner sc= new Scanner (System.in);
		System.out.println("\nKet : Input Id barang yang ingin dihapus");
		System.out.println(".......................");
		System.out.println("^^ HAPUS DATA BARANG ^^");
		System.out.print("Id Barang\t: ");
		int hapus = sc.nextInt();
		System.out.println(".......................");

		String sql = "DELETE FROM barang WHERE id_brg = '"+hapus+"'";
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("___________________________");
			System.out.println("~~ DATA BERHASIL DIHAPUS ~~\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
