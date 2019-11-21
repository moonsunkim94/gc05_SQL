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
		
		System.out.println(" �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ� ");
		System.out.println(" �Ƣ�                                                                   �Ƣ� ");
		System.out.println(" �Ƣ�                       �����ͺ��̽� ���� ���α׷�                                             �Ƣ�");
		System.out.println(" �Ƣ�                                                                   �Ƣ�");
		System.out.println(" �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ� ");
		System.out.println("");
		
		while (check) {
			System.out.println("  �ˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢ�");
			System.out.println("");
			System.out.println(" \t\t\t           ��  Select Menu ��");
			System.out.println("");
			System.out.println("    1. Data �Է� \t 2. Data ��� \t\t 3. Data ���� \t 4. Data ����   \t\n"
							 + "    5. ���Ѻο� \t 6. ���� Ȯ�� �� ���� \t 7. �� ��� \t 8. ����");
			System.out.println("");
			System.out.println("  �ˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢ�");
			
			System.out.print(" >> �۾��� �����ϼ��� :  ");
			menu = scan.nextInt();
			int tablechoice, viewchoice;

			switch (menu) {
			case 1: // ������ �Է� �Ϸ�!!
				System.out.println(" => 1�� 'Data �Է�'�� �����߽��ϴ�.");
				System.out.println("");
				System.out.println("���� �� Data �Է� ȭ��(Insert) ������ ");
				System.out.println(":: �� 3���� ���̺��� �ֽ��ϴ�.");
				System.out.println(":: 1. �����̺� \t 2. ��ǰ���̺� \t 3.�ֹ��������̺�");
				System.out.print(">> �Է��� ���̺��� �����ϼ��� : ");
				tablechoice = scan.nextInt();
				System.out.println("=========================");

				switch (tablechoice) {
				case 1: // customer table
					System.out.println("�� ���������̺�(customer)�� �����߽��ϴ�.");
					System.out.println("=========================");
					pro = new Process();
					customer = pro.inputInfo();
					connection.input(customer);
					System.out.println("");
					break;

				case 2: // products table
					System.out.println("�� ��ǰ�������̺�(products)�� �����߽��ϴ�.");
					System.out.println("=========================");
					pro = new Process();
					products = pro.inputInfo2();
					connection.input(products);
					System.out.println("");
					break;

				case 3: // orders table
					System.out.println("�� �ֹ��������̺�(orders)�� �����߽��ϴ�.");
					System.out.println("=========================");
					pro = new Process();
					orders = pro.inputInfo3();
					connection.input(orders);
					System.out.println("");
					break;

				}
				break;

			case 2: // ���� ��� select �Ϸ�!!!

				System.out.println(" => 2�� 'Data ���'�� �����߽��ϴ�.");
				System.out.println("");
				System.out.println("���� �� Data ��� ȭ��(Select) ������ ");
				System.out.println(":: �� 3���� ���̺��� �ֽ��ϴ�.");
				System.out.println(":: 1. �����̺� \t 2. ��ǰ���̺� \t 3.�ֹ��������̺�");
				System.out.print(">> ����� ���̺��� �����ϼ��� : ");
				tablechoice = scan.nextInt();
				System.out.println("=========================");
				// System.out.println();

				switch (tablechoice) {
				case 1: // customer table
					System.out.println("�� ���������̺�(customer)�� �����߽��ϴ�.");
					System.out.println("=========================");
					System.out.println("==> customer table�� ����մϴ�.");
					System.out.println("");
					System.out.println(" ��ID \t ����\t    ����ȭ��ȣ \t    ���ּ�");
					System.out.println("============================================");
					connection.output();
					break;

				case 2: // products table
					System.out.println("�� ��ǰ�������̺�(products)�� �����߽��ϴ�.");
					System.out.println("=========================");
					System.out.println("==> products table�� ����մϴ�.");
					System.out.println("");
					System.out.println("��ǰID \t        ��ǰ��\t    ���� \t");
					System.out.println("===================================");
					connection.output2();
					break;

				case 3: // orders table
					System.out.println("�� �ֹ��������̺�(orders)�� �����߽��ϴ�.");
					System.out.println("=========================");
					System.out.println("==> orders table�� ����մϴ�.");
					System.out.println("");
					System.out.println("�ֹ���ȣ \t  �ֹ�����\t     �ֹ���¥       �ֹ���ID   �ֹ���ǰID");
					System.out.println("==================================================");
					connection.output3();
					break;

				}
				break;

			case 3: // ���� �Ϸ�!!
				System.out.println(" => 3�� 'Data ����'�� �����߽��ϴ�.");
				System.out.println("");
				System.out.println("���� �� Data ���� ȭ��(Delete) ������ ");
				System.out.println(":: �� 3���� ���̺��� �ֽ��ϴ�.");
				System.out.println(":: 1. �����̺� \t 2. ��ǰ���̺� \t 3.�ֹ��������̺�");
				System.out.print(">> ������ �÷��� �ִ� ���̺��� �����ϼ��� : ");
				tablechoice = scan.nextInt();
				System.out.println("=========================");

				switch (tablechoice) {
				case 1: // customer table
					System.out.println("�� ���������̺�(customer)�� �����߽��ϴ�.");
					System.out.println("=========================");
					System.out.println(" @ customer table �÷����� ȭ���Դϴ� @");
					System.out.print("> �������� ������ ��ID�� �Է��ϼ���: ");
					connection.delete(scan.nextInt());
					System.out.println("");
					break;

				case 2: // products table
					System.out.println("�� ��ǰ�������̺�(products)�� �����߽��ϴ�.");
					System.out.println("=========================");
					System.out.println(" @ products table �÷����� ȭ���Դϴ� @");
					System.out.print("> ��ǰ������ ������ ��ǰID�� �Է��ϼ���: ");
					connection.delete2(scan.nextInt());
					System.out.println("");
					break;

				case 3: // orders table
					System.out.println("�� �ֹ��������̺�(orders)�� �����߽��ϴ�.");
					System.out.println("=========================");
					System.out.println(" @ orders table �÷����� ȭ���Դϴ� @");
					System.out.print("> �ֹ������� ������ �ֹ���ȣ�� �Է��ϼ���: ");
					connection.delete3(scan.nextInt());
					System.out.println("");
					break;

				}
				break;

			case 4: // ���� -- update..
				System.out.println("=> 4�� 'Data ����'�� �����߽��ϴ�.");
				System.out.println("");
				System.out.println("���� �� Data ���� ȭ��(Update) ������ ");
				System.out.println(":: �� 3���� ���̺��� �ֽ��ϴ�.");
				System.out.println(":: 1. �����̺� \t 2. ��ǰ���̺� \t 3.�ֹ��������̺�");
				System.out.print(">> ������ ���̺��� �����ϼ��� : ");
				tablechoice = scan.nextInt();
				System.out.println("=========================");

				switch (tablechoice) {
				case 1: // customer update
					System.out.println("�� ���������̺�(customer)�� �����߽��ϴ�.");
					System.out.println("=========================");
					System.out.println("@ customer table ����(update) ȭ���Դϴ� @");
					connection.update();
					break;

				case 2: // products update
					System.out.println("�� ��ǰ�������̺�(products)�� �����߽��ϴ�.");
					System.out.println("=========================");
					System.out.println("@ products table ����(update) ȭ���Դϴ� @");
					connection.update2();
					break;

				case 3: // orders update
					System.out.println("�� �ֹ��������̺�(orders)�� �����߽��ϴ�.");
					System.out.println("=========================");
					System.out.println("@ orders table ����(update) ȭ���Դϴ� @");
					connection.update3();
					break;
				}
				break;

			case 5: // ���� �ο� grant,revoke
				System.out.println(" => 5�� '���Ѻο�'�� �����߽��ϴ�.");
				System.out.println("");
				System.out.println("���� �� ���� �ο�/Ȯ��/ȸ�� ȭ��(Grant/Revoke) ������ ");
				connection.grant();
				System.out.println("");
				break;

			case 6:
				System.out.println(" => 6�� '���� Ȯ�� �� ����'�� �����߽��ϴ�.");
				System.out.println("");
				System.out.println("���� �� ���� Ȯ�� �� ���� ȭ�� ������ ");
				connection.accountcontent();
				System.out.println("");
				break;

			case 7: // mysql���� ������ ������ϴ� �޴��Դϴ�.
				// �� 2������ �����Ͽ����Ƿ� 2������ �����ϴ� �޴����� ����Ͽ� �����ϰ� �Ұ��Դϴ�.
				System.out.println(" => 7�� '�� ���'�� �����߽��ϴ�.");
				System.out.println("");
				System.out.println("���� �� �� ��� ȭ�� ������ ");
				System.out.println(":: �� 2���� �䰡 �ֽ��ϴ�.");
				System.out.println(":: 1. �ֹ��������� ��(easyorder)  \t 2. �ֹ������� ��(easyorderdetail)");
				System.out.print(">> ����� �並 �����ϼ��� : ");
				viewchoice = scan.nextInt();
				System.out.println("=========================");

				switch (viewchoice) {
				case 1: // easyorder
					System.out.println("�� �ֹ��������� ��(easyorder)�� �����߽��ϴ�.");
					System.out.println("# easyorder view�� ����մϴ�.");
					System.out.println("");
					System.out.println(" ��ID    ���̸�    ��ǰID    ��ǰ��");
					System.out.println("=================================");
					connection.view_output();
					break;

				case 2: // easyorderdetail
					System.out.println("�� �ֹ������� ��(easyorderdetail)�� �����߽��ϴ�.");
					System.out.println("# easyorderdetail view�� ����մϴ�");
					System.out.println("");
					System.out.println(" \t\t\t\t�ֹ���������");
					System.out.println("======================================================================");
					connection.view_output2();
					break;
				}
				break;

			case 8:
				System.out.println("���α׷��� �����մϴ�!!");
				check = false;
				break;

			default:
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. �ٽ� �������ּ���. \n");
				break;
			}
		}
		scan.close();
		scan2.close();
		connection.end();
	}
}
