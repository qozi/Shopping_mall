package ShoppingMall;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class ScreenSize {
	Toolkit kit = Toolkit.getDefaultToolkit();// 工具，可以获得屏幕等硬件的相关信息
	public static int SCREEN_WIDTH, SCREEN_HEIGTH;

	ScreenSize() {
		SCREEN_WIDTH = kit.getScreenSize().width;// 获得当前电脑屏幕的宽度
		SCREEN_HEIGTH = kit.getScreenSize().height;// 获得当前电脑屏幕的高度
	}

	public static void setCenterLocation(JFrame j) {
		j.setLocation((SCREEN_WIDTH - j.getWidth()) / 2,
				(SCREEN_HEIGTH - j.getHeight()) / 2);
	}

	public static void setConstSize(JFrame j) {
		j.setSize(SCREEN_WIDTH * 4 / 10, SCREEN_WIDTH * 4 / 10 * 9 / 8);
	}
}
