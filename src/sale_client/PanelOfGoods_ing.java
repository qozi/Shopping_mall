package sale_client;

import java.awt.event.WindowEvent;

import javax.swing.JPanel;

import com.dao.GoodsDao;

public class PanelOfGoods_ing extends JPanel {
	static TableOfGoods_ing model;

	PanelOfGoods_ing() {
		this.setLayout(null);
		this.setSize(500, 1000);
		model = new TableOfGoods_ing();
		String[] names = { "��Ʒ����", "��Ʒ����", "����", "�ܼ�" };
		model.setNames(names);
		model.TableInit(model, 500, 500, this);

	}

	// public static void updateTableOfSale() {
	// model.updateTable(new GoodsDao().getGoods());
	// }
}
