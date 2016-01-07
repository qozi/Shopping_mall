package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.dao.EmployeesDao;
import com.dao.PositionDao;
import com.pojo.Employees;
import com.pojo.Position;

public class PanelOfEmployees extends MyWindowListener implements
		ActionListener {
	TableOfEmployees model;
	JTextField field;
	JButton serch, jb1, jb2, jb3;

	PanelOfEmployees() {
		this.setLayout(null);
		model = new TableOfEmployees();
		String[] names = { "Ա��ID", "Ա������", "Ա���Ա�", "��ϵ�绰", "Ա��ְλ" };
		model.setNames(names);
		model.addData(new EmployeesDao().getEmployees());
		model.TableInit(model, 400, 400, this);
		field = new JTextField();
		serch = new JButton("��");
		jb1 = new JButton("����Ա��");
		jb2 = new JButton("�޸���Ϣ");
		jb3 = new JButton("ɾ����Ϣ");
		jb1.addActionListener(this);
		serch.addActionListener(this);
		this.add(field).setBounds(35, 20, 100, 25);
		this.add(serch).setBounds(135, 20, 50, 25);
		this.add(jb1).setBounds(35, 50, 100, 30);
		this.add(jb2).setBounds(35, 90, 100, 30);
		this.add(jb3).setBounds(35, 130, 100, 30);
	}

	void updateTable() {
		model.updateTable(new EmployeesDao().getEmployees());
	}

	class CreateNewEmployeerDialog extends JDialog implements ActionListener {
		JButton jb1, jb2;
		JRadioButton jr1, jr2;
		JTextField t1, t2, t4;
		JComboBox jc;

		CreateNewEmployeerDialog() {
			this.setLayout(null);
			this.setModal(true);
			this.setTitle("����Ա��");
			this.setSize(350, 500);
			ScreenSize.setCenterLocation(this);

			JLabel l1 = new JLabel("Ա��   ID");
			JLabel l2 = new JLabel("Ա������");
			JLabel l3 = new JLabel("Ա���Ա�");
			JLabel l4 = new JLabel("Ա���绰");
			JLabel l5 = new JLabel("Ա��ְλ");
			t1 = new JTextField();
			t2 = new JTextField();
			jr1 = new JRadioButton("��");
			jr2 = new JRadioButton("Ů");
			ButtonGroup group = new ButtonGroup();
			group.add(jr1);
			group.add(jr2);
			t4 = new JTextField();
			jc = new JComboBox(new PositionDao().getPosition());
			jb1 = new JButton("ȷ��");
			jb2 = new JButton("ȡ��");
			this.add(l1).setBounds(50, 30, 70, 30);
			this.add(l2).setBounds(50, 70, 70, 30);
			this.add(l3).setBounds(50, 110, 70, 30);
			this.add(l4).setBounds(50, 150, 70, 30);
			this.add(l5).setBounds(50, 190, 70, 30);
			this.add(t1).setBounds(140, 35, 100, 20);
			this.add(t2).setBounds(140, 75, 100, 20);
			this.add(jr1).setBounds(140, 115, 50, 20);
			this.add(jr2).setBounds(190, 115, 50, 20);
			this.add(t4).setBounds(140, 155, 100, 20);
			this.add(jc).setBounds(140, 195, 70, 25);
			this.add(jb1).setBounds(100, 250, 70, 30);
			this.add(jb2).setBounds(180, 250, 70, 30);

			jb1.addActionListener(this);
			jb2.addActionListener(this);

			jr1.setSelected(true);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb2) {
				this.dispose();
			} else if (e.getSource() == jb1) {
				Employees em = new Employees();
				em.setPid(Integer.parseInt(t1.getText()));
				em.setPname(t2.getText().trim());
				em.setPsex(jr1.isSelected() ? "��" : "Ů");
				em.setPphone(t4.getText().trim());
				Position p = (Position) jc.getSelectedItem();
				em.setPpositionid(p.getPoid());
				new EmployeesDao().setEmployees(em);
				this.dispose();
			}
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		updateTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == serch) {
			model.updateTable(new EmployeesDao().serchEmployees(field.getText().trim()));
		} else if (e.getSource() == jb1) {
			CreateNewEmployeerDialog cned = new CreateNewEmployeerDialog();
			cned.addWindowListener(this);
		}
	}
}
