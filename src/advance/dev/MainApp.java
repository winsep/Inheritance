package advance.dev;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConNguoi[] connguoi = new ConNguoi[10];
		input(connguoi);
		print(connguoi);
		findTeacher(connguoi);
		findHighScoringStudent((HocSinh[]) connguoi);
	}

	// Phương thức nhập thông tin
	public static void input(ConNguoi[] connguoi) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < connguoi.length; i++) {
			System.out.println("Nhập thông tin cho người thứ " + (i + 1) + ":");
			System.out.println("Tên: ");
			String name = scanner.nextLine();
			System.out.println("Tuổi: ");
			int age = scanner.nextInt();
			System.out.println("Số điện thoại: ");
			String phone = scanner.nextLine();
			scanner.nextLine();
			if (i < 4) { // Nhập thông tin giáo viên
				System.out.println("Mã giáo viên: ");
				String TeacherID = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Hệ số lương: ");
				double salary = scanner.nextDouble();
				scanner.nextLine(); // Đọc dấu xuống dòng sau cùng và làm sạch bộ đệm
				connguoi[i] = new GiaoVien(name, age, phone, salary, TeacherID);
			} else { // Nhập thông tin sinh viên

				System.out.print("Mã sinh viên: ");
				String StudentID = scanner.nextLine();
//				System.out.println("số điện thoại: ");
//				String phone = scanner.nextLine();
				System.out.print("Lớp: ");
				String Class = scanner.nextLine();
				scanner.nextLine(); // Đọc dấu xuống dòng sau cùng và làm sạch bộ đệm
				System.out.print("Điểm Toán: ");
				double Toan = scanner.nextDouble();
				System.out.print("Điểm Lý: ");
				double Ly = scanner.nextDouble();
				System.out.print("Điểm Hóa: ");
				double Hoa = scanner.nextDouble();

				connguoi[i] = new HocSinh(name, age, phone, Toan, Ly, Hoa, StudentID, Class);

			}
		}
		scanner.close();
	}

	// Phương thức xuất thông tin
	public static void print(ConNguoi[] connguoi) {
		System.out.println("\nThông tin của danh sách 10 người:");
		for (int i = 0; i < connguoi.length; i++) {
			System.out.println("Người thứ " + (i + 1) + ":");
			System.out.println("Tên: " + connguoi[i].name);
			System.out.println("Tuổi: " + connguoi[i].age);
			System.out.println("Số điện thoại: " + connguoi[i].phone);
			if (connguoi[i] instanceof GiaoVien) {
				GiaoVien gv = (GiaoVien) connguoi[i];
				System.out.println("Mã giáo viên: " + gv.TeacherID);
				System.out.println("Hệ số lương: " + gv.salary);
			} else if (connguoi[i] instanceof HocSinh) {
				HocSinh hs = (HocSinh) connguoi[i];
				System.out.println("Mã sinh viên: " + hs.StudentID);
				System.out.println("Lớp: " + hs.Class);
				System.out.println("Điểm trung bình: " + hs.calculateAverageScore());
			}
			System.out.println();
		}
	}

// Phương thức tìm giáo viên có lương cao nhất
	public static void findTeacher(ConNguoi[] connguoi) {
		GiaoVien highestPaidTeacher = null;
		double maxSalary = 0;

		for (ConNguoi cn : connguoi) {
			if (cn instanceof GiaoVien) {
				GiaoVien gv = (GiaoVien) cn;
				double salary = gv.calculateSalary();
				if (salary > maxSalary) {
					maxSalary = salary;
					highestPaidTeacher = gv;
				}
			}
		}

		if (highestPaidTeacher != null) {
			System.out.println("Giáo viên có lương cao nhất là:");
			System.out.println("Tên: " + highestPaidTeacher.name);
			System.out.println("Tuổi: " + highestPaidTeacher.age);
			System.out.println("Số điện thoại: " + highestPaidTeacher.phone);
			System.out.println("Mã giáo viên: " + highestPaidTeacher.TeacherID);
			System.out.println("Hệ số lương: " + highestPaidTeacher.salary);
			System.out.println("Lương: " + maxSalary);
		} else {
			System.out.println("Không có giáo viên nào trong danh sách.");
		}
	}

// Phương thức tìm sinh viên có điểm trung bình cao nhất
	public static void findHighScoringStudent(HocSinh[] hocsinh) {
		HocSinh highestScoringStudent = null;
		double maxAverageScore = 0;

		for (HocSinh hs : hocsinh) {
			double averageScore = hs.calculateAverageScore();
			if (averageScore > maxAverageScore) {
				maxAverageScore = averageScore;
				highestScoringStudent = hs;
			}
		}

		if (highestScoringStudent != null) {
			System.out.println("\nSinh viên có điểm trung bình cao nhất là:");
			System.out.println("Tên: " + highestScoringStudent.name);
			System.out.println("Tuổi: " + highestScoringStudent.age);
			System.out.println("Số điện thoại: " + highestScoringStudent.phone);
			System.out.println("Mã sinh viên: " + highestScoringStudent.StudentID);
			System.out.println("Lớp: " + highestScoringStudent.Class);
			System.out.println("Điểm trung bình: " + maxAverageScore);
		} else {
			System.out.println("\nKhông có sinh viên nào trong danh sách.");
		}
	}
}
