package application;

import java.time.LocalDate;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("TEST 1 ==== seller findById");
		SellerDao dao = DaoFactory.createSellerDao();
		Seller seller = dao.findById(1);
		System.out.println(seller);
		
		System.out.println("TEST 2 ==== seller findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = dao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("TEST 3 ==== seller findAll");
		list = dao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("TEST 4 ==== seller insert");
		Seller newSeller = new Seller(null, "Diogo", "diogo@protonmail.com", LocalDate.parse("1992-11-19"), 16000.0, department);
		dao.insert(newSeller);
		System.out.println("Seller inserted! New id = " + newSeller.getId());
		
		System.out.println("TEST 4 ==== seller update");
		seller = dao.findById(1);
		seller.setName("Jones Manoel");
		seller.setEmail("jones@presidente2020.com");
		dao.update(seller);
		System.out.println("Update completed!");
	}

}
