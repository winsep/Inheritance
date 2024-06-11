package advance.dev;

public class GiaoVien extends ConNguoi {

	String TeacherID;
	double salary;

	// Constructor
	public GiaoVien(String name, int age, String phone, double salary, String TeacherID) {
		super(name, age, phone);
		this.TeacherID = TeacherID;
		this.salary = salary;
	}

	// Phương thức tính lương
	public double calculateSalary() {
		return salary * 1000000; // Giả sử mỗi hệ số lương tương ứng với 1 triệu đồng
	}
}