package sale_client;

import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.dao.BuyDao;
import com.dao.FactoryDao;
import com.dao.GoodsDao;
import com.dao.KindDao;
import com.pojo.Goods;

public class PanelOfGoods extends JPanel {
	static TableOfGoods model;
	MainFrame frame;

	PanelOfGoods(MainFrame frame) {
		this.frame = frame;
		this.setLayout(null);
		this.setSize(500, 1000);
		model = new TableOfGoods();
		String[] names = { "商品ID", "商品名称", "商品种类", "商品数量", "商品价格" };
		model.setNames(names);
		model.addData(new GoodsDao().getGoods());
		model.TableInit(model, 500, 1000, this);

	}

	void setSelectRow(int gid,int flag) {
		frame.addItem(gid,flag);
	}

	public static void updateTableOfSale() {
		model.updateTable(new GoodsDao().getGoods());
	}
}
