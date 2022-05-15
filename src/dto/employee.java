package dto;

public class Employee {

	//field
	private int empNo;
	private String name;
	private int departmentNo;
	private String departmentName;
	private String position;
	private int salary;
	
	//constructor
	public Employee(int empNo, String name, int departmentNo, String departmentName, String position, int salary) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.position = position;
		this.salary = salary;
	}

	//gettter & setter
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "    "+empNo + "\t" + "   "+ name + "\t    " +  departmentNo + "\t      " + departmentName + "\t" + position + "\t    " + salary ;
	}
	
	
}
