import java.sql.*; import java.util.*;

public class DBConnection {
	private Connection con; private Statement st;
	private ResultSet rs;   
	Scanner scan; 	Scanner scan2;

	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shopping?" 
					+ "autoReconnect=true&useUnicode=true&"
					+ "characterEncoding=utf8";
			con = DriverManager.getConnection(url, "root", "1234");
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결오류: " + e.getMessage());
		}
	}

	// 1번 Data 입력-고객정보 입력 insert 완료
	public void input(customerInfo customer) { // 고객정보 입력 insert
		try {
			String SQL = "insert into customer " + "values (" + customer.getCustid() 
				+ ",'" + customer.getCustname() + "','" + customer.getCusttel() 
				+ "','" + customer.getCustadd() + "');";
			st.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println("데이터베이스 customer 입력 오류 : " + e.getMessage());
		}
	}

	// 1번 Data 입력-주문정보 입력 insert 완료
	public void input(ordersInfo orders) { // 주문정보 입력 insert
		try {
			String SQL = "insert into orders " + "values (" + orders.getOrderid() 
				+ "," + orders.getOrdercount() + ",'"+ orders.getOrderdate() + "'," 
				+ orders.getCustid() + "," + orders.getProid() + ");";
			st.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println("데이터베이스 orders 입력 오류 : " + e.getMessage());
		}
	}

	// 1번 Data 입력-상품정보 입력 insert 완료
	public void input(productsInfo products) { // 상품 정보 입력
		try {
			String SQL = "insert into products " + "values (" + products.getProid() 
				+ ",'" + products.getProname()+ "'," + products.getPrice() + ");";
			st.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println("데이터베이스 products 입력 오류 : " + e.getMessage());
		}
	}

	// 2번 Data 출력 - 고객 customer 완료
	public void output() {
		String custname, custtel, custadd;
		int custid;

		try {
			rs = st.executeQuery("select * from customer;");
			if (rs == null) {
				System.out.println("저장된 데이터가 없습니다.");
			} else {
				while (rs.next()) {
					custid = rs.getInt("custid");
					custname = rs.getString("custname");
					custtel = rs.getString("custtel");
					custadd = rs.getString("custadd");
					System.out.printf("%5d \t %3s \t %8s \t %5s", 
							custid, custname, custtel, custadd);
					System.out.println();
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 customer 출력 오류 : " + e.getMessage());
		}
	}

	// 2번 Data 출력 - 상품 products 완료!!!
	public void output2() { // products
		String proname;
		int proid, price;

		try {
			rs = st.executeQuery("select * from products;");
			if (rs == null) {
				System.out.println("저장된 데이터가 없습니다.");
			} else {
				while (rs.next()) {
					proid = rs.getInt("proid");
					proname = rs.getString("proname");
					price = rs.getInt("price");
					System.out.printf("%3d \t %10s \t %5d", proid, proname, price);
					System.out.println();
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 products 출력 오류 : " + e.getMessage());
		}
	}

	// 2번 Data 출력 - 주문정보 orders 완료!!
	public void output3() { // orders
		String orderdate;
		int orderid, proid, custid, ordercount;

		try {
			rs = st.executeQuery("select * from orders;");
			if (rs == null) {
				System.out.println("저장된 데이터가 없습니다.");
			} else {
				while (rs.next()) {
					orderid = rs.getInt("orderid");
					ordercount = rs.getInt("ordercount");
					orderdate = rs.getString("orderdate");
					custid = rs.getInt("custid");
					proid = rs.getInt("proid");
					System.out.printf("%3d \t %3d \t %9s \t %d \t %2d", 
							orderid, ordercount, orderdate, custid, proid);
					System.out.println();
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 orders 출력 오류 : " + e.getMessage());
		}
	}

	// 3번 데이터 삭제..-customer 테이블
	public void delete(int custid) {
		try {
			String SQL = "delete from customer where custid = " + custid + ";";
			st.executeUpdate(SQL);
		} catch (SQLException e) {
			System.out.println("데이터베이스 customer 삭제 오류 : " + e.getMessage());
		}
	}

	// 3번 데이터 삭제..-products 테이블
	public void delete2(int proid) {
		try {
			String SQL = "delete from products where proid = " + proid + ";";
			st.executeUpdate(SQL);
		} catch (SQLException e) {
			System.out.println("데이터베이스 products 삭제 오류 : " + e.getMessage());
		}
	}

	// 3번 데이터 삭제..-orders 테이블
	public void delete3(int orderid) {
		try {
			String SQL = "delete from orders where orderid = " + orderid + ";";
			st.executeUpdate(SQL);
		} catch (SQLException e) {
			System.out.println("데이터베이스 orders 삭제 오류 : " + e.getMessage());
		}
	}

	// 4번 데이터 수정... customer 완료!!
	public void update() { // update문

		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		String sql;
		int menu, custid, modify2;
		String modify1;

		// 기준은 아이디로 지정한다..
		System.out.println("1.고객명  2.고객전화번호  3.고객주소");
		System.out.print("수정할 필드명을 선택하세요: >>");
		menu = scan.nextInt();
		try {
			switch (menu) {
			case 1: // 1번 고객명 수정
				System.out.print("+ 수정할 고객명을 입력하세요:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ 수정할 고객id를 입력하세요:>> ");
				custid = scan.nextInt();
				sql = "update customer set custname='" + modify1 
						+ "' where custid=" + custid + ";";
				st.executeUpdate(sql);
				break;

			case 2: // 2번 고객전화번호 수정
				System.out.print("+ 수정할 고객전화번호를 입력하세요:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ 수정할 고객id를 입력하세요:>> ");
				custid = scan.nextInt();
				sql = "update customer set custtel='" + modify1 
						+ "' where custid=" + custid + ";";
				st.executeUpdate(sql);
				break;

			case 3: // 3번 고객 주소 수정
				System.out.print("+ 수정할 고객 주소를 입력하세요:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ 수정할 고객id를 입력하세요:>> ");
				custid = scan.nextInt();
				sql = "update customer set custadd='" + modify1 
						+ "' where custid=" + custid + ";";
				st.executeUpdate(sql);
				break;
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 customer update(수정) 오류 : " + e.getMessage());
		}
	}

	// 4번 데이터 수정... products
	public void update2() { // update문
		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		String sql;
		int menu, proid, modify2;
		String modify1;

		// 기준은 아이디로 지정한다..
		System.out.println("1.상품명  2.상품가격");
		System.out.print("수정할 필드명을 선택하세요: >>");
		menu = scan.nextInt();
		try {
			switch (menu) {
			case 1: // proname
				System.out.print("+ 수정할 상품명을 입력하세요:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ 수정할 상품id를 입력하세요:>> ");
				proid = scan.nextInt();
				sql = "update products set proname='" + modify1 
						+ "' where proid=" + proid + ";";
				st.executeUpdate(sql);
				break;

			case 2: // price
				System.out.print("+ 수정할 상품가격를 입력하세요:>> ");
				modify2 = scan2.nextInt();
				System.out.print("+ 수정할 상품id를 입력하세요:>> ");
				proid = scan.nextInt();
				sql = "update products set price='" + modify2 + "' where proid="+ proid + ";";
				st.executeUpdate(sql);
				break;
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 products update(수정) 오류 : " + e.getMessage());
		}
	}

	// 4번 데이터 수정... orders
	public void update3() { // update문
		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		String sql;
		int menu, orderid, modify2;
		String modify1;

		// 기준은 아이디로 지정한다..
		System.out.println("1.주문수량  2.주문날짜  3.주문고객ID 4.주문상품ID");
		System.out.print("수정할 필드명을 선택하세요: >>");
		menu = scan.nextInt();
		try {
			switch (menu) {
			case 1: // ordercount
				System.out.print("+ 수정할 주문수량을 입력하세요:>> ");
				modify2 = scan2.nextInt();
				System.out.print("+ 수정할 주문번호를 입력하세요:>> ");
				orderid = scan.nextInt();
				sql = "update orders set ordercount=" + modify2 + " where orderid=" + orderid + ";";
				st.executeUpdate(sql);
				break;

			case 2: // orderdate
				System.out.print("+ 수정할 주문날짜를 입력하세요:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ 수정할 주문번호를 입력하세요:>> ");
				orderid = scan.nextInt();
				sql = "update orders set orderdate='" + modify1 + "' where orderid=" + orderid + ";";
				st.executeUpdate(sql);
				break;

			case 3: // custid
				System.out.print("+ 수정할 주문고객ID를 입력하세요:>> ");
				modify2 = scan2.nextInt();
				System.out.print("+ 수정할 주문번호를 입력하세요:>> ");
				orderid = scan.nextInt();
				sql = "update orders set custid=" + modify2 + " where orderid=" + orderid + ";";
				st.executeUpdate(sql);
				break;

			case 4: // proid
				System.out.print("+ 수정할 주문상품ID를 입력하세요:>> ");
				modify2 = scan2.nextInt();
				System.out.print("+ 수정할 주문번호를 입력하세요:>> ");
				orderid = scan.nextInt();
				sql = "update orders set proid=" + modify2 + " where orderid=" + orderid + ";";
				st.executeUpdate(sql);
				break;
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 orders update(수정) 오류 : " + e.getMessage());
		}
	}

	public void grant() { // 권한 부여,회수,확인

		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		System.out.println("1. 권한부여 \t 2. 권한 확인 \t 3. 권한 회수");
		System.out.print("메뉴 번호를 선택해주세요>>");
		int grantmenu = scan.nextInt();
		System.out.println("==============================================");
		String crud_rights; // 입력받게.... select,update,delete,insert,all
		String db_name; // 권한 줄 데이터베이스 이름 .. db이름...전체(*)
		String table_name; // 권한 줄 데이터베이스 이름.. 테이블 이름,...전체(*)
		String account; // 권한 계정 생성
		String account_pw; // 권한 계정 비밀번호 ...

		switch (grantmenu) {
		case 1: // 권한 부여
			System.out.println("* 권한 부여 화면입니다 * ");
			try {
				System.out.println(":: 권한을 여러개 부여받을시 ','로 이어주세요!!");
				System.out.println(":: 전체 권한을 부여받고 싶으면 'all'을 입력해주시면 됩니다!!");
				System.out.println("==============================================");

				System.out.print(">> 부여받을 권한을 입력하세요 :");
				crud_rights = scan.next();
				System.out.print(">> 권한을 넣고싶은 DB명을 입력하세요 :");
				db_name = scan.next();
				System.out.print(">> 권한을 넣고싶은 테이블명을 입력하세요 :");
				table_name = scan.next();
				System.out.print(">> 계정명을 입력하세요 :");
				account = scan.next();
				System.out.print(">> 비밀번호를 입력하세요 :");
				account_pw = scan.next();

//grant all on bookstore.* to user1@localhost identified by 'user1234';	

				String SQL = "grant " + crud_rights + " on " + db_name + "." + table_name + " to " + account
						+ "@localhost identified by '" + account_pw + "';";
				st.executeUpdate(SQL);
			} catch (SQLException e) {
				System.out.println("데이터베이스 권한부여 오류 : " + e.getMessage());
			}
			break;

		case 2: // 권한 확인
			System.out.println("* 권한 부여 및 회수 후 권한 확인하는 화면입니다. *");
			try {
				System.out.print(">> 권한을 확인할 계정명을 입력하세요: ");
				String accout = scan.next();
				System.out.println("======================================");
				System.out.println("☞ "+accout+"계정의 권한을 출력합니다.");
				String sql = "show grants for " + accout + "@localhost;";
				rs = st.executeQuery(sql);

				while (rs.next()) {
					String db = rs.getString(1);
					System.out.println(db);
				}
			} catch (SQLException e) {
				System.out.println("데이터베이스 권한확인 오류 : " + e.getMessage());
			}
			break;

		case 3: // 권한 회수
			System.out.println("* 권한 회수하는 화면입니다. *");
			try {
				System.out.println(":: 권한을 여러개 회수할시  ','로 이어주세요!!");
				System.out.println(":: 전체 권한을 회수하고 싶으면 'all'을 입력해주시면 됩니다!!");
				System.out.println("======================================");
				System.out.print(">> 회수할 권한을 입력하세요 :");
				crud_rights = scan.next();
				System.out.print(">> 권한을 회수할 DB명을 입력하세요 :");
				db_name = scan.next();
				System.out.print(">> 권한을 회수할 테이블명을 입력하세요 :");
				table_name = scan.next();
				System.out.print(">> 권한을 회수할 계정명을 입력하세요 :");
				account = scan.next();

				// revoke all on bookstore.* from user1@localhost;

				String SQL = "revoke " + crud_rights + " on " + db_name + "." + table_name + " from " + account
						+ "@localhost;";
				st.executeUpdate(SQL);
			} catch (SQLException e) {
				System.out.println("데이터베이스 권한회수 오류 : " + e.getMessage());
			}
			break;
		}
	}

	public void accountcontent() {
		int accountmenu;// 모든 계정확인 및 계정 삭제 메뉴를 고를 수 있는 변수명..
		scan = new Scanner(System.in);
		System.out.println(" * mysql 내에 있는 모든 계정 확인 및 삭제 메뉴입니다 * ");
		System.out.println("1. 모든 계정 확인 \t 2. 특정 계정 삭제");
		System.out.print(">> 메뉴 번호를 선택하세요: ");
		accountmenu = scan.nextInt();
		System.out.println("=========================");
		
		switch (accountmenu) {
		case 1:
			System.out.println("## mysql내에 있는 모든 계정 출력 ##");
			/*
			 * 등록된 계정 확인 use mysql; select user from user;
			 */
			try {
				ResultSet rs = st.executeQuery("use mysql;");
				rs = st.executeQuery("select user from user;");

				while (rs.next()) {
					String db = rs.getString(1);
					System.out.println(db);
				}
			} catch (SQLException e) {
				e.getStackTrace();
			}
			break;

		case 2:
			System.out.println("## mysql내에 있는 특정 계정 삭제 화면 ##");
			/* drop user 계정명@호스트; */
			try {

				System.out.print(">> 삭제할 계정명을 입력하세요 :");
				String account = scan.next();
				String SQL = "drop user " + account + "@localhost;";
				st.executeUpdate(SQL);

			} catch (SQLException e) {
				e.getStackTrace();
			}

			break;
		}
	}

	// 7번 메뉴 뷰를 출력하는 화면!! view_output
	public void view_output() { 
		String 고객이름,상품명;
		int 고객아이디, 상품아이디;

		try {
			ResultSet rs = st.executeQuery("use shopping;");
			rs = st.executeQuery("select * from easyorder;");
			if (rs == null) {
				System.out.println("저장된 데이터가 없습니다.");
			} else {
				while (rs.next()) {
					고객아이디 = rs.getInt("고객아이디");
					고객이름 = rs.getString("고객이름");
					상품아이디 = rs.getInt("상품아이디");
					상품명 = rs.getString("상품명");
					System.out.printf("%3d \t %5s \t %3d \t %6s", 고객아이디, 고객이름, 상품아이디, 상품명);
					System.out.println();
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 뷰  easyorder 출력 오류 : " + e.getMessage());
		}
	}
	
	public void view_output2() { 
		String 주문정보설명;

		try {
			ResultSet rs = st.executeQuery("use shopping;");
			rs = st.executeQuery("select * from easyorderdetail;");
			if (rs == null) {
				System.out.println("저장된 데이터가 없습니다.");
			} else {
				while (rs.next()) {
					주문정보설명 = rs.getString("주문정보설명");
					System.out.printf("%s", 주문정보설명);
					System.out.println();
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 뷰  easyorder 출력 오류 : " + e.getMessage());
		}
	}
	
	public void end() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류 : " + e.getMessage());
		}
	}
}
