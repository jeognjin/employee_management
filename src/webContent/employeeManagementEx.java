package webContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

		while (run) {

			System.out.println("========================Employee Management====================");
			System.out.println("\t1.관리자 로그인 | 2.로그아웃 | 3.관리자 등록 | 4.관리자 삭제");
			System.out.println("---------------------------------------------------------------");
			System.out.println(" 5.직원목록 | 6.부서검색 | 7.직원검색 | 8.직원등록 | 9.직원삭제 | 10.직원정보수정");
			System.out.println("================================================================");

			System.out.println("번호 선택 >>> ");
			select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1: // 로그인
				Map<String, String> info = inputMasterInfo();
				manager = EmployeeController.login(info); // EmployeeController 입력값 전달 후 리턴값을 manager 객체에 저장

				if (manager != null) { // id, password가 일치하는 경우
					System.out.printf("%s님(%s), 로그인 되었습니다.\n", manager.getManagerName(), manager.getManagerId());
				} else { // id 또는 password가 일치하지 않으면 null반환
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
			case 2: // 로그아웃
				info = inputMasterInfo();
				manager = EmployeeController.logout(info);
				if (manager != null) {
					System.out.printf("%s님(%s), 로그아웃 되었습니다.\n", manager.getManagerName(), manager.getManagerId());
				} else { // id 또는 password가 일치하지 않으면 null반환
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
				break;
			case 3: // 관리자등록
				info = inputMasterInfo();
				manager = EmployeeController.login(info);
				if (manager != null) { // id, password가 일치하는 경우 관리자 등록 실행
					System.out.println("관리자 확인 완료. 등록할 관리자의 정보를 입력해주세요.");
					manager = managerRegistInfo();
					if (manager != null) { // 신규정보 입력 시 비밀번호 확인 입력이 동일하지 않으면 null값 반환
						result = EmployeeController.managerRegist(manager);
						if (result > 0) {
							System.out.println(manager.getManagerName() + "님, 등록이 완료 되었습니다.");
						} else {
							System.out.println("등록 실패. 관리자에게 문의해주세요.");
						}
					} else {
						System.out.println("비밀번호를 동일하게 입력해주세요.");
					}
				} else { // id 또는 password가 일치하지 않으면 null반환
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}

				break;
			case 4: // 관리자 삭제
				info = inputMasterInfo();
				manager = EmployeeController.login(info);
				if (manager != null) {
					System.out.println("관리자 확인 완료. 삭제할 ID를 입력해주세요.");
					System.out.println("삭제할 ID 입력 >>> ");
					String managerId = sc.nextLine();
					result = EmployeeController.managerResign(managerId);
					if (result > 0) {
						System.out.println(managerId + " 삭제 완료 되었습니다.");
					} else {
						System.out.println("삭제 실패. 관리자에게 문의해주세요.");
					}
				} else { // id 또는 password가 일치하지 않으면 null반환
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
				break;
			case 5:// 직원 목록 보기
				info = inputMasterInfo();
				manager = EmployeeController.login(info);
				if (manager != null) { // 관리자 로그인 후 직원목록 열람가능
					List<Employee> employees = EmployeeController.empList();
					printList(employees);
				} else {
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
				break;
			case 6: // 부서검색
				info = inputMasterInfo();
				manager = EmployeeController.login(info);
				if (manager != null) { // 관리자 로그인 후 부서검색
					System.out.println("관리자 확인 완료. 검색할 부서번호를 입력해주세요.");
					System.out.println("부서번호 입력 >>> ");
					int deptNo = Integer.parseInt(sc.nextLine());
					List<Employee> employees = EmployeeController.deptList(deptNo);
					printList(employees);
				} else {
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
				break;
			case 7: // 직원검색
				info = inputMasterInfo();
				manager = EmployeeController.login(info);
				if (manager != null) { // 관리자 로그인 후 직원검색
					System.out.println("관리자 확인 완료. 검색할 직원의 이름을 입력해주세요.");
					System.out.println("직원 이름 입력 >>> ");
					String empName = sc.nextLine();
					List<Employee> employee = EmployeeController.empSelect(empName);
					printList(employee);
				} else {
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
				break;
			case 8: // 직원등록
				System.out.println("직원번호 입력 >>> ");
				int empNo = Integer.parseInt(sc.nextLine());
				info = inputMasterInfo();
				manager = EmployeeController.login(info);
				if (manager != null) { // id, password가 일치하는 경우 직원등록 실행
					System.out.println("관리자 확인 완료. 등록할 직원의 정보를 입력해주세요.");
					emp = inputEmpInfo(empNo);
					result = EmployeeController.empRegist(emp);
					if (result > 0) {
						System.out.println(emp.getName() + " 등록이 완료 되었습니다.");
					} else {
						System.out.println("등록 실패. 관리자에게 문의해주세요.");
					}
				} else {
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
				break;
			case 9: // 직원삭제
				info = inputMasterInfo();
				manager = EmployeeController.login(info);
				if (manager != null) { //관리자 로그인 후 직원 삭제 실행
					System.out.println("관리자 확인 완료. 삭제할 직원의 직원번호를 입력해주세요.");
					System.out.println("직원번호 입력 >>> ");
					empNo = Integer.parseInt(sc.nextLine());
					result = EmployeeController.empResign(empNo);
					if (result > 0) {
						System.out.println(empNo + "번 직원정보 삭제 완료 되었습니다.");
					} else {
						System.out.println("삭제 실패. 관리자에게 문의해주세요.");
					}
				} else { 
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
				break;
			case 10: // 직원 정보수정
				info = inputMasterInfo();
				manager = EmployeeController.login(info);
				if (manager != null) { //관리자 로그인 후 직원 정보 수정 실행
					System.out.println("관리자 확인 완료. 수정할 직원의 직원번호를 입력해주세요.");
					System.out.println("직원번호 입력 >>> ");
					empNo = Integer.parseInt(sc.nextLine());
					emp = inputEmpInfo(empNo);
					result = EmployeeController.empUpdate(emp);
					if (result > 0) {
						System.out.println(empNo + "번 직원정보 수정이 완료 되었습니다.");
					} else {
						System.out.println("수정 실패. 관리자에게 문의해주세요.");
					}
				} else { 
					System.out.println("ID 또는 비밀번호가 맞지 않습니다. 다시 시도해주세요");
				}
				break;
			default:
				break;
			}
		}
	}

	//직원번호를 받아서 나머지 직원정보 입력받은 후 객체로 반환
	private static Employee inputEmpInfo(int empNo) {
		System.out.println("이름 입력 >>> ");
		String name = sc.nextLine();
		System.out.println("부서번호 입력 >>> ");
		int departmentNo = Integer.parseInt(sc.nextLine());
		System.out.println("부서명 입력 >>> ");
		String departmentName = sc.nextLine();
		System.out.println("직급 입력 >>> ");
		String position = sc.nextLine();
		System.out.println("급여 입력 >>> ");
		int salary = Integer.parseInt(sc.nextLine());
		Employee emp = new Employee(empNo, name, departmentNo, departmentName, position, salary);
		return emp;
	}

	// 직원 목록 출력
	private static void printList(List<Employee> employees) {
		Iterator emps = employees.iterator();
		Employee employee = null;
		System.out.println("------------------직원 목록--------------------");
		System.out.println("사원 번호 |  이름   |  부서번호  |  부서명   |   직급    |  급여");
		while (emps.hasNext()) {
			employee = (Employee) emps.next();
			System.out.println(employee);
		}
	}

	// 신규 관리자 등록 정보 입력받아서 객체로 반환
	private static Manager managerRegistInfo() {
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
