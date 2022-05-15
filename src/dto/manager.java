package dto;

public class Manager {

	//field
	private String managerId;
	private String managerPassword;
	private String managerName;
	private boolean loginCheck; //관리자 로그인 여부 확인을 위해 boolean 사용
	
	//constructor
	public Manager(String managerId, String managerPassword, String managerName, boolean loginCheck) {
		super();
		this.managerId = managerId;
		this.managerPassword = managerPassword;
		this.managerName = managerName;
		this.loginCheck = loginCheck;
	}

	//gettter & setter
	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public boolean isLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(boolean loginCheck) {
		this.loginCheck = loginCheck;
	}

	@Override
	public String toString() {
		return "manager [managerId=" + managerId + ", managerPassword=" + managerPassword + ", managerName="
				+ managerName + ", loginCheck=" + loginCheck + "]";
	}

	
}
