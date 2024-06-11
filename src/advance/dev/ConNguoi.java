package advance.dev;

public class ConNguoi {
	String name;
	int age;
	String phone;

	

	// Constructor
	public ConNguoi(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public void info() {
		System.out.println(name  + age + phone);
	}
}