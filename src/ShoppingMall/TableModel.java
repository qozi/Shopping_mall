package ShoppingMall;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	private static int NUM = 0;
	private String[] title_name = { "姓名", "性别", "年龄" };// 定义表格的表头的各个项目的名称
	private Vector content = null;// 设置一个可动态增长的集合用于存放条目

	public TableModel() {
		// TODO Auto-generated constructor stub
		content = new Vector();// 默认构造方法
	}

	public TableModel(int count) {
		// TODO Auto-generated method stub
		content = new Vector(count);// 可以指定条目数量的构造方法
	}

	public void addRow(String name, boolean s, String age) {// 向列表尾添加数据
		Vector v = new Vector(3);// 新建一个数组用来存列表中一行数据
		v.add(0, name);
		v.add(1, new Boolean(s));
		v.add(2, age); // 本列在前面已经设置成了JComboBox组件，这里随便输入什么字符串都没关系

		content.add(v);
	}

	public void removeRow(int row) {// 删除指定行的数据
		content.remove(row);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {// 如果rowIndex和columnIndex位置的单元格是可编辑的，则返回true
		// TODO Auto-generated method stub
		if (rowIndex == 2) {
			return false;
		}
		return true;
	}

	public void setValueAt(Object value, int row, int col) {// 设置指定位置的数据，相关参数：aValue要分配给单元格的值rowIndex单元格所在行columnIndex单元格所在列
		((Vector) content.get(row)).remove(col);
		((Vector) content.get(row)).add(col, value);
		this.fireTableCellUpdated(row, col);// 通知所有的监听器，已更新(row ,col )处单元格的值
	}

	public String getColumnName(int col) {// 返回指定列的标题名
		return title_name[col];
	}

	@Override
	public int getRowCount() {// 返回列表的长度
		// TODO Auto-generated method stub
		return content.size();
	}

	@Override
	public int getColumnCount() {// 返回列的个数
		// TODO Auto-generated method stub
		return title_name.length;
	}

	@Override
	public Object getValueAt(int row, int col) {// 取得指定单元格的值
		// TODO Auto-generated method stub
		return ((Vector) content.get(row)).get(col);
	}

	public Class getColumnClass(int col) {// 返回指定列的object.class
		return getValueAt(0, col).getClass();
	}

}
