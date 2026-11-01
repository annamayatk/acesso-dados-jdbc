package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao dao = DaoFactory.createDepartmentDao();
		
//		System.out.println("TEST 1 ==== department insert");
//		Department newDep = new Department(null, "Design");
//		dao.insert(newDep);
//		System.out.println("Department inserted! New id = " + newDep.getId());
		
		System.out.println("TEST 2 ==== department update");
		Department dep = dao.findById(3);
		dep.setName("Stationary");
		dao.update(dep);
		System.out.println("Update Completed");
		
		System.out.println("TEST 3 ==== department findById");
		dep = dao.findById(2);
		System.out.println(dep);
		
		System.out.println("TEST 4 ==== department findAll");
		List<Department> list = dao.findAll();
		 
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("TEST 5 ==== department deleteById");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		dao.deleteById(id);
		System.out.println("Delete completed.");
		sc.close();
		
 	}
}
