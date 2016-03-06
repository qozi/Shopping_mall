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
		String[] names = { "��ƷID", "��Ʒ����", "��Ʒ����", "��Ʒ����", "��Ʒ�۸�" };
		model.setNames(names);
		model.addData(new GoodsDao().getGoods());
		model.TableInit(model, 400, 800, -15, 0, this);

		j1 = new JLabel("��Ʒ����");
		j2 = new JLabel("��Ʒ����");
		j3 = new JLabel("��������");
		j4 = new JLabel("��������");
		j5 = new JLabel("����ʱ��");
		j6 = new JLabel("��������");
		j7 = new JLabel("���α���");
		j8 = new JLabel("�����۸�");
		j9 = new JLabel("���ۼ۸�");

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
		j1.setText("��Ʒ����    " + g.getGname());
		j2.setText("��Ʒ����    " + new KindDao().getOneKind(g.getGkind()));
		j3.setText("��������    " + Integer.toString(g.getGnum()));
		j4.setText("��������    " + new SimpleDateFormat("yyyy-MM-dd").format(g.getGdatein()));
		j5.setText("����ʱ��    " + Integer.toString(g.getGklong()));
		j6.setText("��������    " + new FactoryDao().getOneFactory(g.getGfrom()));
		j7.setText("���α���    " + Integer.toString(g.getGcode()));
		j8.setText("�����۸�    " + Float.toString(g.getGpricein()));
		j9.setText("���ۼ۸�    " + Float.toString(g.getGpriceout()));
	}

	public static void updateTableOfSale() {
		model.updateTable(new GoodsDao().getGoods());
	}
}
