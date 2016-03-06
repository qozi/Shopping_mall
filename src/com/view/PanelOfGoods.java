package com.view;

import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.dao.BuyDao;
import com.dao.FactoryDao;
import com.dao.GoodsDao;
import com.dao.KindDao;
import com.pojo.Goods;

public class PanelOfGoods extends JPanel {
	static TableOfGoods model;
	JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9;

	PanelOfGoods() {
		this.setLayout(null);
		model = new TableOfGoods();
		String[] names = { "商品ID", "商品名称", "商品种类", "商品数量", "商品价格" };
		model.setNames(names);
		model.addData(new GoodsDao().getGoods());
		model.TableInit(model, 400, 800, -15, 0, this);

		j1 = new JLabel("商品名称");
		j2 = new JLabel("商品种类");
		j3 = new JLabel("进货数量");
		j4 = new JLabel("进货日期");
		j5 = new JLabel("保质时长");
		j6 = new JLabel("供货厂家");
		j7 = new JLabel("条形编码");
		j8 = new JLabel("进货价格");
		j9 = new JLabel("零售价格");

		this.add(j1).setBounds(450, 20, 100, 15);
		this.add(j2).setBounds(600, 20, 100, 15);
		this.add(j3).setBounds(750, 20, 100, 15);
		this.add(j4).setBounds(450, 60, 150, 15);
		this.add(j5).setBounds(600, 60, 100, 15);
		this.add(j6).setBounds(450, 100, 300, 15);
		this.add(j7).setBounds(450, 140, 300, 15);
		this.add(j8).setBounds(450, 180, 100, 15);
		this.add(j9).setBounds(600, 180, 100, 15);
	}

	void setSelectRow(int gid) {
		Goods g = new GoodsDao().getOneGoods(gid);
		j1.setText("商品名称    " + g.getGname());
		j2.setText("商品种类    " + new KindDao().getOneKind(g.getGkind()));
		j3.setText("进货数量    " + Integer.toString(g.getGnum()));
		j4.setText("进货日期    " + new SimpleDateFormat("yyyy-MM-dd").format(g.getGdatein()));
		j5.setText("保质时长    " + Integer.toString(g.getGklong()));
		j6.setText("供货厂家    " + new FactoryDao().getOneFactory(g.getGfrom()));
		j7.setText("条形编码    " + Integer.toString(g.getGcode()));
		j8.setText("进货价格    " + Float.toString(g.getGpricein()));
		j9.setText("零售价格    " + Float.toString(g.getGpriceout()));
	}

	public static void updateTableOfSale() {
		model.updateTable(new GoodsDao().getGoods());
	}
}
