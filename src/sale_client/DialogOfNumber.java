package sale_client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class DialogOfNumber extends JDialog implements ActionListener {
	JButton jb1;
	MainFrame frame;
	int flag = 0;

	public DialogOfNumber(MainFrame frame, int flag) {
		this.flag = flag;
		this.frame = frame;
		setTitle("ÊýÁ¿");
		setLayout(null);
		setModal(true);
		setSize(400, 400);

		jb1 = new JButton("10");
		add(jb1).setBounds(0, 0, 100, 30);
		jb1.addActionListener(this);

		new ScreenSize().setCenterLocation(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb1) {
			if (flag == 1) {
				frame.num1 = 10;
			} else if (flag == 2) {
				frame.num2 = 10;
			}
			this.dispose();
		}
	}
}
