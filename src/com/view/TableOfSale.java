package com.view;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dao.GoodsDao;

public class TableOfSale extends DefaultTableModel {// ��DefaultTableModel�̳�
	private Vector<String> names = new Vector<String>();// ���嶯̬���ϴ������
	// private Vector<Object> rows; // ���嶯̬���ϴ��ÿһ�е����ݣ�����ΪObject�࣬��Ϊ�����ŵĲ�ֹһ������
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// ���嶯̬���ϴ��������
	private MainFrame tempFrame;

	public TableOfSale() {
		super.setDataVector(data, names);// ���ø���Ĺ��캯��������DefaultTableModelʵ��
	}

	JTable table;// newһ��������

	public void TableInit(TableOfSale tof, int x, int y, MainFrame tempFrame) {// ��ʼ����񣬲��ѱ��add��p�У���������Ĵ�С
		table = new JTable(tof);// Table���췽���д���DefaultTableModelʵ��
		table.addMouseListener(new mymouceListener());// Ϊ�������������¼�
		JScrollPane scrollpane = new JScrollPane(table);// Ϊ�����ӹ�����
		scrollpane.setSize(x, y);// ���ñ���С
		tempFrame.p1.add(scrollpane).setBounds(0, 0, x, y);// �������ӵ�p��
		this.tempFrame = tempFrame;
	}

	public void setNames(String[] strings) {// ���ñ�ͷ���Ƶķ���������һ��String������
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// ���ñ�ͷ���Ƶķ��������أ�������һ��String
		names.add(string);
	}

	public void addData(Vector<Vector<Object>> data) {// ���������ݵķ�����ÿ����ӵ�����ĩβ
		this.data.addAll(data);
		System.out.println(this.data);
	}

	public void addData(Object[] objects) {// ���������ݵķ�����ÿ����ӵ�����ĩβ
		Vector<Object> rows = new Vector<Object>();// ����Vector���߳�ͬ���ģ�����ÿ�ζ�Ҫ��newһ��Vector�������µ�����
		Collection<Object> c = new Vector<Object>(Arrays.asList(objects));
		rows.addAll(c);
		data.add(rows);
	}

	class mymouceListener extends MyMouceListener {// �̳����������ӿڵ�ʵ���࣬��д������¼��ķ���

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = new Point();// ����һ���㣨Point������
			p.x = e.getX();// �������X����
			p.y = e.getY();// �������Y����
			int col = table.columnAtPoint(p);// ����table�ķ�������������Ԫ���columnֵ
			int row = table.rowAtPoint(p);// ����table�ķ�������������Ԫ���rowֵ
			tempFrame.dataShowUpdate(tempFrame.p1, table.getValueAt(row, 0)
					.toString(), table.getValueAt(row, 1).toString(), Integer
					.parseInt(table.getValueAt(row, 2).toString()), Integer
					.parseInt(table.getValueAt(row, 3).toString()));
		}

	}
}
