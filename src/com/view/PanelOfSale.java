package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.dao.SaleDao;

public class PanelOfSale extends JPanel implements ActionListener{
	TableOfSale model;
	JButton update;

	PanelOfSale() {
		this.setLayout(null);
		model = new TableOfSale();
		String[] names = { "���ױ��", "���ۼ۸�", "����ʱ��", "��������", "������Ʒ" };
		model.setNames(names);
		model.addData(new SaleDao().getSale());
		model.TableInit(model, 600, 500, this);

		update = new JButton("ˢ��");
		this.add(update).setBounds(0, 0, 50, 30);
	}

	public void updateTableOfSale() {
		model.updateTable(new SaleDao().getSale());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==update){
			updateTableOfSale();
		}
	}
}
