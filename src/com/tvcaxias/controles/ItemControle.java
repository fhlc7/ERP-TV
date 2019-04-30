package com.tvcaxias.controles;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.tvcaxias.conexoes.Conexao;
import com.tvcaxias.dao.ItemDAO;
import com.tvcaxias.entidades.Item;
import com.tvcaxias.utils.FHLC;

public class ItemControle {

	public static long salvar(Item item) {
		Connection con = new Conexao().getConexao();
		long id = 0;
		try {
			if (item.getId() <= 0) {
				id = ItemDAO.inserir(con, item);
			} else {
				//alterar
			}
			con.commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar");
			e.printStackTrace();
		} finally {			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
	public static DefaultTableModel tabela() {
		DefaultTableModel dtm = new DefaultTableModel(null, new Object[] {
				"id",
				"Descrição",
				"Entrada",
				"Saída",
				"Status",
				"Quem",
				}) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		Connection con = new Conexao().getConexao();
		try {
			for (Item item : ItemDAO.selecionar(con)) {
				dtm.addRow(new Object[] {
						item.getId(),
						item.getDescricao(),
						FHLC.calendarString(item.getEntrada()),
						FHLC.calendarString(item.getSaida()),
						item.getStatus(),
						item.getQuem()
				});
			}
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao tentar recarregar a tabela");
			e.printStackTrace();
		} finally {			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtm;
	}
	
}
