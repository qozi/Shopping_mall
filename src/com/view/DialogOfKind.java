package com.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import com.dao.KindDao;
import com.pojo.Kind;

public class DialogOfKind extends JDialog implements ActionListener {
	JTextField field;
	JButton add, del,cancel;
	TableOfKind kind;

	public DialogOfKind() {
		this.setTitle("商品种类");
		this.setSize(330, 400);
		this.setModal(true);
		this.setLayout(null);
		ScreenSize.setCenterLocation(this);

		kind = new TableOfKind();
		String[] names = { "种类编号 ", "种类名称" };
		kind.setNames(names);
		kind.addData(new KindDao().getKind());
		kind.TableInit(kind, 170, 400, this);

		field = new JTextField();
		add = new JButton("新增");
		del = new JButton("删除");
		cancel = new JButton("退出");

		this.add(field).setBounds(190, 50, 100, 25);
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
		kind.updateTable(new KindDao().getKind());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			Kind kind = new Kind();
			kind.setKid(0);
			kind.setKname(field.getText().trim());
			new KindDao().setKind(kind);
			field.setText("");
			updateTable();
		} else if (e.getSource() == del) {
			if(kind.table.getSelectedRow()>-1){
				new KindDao().delKind((int)kind.table.getValueAt(kind.table.getSelectedRow(), 0));
				updateTable();
			}
			else{
				System.out.println("oh!");
			}
		}else if(e.getSource()==cancel){
			this.dispose();
		}
	}
}
