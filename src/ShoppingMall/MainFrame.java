package ShoppingMall;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class MainFrame extends JFrame {
	// public static
	public static double Bnum = 2.0;
	public static String Username;

	public MainFrame(String username) {
		Username = username;
		setTitle("���к�̨����ϵͳ  v" + Bnum + "   ��¼�ʺţ�" + Username);
		// new ScreenSize().setConstSize(this);// ���ô��ڰ��շֱ��ʵȱ�������
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setMenu();
		setLable();
		setTable();
		// new ScreenSize().setCenterLocation(this);// ���ô�������Ļ���������
		ScreenSize.setCenterLocation(this);
		// setResizable(false);// ���������ı䴰���С
		setVisible(true);

	}

	Vector data, row, name;

	public void setTable() {
		TableOfSale model = new TableOfSale();
		String[] names = { "��Ʒ����", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����" };
		model.setNames(names);
		for (int i = 0; i < 20; i++) {
			Object[] data = { "ƻ��", "ˮ��", new Integer(10), new Integer(20) };
			model.addData(data);
		}
		for (int i = 0; i < 20; i++) {
			Object[] data = { "ѩ��", "ˮ��", new Integer(50), new Integer(90) };
			model.addData(data);
		}

		model.TableInit(model, p1, 400, 600,this);
		model.dataShow(p1);
	}

	JPanel p1, p2, p3, p4;
	JTabbedPane jp = new JTabbedPane(JTabbedPane.TOP);

	public void setLable() {
		p1 = new JPanel();
		jp.add("��ҳ", p1);
		p1.setLayout(null);
		p2 = new JPanel();
		jp.add("�����¼", p2);
		p3 = new JPanel();
		jp.add("���ۼ�¼", p3);
		p4 = new JPanel();
		jp.add("����ͳ��", p4);
		add(jp);
	}

	JMenu menu1, menu2, menu3, menu4;
	JMenuItem item1, item2, item3, item4;

	private void setMenu() {// �˵����������������ò˵���
		JMenuBar bar = new JMenuBar();// �˵���������������Ų˵���ѡ��
		this.setJMenuBar(bar);// ���˵����������봰����
		menu1 = new JMenu("�˺�");// ����һ���˵���ѡ���ͬ��
		bar.add(menu1);// ��ѡ����뵽�˵��������У���ͬ��
		menu2 = new JMenu("��ѯ");
		bar.add(menu2);
		menu3 = new JMenu("����");
		bar.add(menu3);
		menu4 = new JMenu("����");
		bar.add(menu4);
		item1 = new JMenuItem("ע�����˺�");// ���ò˵���ѡ����ѡ���ͬ��
		menu1.add(item1);// ����ѡ����뵽ѡ���У���ͬ��
		item2 = new JMenuItem("�޸�����");
		menu1.add(item2);
		item2.addActionListener(new ItemListener());
		item3 = new JMenuItem("�л��ʺ�");
		menu1.add(item3);
		item3.addActionListener(new ItemListener());// Ϊѡ�����õ���¼���������Ӧ
		item4 = new JMenuItem("�˳�");
		menu1.add(item4);
		item4.addActionListener(new ItemListener());
	}

	class ItemListener implements ActionListener {// ���ò˵���ѡ����¼�

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem) e.getSource();// ���һ���˵�����ѡ�������
			if (item == item4) {// �ԱȻ�õ����õĵ�ַ�Ƿ�����Ҫ�Ĳ˵�����ѡ��ĵ�ַ��ͬ
				System.exit(0);
			} else if (item == item3) {
				new LoginFrame();
				dispose();
			} else if (item == item2) {
				new PasswordChange(Username);
			}
		}

	}
}
