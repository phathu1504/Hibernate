package test;

import java.sql.Date;

import dao.CatDAO;
import model.Cat;

public class TestUpdate {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.setId(3);
		cat.setDateOfBirth(new Date(System.currentTimeMillis()));
		CatDAO dao = new CatDAO();
		boolean result = dao.update(cat);
		System.out.println(result);
	}
}
