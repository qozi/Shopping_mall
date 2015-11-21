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

public class TableOfSale extends DefaultTableModel {// 从DefaultTableModel继承
	private Vector<String> names = new Vector<String>();// 定义动态集合存放列名
	private Vector<Object> rows; // 定义动态集合存放每一行的数据，定义为Object类，因为里面存放的不止一个类型
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// 定义动态集合存放行数据
	private MainFrame tempFrame;

	public TableOfSale() {
		super.setDataVector(data, names);// 调用父类的构造函数，构造DefaultTableModel实例
	}

	JTable table;// new一个表格组件

	public void TableInit(TableOfSale tof, int x, int y, MainFrame tempFrame) {// 初始化表格，并把表格add到p中，并定义表格的大小
		table = new JTable(tof);// Table构造方法中传入DefaultTableModel实例
		table.addMouseListener(new mymouceListener());// 为表格添加鼠标监听事件
		JScrollPane scrollpane = new JScrollPane(table);// 为表格添加滚动条
		scrollpane.setSize(x, y);// 设置表格大小
		tempFrame.p1.add(scrollpane).setBounds(0, 0, x, y);// 将表格添加到p中
		this.tempFrame = tempFrame;
	}

	// JLabel l1, l2, l3, l4;
	// String name = "", kind = "";
	// int price = 0, number = 0;

	// public void dataShow(JPanel tempPanel) {
	// l1 = new JLabel("商品名称：" + name);
	// l2 = new JLabel("商品种类：" + kind);
	// l3 = new JLabel("商品价格：" + price);
	// l4 = new JLabel("商品数量：" + number);
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

	public void setNames(String[] strings) {// 设置表头名称的方法，传入一个String的数组
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// 设置表头名称的方法（重载），传入一个String
		names.add(string);
	}

	/*
	 * public void addNames(int index,String string){ names.add(index, string);
	 * }
	 */

	public void addData(Object[] objects) {// 设置行数据的方法，每次添加到表格的末尾
		rows = new Vector<Object>();// 由于Vector是线程同步的，所以每次都要新new一个Vector来储存新的数据
		Collection<Object> c = new Vector<Object>(Arrays.asList(objects));
		rows.addAll(c);
		data.add(rows);
	}

	class mymouceListener extends MyMouceListener {// 继承自鼠标监听接口的实现类，重写鼠标点击事件的方法

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = new Point();// 定义一个点（Point）对象
			p.x = e.getX();// 获得鼠标的X坐标
			p.y = e.getY();// 获得鼠标的Y坐标
			int col = table.columnAtPoint(p);// 调用table的方法获得鼠标点击单元格的column值
			int row = table.rowAtPoint(p);// 调用table的方法获得鼠标点击单元格的row值
			System.out.println("(" + col + "," + row + ")" + "内容为："
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
