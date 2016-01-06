package com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PasswordChange extends JDialog implements ActionListener {
	Container c = getContentPane();
	JLabel JAError, JACurret1, JACurret2, JACurret3;
	JButton Yes, No;
	JTextField oldpass, newpass, surepass;
	String Tempoldpass = "123456", Tempnewpass, Tempsurepass;

	public PasswordChange(String title_name) {
		// TODO Auto-generated constructor stub
		setTitle("�޸�����" + "   ��¼�ʺţ�" + title_name);
		setSize(350, 200);
		setModal(true);
		// setLocation(400, 400);
		ScreenSize.setCenterLocation(this);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		c.setLayout(null);
		JLabel JAoldpass = new JLabel("������");
		JLabel JAnewpass = new JLabel("������");
		JLabel JAsurepass = new JLabel("ȷ������");

		JAError = new JLabel("��");// ����������ʾ����
		JAError.setForeground(Color.RED);// ����СXǰ��ɫΪ��ɫ
		JAError.setFont(new Font(Font.DIALOG, Font.BOLD, 30));// ����СX�Ĵ�С���������������ԣ�����������Ϊ�����С��

		oldpass = new JTextField();
		newpass = new JTextField();
		surepass = new JTextField();
		Yes = new JButton("ȷ��");
		No = new JButton("ȡ��");

		c.add(JAoldpass).setBounds(65, 20, 60, 16);
		c.add(JAnewpass).setBounds(65, 55, 60, 16);
		c.add(JAsurepass).setBounds(38 + 15, 90, 60, 16);
		c.add(oldpass).setBounds(125, 17, 131, 24);
		c.add(newpass).setBounds(125, 52, 131, 24);
		c.add(surepass).setBounds(125, 87, 131, 24);
		c.add(Yes).setBounds(70 + 15, 125, 70, 24);
		c.add(No).setBounds(170 + 15, 125, 70, 24);

		Yes.addActionListener(this);
		No.addActionListener(this);

		// new ScreenSize().setCenterLocation(this);//105-60=45
		setVisible(true);
	}

	// public static void main(String[] args) {
	// new PasswordChange();
	// }

	private void ErrorShow(int x) { // �����־��ʾ�ĺ����������ж�СX����ʾ���û����������滹��������������
		switch (x) {
		case 1:
			c.add(JAError).setBounds(243 + 15, 20, 20, 20);
			break;
		case 2:
			c.add(JAError).setBounds(243 + 15, 55, 20, 20);
			break;
		case 3:
			c.add(JAError).setBounds(243 + 15, 90, 20, 20);
			break;
		case 4:
			c.add(JAError).setBounds(243 + 100, 90, 20, 20);
			break;
		}
	}

	private void CurrentShow() {
		Color color = new Color(46, 217, 80);
		JACurret1 = new JLabel("��");// ����������ʾ����
		JACurret1.setForeground(color);// ����СXǰ��ɫΪ��ɫ
		JACurret1.setFont(new Font(Font.DIALOG, Font.BOLD, 15));// ����СX�Ĵ�С���������������ԣ�����������Ϊ�����С��
		JACurret2 = new JLabel("��");
		JACurret2.setForeground(color);
		JACurret2.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		JACurret3 = new JLabel("��");
		JACurret3.setForeground(color);
		JACurret3.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		c.add(JACurret1).setBounds(243 + 20, 20, 20, 20);
		c.add(JACurret2).setBounds(243 + 20, 55, 20, 20);
		c.add(JACurret3).setBounds(243 + 20, 90, 20, 20);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == No) {
			this.setVisible(false);
		} else if (e.getSource() == Yes) {
			String tempoldpass = oldpass.getText().toString();
			String tempnewpass = newpass.getText().toString();
			String tempsurepass = surepass.getText().toString();
			if (tempoldpass.equals("")) {
				setTitle("�����벻��Ϊ�գ�");
				ErrorShow(1);
			} else if (tempnewpass.equals("")) {
				setTitle("�����벻��Ϊ�գ�");
				ErrorShow(2);
			} else if (tempsurepass.equals("")) {
				setTitle("��ȷ����������룡");
				ErrorShow(3);
			} else {
				if (tempoldpass.equals(Tempoldpass)) {
					if (tempnewpass.equals(tempoldpass)) {
						setTitle("�����벻�����������ͬ��");
						ErrorShow(2);
					} else {
						if (tempnewpass.equals(tempsurepass)) {
							setTitle("�����޸ĳɹ���");
							ErrorShow(4);
							CurrentShow();
							Yes.setVisible(false);
						} else {
							setTitle("��������������벻��ͬ��");
							ErrorShow(3);
						}
					}
				} else {
					setTitle("Old password is not current");
					ErrorShow(3);
				}
			}
		}
	}
}
// package com.view;
//
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
//
// import javax.swing.*;
//
// public class PasswordChange extends JFrame implements ActionListener {
// Container c = getContentPane();
// JLabel JAError, JACurret1, JACurret2, JACurret3;
// JButton Yes, No;
// JTextField oldpass, newpass, surepass;
// String Tempoldpass = "123456", Tempnewpass, Tempsurepass;
//
// public PasswordChange(String title_name) {
// // TODO Auto-generated constructor stub
// setTitle("�޸�����" + "   ��¼�ʺţ�" + title_name);
// setSize(350, 200);
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
// c.setLayout(null);
// JLabel JAoldpass = new JLabel("������");
// JLabel JAnewpass = new JLabel("������");
// JLabel JAsurepass = new JLabel("ȷ������");
//
// JAError = new JLabel("��");// ����������ʾ����
// JAError.setForeground(Color.RED);// ����СXǰ��ɫΪ��ɫ
// JAError.setFont(new Font(Font.DIALOG, Font.BOLD, 30));//
// ����СX�Ĵ�С���������������ԣ�����������Ϊ�����С��
//
// oldpass = new JTextField();
// newpass = new JTextField();
// surepass = new JTextField();
// Yes = new JButton("ȷ��");
// No = new JButton("ȡ��");
//
// c.add(JAoldpass).setBounds(65, 20, 60, 16);
// c.add(JAnewpass).setBounds(65, 55, 60, 16);
// c.add(JAsurepass).setBounds(38 + 15, 90, 60, 16);
// c.add(oldpass).setBounds(125, 17, 131, 24);
// c.add(newpass).setBounds(125, 52, 131, 24);
// c.add(surepass).setBounds(125, 87, 131, 24);
// c.add(Yes).setBounds(70 + 15, 125, 70, 24);
// c.add(No).setBounds(170 + 15, 125, 70, 24);
//
// Yes.addActionListener(this);
// No.addActionListener(this);
//
// new ScreenSize().setCenterLocation(this);//105-60=45
// setVisible(true);
// }
//
// // public static void main(String[] args) {
// // new PasswordChange();
// // }
//
// private void ErrorShow(int x) { // �����־��ʾ�ĺ����������ж�СX����ʾ���û����������滹��������������
// switch (x) {
// case 1:
// c.add(JAError).setBounds(243 + 15, 20, 20, 20);
// break;
// case 2:
// c.add(JAError).setBounds(243 + 15, 55, 20, 20);
// break;
// case 3:
// c.add(JAError).setBounds(243 + 15, 90, 20, 20);
// break;
// case 4:
// c.add(JAError).setBounds(243 + 100, 90, 20, 20);
// break;
// }
// }
//
// private void CurrentShow() {
// Color color = new Color(46, 217, 80);
// JACurret1 = new JLabel("��");// ����������ʾ����
// JACurret1.setForeground(color);// ����СXǰ��ɫΪ��ɫ
// JACurret1.setFont(new Font(Font.DIALOG, Font.BOLD, 15));//
// ����СX�Ĵ�С���������������ԣ�����������Ϊ�����С��
// JACurret2 = new JLabel("��");
// JACurret2.setForeground(color);
// JACurret2.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
// JACurret3 = new JLabel("��");
// JACurret3.setForeground(color);
// JACurret3.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
// c.add(JACurret1).setBounds(243 + 20, 20, 20, 20);
// c.add(JACurret2).setBounds(243 + 20, 55, 20, 20);
// c.add(JACurret3).setBounds(243 + 20, 90, 20, 20);
//
// }
//
// @Override
// public void actionPerformed(ActionEvent e) {
// // TODO Auto-generated method stub
// if (e.getSource() == No) {
// this.setVisible(false);
// } else if (e.getSource() == Yes) {
// String tempoldpass = oldpass.getText().toString();
// String tempnewpass = newpass.getText().toString();
// String tempsurepass = surepass.getText().toString();
// if (tempoldpass.equals("")) {
// setTitle("�����벻��Ϊ�գ�");
// ErrorShow(1);
// } else if (tempnewpass.equals("")) {
// setTitle("�����벻��Ϊ�գ�");
// ErrorShow(2);
// } else if (tempsurepass.equals("")) {
// setTitle("��ȷ����������룡");
// ErrorShow(3);
// } else {
// if (tempoldpass.equals(Tempoldpass)) {
// if (tempnewpass.equals(tempoldpass)) {
// setTitle("�����벻�����������ͬ��");
// ErrorShow(2);
// } else {
// if (tempnewpass.equals(tempsurepass)) {
// setTitle("�����޸ĳɹ���");
// ErrorShow(4);
// CurrentShow();
// Yes.setVisible(false);
// } else {
// setTitle("��������������벻��ͬ��");
// ErrorShow(3);
// }
// }
// } else {
// setTitle("Old password is not current");
// ErrorShow(3);
// }
// }
// }
// }
// }