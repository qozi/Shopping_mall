package sale_client;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dao.GoodsDao;
import com.dao.KindDao;
import com.dao.SaleDao;
import com.pojo.Employees;
import com.pojo.Goods;
import com.pojo.Sale;
import com.view.PanelOfBuy;

public class TableOfGoods_ing extends DefaultTableModel {// ��DefaultTableModel�̳�
	private Vector<String> names = new Vector<String>();// ���嶯̬���ϴ������
	// private Vector<Object> rows; // ���嶯̬���ϴ��ÿһ�е����ݣ�����ΪObject�࣬��Ϊ�����ŵĲ�ֹһ������
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();// ���嶯̬���ϴ��������

	public TableOfGoods_ing() {
		super.setDataVector(data, names);// ���ø���Ĺ��캯��������DefaultTableModelʵ��
	}

	JTable table;// newһ��������
	int row;

	public void TableInit(TableOfGoods_ing tof, int x, int y, JPanel tempPanel) {// ��ʼ����񣬲��ѱ��add��p�У���������Ĵ�С
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
				row = table.rowAtPoint(p);
				PanelOfGoods_ing pog = (PanelOfGoods_ing) tempPanel;
				int gid = new GoodsDao().getOneGoods((String) table.getValueAt(
						row, 0));
				if (e.getButton() == 1) {
					pog.setSelectRow(gid, 0);
				} else if (e.getButton() == 3) {
					pog.setSelectRow(gid, 1);
				}
			}
		});
	}

	public void setNames(String[] strings) {// ���ñ�ͷ���Ƶķ���������һ��String������
		Collection<String> c = new ArrayList<String>(Arrays.asList(strings));
		names.addAll(c);
	}

	public void addNames(String string) {// ���ñ�ͷ���Ƶķ��������أ�������һ��String
		names.add(string);
	}

	public void addData(Goods g, int num) {// ���������ݵķ�����ÿ����ӵ�����ĩβ
		for (Vector<Object> v : data) {
			String s = (String) v.get(0);
			int i = (Integer) v.get(2);
			if (s.equals(g.getGname())) {
				if (i + num < 1) {
					data.remove(v);
					table.updateUI();
					return;
				}
				v.set(2, i + num);
				v.set(3, g.getGpriceout() * (i + num));
				table.updateUI();
				return;
			}
		}
		Vector<Object> tempv = new Vector<Object>();
		tempv.add(g.getGname());
		tempv.add(new KindDao().getOneKind(g.getGkind()));
		tempv.add(num);
		tempv.add(g.getGpriceout() * num);
		data.add(tempv);
		table.updateUI();
	}

	public void addSale() {
		for (Vector<Object> v : data) {
			int gid = new GoodsDao().getOneGoods((String) v.get(0));
			Sale s = new Sale();
			s.setSprice((Float) v.get(3));
			s.setSdatetime(new Date());
			s.setSnum((Integer) v.get(2));
			s.setSgid(gid);
			new SaleDao().setSale(s);
			Goods goods = new GoodsDao().getOneGoods(gid);
			goods.setGnum(goods.getGnum() - s.getSnum());
			new GoodsDao().updateGoods(goods);
		}
		data.removeAllElements();
		table.updateUI();
	}

	// public void addData(Vector<Goods> v) {
	// Vector<Vector<Object>> tempdata = new Vector<Vector<Object>>();
	// for (Goods g : v) {
	// Vector<Object> tempv = new Vector<Object>();
	// tempv.add(g.getGname());
	// tempv.add(g.getGkindname());
	// tempv.add(g.getGnum());
	// tempv.add(g.getGpriceout());
	// tempdata.add(tempv);
	// }
	// this.data.addAll(tempdata);
	// }
	//
	// public void updateTable(Vector<Goods> v) {
	// data.removeAllElements();
	// addData(v);
	// table.updateUI();
	// }

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
