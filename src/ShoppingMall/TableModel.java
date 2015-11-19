package ShoppingMall;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	private static int NUM = 0;
	private String[] title_name = { "����", "�Ա�", "����" };// ������ı�ͷ�ĸ�����Ŀ������
	private Vector content = null;// ����һ���ɶ�̬�����ļ������ڴ����Ŀ

	public TableModel() {
		// TODO Auto-generated constructor stub
		content = new Vector();// Ĭ�Ϲ��췽��
	}

	public TableModel(int count) {
		// TODO Auto-generated method stub
		content = new Vector(count);// ����ָ����Ŀ�����Ĺ��췽��
	}

	public void addRow(String name, boolean s, String age) {// ���б�β�������
		Vector v = new Vector(3);// �½�һ�������������б���һ������
		v.add(0, name);
		v.add(1, new Boolean(s));
		v.add(2, age); // ������ǰ���Ѿ����ó���JComboBox����������������ʲô�ַ�����û��ϵ

		content.add(v);
	}

	public void removeRow(int row) {// ɾ��ָ���е�����
		content.remove(row);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {// ���rowIndex��columnIndexλ�õĵ�Ԫ���ǿɱ༭�ģ��򷵻�true
		// TODO Auto-generated method stub
		if (rowIndex == 2) {
			return false;
		}
		return true;
	}

	public void setValueAt(Object value, int row, int col) {// ����ָ��λ�õ����ݣ���ز�����aValueҪ�������Ԫ���ֵrowIndex��Ԫ��������columnIndex��Ԫ��������
		((Vector) content.get(row)).remove(col);
		((Vector) content.get(row)).add(col, value);
		this.fireTableCellUpdated(row, col);// ֪ͨ���еļ��������Ѹ���(row ,col )����Ԫ���ֵ
	}

	public String getColumnName(int col) {// ����ָ���еı�����
		return title_name[col];
	}

	@Override
	public int getRowCount() {// �����б�ĳ���
		// TODO Auto-generated method stub
		return content.size();
	}

	@Override
	public int getColumnCount() {// �����еĸ���
		// TODO Auto-generated method stub
		return title_name.length;
	}

	@Override
	public Object getValueAt(int row, int col) {// ȡ��ָ����Ԫ���ֵ
		// TODO Auto-generated method stub
		return ((Vector) content.get(row)).get(col);
	}

	public Class getColumnClass(int col) {// ����ָ���е�object.class
		return getValueAt(0, col).getClass();
	}

}
