package com.view;

import javax.swing.JPanel;

import com.dao.GoodsDao;

public class PanelOfSale extends JPanel {
	PanelOfSale() {
		this.setLayout(null);
		TableOfSale model = new TableOfSale();
		String[] names = { "商品名称", "商品种类", "商品数量", "商品价格" };
		model.setNames(names);
		model.addData(new GoodsDao().getGoods());
		model.TableInit(model, 400, 600, this);
	}
}
