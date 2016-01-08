package sale_client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.dao.GoodsDao;

public class MainFrame extends JFrame implements ActionListener {
	int num = 0;
	PanelOfGoods pog1;
	PanelOfGoods_ing pog2;
	JButton jb1;

	public MainFrame() {
		setTitle("Sale");
		setSize(1000, 1000);
		setLayout(null);

		pog1 = new PanelOfGoods(this);
		pog2 = new PanelOfGoods_ing();
		jb1 = new JButton("х╥хо");
		this.add(pog1).setBounds(0, 0, 500, 1000);
		this.add(pog2).setBounds(500, 0, 500, 500);
		this.add(jb1).setBounds(600, 600, 100, 30);
		jb1.addActionListener(this);

		new ScreenSize().setCenterLocation(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void addItem(int gid, int flag) {
		if (flag == 1) {
			pog2.model.addData(new GoodsDao().getOneGoods(gid), 1);
		} else if (flag == 0) {
			new DialogOfNumber(this);
			pog2.model.addData(new GoodsDao().getOneGoods(gid), num);
		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			pog2.model.addSale();
		}
	}

}
