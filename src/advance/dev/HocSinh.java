package advance.dev;

public class HocSinh extends ConNguoi {
	double Toan;
	double Ly;
	double Hoa;
	String StudentID;
	String Class;

	// Constructor
	public HocSinh(String name, int age, String phone, double Toan, double Ly, double Hoa, String StudentID,
			String Class) {
		super(name, age, phone);
		this.Toan = Toan;
		this.Ly = Ly;
		this.Hoa = Hoa;
		this.StudentID = StudentID;
		this.Class = Class;

	}

	public void info() {
//		super.info();
		System.out.println(
				"/nToan:" + Toan + "Ly: " + Ly + "Hoa: " + Hoa + "Mã sinh viên: " + StudentID + "Lớp: " + Class);
	}

	public double calculateAverageScore() {
		return (Toan + Ly + Hoa) / 3;
	}
}
