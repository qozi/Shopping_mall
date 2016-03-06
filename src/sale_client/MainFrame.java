package sale_client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.dao.GoodsDao;
import com.pojo.Goods;

public class MainFrame extends JFrame implements ActionListener {
	int num1 = 0;
	int num2 = 0;
	PanelOfGoods pog1;
	PanelOfGoods_ing pog2;
	JButton jb1;
	JLabel jl1, jl2;

	public MainFrame() {
		setTitle("Sale");
		setSize(1000, 1000);
		setLayout(null);

		pog1 = new PanelOfGoods(this);
		pog2 = new PanelOfGoods_ing(this);
		jb1 = new JButton("х╥хо");
		jl1 = new JLabel("0.0");
		jl2 = new JLabel("$");
		jl1.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
		jl2.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		this.add(pog1).setBounds(0, 0, 500, 1000);
		this.add(pog2).setBounds(500, 0, 500, 500);
		this.add(jb1).setBounds(700, 700, 100, 30);
		this.add(jl1).setBounds(650, 600, 200, 50);
		this.add(jl2).setBounds(850, 600, 100, 50);
		jb1.addActionListener(this);

		new ScreenSize().setCenterLocation(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void resetlable() {
		jl1.setText("0.0");
	}

	public void changelable(double num) {
		double temp = Double.parseDouble(jl1.getText());
		if (temp + num < 0) {
			jl1.setText("0.0");
		} else {
			jl1.setText(Double.toString(temp + num));
		}

	}

	public void addItem(int gid, int flag) {
		if (flag == 1) {
			pog2.model.addData(new GoodsDao().getOneGoods(gid), 1);
			pog1.model.updateNumber(1);
			changelable(new GoodsDao().getOneGoods(gid).getGpriceout());
		} else if (flag == 0) {
			num1 = 0;
			new DialogOfNumber(this, 1);
			if (num1 != 0) {
				pog2.model.addData(new GoodsDao().getOneGoods(gid), num1);
				pog1.model.updateNumber(num1);
				changelable(new GoodsDao().getOneGoods(gid).getGpriceout() * num1);
			}
		}
	}

	public void delItem(int gid, int flag) {
		if (flag == 1) {
			pog1.model.addData(gid, 1);
			pog2.model.addData(new GoodsDao().getOneGoods(gid), -1);
			changelable(new GoodsDao().getOneGoods(gid).getGpriceout() * -1);
		} else if (flag == 0) {
			num2 = 0;
			new DialogOfNumber(this, 2);
			if (num2 != 0) {
				pog1.model.addData(gid, num2);
				pog2.model.addData(new GoodsDao().getOneGoods(gid), -num2);
				changelable(new GoodsDao().getOneGoods(gid).getGpriceout() * -num2);
			}
		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			new PanelOfPrice(Double.parseDouble(jl1.getText()), this);
		}
	}

}
