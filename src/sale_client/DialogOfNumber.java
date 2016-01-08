package sale_client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class DialogOfNumber extends JDialog implements ActionListener {
	JButton jb1;
	MainFrame frame;

	public DialogOfNumber(MainFrame frame) {
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
			frame.num = 10;
			this.dispose();
		}
	}
}
