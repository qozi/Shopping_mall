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
	// Toolkit kit = Toolkit.getDefaultToolkit();// ���ߣ����Ի����Ļ��Ӳ���������Ϣ

	// public static int SCREEN_WIDTH, SCREEN_HEIGTH;
	Container c = getContentPane();
	JButton Yes, No;
	JTextField UserName, PassWord;
	JLabel JAcharge;
	String TempUsername = "admin", TempPassword = "123456";

	public LoginFrame() {
		// SCREEN_WIDTH = kit.getScreenSize().width;
		// SCREEN_HEIGTH = kit.getScreenSize().height;

		setTitle("��¼");// ����
		setSize(320, 160);// ���ڴ�С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô��ڹرհ�ť

		c.setLayout(null);// ���ֹ���������Ϊû�в��֣����þ��Բ��ֵķ�ʽ���ƽ���
		JLabel JAusername = new JLabel("�û���");// �û���������ǩ
		JLabel JApassword = new JLabel("��    ��");// ����������ǩ
		JAcharge = new JLabel("��");// ����������ʾ����
		JAcharge.setForeground(Color.RED);// ����СXǰ��ɫΪ��ɫ
		JAcharge.setFont(new Font(Font.DIALOG, Font.BOLD, 30));// ����СX�Ĵ�С���������������ԣ�����������Ϊ�����С��
		UserName = new JTextField("+0");// �û��������+0Ϊ�����ö����ʺţ�ʵ��Ӧɾ����
		PassWord = new JTextField();// ���������
		Yes = new JButton("ȷ��");// ȷ�ϰ�ť
		No = new JButton("ȡ��");// ȡ����ť
		c.add(JAusername).setBounds(60, 20, 60, 16);// ����Ϊ���ø�������Ԫ�ص�λ��
		c.add(JApassword).setBounds(60, 55, 60, 16);
		c.add(UserName).setBounds(120, 18, 120, 24);
		c.add(PassWord).setBounds(120, 53, 120, 24);
		c.add(Yes).setBounds(70, 90, 70, 24);
		c.add(No).setBounds(170, 90, 70, 24);

		No.addActionListener(this);// Ϊ������ť��Ӱ�ť����¼�
		Yes.addActionListener(this);

		new ScreenSize().setCenterLocation(this);
		setResizable(false);// ������ı��¼���ڵĴ�С
		setVisible(true);// ���ô���Ϊ�ɼ�
	}

	public static void main(String[] args) {
		new LoginFrame();// ������
	}

	private void ErrorShow(int x) { // �����־��ʾ�ĺ����������ж�СX����ʾ���û����������滹��������������
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
	public void actionPerformed(ActionEvent e) { // ��ť����¼�����Ӧ
		// TODO Auto-generated method stub
		if (e.getSource() == No) { // ������ȡ����ť���˳�����
			System.exit(0);
		} else if (e.getSource() == Yes) { // ������ȷ����ť�Ϳ����ж�
			String tempusername = UserName.getText().toString();// ���������������������ݣ���String������
			String temppassword = PassWord.getText().toString();

			if (tempusername.equals("+0")) {
				new MainFrame(UserName.getText().toString());// ��ʱ�õĶ����û�
				this.dispose();// �ر��Լ�
			}

			if (tempusername.equals("")) {
				this.setTitle("�û�������Ϊ�գ�");// �ж��û�������������������Ƿ�Ϊ�գ��ڱ���������������ʾ������ʾС��X�������ĺ���
				ErrorShow(1);
			} else if (temppassword.equals("")) {
				this.setTitle("���벻��Ϊ�գ�");
				ErrorShow(2);
			} else {
				if (tempusername.equals(TempUsername)) {
					if (temppassword.equals(TempPassword)) {
						new MainFrame(UserName.getText().toString());// ���û�������������ݶ���ȵ�ʱ�򣬾�ִ�������ڣ��������û���
						this.dispose();// �ر��Լ�
					} else {
						this.setTitle("����������֤������");// ��ʾ����������ʾ
						ErrorShow(2);
					}
				} else {
					this.setTitle("���û���δע��");// ��ʾ�û����������ʾ
					ErrorShow(1);
				}
			}
		}
	}

	/*
	 * public void WindowMove() {
	 * 
	 * //����û�б���Ĵ��ڿ����϶� this.addMouseListener(new MouseAdapter() { public void
	 * mousePressed(MouseEvent e) { //���£�mousePressed ���ǵ����������걻����û��̧�� origin.x
	 * = e.getX(); //����갴�µ�ʱ���ô��ڵ�ǰ��λ�� origin.y = e.getY(); } });
	 * this.addMouseMotionListener(new MouseMotionAdapter() { public void
	 * mouseDragged(MouseEvent e) { Point p =getLocation(); //������϶�ʱ��ȡ���ڵ�ǰλ��
	 * //���ô��ڵ�λ�� //���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ�� setLocation(p.x +
	 * e.getX() - origin.x, p.y + e.getY() - origin.y); } }); }
	 */

}
