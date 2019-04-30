package com.tvcaxias.controles;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.tvcaxias.conexoes.Conexao;
import com.tvcaxias.dao.ItemDAO;
import com.tvcaxias.entidades.Item;
import com.tvcaxias.utils.FHLC;

public class ItemControle {

	public static Item salvar(Item item) {
		Connection con = new Conexao().getConexao();
		try {
			if (item.getId() <= 0) {
				item = ItemDAO.inserir(con, item);
			} else {
				ItemDAO.alterar(con, item);
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
		return item;
	}
	
	public static void tabela(JTable jTable) {
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
			}
		};
		// uma das maneiras de pintar a tabela
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				
				int status = 4;
				for (int i = 0; i < jTable.getColumnCount(); i++) {
					if (jTable.getColumnName(i).equals("Status")) {
						status = i;
						break;
					}
				}
				
				if (jTable.getValueAt(row, status).toString().equals("Pendente")) {
					for (int i = 0; i < jTable.getColumnCount(); i++) {
						comp.setBackground(Color.RED);
						comp.setForeground(Color.BLACK);
					}
				} else if (jTable.getValueAt(row, status).toString().equals("Em andamento")) {
					for (int i = 0; i < jTable.getColumnCount(); i++) {
						comp.setBackground(Color.YELLOW);
						comp.setForeground(Color.BLACK);
					}
				} else if (jTable.getValueAt(row, status).toString().equals("Finalizado")) {
					for (int i = 0; i < jTable.getColumnCount(); i++) {
						comp.setBackground(Color.BLUE);
						comp.setForeground(Color.WHITE);
					}
				}
//				else {
//					for (int i = 0; i < jTable.getColumnCount(); i++) {
//						comp.setBackground(null);
//						comp.setForeground(Color.BLACK);
//					}
//				}
				
				return comp;
			}
		};
		jTable.setDefaultRenderer(Object.class, dtcr);
		/////////////////////////////////////////////////////////////////////
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
		RowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(dtm);
		jTable.setRowSorter(rowSorter);
		jTable.setModel(dtm);
		// eu acho esta a melhor maneira de pintar a tabela, o problema é que pinta tudo
//		Component comp = (Component) jTable.getCellRenderer(1, 1);
//		comp.setBackground(Color.BLUE);
//		comp.setForeground(Color.WHITE);
	}
	
	public static Item get(long id) {
		Connection con = new Conexao().getConexao();
		Item item = new Item();
		try {
			item = ItemDAO.get(con, id);
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao tentar retornar item");
			e.printStackTrace();
		} finally {			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return item;
	}
	
}
