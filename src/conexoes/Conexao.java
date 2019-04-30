package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {

	public Connection getConexao() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/erp_tv", "root", "fhlc123");
			con.setAutoCommit(false);
			System.out.println("Conectado com sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados");
			e.printStackTrace();
		}
		return con;
	}
	
//	public static void main(String[] args) {
//		new Conexao().getConexao();
//	}
	
}
