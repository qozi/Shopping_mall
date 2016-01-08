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

public class TableOfGoods extends DefaultTableModel {// 从DefaultTableModel继承
	private Vector<String> names = new Vector<String>();// 定义动态集合存放列名
	// private Vector<Object> rows; // 定义动态集合存放每一行的数据，定义为Object类，因为里面存放的不止一个类型
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// 定义动态集合存放行数据

	public TableOfGoods() {
		super.setDataVector(data, names);// 调用父类的构造函数，构造DefaultTableModel实例
	}

	JTable table;// new一个表格组件

	public void TableInit(TableOfGoods tof, int x, int y, JPanel tempPanel) {// 初始化表格，并把表格add到p中，并定义表格的大小
		table = new JTable(tof);// Table构造方法中传入DefaultTableModel实例
		table.addMouseListener(new mymouceListener());// 为表格添加鼠标监听事件
		JScrollPane scrollpane = new JScrollPane(table);// 为表格添加滚动条
		scrollpane.setSize(x, y);// 设置表格大小
		tempPanel.add(scrollpane).setBounds(0, 0, x, y);// 将表格添加到p中

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

	public void setNames(String[] strings) {// 设置表头名称的方法，传入一个String的数组
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// 设置表头名称的方法（重载），传入一个String
		names.add(string);
	}

	// public void addData(Vector<Vector<Object>> data) {// 设置行数据的方法，每次添加到表格的末尾
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
	public boolean isCellEditable(int row, int column) {// 让表格不可被编辑
		// TODO Auto-generated method stub
		return false;
	}

	class mymouceListener extends MyMouceListener {// 继承自鼠标监听接口的实现类，重写鼠标点击事件的方法

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = new Point();// 定义一个点（Point）对象
			p.x = e.getX();// 获得鼠标的X坐标
			p.y = e.getY();// 获得鼠标的Y坐标
			int col = table.columnAtPoint(p);// 调用table的方法获得鼠标点击单元格的column值
			int row = table.rowAtPoint(p);// 调用table的方法获得鼠标点击单元格的row值
		}

	}
}
