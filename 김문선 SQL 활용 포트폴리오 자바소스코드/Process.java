import java.util.*;

public class Process {
	Scanner scan = new Scanner(System.in);
	Scanner scan2 = new Scanner(System.in);
	customerInfo customer;
	ordersInfo orders;
	productsInfo products;

	public Process() {
		System.out.println("���̺� �Է� ���� �־��ּ���!!!");
		
		customer = new customerInfo();
		orders = new ordersInfo();
		products = new productsInfo();
	}

	customerInfo inputInfo() {
		System.out.print("> �� ID �Է��ϼ��� : ");
		customer.setCustid(scan.nextInt());
		System.out.print("> �� �̸� �Է��ϼ��� : ");
		customer.setCustname(scan2.nextLine());
		System.out.print("> �� ��ȭ��ȣ�� �Է��ϼ��� : ");
		customer.setCusttel(scan.next());
		System.out.print("> �� �ּҸ� �Է��ϼ��� : ");
		customer.setCustadd(scan2.nextLine());

		return customer;
	}

	productsInfo inputInfo2() {
		System.out.print("> ��ǰ ID �Է��ϼ��� : ");
		products.setProid(scan.nextInt());
		System.out.print("> ��ǰ�� �Է��ϼ��� : ");
		products.setProname(scan2.nextLine());
		System.out.print("> ��ǰ ���� �Է��ϼ��� : ");
		products.setPrice(scan.nextInt());

		return products;
	}

	ordersInfo inputInfo3() {
		System.out.print("> �ֹ� ��ȣ �Է��ϼ��� : ");
		orders.setOrderid(scan.nextInt());
		System.out.print("> ��ǰ �ֹ� ���� �Է��ϼ��� : ");
		orders.setOrdercount(scan.nextInt());
		System.out.print("> �ֹ����� �Է��ϼ��� : ");
		orders.setOrderdate(scan2.nextLine());
		System.out.print("> �ֹ� �� ID �Է��ϼ��� : ");
		orders.setCustid(scan.nextInt());
		System.out.print("> �ֹ� ��ǰ ID �Է��ϼ��� : ");
		orders.setProid(scan.nextInt());

		return orders;
	}
}
