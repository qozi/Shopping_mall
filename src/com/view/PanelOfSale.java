package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dao.BuyDao;
import com.dao.SaleDao;

public class PanelOfSale extends JPanel implements ActionListener {
	JTextField serch_t, serch_date;
	JButton serch_b, serch_c;
	TableOfSale model;
	JButton update;

	PanelOfSale() {
		this.setLayout(null);
		model = new TableOfSale();
		String[] names = { "交易编号", "销售商品", "销售时间", "销售数量", "销售价格", "单笔销售总价" };
		model.setNames(names);
		model.addData(new SaleDao().getSale());
		model.TableInit(model, 700, 700, this);

		serch_b = new JButton("搜");
		serch_c = new JButton("清");
		serch_t = new JTextField();
		serch_date = new JTextField();

		DateChooser chooser2 = DateChooser.getInstance("yyyy-MM-dd");
		chooser2.register(serch_date);

		this.add(serch_t).setBounds(300, 15, 100, 25);
		this.add(serch_b).setBounds(520, 15, 60, 25);
		this.add(serch_c).setBounds(590, 15, 60, 25);
		this.add(serch_date).setBounds(420, 15, 80, 25);
		serch_date.setText("");

		serch_b.addActionListener(this);
		serch_c.addActionListener(this);

		update = new JButton("刷新");
		this.add(update).setBounds(120, 15, 100, 25);
		update.addActionListener(this);

	}

	public void updateTableOfSale() {
		model.updateTable(new SaleDao().getSale());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == update) {
			updateTableOfSale();
		} else if (e.getSource() == serch_b) {
		} else if (e.getSource() == serch_c) {
		}
	}
}
