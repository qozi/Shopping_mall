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
		String[] names = { "员工ID", "员工姓名", "员工性别", "联系电话", "员工职位" };
		model.setNames(names);
		model.addData(new EmployeesDao().getEmployees());
		model.TableInit(model, 400, 400, this);
		field = new JTextField();
		serch = new JButton("搜");
		jb1 = new JButton("新增员工");
		jb2 = new JButton("修改信息");
		jb3 = new JButton("删除信息");
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
			this.setTitle("新增员工");
			this.setSize(350, 500);
			ScreenSize.setCenterLocation(this);

			JLabel l1 = new JLabel("员工   ID");
			JLabel l2 = new JLabel("员工姓名");
			JLabel l3 = new JLabel("员工性别");
			JLabel l4 = new JLabel("员工电话");
			JLabel l5 = new JLabel("员工职位");
			t1 = new JTextField();
			t2 = new JTextField();
			jr1 = new JRadioButton("男");
			jr2 = new JRadioButton("女");
			ButtonGroup group = new ButtonGroup();
			group.add(jr1);
			group.add(jr2);
			t4 = new JTextField();
			jc = new JComboBox(new PositionDao().getPosition());
			jb1 = new JButton("确认");
			jb2 = new JButton("取消");
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
				em.setPsex(jr1.isSelected() ? "男" : "女");
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
