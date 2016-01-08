package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dao.BuyDao;
import com.dao.FactoryDao;
import com.dao.GoodsDao;
import com.dao.KindDao;
import com.pojo.Factory;
import com.pojo.Kind;

public class PanelOfBuy extends MyWindowListener implements ActionListener {
	JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9;
	JTextField t1, t3, t4, t5, t7, t8, t9;
	JComboBox jc2, jc6;
	JButton add_kind, add_factory;

	PanelOfBuy() {
		this.setLayout(null);
		TableOfBuy model = new TableOfBuy();
		String[] names = { "入货编号", "入货价格", "入货时间", "入货数量", "货品名称" };
		model.setNames(names);
		model.addData(new BuyDao().getBuy());
		model.TableInit(model, 400, 600, this);

		j1 = new JLabel("商品名称");
		j2 = new JLabel("商品种类");
		j3 = new JLabel("进货数量");
		j4 = new JLabel("进货日期");
		j5 = new JLabel("保质时长");
		j6 = new JLabel("供货厂家");
		j7 = new JLabel("条形编码");
		j8 = new JLabel("进货价格");
		j9 = new JLabel("零售价格");

		add_kind = new JButton("+");
		add_factory = new JButton("+");

		t1 = new JTextField();
		jc2 = new JComboBox(new KindDao().getKind());
		t3 = new JTextField();
		t4 = new JTextField("点击选择日期");
		t5 = new JTextField();
		jc6 = new JComboBox(new FactoryDao().getFactory());
		t7 = new JTextField();
		t8 = new JTextField();
		t9 = new JTextField();

		this.add(j1).setBounds(430, 30, 70, 30);
		this.add(j2).setBounds(430, 80, 70, 30);
		this.add(j3).setBounds(430, 130, 70, 30);
		this.add(j4).setBounds(430, 180, 70, 30);
		this.add(j5).setBounds(430, 230, 70, 30);
		this.add(j6).setBounds(430, 280, 70, 30);
		this.add(j7).setBounds(430, 330, 70, 30);
		this.add(j8).setBounds(430, 380, 70, 30);
		this.add(j9).setBounds(430, 430, 70, 30);

		DateChooser chooser = DateChooser.getInstance("yyyy-MM-dd");
		chooser.register(t4);

		this.add(t1).setBounds(530, 32, 140, 25);
		this.add(jc2).setBounds(530, 82, 100, 25);
		this.add(add_kind).setBounds(630, 82, 40, 25);
		this.add(t3).setBounds(530, 132, 140, 25);
		this.add(t4).setBounds(530, 182, 140, 25);
		this.add(t5).setBounds(530, 232, 140, 25);
		this.add(jc6).setBounds(530, 282, 100, 25);
		this.add(add_factory).setBounds(630, 282, 40, 25);
		this.add(t7).setBounds(530, 332, 140, 25);
		this.add(t8).setBounds(530, 382, 140, 25);
		this.add(t9).setBounds(530, 432, 140, 25);

		add_kind.addActionListener(this);
		add_factory.addActionListener(this);

	}

	void updateComboBox() {
		jc2.removeAllItems();
		for (Kind k : new KindDao().getKind()) {
			jc2.addItem(k);
		}
		jc6.removeAllItems();
		for (Factory f : new FactoryDao().getFactory()) {
			jc6.addItem(f);
		}
		this.updateUI();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		updateComboBox();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		updateComboBox();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add_kind) {
			DialogOfKind kind = new DialogOfKind();
			kind.addWindowListener(this);
		} else if (e.getSource() == add_factory) {
			DialogOfFactory factory = new DialogOfFactory();
			factory.addWindowListener(this);
		}
	}
}
