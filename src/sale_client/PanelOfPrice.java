package sale_client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelOfPrice extends JDialog implements ActionListener {

	JLabel jl1, jl2, jl3;
	JButton jb1, jb2;
	JTextField field;
	MainFrame frame;
	int flag;
	double price;

	public PanelOfPrice(double price, MainFrame frame) {
		flag = 0;
		this.price = price;
		this.frame = frame;
		setTitle("收款");
		setLayout(null);
		setModal(true);
		setSize(420, 300);

		jl1 = new JLabel("应收：" + Double.toString(price));
		jl2 = new JLabel("实收： ");
		jl3 = new JLabel("应找： ");
		jb1 = new JButton("确定");
		jb2 = new JButton("取消");
		field = new JTextField();
		
		jl1.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		jl2.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		jl3.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

		this.add(jl1).setBounds(100, 20, 300, 40);
		this.add(jl2).setBounds(100, 60, 140, 40);
		this.add(field).setBounds(190, 60, 105, 40);
		this.add(jl3).setBounds(100, 100, 300, 40);
		this.add(jb1).setBounds(100, 170, 100, 30);
		this.add(jb2).setBounds(220, 170, 100, 30);

		jb1.addActionListener(this);
		jb2.addActionListener(this);

		ScreenSize.setCenterLocation(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			if (flag == 0) {
				jl2.setBounds(100, 60, 300, 40);
				jl2.setText("实收：" + field.getText());
				jl3.setText("应找：" + (Double.parseDouble(field.getText()) - price));
				field.setVisible(false);
				flag = 1;
			} else if (flag == 1) {
				frame.pog2.model.addSale();
				frame.resetlable();
				this.dispose();
			}
		} else if (e.getSource() == jb2) {
			this.dispose();
		}
	}

}
