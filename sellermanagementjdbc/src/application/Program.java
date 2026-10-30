package application;

import java.time.LocalDate;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department dep = new Department(1, "TI");
		
		Seller seller = new Seller(32, "Anna", "annamda75@gmail.com", LocalDate.now(), 3200.00, dep);
		
		SellerDao dao = DaoFactory.createSellerDao();
		
		System.out.println(seller);
	}

}
