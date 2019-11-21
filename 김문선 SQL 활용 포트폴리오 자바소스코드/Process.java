import java.util.*;

public class Process {
	Scanner scan = new Scanner(System.in);
	Scanner scan2 = new Scanner(System.in);
	customerInfo customer;
	ordersInfo orders;
	productsInfo products;

	public Process() {
		System.out.println("테이블에 입력 값을 넣어주세요!!!");
		
		customer = new customerInfo();
		orders = new ordersInfo();
		products = new productsInfo();
	}

	customerInfo inputInfo() {
		System.out.print("> 고객 ID 입력하세요 : ");
		customer.setCustid(scan.nextInt());
		System.out.print("> 고객 이름 입력하세요 : ");
		customer.setCustname(scan2.nextLine());
		System.out.print("> 고객 전화번호를 입력하세요 : ");
		customer.setCusttel(scan.next());
		System.out.print("> 고객 주소를 입력하세요 : ");
		customer.setCustadd(scan2.nextLine());

		return customer;
	}

	productsInfo inputInfo2() {
		System.out.print("> 상품 ID 입력하세요 : ");
		products.setProid(scan.nextInt());
		System.out.print("> 상품명 입력하세요 : ");
		products.setProname(scan2.nextLine());
		System.out.print("> 상품 가격 입력하세요 : ");
		products.setPrice(scan.nextInt());

		return products;
	}

	ordersInfo inputInfo3() {
		System.out.print("> 주문 번호 입력하세요 : ");
		orders.setOrderid(scan.nextInt());
		System.out.print("> 상품 주문 개수 입력하세요 : ");
		orders.setOrdercount(scan.nextInt());
		System.out.print("> 주문일자 입력하세요 : ");
		orders.setOrderdate(scan2.nextLine());
		System.out.print("> 주문 고객 ID 입력하세요 : ");
		orders.setCustid(scan.nextInt());
		System.out.print("> 주문 상품 ID 입력하세요 : ");
		orders.setProid(scan.nextInt());

		return orders;
	}
}
