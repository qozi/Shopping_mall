package com.view;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import org.omg.CosNaming.IstringHelper;

import com.dao.GoodsDao;
import com.pojo.Employees;
import com.pojo.Goods;

public class TableOfGoods extends DefaultTableModel {// ��DefaultTableModel�̳�
	private Vector<String> names = new Vector<String>();// ���嶯̬���ϴ������
	// private Vector<Object> rows; // ���嶯̬���ϴ��ÿһ�е����ݣ�����ΪObject�࣬��Ϊ�����ŵĲ�ֹһ������
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// ���嶯̬���ϴ��������

	public TableOfGoods() {
		super.setDataVector(data, names);// ���ø���Ĺ��캯��������DefaultTableModelʵ��
	}

	JPanel tempPanel;
	JTable table;// newһ��������

	public void TableInit(TableOfGoods tof, int x, int y, int p, int q, JPanel tempPanel) {// ��ʼ����񣬲��ѱ��add��p�У���������Ĵ�С
		this.tempPanel = tempPanel;
		table = new JTable(tof);// Table���췽���д���DefaultTableModelʵ��
		setColumnLook();
		JScrollPane scrollpane = new JScrollPane(table);// Ϊ�����ӹ�����
		scrollpane.setSize(x, y);// ���ñ���С
		tempPanel.add(scrollpane).setBounds(p, q, x, y);// �������ӵ�p��
		table.setRowHeight(50);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, renderer);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = new Point();
				p.x = e.getX();
				p.y = e.getY();
				PanelOfGoods pog = (PanelOfGoods) tempPanel;
				pog.setSelectRow((int) table.getValueAt(table.rowAtPoint(p), 0));
			}

		});
	}

	public void setColumnLook() {
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
		TableColumn column;
		column = table.getColumnModel().getColumn(0);
		column.setResizable(false);
		column.setPreferredWidth(0);
		column.setMaxWidth(0);
		column.setMinWidth(0);
		column = table.getColumnModel().getColumn(1);
		column.setPreferredWidth(130);
		column.setMaxWidth(130);
		column.setMinWidth(130);
		column = table.getColumnModel().getColumn(2);
		column.setPreferredWidth(130);
		column.setMaxWidth(130);
		column.setMinWidth(130);
		column = table.getColumnModel().getColumn(3);
		column.setPreferredWidth(55);
		column.setMaxWidth(55);
		column.setMinWidth(55);
	}

	public void setNames(String[] strings) {// ���ñ�ͷ���Ƶķ���������һ��String������
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// ���ñ�ͷ���Ƶķ��������أ�������һ��String
		names.add(string);
	}

	public void addData(Vector<Goods> v) {
		Vector<Vector<Object>> tempdata = new Vector<Vector<Object>>();
		for (Goods g : v) {
			Vector<Object> tempv = new Vector<Object>();
			tempv.add(g.getGid());
			tempv.add(g.getGname());
			tempv.add(g.getGkindname());
			tempv.add(g.getGnum());
			tempv.add(g.getGpriceout());
			tempdata.add(tempv);
		}
		this.data.addAll(tempdata);
	}

	public void updateTable(Vector<Goods> v) {
		data.removeAllElements();
		addData(v);
		table.updateUI();
	}

	@Override
	public boolean isCellEditable(int row, int column) {// �ñ�񲻿ɱ��༭
		// TODO Auto-generated method stub
		return false;
	}
}
