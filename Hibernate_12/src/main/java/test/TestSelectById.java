package test;

import dao.CatDAO;
import model.Cat;

public class TestSelectById {
	public static void main(String[] args) {
		CatDAO dao = new CatDAO();
		Cat cat = new Cat();
		cat.setId(2);
		Cat resultCat = dao.selectById(cat);
		System.out.println(resultCat);
	}
}
