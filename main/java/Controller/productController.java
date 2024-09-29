package Controller;

import java.util.List;
import java.util.Scanner;
import dao.dbMerchant;
import dao.dbproduct;
import dto.product;
import dto.merchant;

public class productController {
	static Scanner s = new Scanner(System.in);
	static dbproduct dao = new dbproduct();
	static dbMerchant merchant = new dbMerchant();
	static merchant merchatdto = new merchant();
	static merchantController merchantcontroller = new merchantController();

	public static void saveProduct() {
		System.out.println("Enter the name,brand,cost,merchant id to save product");
		product p = new product();
		p.setName(s.next());
		p.setBrand(s.next());
		p.setCost(s.nextInt());
		p.setMerchants(merchant.findMerchantById(s.nextInt()));
		p = dao.saveProduct(p);
		System.out.println("product saved ");
		display(p);
	}

	public static void updateProduct() {
		System.out.println("Enter the product Id to update");
		product dbproduct = dao.findpdtById(s.nextInt());
		if (dbproduct != null) {
			System.out.println("Enter the product Name,Brand,cost,merchant id to update");
			dbproduct.setName(s.next());
			dbproduct.setBrand(s.next());
			dbproduct.setCost(s.nextDouble());
			dbproduct.setMerchants(merchant.findMerchantById(s.nextInt()));
			dao.saveProduct(dbproduct);
			System.out.println("Product updated ");
			display(dbproduct);

		} else
			System.out.println("Invalid id");

	}

	public static void findProductById() {
		System.out.println("Enter the product Id");
		int id = s.nextInt();
		product p = dao.findpdtById(id);
		print(p);
	}

	public static void findByName() {
		System.out.println("Enter the name to display product details");
		String name = s.next();
		List<product> p = dao.findByName(name);
		print(p);
	}

	public static void findNameByBrand() {
		System.out.println("Enter the brand name to display product detials");
		String brand = s.next();
		List<product> p = dao.findByBrand(brand);
		print(p);
	}

	public static void findNameByCost() {
		System.out.println("Enter the  cost to display product detials");
		double cost = s.nextDouble();
		List<product> p = dao.findNameByCost(cost);
		print(p);
	}

	public static void delete() {
		System.out.println("Enter the Product Id to delete");
		int id = s.nextInt();
		boolean deleted = dao.deletepdt(id);
		if (deleted)
			System.err.println("Product deleted");
		else
			System.err.println("Cannot delete product as Id is Invalid");
	}

	public static void print(List<product> p) {
		if (p.size() > 0) {
			for (product u : p) {
				display(u);
			}
		} else
			System.err.println("Product not found");

	}

	public static void print(product u) {
		if (u != null) {
			display(u);
		} else {
			System.err.println("Product not found");
		}

	}

	public static void display(product u) {
		System.out.println("---------Product detials----------");
		System.out.println("Product Id    :" + u.getId());
		System.out.println("Product Name  :" + u.getName());
		System.out.println("brand Name    :" + u.getBrand());
		System.out.println("cost Name     :" + u.getCost());
		System.out.println("---------------------------------------");
	}

	public static void displayMerchantAndProduct() {
		System.out.println("Enter the product Id to find merchant");
		product dbproduct = dao.findpdtById(s.nextInt());
		merchant m = dbproduct.getMerchants();
		merchant dbmerchant = merchant.findMerchantById(m.getId());
		merchantcontroller.display(dbmerchant);
		System.out.println("===============================");
		display(dbproduct);
	}

}
