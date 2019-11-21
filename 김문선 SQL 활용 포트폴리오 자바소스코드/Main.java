import java.util.*;

public class Main {
	public static void main(String[] args) {
		boolean check = true;
		int menu;
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Process pro;
		DBConnection connection = new DBConnection();
		customerInfo customer;
		productsInfo products;
		ordersInfo orders;
		
		System.out.println(" ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ ");
		System.out.println(" ▒▒                                                                   ▒▒ ");
		System.out.println(" ▒▒                       데이터베이스 관리 프로그램                                             ▒▒");
		System.out.println(" ▒▒                                                                   ▒▒");
		System.out.println(" ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ ");
		System.out.println("");
		
		while (check) {
			System.out.println("  ▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("");
			System.out.println(" \t\t\t           ※  Select Menu ※");
			System.out.println("");
			System.out.println("    1. Data 입력 \t 2. Data 출력 \t\t 3. Data 삭제 \t 4. Data 수정   \t\n"
							 + "    5. 권한부여 \t 6. 계정 확인 및 삭제 \t 7. 뷰 출력 \t 8. 종료");
			System.out.println("");
			System.out.println("  ▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			
			System.out.print(" >> 작업을 선택하세요 :  ");
			menu = scan.nextInt();
			int tablechoice, viewchoice;

			switch (menu) {
			case 1: // 데이터 입력 완료!!
				System.out.println(" => 1번 'Data 입력'을 선택했습니다.");
				System.out.println("");
				System.out.println("▶▶ ▶ Data 입력 화면(Insert) ◀◀◀ ");
				System.out.println(":: 총 3개의 테이블이 있습니다.");
				System.out.println(":: 1. 고객테이블 \t 2. 상품테이블 \t 3.주문정보테이블");
				System.out.print(">> 입력할 테이블을 선택하세요 : ");
				tablechoice = scan.nextInt();
				System.out.println("=========================");

				switch (tablechoice) {
				case 1: // customer table
					System.out.println("☞ 고객정보테이블(customer)을 선택했습니다.");
					System.out.println("=========================");
					pro = new Process();
					customer = pro.inputInfo();
					connection.input(customer);
					System.out.println("");
					break;

				case 2: // products table
					System.out.println("☞ 상품정보테이블(products)을 선택했습니다.");
					System.out.println("=========================");
					pro = new Process();
					products = pro.inputInfo2();
					connection.input(products);
					System.out.println("");
					break;

				case 3: // orders table
					System.out.println("☞ 주문정보테이블(orders)을 선택했습니다.");
					System.out.println("=========================");
					pro = new Process();
					orders = pro.inputInfo3();
					connection.input(orders);
					System.out.println("");
					break;

				}
				break;

			case 2: // 정보 출력 select 완료!!!

				System.out.println(" => 2번 'Data 출력'을 선택했습니다.");
				System.out.println("");
				System.out.println("▶▶ ▶ Data 출력 화면(Select) ◀◀◀ ");
				System.out.println(":: 총 3개의 테이블이 있습니다.");
				System.out.println(":: 1. 고객테이블 \t 2. 상품테이블 \t 3.주문정보테이블");
				System.out.print(">> 출력할 테이블을 선택하세요 : ");
				tablechoice = scan.nextInt();
				System.out.println("=========================");
				// System.out.println();

				switch (tablechoice) {
				case 1: // customer table
					System.out.println("☞ 고객정보테이블(customer)을 선택했습니다.");
					System.out.println("=========================");
					System.out.println("==> customer table을 출력합니다.");
					System.out.println("");
					System.out.println(" 고객ID \t 고객명\t    고객전화번호 \t    고객주소");
					System.out.println("============================================");
					connection.output();
					break;

				case 2: // products table
					System.out.println("☞ 상품정보테이블(products)을 선택했습니다.");
					System.out.println("=========================");
					System.out.println("==> products table을 출력합니다.");
					System.out.println("");
					System.out.println("상품ID \t        상품명\t    가격 \t");
					System.out.println("===================================");
					connection.output2();
					break;

				case 3: // orders table
					System.out.println("☞ 주문정보테이블(orders)을 선택했습니다.");
					System.out.println("=========================");
					System.out.println("==> orders table을 출력합니다.");
					System.out.println("");
					System.out.println("주문번호 \t  주문개수\t     주문날짜       주문고객ID   주문상품ID");
					System.out.println("==================================================");
					connection.output3();
					break;

				}
				break;

			case 3: // 삭제 완료!!
				System.out.println(" => 3번 'Data 삭제'를 선택했습니다.");
				System.out.println("");
				System.out.println("▶▶ ▶ Data 삭제 화면(Delete) ◀◀◀ ");
				System.out.println(":: 총 3개의 테이블이 있습니다.");
				System.out.println(":: 1. 고객테이블 \t 2. 상품테이블 \t 3.주문정보테이블");
				System.out.print(">> 삭제할 컬럼이 있는 테이블을 선택하세요 : ");
				tablechoice = scan.nextInt();
				System.out.println("=========================");

				switch (tablechoice) {
				case 1: // customer table
					System.out.println("☞ 고객정보테이블(customer)을 선택했습니다.");
					System.out.println("=========================");
					System.out.println(" @ customer table 컬럼삭제 화면입니다 @");
					System.out.print("> 고객정보의 삭제할 고객ID를 입력하세요: ");
					connection.delete(scan.nextInt());
					System.out.println("");
					break;

				case 2: // products table
					System.out.println("☞ 상품정보테이블(products)을 선택했습니다.");
					System.out.println("=========================");
					System.out.println(" @ products table 컬럼삭제 화면입니다 @");
					System.out.print("> 상품정보의 삭제할 상품ID를 입력하세요: ");
					connection.delete2(scan.nextInt());
					System.out.println("");
					break;

				case 3: // orders table
					System.out.println("☞ 주문정보테이블(orders)을 선택했습니다.");
					System.out.println("=========================");
					System.out.println(" @ orders table 컬럼삭제 화면입니다 @");
					System.out.print("> 주문정보의 삭제할 주문번호를 입력하세요: ");
					connection.delete3(scan.nextInt());
					System.out.println("");
					break;

				}
				break;

			case 4: // 수정 -- update..
				System.out.println("=> 4번 'Data 수정'을 선택했습니다.");
				System.out.println("");
				System.out.println("▶▶ ▶ Data 수정 화면(Update) ◀◀◀ ");
				System.out.println(":: 총 3개의 테이블이 있습니다.");
				System.out.println(":: 1. 고객테이블 \t 2. 상품테이블 \t 3.주문정보테이블");
				System.out.print(">> 수정할 테이블을 선택하세요 : ");
				tablechoice = scan.nextInt();
				System.out.println("=========================");

				switch (tablechoice) {
				case 1: // customer update
					System.out.println("☞ 고객정보테이블(customer)을 선택했습니다.");
					System.out.println("=========================");
					System.out.println("@ customer table 수정(update) 화면입니다 @");
					connection.update();
					break;

				case 2: // products update
					System.out.println("☞ 상품정보테이블(products)을 선택했습니다.");
					System.out.println("=========================");
					System.out.println("@ products table 수정(update) 화면입니다 @");
					connection.update2();
					break;

				case 3: // orders update
					System.out.println("☞ 주문정보테이블(orders)을 선택했습니다.");
					System.out.println("=========================");
					System.out.println("@ orders table 수정(update) 화면입니다 @");
					connection.update3();
					break;
				}
				break;

			case 5: // 권한 부여 grant,revoke
				System.out.println(" => 5번 '권한부여'를 선택했습니다.");
				System.out.println("");
				System.out.println("▶▶ ▶ 권한 부여/확인/회수 화면(Grant/Revoke) ◀◀◀ ");
				connection.grant();
				System.out.println("");
				break;

			case 6:
				System.out.println(" => 6번 '계정 확인 및 삭제'를 선택했습니다.");
				System.out.println("");
				System.out.println("▶▶ ▶ 계정 확인 및 삭제 화면 ◀◀◀ ");
				connection.accountcontent();
				System.out.println("");
				break;

			case 7: // mysql에서 생성한 뷰출력하는 메뉴입니다.
				// 총 2가지를 생성하였으므로 2가지를 선택하는 메뉴단을 출력하여 실행하게 할것입니다.
				System.out.println(" => 7번 '뷰 출력'을 선택했습니다.");
				System.out.println("");
				System.out.println("▶▶ ▶ 뷰 출력 화면 ◀◀◀ ");
				System.out.println(":: 총 2개의 뷰가 있습니다.");
				System.out.println(":: 1. 주문간단정보 뷰(easyorder)  \t 2. 주문상세정보 뷰(easyorderdetail)");
				System.out.print(">> 출력할 뷰를 선택하세요 : ");
				viewchoice = scan.nextInt();
				System.out.println("=========================");

				switch (viewchoice) {
				case 1: // easyorder
					System.out.println("☞ 주문간단정보 뷰(easyorder)를 선택했습니다.");
					System.out.println("# easyorder view를 출력합니다.");
					System.out.println("");
					System.out.println(" 고객ID    고객이름    상품ID    상품명");
					System.out.println("=================================");
					connection.view_output();
					break;

				case 2: // easyorderdetail
					System.out.println("☞ 주문상세정보 뷰(easyorderdetail)를 선택했습니다.");
					System.out.println("# easyorderdetail view를 출력합니다");
					System.out.println("");
					System.out.println(" \t\t\t\t주문정보설명");
					System.out.println("======================================================================");
					connection.view_output2();
					break;
				}
				break;

			case 8:
				System.out.println("프로그램을 종료합니다!!");
				check = false;
				break;

			default:
				System.out.println("메뉴를 잘못 선택하셨습니다. 다시 선택해주세요. \n");
				break;
			}
		}
		scan.close();
		scan2.close();
		connection.end();
	}
}
