package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dao.BuyDao;
import com.dao.FactoryDao;
import com.dao.GoodsDao;
import com.dao.KindDao;
import com.pojo.Buy;
import com.pojo.Factory;
import com.pojo.Goods;
import com.pojo.Kind;

public class PanelOfBuy extends MyWindowListener implements ActionListener {
	JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, serch_l;
	JTextField t1, t3, t4, t5, t7, t8, t9, serch_t, serch_date;
	JComboBox jc2, jc6;
	JButton add_kind, add_factory, yes, no, serch_b, serch_c;
	TableOfBuy model;
	TableOfGoods model2;
	static int select_row = 0;

	PanelOfBuy() {
		this.setLayout(null);
		model = new TableOfBuy();
		String[] names = { "入货编号", "货品名称", "入货时间", "入货数量", "价格" };
		model.setNames(names);
		model.addData(new BuyDao().getBuy());
		model.TableInit(model, 400, 650, this);

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
		serch_b = new JButton("搜");
		serch_c = new JButton("清");

		serch_t = new JTextField();
		serch_date = new JTextField();
		t1 = new JTextField();
		jc2 = new JComboBox(new KindDao().getKind());
		t3 = new JTextField();
		t4 = new JTextField("点击选择日期");
		t5 = new JTextField();
		jc6 = new JComboBox(new FactoryDao().getFactory());
		t7 = new JTextField();
		t8 = new JTextField();
		t9 = new JTextField();
		yes = new JButton("确认");
		no = new JButton("清空");

		this.add(j1).setBounds(430, 30 + 60, 70, 30);
		this.add(j2).setBounds(430, 80 + 60, 70, 30);
		this.add(j3).setBounds(430, 130 + 60, 70, 30);
		this.add(j4).setBounds(430, 180 + 60, 70, 30);
		this.add(j5).setBounds(430, 230 + 60, 70, 30);
		this.add(j6).setBounds(430, 280 + 60, 70, 30);
		this.add(j7).setBounds(430, 330 + 60, 70, 30);
		this.add(j8).setBounds(430, 380 + 60, 70, 30);
		this.add(j9).setBounds(430, 430 + 60, 70, 30);

		DateChooser chooser = DateChooser.getInstance("yyyy-MM-dd");
		chooser.register(t4);
		DateChooser chooser2 = DateChooser.getInstance("yyyy-MM-dd");
		chooser2.register(serch_date);

		this.add(t1).setBounds(530, 32 + 60, 140, 25);
		this.add(jc2).setBounds(530, 82 + 60, 100, 25);
		this.add(add_kind).setBounds(630, 82 + 60, 40, 25);
		this.add(t3).setBounds(530, 132 + 60, 140, 25);
		this.add(t4).setBounds(530, 182 + 60, 140, 25);
		this.add(t5).setBounds(530, 232 + 60, 140, 25);
		this.add(jc6).setBounds(530, 282 + 60, 100, 25);
		this.add(add_factory).setBounds(630, 282 + 60, 40, 25);
		this.add(t7).setBounds(530, 332 + 60, 140, 25);
		this.add(t8).setBounds(530, 382 + 60, 140, 25);
		this.add(t9).setBounds(530, 432 + 60, 140, 25);

		this.add(serch_t).setBounds(30, 20, 100, 25);
		this.add(serch_b).setBounds(250, 20, 60, 25);
		this.add(serch_c).setBounds(320, 20, 60, 25);
		this.add(serch_date).setBounds(150, 20, 80, 25);
		serch_date.setText("");

		this.add(yes).setBounds(430, 500 + 60, 70, 30);
		this.add(no).setBounds(530, 500 + 60, 70, 30);

		add_kind.addActionListener(this);
		add_factory.addActionListener(this);
		yes.addActionListener(this);
		no.addActionListener(this);
		serch_b.addActionListener(this);
		serch_c.addActionListener(this);

		clearAll();
	}

	void updateTable() {
		model.updateTable(new BuyDao().getBuy());
	}

	void updateComboBox() {
		Kind tempkind = (Kind) jc2.getSelectedItem();
		jc2.removeAllItems();
		for (Kind k : new KindDao().getKind()) {
			jc2.addItem(k);
		}
		jc2.setSelectedItem(tempkind);
		Factory tempfactory = (Factory) jc6.getSelectedItem();
		jc6.removeAllItems();
		for (Factory f : new FactoryDao().getFactory()) {
			jc6.addItem(f);
		}
		jc6.setSelectedItem(tempfactory);
		this.updateUI();
	}

	void setSelectRow(int bid) {
		int gid = new BuyDao().getOneBuy(bid);
		Goods g = new GoodsDao().getOneGoods(gid);
		t1.setText(g.getGname());
		jc2.setSelectedItem(new KindDao().getOneKind(g.getGkind()));
		t4.setText(new SimpleDateFormat("yyyy-MM-dd").format(g.getGdatein()));
		t5.setText(Integer.toString(g.getGklong()));
		jc6.setSelectedItem(new FactoryDao().getOneFactory(g.getGfrom()));
		t7.setText(Integer.toString(g.getGcode()));
		t8.setText(Float.toString(g.getGpricein()));
		t9.setText(Float.toString(g.getGpriceout()));
	}

	void setSelectName(int gid) {
		Goods g = new GoodsDao().getOneGoods(gid);
		t1.setText(g.getGname());
		jc2.setSelectedItem(new KindDao().getOneKind(g.getGkind()));
		t4.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		t5.setText(Integer.toString(g.getGklong()));
		jc6.setSelectedItem(new FactoryDao().getOneFactory(g.getGfrom()));
		t7.setText(Integer.toString(g.getGcode()));
		t8.setText(Float.toString(g.getGpricein()));
		t9.setText(Float.toString(g.getGpriceout()));
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
		} else if (e.getSource() == yes) {
			if (new GoodsDao().getOneGoods(t1.getText().trim()) == 0) {
				newCommodity();
			} else {
				oldCommodity();
			}
		} else if (e.getSource() == no) {
			clearAll();
		} else if (e.getSource() == serch_b) {
			model.updateTable(new BuyDao().serchBuy(serch_t.getText().trim()));
		} else if (e.getSource() == serch_c) {
			serch_t.setText("");
			model.updateTable(new BuyDao().getBuy());
		}
	}

	void oldCommodity() {
		Goods tempgoods = null;
		String tempname = t1.getText().trim();
		Vector<Goods> tempv = new GoodsDao().getGoods();
		for (Goods goods : tempv) {
			if (goods.getGname().equals(tempname)) {
				tempgoods = goods;
				break;
			}
		}

		Goods goods = new Goods();
		goods.setGid(tempgoods.getGid());
		goods.setGname(t1.getText().trim());
		Kind kind = (Kind) jc2.getSelectedItem();
		goods.setGkind(kind.getKid());
		goods.setGnum(tempgoods.getGnum() + Integer.parseInt(t3.getText().trim()));
		try {
			goods.setGdatein(new SimpleDateFormat("yyyy-MM-dd").parse(t4.getText().trim()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		goods.setGklong(Integer.parseInt(t5.getText().trim()));
		Factory factory = (Factory) jc6.getSelectedItem();
		goods.setGfrom(factory.getFid());
		goods.setGcode(Integer.parseInt(t7.getText().trim()));
		goods.setGpricein(Float.parseFloat(t8.getText().trim()));
		goods.setGpriceout(Float.parseFloat(t9.getText().trim()));
		new GoodsDao().updateGoods(goods);
		PanelOfGoods.updateTableOfSale();

		Date date = new Date();
		String[] time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date).split(" ");
		String datetime = t4.getText().trim() + " " + time[1];
		try {
			date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(datetime);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Buy buy = new Buy();
		buy.setBprice(goods.getGpricein());
		buy.setBdatetime(date);
		buy.setBnum(Integer.parseInt(t3.getText().trim()));
		buy.setBgid(new GoodsDao().getOneGoods(goods.getGname()));
		new BuyDao().setBuy(buy);
		updateTable();

		clearAll();
	}

	void newCommodity() {
		Goods goods = new Goods();
		goods.setGname(t1.getText().trim());
		Kind kind = (Kind) jc2.getSelectedItem();
		goods.setGkind(kind.getKid());
		goods.setGnum(Integer.parseInt(t3.getText().trim()));
		try {
			goods.setGdatein(new SimpleDateFormat("yyyy-MM-dd").parse(t4.getText().trim()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		goods.setGklong(Integer.parseInt(t5.getText().trim()));
		Factory factory = (Factory) jc6.getSelectedItem();
		goods.setGfrom(factory.getFid());
		goods.setGcode(Integer.parseInt(t7.getText().trim()));
		goods.setGpricein(Float.parseFloat(t8.getText().trim()));
		goods.setGpriceout(Float.parseFloat(t9.getText().trim()));
		new GoodsDao().setGoods(goods);
		PanelOfGoods.updateTableOfSale();

		Date date = new Date();
		String[] time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date).split(" ");
		String datetime = t4.getText().trim() + " " + time[1];
		try {
			date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(datetime);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Buy buy = new Buy();
		buy.setBprice(goods.getGpricein());
		buy.setBdatetime(date);
		buy.setBnum(goods.getGnum());
		buy.setBgid(new GoodsDao().getOneGoods(goods.getGname()));
		new BuyDao().setBuy(buy);
		updateTable();

		clearAll();
	}

	void clearAll() {
		t1.setText("");
		jc2.setSelectedIndex(-1);
		t3.setText("");
		t4.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		t5.setText("");
		jc6.setSelectedIndex(-1);
		t7.setText("");
		t8.setText("");
		t9.setText("");
	}
}
