package ShoppingMall;

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

public class TableOfSale extends DefaultTableModel {// ��DefaultTableModel�̳�
	private Vector<String> names = new Vector<String>();// ���嶯̬���ϴ������
	private Vector<Object> rows; // ���嶯̬���ϴ��ÿһ�е����ݣ�����ΪObject�࣬��Ϊ�����ŵĲ�ֹһ������
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

	// JLabel l1, l2, l3, l4;
	// String name = "", kind = "";
	// int price = 0, number = 0;

	// public void dataShow(JPanel tempPanel) {
	// l1 = new JLabel("��Ʒ���ƣ�" + name);
	// l2 = new JLabel("��Ʒ���ࣺ" + kind);
	// l3 = new JLabel("��Ʒ�۸�" + price);
	// l4 = new JLabel("��Ʒ������" + number);
	// l1.setBounds(420, 5, 100, 30);
	// l2.setBounds(420, 30, 100, 30);
	// l3.setBounds(420, 55, 100, 30);
	// l4.setBounds(420, 80, 100, 30);
	// tempPanel.add(l1);
	// tempPanel.add(l2);
	// tempPanel.add(l3);
	// tempPanel.add(l4);
	// }
	// public void dataShowUpdate(JPanel tempPanel){
	// System.out.println("ok");
	// tempPanel.remove(l1);
	// tempPanel.remove(l2);
	// tempPanel.remove(l3);
	// tempPanel.remove(l4);
	// //dataShow(tempPanel);
	// }

	public void setNames(String[] strings) {// ���ñ�ͷ���Ƶķ���������һ��String������
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// ���ñ�ͷ���Ƶķ��������أ�������һ��String
		names.add(string);
	}

	/*
	 * public void addNames(int index,String string){ names.add(index, string);
	 * }
	 */

	public void addData(Object[] objects) {// ���������ݵķ�����ÿ����ӵ�����ĩβ
		rows = new Vector<Object>();// ����Vector���߳�ͬ���ģ�����ÿ�ζ�Ҫ��newһ��Vector�������µ�����
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
			System.out.println("(" + col + "," + row + ")" + "����Ϊ��"
					+ table.getValueAt(row, col));
			// for (int i = 0; i < table.getColumnCount(); i++) {
			// System.out.print(names.get(i).toString() + ":"
			// + table.getValueAt(row, i).toString() + "\n");
			// }
			// name = table.getValueAt(row,
			// 0).toString();dataShowUpdate(tempFrame.p1);
			tempFrame.dataShow(tempFrame.p1);
			System.out.println();
		}

	}
}
