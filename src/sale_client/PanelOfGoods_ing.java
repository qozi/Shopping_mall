package sale_client;

import java.awt.event.WindowEvent;

import javax.swing.JPanel;

import com.dao.GoodsDao;
import com.pojo.Goods;

public class PanelOfGoods_ing extends JPanel {
	static TableOfGoods_ing model;
	MainFrame frame;

	PanelOfGoods_ing(MainFrame frame) {
		this.frame = frame;
		this.setLayout(null);
		this.setSize(500, 1000);
		model = new TableOfGoods_ing();
		String[] names = { "商品名称", "商品种类", "数量", "总价" };
		model.setNames(names);
		model.TableInit(model, 500, 500, this);

	}

	void setSelectRow(int gid, int flag) {
		frame.delItem(gid, flag);
	}

	// public static void updateTableOfSale() {
	// model.updateTable(new GoodsDao().getGoods());
	// }
}
