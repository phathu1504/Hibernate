package test;

import dao.CatDAO;
import model.Cat;

public class TestDelete {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.setId(1);

		CatDAO dao = new CatDAO();
		dao.delete(cat);
	}
}
