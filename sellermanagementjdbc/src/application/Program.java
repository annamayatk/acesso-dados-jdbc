package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("TEST 1 ==== findById");
		SellerDao dao = DaoFactory.createSellerDao();
		Seller seller = dao.findById(1);
		System.out.println(seller);
		
		System.out.println("TEST 2 ==== findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = dao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
	}

}
