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
		setTitle("超市后台管理系统  v" + Bnum + "   登录帐号：" + Username);
		// new ScreenSize().setConstSize(this);// 设置窗口按照分辨率等比例缩放
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setMenu();
		setLable();
		setTable();
		// new ScreenSize().setCenterLocation(this);// 设置窗口在屏幕正中央出现
		ScreenSize.setCenterLocation(this);
		// setResizable(false);// 不能拖拉改变窗体大小
		setVisible(true);

	}

	Vector data, row, name;

	public void setTable() {
		TableOfSale model = new TableOfSale();
		String[] names = { "商品名称", "商品种类", "商品价格", "商品数量" };
		model.setNames(names);
		for (int i = 0; i < 20; i++) {
			Object[] data = { "苹果", "水果", new Integer(10), new Integer(20) };
			model.addData(data);
		}
		for (int i = 0; i < 20; i++) {
			Object[] data = { "雪梨", "水果", new Integer(50), new Integer(90) };
			model.addData(data);
		}

		model.TableInit(model, p1, 400, 600,this);
		model.dataShow(p1);
	}

	JPanel p1, p2, p3, p4;
	JTabbedPane jp = new JTabbedPane(JTabbedPane.TOP);

	public void setLable() {
		p1 = new JPanel();
		jp.add("首页", p1);
		p1.setLayout(null);
		p2 = new JPanel();
		jp.add("入货记录", p2);
		p3 = new JPanel();
		jp.add("销售记录", p3);
		p4 = new JPanel();
		jp.add("数据统计", p4);
		add(jp);
	}

	JMenu menu1, menu2, menu3, menu4;
	JMenuItem item1, item2, item3, item4;

	private void setMenu() {// 菜单栏方法，用于设置菜单栏
		JMenuBar bar = new JMenuBar();// 菜单栏容器，在里面放菜单栏选项
		this.setJMenuBar(bar);// 将菜单栏容器放入窗口中
		menu1 = new JMenu("账号");// 设置一个菜单栏选项（下同）
		bar.add(menu1);// 将选项加入到菜单栏容器中（下同）
		menu2 = new JMenu("查询");
		bar.add(menu2);
		menu3 = new JMenu("设置");
		bar.add(menu3);
		menu4 = new JMenu("关于");
		bar.add(menu4);
		item1 = new JMenuItem("注册新账号");// 设置菜单栏选项子选项（下同）
		menu1.add(item1);// 将子选项加入到选项中（下同）
		item2 = new JMenuItem("修改密码");
		menu1.add(item2);
		item2.addActionListener(new ItemListener());
		item3 = new JMenuItem("切换帐号");
		menu1.add(item3);
		item3.addActionListener(new ItemListener());// 为选项设置点击事件，做出相应
		item4 = new JMenuItem("退出");
		menu1.add(item4);
		item4.addActionListener(new ItemListener());
	}

	class ItemListener implements ActionListener {// 设置菜单栏选项单击事件

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem) e.getSource();// 获得一个菜单栏子选项的引用
			if (item == item4) {// 对比获得的引用的地址是否与想要的菜单栏子选项的地址相同
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
