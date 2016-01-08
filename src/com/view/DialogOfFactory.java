package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import com.dao.FactoryDao;
import com.dao.KindDao;
import com.pojo.Factory;
import com.pojo.Kind;

public class DialogOfFactory extends JDialog implements ActionListener {
	JTextField field, field2;
	JButton add, del, cancel;
	TableOfFactory factory;

	public DialogOfFactory() {
		this.setTitle("��������");
		this.setSize(330, 400);
		this.setModal(true);
		this.setLayout(null);
		ScreenSize.setCenterLocation(this);

		factory = new TableOfFactory();
		String[] names = { "���ұ�� ", "��������", "��ϵ�绰" };
		factory.setNames(names);
		factory.addData(new FactoryDao().getFactory());
		factory.TableInit(factory, 170, 400, this);

		field = new JTextField();
		field2 = new JTextField();
		add = new JButton("����");
		del = new JButton("ɾ��");
		cancel = new JButton("�˳�");

		this.add(field).setBounds(190, 50, 100, 25);
		this.add(field2).setBounds(190, 90, 100, 25);
		this.add(add).setBounds(190, 130, 100, 30);
		this.add(del).setBounds(190, 180, 100, 30);
		this.add(cancel).setBounds(190, 230, 100, 30);

		add.addActionListener(this);
		del.addActionListener(this);
		cancel.addActionListener(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	void updateTable() {
		factory.updateTable(new FactoryDao().getFactory());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			Factory factory = new Factory();
			factory.setFid(0);
			factory.setFname(field.getText().trim());
			factory.setFphone(field2.getText().trim());
			new FactoryDao().setFactory(factory);
			field.setText("");
			field2.setText("");
			updateTable();
		} else if (e.getSource() == del) {
			if (factory.table.getSelectedRow() > -1) {
				new KindDao().delKind((int) factory.table.getValueAt(
						factory.table.getSelectedRow(), 0));
				updateTable();
			} else {
				System.out.println("oh!");
			}
		} else if (e.getSource() == cancel) {
			this.dispose();
		}
	}
}
