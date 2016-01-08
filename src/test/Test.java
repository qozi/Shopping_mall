package test;

import com.dao.GoodsDao;

public class Test {
	public static void main(String[] args) {
		System.out.println(new GoodsDao().getOneGoods("вс"));
	}
}
