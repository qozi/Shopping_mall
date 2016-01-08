package com.view;

import java.awt.event.WindowEvent;

import javax.swing.JPanel;

import com.dao.GoodsDao;

public class PanelOfGoods extends JPanel {
	static TableOfGoods model;

	PanelOfGoods() {
		this.setLayout(null);
		model = new TableOfGoods();
		String[] names = { "��Ʒ����", "��Ʒ����", "��Ʒ����", "��Ʒ�۸�" };
		model.setNames(names);
		model.addData(new GoodsDao().getGoods());
		model.TableInit(model, 400, 600, this);

	}

	public static void updateTableOfSale() {
		model.updateTable(new GoodsDao().getGoods());
	}
}
