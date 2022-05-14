package dto;

public class Manager {

	private String managerId;
	private String managerPassword;
	private String managerName;
	private boolean loginCheck;
	
	public Manager(String managerId, String managerPassword, String managerName, boolean loginCheck) {
		super();
		this.managerId = managerId;
		this.managerPassword = managerPassword;
		this.managerName = managerName;
		this.loginCheck = loginCheck;
	}

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
