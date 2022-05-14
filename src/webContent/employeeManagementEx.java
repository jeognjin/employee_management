package webContent;

import java.util.Scanner;

import controller.EmployeeController;
import dto.Employee;
import dto.Manager;

public class EmployeeManagementEx {

	private static Scanner sc = new Scanner(System.in);
	private static EmployeeController empControl = EmployeeController.getInstance();
	
	public static void main(String[] args) {
		int select;
		boolean run = true;
		Employee emp = null;
		Manager manager = null;
		String id = "";
		String password = "";
		int result = 0;
		
		while(run) {
			
			System.out.println("========================Employee Management====================");
			System.out.println("\t1.관리자 로그인 | 2.로그아웃 | 3.관리자 등록 | 4.관리자 삭제");
			System.out.println("---------------------------------------------------------------");
			System.out.println(" 4.직원목록 | 5.부서검색 | 6.직원검색 | 6.직원등록 | 7.직원삭제 | 8.직원정보수정");
			System.out.println("================================================================");
			
			System.out.println("번호 선택 >>> ");
			select = Integer.parseInt(sc.nextLine());
			
			switch (select) {
			case 1:
				System.out.println("ID 입력 >>> ");
				id = sc.nextLine();
				System.out.println("password 입력 >>> ");
				password = sc.nextLine();
				manager = EmployeeController.login(id, password);
				
				if (manager != null) {
					System.out.printf("%s님(%s), 로그인 되었습니다.\n", manager.getManagerName(), manager.getManagerId());
				} else {
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			default:
				break;
			}
		}
		
		
		
	}
	
}
