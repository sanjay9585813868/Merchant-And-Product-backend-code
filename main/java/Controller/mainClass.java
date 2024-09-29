package Controller;

import java.util.List;
import java.util.Scanner;
import Controller.merchantController;
import Controller.productController;

public class mainClass {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("==================================");
		System.out.println("---------Merchant and Product------------");
		System.out.println("==================================");

		while (true) {
			System.out.println("1.Save merchant");
			System.out.println("2.Update merchant");
			System.out.println("3.Find merchant By Id");
			System.out.println("4.Verify merchant By Phone and password");
			System.out.println("5.Verify merchant By Id and password");
			System.out.println("6.Find merchants By Name");
			System.out.println("7.Find merchants By Age");
			System.out.println("8.Find merchants By gender");
			System.out.println("9.Delete merchant By id");
			System.out.println("10.Find product list By merchant id");
			System.out.println("----------------------");
			System.out.println("11.Save product");
			System.out.println("12.Update product");
			System.out.println("13.Find product By Id");
			System.out.println("14.Delete product");
			System.out.println("15.Find product By Name");
			System.out.println("16.Find product By Brand");
			System.out.println("17.Find product By Cost");
			System.out.println("18.Find merchant detials from product id");

			switch (s.nextInt()) {
			case 1: {
				merchantController.save();
				;
				break;
			}
			case 2: {
				merchantController.update();
				break;
			}
			case 3: {
				merchantController.findUserById();
				break;
			}
			case 4: {
				merchantController.verifyUserByPhone();
				break;
			}
			case 5: {
				merchantController.verifyUserById();
				break;
			}
			case 6: {
				merchantController.findByName();
				break;
			}
			case 7: {
				merchantController.findByAge();
				break;
			}
			case 8: {
				merchantController.findByGender();
				break;
			}
			case 9: {
				merchantController.delete();
				break;
			}
			case 10: {
				merchantController.displayMerchantAndProduct();
				break;
			}
			case 11: {
				productController.saveProduct();
				break;
			}
			case 12: {
				productController.updateProduct();
				break;
			}
			case 13: {
				productController.findProductById();
				break;
			}
			case 14: {
				productController.delete();
				break;
			}
			case 15: {
				productController.findByName();
				break;
			}
			case 16: {
				productController.findNameByBrand();
				break;
			}
			case 17: {
				productController.findNameByCost();
				break;
			}
			case 18: {
				productController.displayMerchantAndProduct();
				;
				break;
			}
			default: {
				System.err.println("Invalid Choice");
			}
			}

		}

	}

}