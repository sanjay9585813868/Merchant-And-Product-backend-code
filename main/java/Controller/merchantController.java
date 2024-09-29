package Controller;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;

import dao.dbMerchant;
import dto.merchant;
import dto.product;

public class merchantController {

	static Scanner s = new Scanner(System.in);
	static dbMerchant dao = new dbMerchant();
	static productController product = new productController();

	public static void save() {
		System.out.println("Enter the name,phone,age,gender and password to save user");
		merchant u = new merchant();
		u.setName(s.next());
		u.setPhone(s.nextLong());
		u.setAge(s.nextInt());
		u.setGender(s.next());
		u.setPassword(s.next());
		u = dao.saveUser(u);
		System.out.println("user saved with:");
		display(u);
	}

	public static void update() {
		System.out.println("Enter the user Id to update");
		merchant dbUser = dao.findMerchantById(s.nextInt());
		if (dbUser != null) {
			System.out.println("Enter the Merchant Name,Phone,Age,Gender Password to update");
			dbUser.setName(s.next());
			dbUser.setPhone(s.nextLong());
			dbUser.setAge(s.nextInt());
			dbUser.setGender(s.next());
			dbUser.setPassword(s.next());
			dao.saveUser(dbUser);
			System.out.println("user updated ");
			display(dbUser);
		} else {
			System.out.println("Invalid id");
		}
	}

	public static void verifyUserByPhone() {
		System.out.println("Enter the Phone Number and Password to verify");
		long phone = s.nextLong();
		String password = s.next();
		merchant u = dao.verifyUser(phone, password);
		System.out.println(u != null ? "Verification Succesfull" : "Entered phone number or password");
		print(u);
	}

	public static void verifyUserById() {
		System.out.println("Enter the merchat Id and Password to verify");
		int id = s.nextInt();
		String password = s.next();
		merchant u = dao.verifyUser(id, password);
		System.out.println(u != null ? "Verification Succesfull" : "Entered Id number or password");
		print(u);
	}

	public static void findUserById() {
		System.out.println("Enter the merchant Id to display details");
		int id = s.nextInt();
		merchant user = dao.findMerchantById(id);
		if (user != null) {
			display(user);
		} else {
			System.err.println("Invalid Id");
		}
	}

	public static void findByName() {
		System.out.println("Enter the name to display details");
		String name = s.next();
		List<merchant> users = dao.findByName(name);
		System.out.println(users != null ? "Merchants found" : "Merchants can't be found");
		print(users);
	}

	public static void findByAge() {
		System.out.println("Enter the age to display details");
		int age = s.nextInt();
		List<merchant> users = dao.findByAge(age);
		System.out.println(users != null ? "Merchants found" : "Merchants can't be found");
		print(users);

	}

	public static void findByGender() {
		System.out.println("Enter the gender to display details");
		String gender = s.next();
		List<merchant> users = dao.findByGender(gender);
		System.out.println(users != null ? "Merchants found" : "Merchants can't be found");
		print(users);

	}

	public static void delete() {
		System.out.println("Enter the user Id to delete");
		int id = s.nextInt();
		boolean deleted = dao.deleteUser(id);
		if (deleted)
			System.err.println("User deleted");
		else
			System.err.println("Cannot delete merchant as Id is Invalid");
	}

	public static void display(merchant u) {

		System.out.println("---------Merchant detials----------");
		System.out.println("User Id      :" + u.getId());
		System.out.println("User Name    :" + u.getName());
		System.out.println("Phone Number :" + u.getPhone());
		System.out.println("Age          :" + u.getAge());
		System.out.println("gender       :" + u.getGender());
		System.out.println("---------------------------------------");
	}

	public static void print(merchant u) {
		if (u != null) {
			display(u);
		} else {
			System.err.println("Invalid data");
		}

	}

	public static void print(List<merchant> users) {
		if (users.size() > 0) {
			for (merchant u : users) {
				display(u);
			}
		} else
			System.err.println("Data not found");

	}

	public static void displayMerchantAndProduct() {
		System.out.println("Enter the merchant Id to find the products");
		
		merchant dbmerchant = dao.findMerchantById(s.nextInt());
		List<product> p = dbmerchant.getProducts();
		display(dbmerchant);
		product.print(p);
		System.out.println("===============================");
	}

}
