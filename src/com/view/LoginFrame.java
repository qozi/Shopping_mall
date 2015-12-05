package com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
	// Toolkit kit = Toolkit.getDefaultToolkit();// 工具，可以获得屏幕等硬件的相关信息

	// public static int SCREEN_WIDTH, SCREEN_HEIGTH;
	Container c = getContentPane();
	JButton Yes, No;
	JTextField UserName, PassWord;
	JLabel JAcharge;
	String TempUsername = "admin", TempPassword = "123456";

	public LoginFrame() {
		// SCREEN_WIDTH = kit.getScreenSize().width;
		// SCREEN_HEIGTH = kit.getScreenSize().height;

		setTitle("登录");// 标题
		setSize(320, 160);// 窗口大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口关闭按钮

		c.setLayout(null);// 布局管理器设置为没有布局，采用绝对布局的方式绘制界面
		JLabel JAusername = new JLabel("用户名");// 用户名输入框标签
		JLabel JApassword = new JLabel("密    码");// 密码输入框标签
		JAcharge = new JLabel("×");// 输入错误的提示符号
		JAcharge.setForeground(Color.RED);// 设置小X前景色为红色
		JAcharge.setFont(new Font(Font.DIALOG, Font.BOLD, 30));// 设置小X的大小（即设置字体属性，第三个数字为字体大小）
		UserName = new JTextField("+0");// 用户名输入框（+0为测试用顶级帐号，实用应删除）
		PassWord = new JTextField();// 密码输入框
		Yes = new JButton("确认");// 确认按钮
		No = new JButton("取消");// 取消按钮
		c.add(JAusername).setBounds(60, 20, 60, 16);// 以下为设置各个界面元素的位置
		c.add(JApassword).setBounds(60, 55, 60, 16);
		c.add(UserName).setBounds(120, 18, 120, 24);
		c.add(PassWord).setBounds(120, 53, 120, 24);
		c.add(Yes).setBounds(70, 90, 70, 24);
		c.add(No).setBounds(170, 90, 70, 24);

		No.addActionListener(this);// 为两个按钮添加按钮点击事件
		Yes.addActionListener(this);

		new ScreenSize().setCenterLocation(this);
		setResizable(false);// 不允许改变登录窗口的大小
		setVisible(true);// 设置窗体为可见
	}

	public static void main(String[] args) {
		new LoginFrame();// 主函数
	}

	private void ErrorShow(int x) { // 错误标志显示的函数，用来判断小X是显示在用户名输入框后面还是密码输入框后面
		switch (x) {
		case 1:
			c.add(JAcharge).setBounds(241, 21, 20, 20);
			break;
		case 2:
			c.add(JAcharge).setBounds(241, 56, 20, 20);
			break;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) { // 按钮点击事件的响应
		// TODO Auto-generated method stub
		if (e.getSource() == No) { // 如果点击取消按钮就退出程序
			System.exit(0);
		} else if (e.getSource() == Yes) { // 如果点击确定按钮就看是判断
			String tempusername = UserName.getText().toString();// 获得两个输入框的输入的内容，是String的类型
			String temppassword = PassWord.getText().toString();

			if (tempusername.equals("+0")) {
				new MainFrame(UserName.getText().toString());// 临时用的顶级用户
				this.dispose();// 关闭自己
			}

			if (tempusername.equals("")) {
				this.setTitle("用户名不能为空！");// 判断用户名输入框和密码输入框是否为空，在标题栏给出错误提示，并显示小红X在输入框的后面
				ErrorShow(1);
			} else if (temppassword.equals("")) {
				this.setTitle("密码不能为空！");
				ErrorShow(2);
			} else {
				if (tempusername.equals(TempUsername)) {
					if (temppassword.equals(TempPassword)) {
						new MainFrame(UserName.getText().toString());// 当用户名和密码的数据都相等的时候，就执行主窗口，并发送用户名
						this.dispose();// 关闭自己
					} else {
						this.setTitle("密码错误！请查证后输入");// 显示密码错误的提示
						ErrorShow(2);
					}
				} else {
					this.setTitle("此用户名未注册");// 显示用户名错误的提示
					ErrorShow(1);
				}
			}
		}
	}

	/*
	 * public void WindowMove() {
	 * 
	 * //设置没有标题的窗口可以拖动 this.addMouseListener(new MouseAdapter() { public void
	 * mousePressed(MouseEvent e) { //按下（mousePressed 不是点击，而是鼠标被按下没有抬起） origin.x
	 * = e.getX(); //当鼠标按下的时候获得窗口当前的位置 origin.y = e.getY(); } });
	 * this.addMouseMotionListener(new MouseMotionAdapter() { public void
	 * mouseDragged(MouseEvent e) { Point p =getLocation(); //当鼠标拖动时获取窗口当前位置
	 * //设置窗口的位置 //窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置 setLocation(p.x +
	 * e.getX() - origin.x, p.y + e.getY() - origin.y); } }); }
	 */

}
