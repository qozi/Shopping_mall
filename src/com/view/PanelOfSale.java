package com.view;

import javax.swing.JPanel;

import com.dao.GoodsDao;

public class PanelOfSale extends JPanel {
	PanelOfSale() {
		this.setLayout(null);
		TableOfSale model = new TableOfSale();
		String[] names = { "��Ʒ����", "��Ʒ����", "��Ʒ����", "��Ʒ�۸�" };
		model.setNames(names);
		model.addData(new GoodsDao().getGoods());
		model.TableInit(model, 400, 600, this);
	}
}
