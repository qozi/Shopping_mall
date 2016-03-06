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
	TableOfEmployees model_Employees;
	TableOfDepartment model_Department;
	JTextField field;
	JButton serch, jb1, jb2, jb3, jb4, jb5, jb6;

	PanelOfEmployees() {
		this.setLayout(null);
		model_Employees = new TableOfEmployees();
		String[] names_Employees = { "员工ID", "员工姓名", "员工性别", "联系电话", "员工职位" };
		model_Employees.setNames(names_Employees);
		model_Employees.addData(new EmployeesDao().getEmployees());
		model_Employees.TableInit(model_Employees, 400, 650, this);

		model_Department = new TableOfDepartment();
		String[] names_Department = { "部门ID", "部门名称" };
		model_Department.setNames(names_Department);
		model_Department.addData(new PositionDao().getPosition());
		model_Department.TableInit(model_Department, 180, 650, this);

		field = new JTextField();
		serch = new JButton("搜");
		jb1 = new JButton("新增员工");
		jb2 = new JButton("修改信息");
		jb3 = new JButton("删除信息");
		jb4 = new JButton("新增部门");
		jb5 = new JButton("修改部门");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		serch.addActionListener(this);
		this.add(field).setBounds(30, 20, 100, 25);
		this.add(serch).setBounds(135, 20, 50, 25);
		this.add(jb1).setBounds(460, 100, 100, 30);
		this.add(jb2).setBounds(460, 160, 100, 30);
		this.add(jb3).setBounds(810, 100, 100, 30);
		this.add(jb4).setBounds(810, 160, 100, 30);
		this.add(jb5).setBounds(35, 210, 100, 30);
	}

	void updateTable() {
		model_Employees.updateTable(new EmployeesDao().getEmployees());
		model_Department.updateTable(new PositionDao().getPosition());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == serch) {
			model_Employees.updateTable(new EmployeesDao().serchEmployees(field
					.getText().trim()));
		} else if (e.getSource() == jb3) {
//			EmployeesDao employeesDao = new EmployeesDao();
//			employeesDao
//					.delEmployees(model_Employees.table.getSelectedRow() + 1);
//			model_Employees.updateTable(employeesDao.getEmployees());
		} else if (e.getSource() == jb1) {
			CreateNewEmployeerDialog cned = new CreateNewEmployeerDialog();
			cned.addWindowListener(this);
		} else if (e.getSource() == jb2) {
			if (model_Employees.table.getSelectedRow() < 0) {
				System.out.println("请选择一行！");
			} else {
				UpdateEmployeerDialog ued = new UpdateEmployeerDialog(
						(int) model_Employees.getValueAt(
								model_Employees.table.getSelectedRow(), 0));
				ued.addWindowListener(this);
			}
		}else if(e.getSource()==jb4){
			CreateNewDepartmentDialog cndd = new CreateNewDepartmentDialog();
			cndd.addWindowListener(this);
		}else if(e.getSource()==jb5){
			if (model_Department.table.getSelectedRow() < 0) {
				System.out.println("请选择一行！");
			} else {
				UpdateDepartmentDialog ued = new UpdateDepartmentDialog(
						(int) model_Department.getValueAt(
								model_Department.table.getSelectedRow(), 0));
				ued.addWindowListener(this);
			}
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		updateTable();
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

			JLabel l2 = new JLabel("员工姓名");
			JLabel l3 = new JLabel("员工性别");
			JLabel l4 = new JLabel("员工电话");
			JLabel l5 = new JLabel("员工职位");
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
			this.add(l2).setBounds(50, 70, 70, 30);
			this.add(l3).setBounds(50, 110, 70, 30);
			this.add(l4).setBounds(50, 150, 70, 30);
			this.add(l5).setBounds(50, 190, 70, 30);
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
				em.setPid(0);
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

	class UpdateEmployeerDialog extends JDialog implements ActionListener {
		JButton jb1, jb2;
		JRadioButton jr1, jr2;
		JTextField t1, t2, t4;
		JComboBox jc;
		int pid;

		UpdateEmployeerDialog(int pid) {
			this.pid = pid;
			Employees employees = new EmployeesDao().getOneEmployees(pid);
			this.setLayout(null);
			this.setModal(true);
			this.setTitle("新增员工");
			this.setSize(350, 500);
			ScreenSize.setCenterLocation(this);

			// JLabel l1 = new JLabel("员工   ID");
			JLabel l2 = new JLabel("员工姓名");
			JLabel l3 = new JLabel("员工性别");
			JLabel l4 = new JLabel("员工电话");
			JLabel l5 = new JLabel("员工职位");
			// t1 = new JTextField(new Integer(employees.getPid()).toString());
			t2 = new JTextField(employees.getPname());
			jr1 = new JRadioButton("男");
			jr2 = new JRadioButton("女");
			ButtonGroup group = new ButtonGroup();
			group.add(jr1);
			group.add(jr2);
			t4 = new JTextField(employees.getPphone());
			jc = new JComboBox(new PositionDao().getPosition());
			jb1 = new JButton("确认");
			jb2 = new JButton("取消");
			// this.add(l1).setBounds(50, 30, 70, 30);
			this.add(l2).setBounds(50, 70, 70, 30);
			this.add(l3).setBounds(50, 110, 70, 30);
			this.add(l4).setBounds(50, 150, 70, 30);
			this.add(l5).setBounds(50, 190, 70, 30);
			// this.add(t1).setBounds(140, 35, 100, 20);
			this.add(t2).setBounds(140, 75, 100, 20);
			this.add(jr1).setBounds(140, 115, 50, 20);
			this.add(jr2).setBounds(190, 115, 50, 20);
			this.add(t4).setBounds(140, 155, 100, 20);
			this.add(jc).setBounds(140, 195, 70, 25);
			this.add(jb1).setBounds(100, 250, 70, 30);
			this.add(jb2).setBounds(180, 250, 70, 30);

			jr1.setSelected(true);
			if (employees.getPsex().equals("女"))
				jr2.setSelected(true);

			jc.setSelectedItem(new PositionDao().getOnePosition(employees
					.getPpositionid()));

			jb1.addActionListener(this);
			jb2.addActionListener(this);

			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb2) {
				this.dispose();
			} else if (e.getSource() == jb1) {
				Employees em = new Employees();
				em.setPid(pid);
				em.setPname(t2.getText().trim());
				em.setPsex(jr1.isSelected() ? "男" : "女");
				em.setPphone(t4.getText().trim());
				Position p = (Position) jc.getSelectedItem();
				em.setPpositionid(p.getPoid());
				new EmployeesDao().updateEmployees(em);
				this.dispose();
			}
		}
	}
	
	class CreateNewDepartmentDialog extends JDialog implements ActionListener {
		JButton jb1, jb2;
		JTextField t2;

		CreateNewDepartmentDialog() {
			this.setLayout(null);
			this.setModal(true);
			this.setTitle("新增部门");
			this.setSize(300, 170);
			ScreenSize.setCenterLocation(this);

			JLabel l2 = new JLabel("部门名称");
			t2 = new JTextField();
			jb1 = new JButton("确认");
			jb2 = new JButton("取消");
			this.add(l2).setBounds(50, 30, 70, 30);
			this.add(t2).setBounds(140, 35, 100, 20);
			this.add(jb1).setBounds(75, 80, 70, 30);
			this.add(jb2).setBounds(155, 80, 70, 30);

			jb1.addActionListener(this);
			jb2.addActionListener(this);

			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb2) {
				this.dispose();
			} else if (e.getSource() == jb1) {
				Position p = new Position();
				p.setPoid(0);
				p.setPoname(t2.getText().trim());
				new PositionDao().setPosition(p);
				this.dispose();
			}
		}
	}
	
	class UpdateDepartmentDialog extends JDialog implements ActionListener {
		JButton jb1, jb2;
		JTextField t2;
		int poid;

		UpdateDepartmentDialog(int poid) {
			this.poid = poid;
			Position position = new PositionDao().getOnePosition(poid);
			this.setLayout(null);
			this.setModal(true);
			this.setTitle("新增部门");
			this.setSize(300, 170);
			ScreenSize.setCenterLocation(this);

			JLabel l2 = new JLabel("员工姓名");
			t2 = new JTextField(position.getPoname());
			jb1 = new JButton("确认");
			jb2 = new JButton("取消");
			this.add(l2).setBounds(50, 30, 70, 30);
			this.add(t2).setBounds(140, 35, 100, 20);
			this.add(jb1).setBounds(75, 80, 70, 30);
			this.add(jb2).setBounds(155, 80, 70, 30);

			jb1.addActionListener(this);
			jb2.addActionListener(this);

			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb2) {
				this.dispose();
			} else if (e.getSource() == jb1) {
				Position position = new Position();
				position.setPoid(poid);
				position.setPoname(t2.getText().trim());
				new PositionDao().updatePosition(position);
				this.dispose();
			}
		}
	}

}
