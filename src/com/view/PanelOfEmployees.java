package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.dao.EmployeesDao;

public class PanelOfEmployees extends JPanel {
	PanelOfEmployees() {
		this.setLayout(null);
		TableOfEmployees model = new TableOfEmployees();
		String[] names = { "员工ID", "员工姓名", "员工性别", "联系电话", "员工职位" };
		model.setNames(names);
		model.addData(new EmployeesDao().getEmployees());
		model.TableInit(model, 400, 400, this);
		JButton jb1 = new JButton("新增员工");
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateNewEmployeerDialog();
			}
		});
		this.add(jb1).setBounds(35, 50, 100, 30);
	}

	class CreateNewEmployeerDialog extends JDialog {
		CreateNewEmployeerDialog() {
			this.setModal(true);
			this.setTitle("新增员工");
			this.setSize(300, 600);
			ScreenSize.setCenterLocation(this);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		}
	}
}
