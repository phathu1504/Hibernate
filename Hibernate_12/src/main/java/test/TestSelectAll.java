package test;

import java.util.List;

import dao.CatDAO;
import model.Cat;

public class TestSelectAll {
	public static void main(String[] args) {
		CatDAO dao = new CatDAO();
		
		List<Cat> list = dao.selectAll();
		
		for (Cat cat : list) {
			System.out.println(cat);
		}
	}
}