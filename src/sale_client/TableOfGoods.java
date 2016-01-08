package sale_client;

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
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dao.GoodsDao;
import com.pojo.Employees;
import com.pojo.Goods;
import com.view.PanelOfBuy;

public class TableOfGoods extends DefaultTableModel {// ��DefaultTableModel�̳�
	private Vector<String> names = new Vector<String>();// ���嶯̬���ϴ������
	// private Vector<Object> rows; // ���嶯̬���ϴ��ÿһ�е����ݣ�����ΪObject�࣬��Ϊ�����ŵĲ�ֹһ������
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// ���嶯̬���ϴ��������

	public TableOfGoods() {
		super.setDataVector(data, names);// ���ø���Ĺ��캯��������DefaultTableModelʵ��
	}

	JTable table;// newһ��������

	public void TableInit(TableOfGoods tof, int x, int y, JPanel tempPanel) {// ��ʼ����񣬲��ѱ��add��p�У���������Ĵ�С
		table = new JTable(tof);// Table���췽���д���DefaultTableModelʵ��
		table.addMouseListener(new mymouceListener());// Ϊ�������������¼�
		JScrollPane scrollpane = new JScrollPane(table);// Ϊ�����ӹ�����
		scrollpane.setSize(x, y);// ���ñ���С
		tempPanel.add(scrollpane).setBounds(0, 0, x, y);// �������ӵ�p��

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
				if (e.getButton() == 1) {
					pog.setSelectRow(
							(int) table.getValueAt(table.rowAtPoint(p), 0), 0);
				} else if (e.getButton() == 3) {
					table.setRowSelectionInterval(table.rowAtPoint(p),
							table.rowAtPoint(p));
					pog.setSelectRow(
							(int) table.getValueAt(table.rowAtPoint(p), 0), 1);
				}
			}

			// @Override
			// public void mouseSingleClicked(MouseEvent e) {
			// Point p = new Point();
			// p.x = e.getX();
			// p.y = e.getY();
			// PanelOfGoods pog = (PanelOfGoods) tempPanel;
			// pog.setSelectRow(
			// (int) table.getValueAt(table.rowAtPoint(p), 0), 0);
			// }
			//
			// @Override
			// public void mouseDoubleClicked(MouseEvent e) {
			// Point p = new Point();
			// p.x = e.getX();
			// p.y = e.getY();
			// PanelOfGoods pog = (PanelOfGoods) tempPanel;
			// pog.setSelectRow(
			// (int) table.getValueAt(table.rowAtPoint(p), 0), 1);
			// }
		});
	}

	public void setNames(String[] strings) {// ���ñ�ͷ���Ƶķ���������һ��String������
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// ���ñ�ͷ���Ƶķ��������أ�������һ��String
		names.add(string);
	}

	// public void addData(Vector<Vector<Object>> data) {// ���������ݵķ�����ÿ����ӵ�����ĩβ
	// this.data.addAll(data);
	// }
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

	class mymouceListener extends MyMouceListener {// �̳����������ӿڵ�ʵ���࣬��д������¼��ķ���

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = new Point();// ����һ���㣨Point������
			p.x = e.getX();// �������X����
			p.y = e.getY();// �������Y����
			int col = table.columnAtPoint(p);// ����table�ķ�������������Ԫ���columnֵ
			int row = table.rowAtPoint(p);// ����table�ķ�������������Ԫ���rowֵ
		}

	}
}
