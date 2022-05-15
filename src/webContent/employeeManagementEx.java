package webContent;

import java.util.HashMap;
import java.util.Map;
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
			case 1: //로그인
				Map<String, String> info = inputMasterInfo();
				manager = EmployeeController.login(info); //EmployeeController 입력값 전달 후 리턴값을 manager 객체에 저장
				
				if (manager != null) { //id, password가 일치하는 경우
					System.out.printf("%s님(%s), 로그인 되었습니다.\n", manager.getManagerName(), manager.getManagerId());
				} else { //id 또는 password가 일치하지 않으면 null반환
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요"); 
				}
			case 2: //로그아웃
				info = inputMasterInfo();
				manager = EmployeeController.logout(info);
				if (manager != null) { 
					System.out.printf("%s님(%s), 로그아웃 되었습니다.\n", manager.getManagerName(), manager.getManagerId());
				} else { //id 또는 password가 일치하지 않으면 null반환
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요"); 
				}
				break;
			case 3: //관리자등록
				info = inputMasterInfo();
				manager = EmployeeController.login(info);
				if (manager != null) { //id, password가 일치하는 경우 관리자 등록 실행
					System.out.println("관리자 확인 완료. 생성할 ID의 정보를 입력해주세요.");
					manager = masterRegistInfo();
					if(manager != null) { //신규정보 입력 시 비밀번호 확인 입력이 동일하지 않으면 null값 반환
						result = EmployeeController.regist(manager);
						if (result > 0) {
							System.out.println(manager.getManagerName() + "님, 등록이 완료 되었습니다.");
						} else {
							System.out.println("등록 실패. 관리자에게 문의해주세요.");
						}
					}else {
						System.out.println("비밀번호를 동일하게 입력해주세요.");
					}
				} else { //id 또는 password가 일치하지 않으면 null반환
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요"); 
				}
				
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

	// 신규 관리자 등록 정보 입력받아서 객체로 반환
	private static Manager masterRegistInfo() {
		System.out.println("신규 ID 입력 >>> ");
		String managerId = sc.nextLine();
		System.out.println("신규 password 입력 >>> ");
		String managerPassword = sc.nextLine();
		System.out.println("password 확인 >>> ");
		String passwordCheck = sc.nextLine();
		if (managerPassword.equals(passwordCheck)) {
			System.out.println("이름 입력 >>> ");
			String managerName = sc.nextLine();
			Manager manager = new Manager(managerId, managerPassword, managerName, false);
			return manager;
		} else {
			return null;
		}
	}

	// 관리자 로그인용 id, password를 입력받아 map으로 반환
	private static Map<String, String> inputMasterInfo() {
		System.out.println("로그인 ID 입력 >>> ");
		String id = sc.nextLine();
		System.out.println("로그인 password 입력 >>> ");
		String password = sc.nextLine();
		Map<String, String> info = new HashMap<>();
		info.put("id", id);
		info.put("password", password);
		return info;
	}

}
