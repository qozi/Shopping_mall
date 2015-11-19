package ShoppingMall;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class ScreenSize {
	Toolkit kit = Toolkit.getDefaultToolkit();// ���ߣ����Ի����Ļ��Ӳ���������Ϣ
	public static int SCREEN_WIDTH, SCREEN_HEIGTH;

	ScreenSize() {
		SCREEN_WIDTH = kit.getScreenSize().width;// ��õ�ǰ������Ļ�Ŀ��
		SCREEN_HEIGTH = kit.getScreenSize().height;// ��õ�ǰ������Ļ�ĸ߶�
	}

	public static void setCenterLocation(JFrame j) {
		j.setLocation((SCREEN_WIDTH - j.getWidth()) / 2,
				(SCREEN_HEIGTH - j.getHeight()) / 2);
	}

	public static void setConstSize(JFrame j) {
		j.setSize(SCREEN_WIDTH * 4 / 10, SCREEN_WIDTH * 4 / 10 * 9 / 8);
	}
}
