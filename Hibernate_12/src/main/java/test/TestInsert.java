package test;

import java.sql.Date;

import dao.CatDAO;
import model.Cat;

public class TestInsert {
	public static void main(String[] args) {
		Cat cat = new Cat("Lông xù", new Date(2004,01, 05), false);
		
		CatDAO dao = new CatDAO();
		boolean result = dao.inser(cat);
		System.out.println(result);
	}
}
