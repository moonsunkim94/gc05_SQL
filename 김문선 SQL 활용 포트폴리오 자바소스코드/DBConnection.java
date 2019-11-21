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
			System.out.println("�����ͺ��̽� �������: " + e.getMessage());
		}
	}

	// 1�� Data �Է�-������ �Է� insert �Ϸ�
	public void input(customerInfo customer) { // ������ �Է� insert
		try {
			String SQL = "insert into customer " + "values (" + customer.getCustid() 
				+ ",'" + customer.getCustname() + "','" + customer.getCusttel() 
				+ "','" + customer.getCustadd() + "');";
			st.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� customer �Է� ���� : " + e.getMessage());
		}
	}

	// 1�� Data �Է�-�ֹ����� �Է� insert �Ϸ�
	public void input(ordersInfo orders) { // �ֹ����� �Է� insert
		try {
			String SQL = "insert into orders " + "values (" + orders.getOrderid() 
				+ "," + orders.getOrdercount() + ",'"+ orders.getOrderdate() + "'," 
				+ orders.getCustid() + "," + orders.getProid() + ");";
			st.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� orders �Է� ���� : " + e.getMessage());
		}
	}

	// 1�� Data �Է�-��ǰ���� �Է� insert �Ϸ�
	public void input(productsInfo products) { // ��ǰ ���� �Է�
		try {
			String SQL = "insert into products " + "values (" + products.getProid() 
				+ ",'" + products.getProname()+ "'," + products.getPrice() + ");";
			st.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� products �Է� ���� : " + e.getMessage());
		}
	}

	// 2�� Data ��� - �� customer �Ϸ�
	public void output() {
		String custname, custtel, custadd;
		int custid;

		try {
			rs = st.executeQuery("select * from customer;");
			if (rs == null) {
				System.out.println("����� �����Ͱ� �����ϴ�.");
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
			System.out.println("�����ͺ��̽� customer ��� ���� : " + e.getMessage());
		}
	}

	// 2�� Data ��� - ��ǰ products �Ϸ�!!!
	public void output2() { // products
		String proname;
		int proid, price;

		try {
			rs = st.executeQuery("select * from products;");
			if (rs == null) {
				System.out.println("����� �����Ͱ� �����ϴ�.");
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
			System.out.println("�����ͺ��̽� products ��� ���� : " + e.getMessage());
		}
	}

	// 2�� Data ��� - �ֹ����� orders �Ϸ�!!
	public void output3() { // orders
		String orderdate;
		int orderid, proid, custid, ordercount;

		try {
			rs = st.executeQuery("select * from orders;");
			if (rs == null) {
				System.out.println("����� �����Ͱ� �����ϴ�.");
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
			System.out.println("�����ͺ��̽� orders ��� ���� : " + e.getMessage());
		}
	}

	// 3�� ������ ����..-customer ���̺�
	public void delete(int custid) {
		try {
			String SQL = "delete from customer where custid = " + custid + ";";
			st.executeUpdate(SQL);
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� customer ���� ���� : " + e.getMessage());
		}
	}

	// 3�� ������ ����..-products ���̺�
	public void delete2(int proid) {
		try {
			String SQL = "delete from products where proid = " + proid + ";";
			st.executeUpdate(SQL);
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� products ���� ���� : " + e.getMessage());
		}
	}

	// 3�� ������ ����..-orders ���̺�
	public void delete3(int orderid) {
		try {
			String SQL = "delete from orders where orderid = " + orderid + ";";
			st.executeUpdate(SQL);
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� orders ���� ���� : " + e.getMessage());
		}
	}

	// 4�� ������ ����... customer �Ϸ�!!
	public void update() { // update��

		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		String sql;
		int menu, custid, modify2;
		String modify1;

		// ������ ���̵�� �����Ѵ�..
		System.out.println("1.����  2.����ȭ��ȣ  3.���ּ�");
		System.out.print("������ �ʵ���� �����ϼ���: >>");
		menu = scan.nextInt();
		try {
			switch (menu) {
			case 1: // 1�� ���� ����
				System.out.print("+ ������ ������ �Է��ϼ���:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ ������ ��id�� �Է��ϼ���:>> ");
				custid = scan.nextInt();
				sql = "update customer set custname='" + modify1 
						+ "' where custid=" + custid + ";";
				st.executeUpdate(sql);
				break;

			case 2: // 2�� ����ȭ��ȣ ����
				System.out.print("+ ������ ����ȭ��ȣ�� �Է��ϼ���:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ ������ ��id�� �Է��ϼ���:>> ");
				custid = scan.nextInt();
				sql = "update customer set custtel='" + modify1 
						+ "' where custid=" + custid + ";";
				st.executeUpdate(sql);
				break;

			case 3: // 3�� �� �ּ� ����
				System.out.print("+ ������ �� �ּҸ� �Է��ϼ���:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ ������ ��id�� �Է��ϼ���:>> ");
				custid = scan.nextInt();
				sql = "update customer set custadd='" + modify1 
						+ "' where custid=" + custid + ";";
				st.executeUpdate(sql);
				break;
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� customer update(����) ���� : " + e.getMessage());
		}
	}

	// 4�� ������ ����... products
	public void update2() { // update��
		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		String sql;
		int menu, proid, modify2;
		String modify1;

		// ������ ���̵�� �����Ѵ�..
		System.out.println("1.��ǰ��  2.��ǰ����");
		System.out.print("������ �ʵ���� �����ϼ���: >>");
		menu = scan.nextInt();
		try {
			switch (menu) {
			case 1: // proname
				System.out.print("+ ������ ��ǰ���� �Է��ϼ���:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ ������ ��ǰid�� �Է��ϼ���:>> ");
				proid = scan.nextInt();
				sql = "update products set proname='" + modify1 
						+ "' where proid=" + proid + ";";
				st.executeUpdate(sql);
				break;

			case 2: // price
				System.out.print("+ ������ ��ǰ���ݸ� �Է��ϼ���:>> ");
				modify2 = scan2.nextInt();
				System.out.print("+ ������ ��ǰid�� �Է��ϼ���:>> ");
				proid = scan.nextInt();
				sql = "update products set price='" + modify2 + "' where proid="+ proid + ";";
				st.executeUpdate(sql);
				break;
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� products update(����) ���� : " + e.getMessage());
		}
	}

	// 4�� ������ ����... orders
	public void update3() { // update��
		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		String sql;
		int menu, orderid, modify2;
		String modify1;

		// ������ ���̵�� �����Ѵ�..
		System.out.println("1.�ֹ�����  2.�ֹ���¥  3.�ֹ���ID 4.�ֹ���ǰID");
		System.out.print("������ �ʵ���� �����ϼ���: >>");
		menu = scan.nextInt();
		try {
			switch (menu) {
			case 1: // ordercount
				System.out.print("+ ������ �ֹ������� �Է��ϼ���:>> ");
				modify2 = scan2.nextInt();
				System.out.print("+ ������ �ֹ���ȣ�� �Է��ϼ���:>> ");
				orderid = scan.nextInt();
				sql = "update orders set ordercount=" + modify2 + " where orderid=" + orderid + ";";
				st.executeUpdate(sql);
				break;

			case 2: // orderdate
				System.out.print("+ ������ �ֹ���¥�� �Է��ϼ���:>> ");
				modify1 = scan2.nextLine();
				System.out.print("+ ������ �ֹ���ȣ�� �Է��ϼ���:>> ");
				orderid = scan.nextInt();
				sql = "update orders set orderdate='" + modify1 + "' where orderid=" + orderid + ";";
				st.executeUpdate(sql);
				break;

			case 3: // custid
				System.out.print("+ ������ �ֹ���ID�� �Է��ϼ���:>> ");
				modify2 = scan2.nextInt();
				System.out.print("+ ������ �ֹ���ȣ�� �Է��ϼ���:>> ");
				orderid = scan.nextInt();
				sql = "update orders set custid=" + modify2 + " where orderid=" + orderid + ";";
				st.executeUpdate(sql);
				break;

			case 4: // proid
				System.out.print("+ ������ �ֹ���ǰID�� �Է��ϼ���:>> ");
				modify2 = scan2.nextInt();
				System.out.print("+ ������ �ֹ���ȣ�� �Է��ϼ���:>> ");
				orderid = scan.nextInt();
				sql = "update orders set proid=" + modify2 + " where orderid=" + orderid + ";";
				st.executeUpdate(sql);
				break;
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� orders update(����) ���� : " + e.getMessage());
		}
	}

	public void grant() { // ���� �ο�,ȸ��,Ȯ��

		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		System.out.println("1. ���Ѻο� \t 2. ���� Ȯ�� \t 3. ���� ȸ��");
		System.out.print("�޴� ��ȣ�� �������ּ���>>");
		int grantmenu = scan.nextInt();
		System.out.println("==============================================");
		String crud_rights; // �Է¹ް�.... select,update,delete,insert,all
		String db_name; // ���� �� �����ͺ��̽� �̸� .. db�̸�...��ü(*)
		String table_name; // ���� �� �����ͺ��̽� �̸�.. ���̺� �̸�,...��ü(*)
		String account; // ���� ���� ����
		String account_pw; // ���� ���� ��й�ȣ ...

		switch (grantmenu) {
		case 1: // ���� �ο�
			System.out.println("* ���� �ο� ȭ���Դϴ� * ");
			try {
				System.out.println(":: ������ ������ �ο������� ','�� �̾��ּ���!!");
				System.out.println(":: ��ü ������ �ο��ް� ������ 'all'�� �Է����ֽø� �˴ϴ�!!");
				System.out.println("==============================================");

				System.out.print(">> �ο����� ������ �Է��ϼ��� :");
				crud_rights = scan.next();
				System.out.print(">> ������ �ְ���� DB���� �Է��ϼ��� :");
				db_name = scan.next();
				System.out.print(">> ������ �ְ���� ���̺���� �Է��ϼ��� :");
				table_name = scan.next();
				System.out.print(">> �������� �Է��ϼ��� :");
				account = scan.next();
				System.out.print(">> ��й�ȣ�� �Է��ϼ��� :");
				account_pw = scan.next();

//grant all on bookstore.* to user1@localhost identified by 'user1234';	

				String SQL = "grant " + crud_rights + " on " + db_name + "." + table_name + " to " + account
						+ "@localhost identified by '" + account_pw + "';";
				st.executeUpdate(SQL);
			} catch (SQLException e) {
				System.out.println("�����ͺ��̽� ���Ѻο� ���� : " + e.getMessage());
			}
			break;

		case 2: // ���� Ȯ��
			System.out.println("* ���� �ο� �� ȸ�� �� ���� Ȯ���ϴ� ȭ���Դϴ�. *");
			try {
				System.out.print(">> ������ Ȯ���� �������� �Է��ϼ���: ");
				String accout = scan.next();
				System.out.println("======================================");
				System.out.println("�� "+accout+"������ ������ ����մϴ�.");
				String sql = "show grants for " + accout + "@localhost;";
				rs = st.executeQuery(sql);

				while (rs.next()) {
					String db = rs.getString(1);
					System.out.println(db);
				}
			} catch (SQLException e) {
				System.out.println("�����ͺ��̽� ����Ȯ�� ���� : " + e.getMessage());
			}
			break;

		case 3: // ���� ȸ��
			System.out.println("* ���� ȸ���ϴ� ȭ���Դϴ�. *");
			try {
				System.out.println(":: ������ ������ ȸ���ҽ�  ','�� �̾��ּ���!!");
				System.out.println(":: ��ü ������ ȸ���ϰ� ������ 'all'�� �Է����ֽø� �˴ϴ�!!");
				System.out.println("======================================");
				System.out.print(">> ȸ���� ������ �Է��ϼ��� :");
				crud_rights = scan.next();
				System.out.print(">> ������ ȸ���� DB���� �Է��ϼ��� :");
				db_name = scan.next();
				System.out.print(">> ������ ȸ���� ���̺���� �Է��ϼ��� :");
				table_name = scan.next();
				System.out.print(">> ������ ȸ���� �������� �Է��ϼ��� :");
				account = scan.next();

				// revoke all on bookstore.* from user1@localhost;

				String SQL = "revoke " + crud_rights + " on " + db_name + "." + table_name + " from " + account
						+ "@localhost;";
				st.executeUpdate(SQL);
			} catch (SQLException e) {
				System.out.println("�����ͺ��̽� ����ȸ�� ���� : " + e.getMessage());
			}
			break;
		}
	}

	public void accountcontent() {
		int accountmenu;// ��� ����Ȯ�� �� ���� ���� �޴��� �� �� �ִ� ������..
		scan = new Scanner(System.in);
		System.out.println(" * mysql ���� �ִ� ��� ���� Ȯ�� �� ���� �޴��Դϴ� * ");
		System.out.println("1. ��� ���� Ȯ�� \t 2. Ư�� ���� ����");
		System.out.print(">> �޴� ��ȣ�� �����ϼ���: ");
		accountmenu = scan.nextInt();
		System.out.println("=========================");
		
		switch (accountmenu) {
		case 1:
			System.out.println("## mysql���� �ִ� ��� ���� ��� ##");
			/*
			 * ��ϵ� ���� Ȯ�� use mysql; select user from user;
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
			System.out.println("## mysql���� �ִ� Ư�� ���� ���� ȭ�� ##");
			/* drop user ������@ȣ��Ʈ; */
			try {

				System.out.print(">> ������ �������� �Է��ϼ��� :");
				String account = scan.next();
				String SQL = "drop user " + account + "@localhost;";
				st.executeUpdate(SQL);

			} catch (SQLException e) {
				e.getStackTrace();
			}

			break;
		}
	}

	// 7�� �޴� �並 ����ϴ� ȭ��!! view_output
	public void view_output() { 
		String ���̸�,��ǰ��;
		int �����̵�, ��ǰ���̵�;

		try {
			ResultSet rs = st.executeQuery("use shopping;");
			rs = st.executeQuery("select * from easyorder;");
			if (rs == null) {
				System.out.println("����� �����Ͱ� �����ϴ�.");
			} else {
				while (rs.next()) {
					�����̵� = rs.getInt("�����̵�");
					���̸� = rs.getString("���̸�");
					��ǰ���̵� = rs.getInt("��ǰ���̵�");
					��ǰ�� = rs.getString("��ǰ��");
					System.out.printf("%3d \t %5s \t %3d \t %6s", �����̵�, ���̸�, ��ǰ���̵�, ��ǰ��);
					System.out.println();
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ��  easyorder ��� ���� : " + e.getMessage());
		}
	}
	
	public void view_output2() { 
		String �ֹ���������;

		try {
			ResultSet rs = st.executeQuery("use shopping;");
			rs = st.executeQuery("select * from easyorderdetail;");
			if (rs == null) {
				System.out.println("����� �����Ͱ� �����ϴ�.");
			} else {
				while (rs.next()) {
					�ֹ��������� = rs.getString("�ֹ���������");
					System.out.printf("%s", �ֹ���������);
					System.out.println();
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ��  easyorder ��� ���� : " + e.getMessage());
		}
	}
	
	public void end() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���� : " + e.getMessage());
		}
	}
}
