package ra.run;

import ra.confic.Message;
import ra.entity.Employee;

import java.text.ParseException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {
        Employee employee = new Employee();
        while (true) {
            System.out.println("*********************MENU********************** \n" +
                    "1.\tThêm mới 1 nhân viên \n" +
                    "2.\tHiển thị danh sách thông tin nhân viên \n" +
                    "3.\tXem thông tin nhân viên theo mã nhân viên\n" +
                    "4.\tCập nhật thông tin nhân viên\n" +
                    "5.\tXóa nhân viên\n" +
                    "6.\tTìm kiếm nhân viên theo tên (tương đối)\n" +
                    "7.\tSắp xếp và hiển thị danh sách nhân viên theo tên từ a - z\n" +
                    "8.\tThoát\n");
            System.out.println(Message.CHOOSE);
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    employee.inputEmploy();
                    break;
                case 2:
                    employee.displayData();
                    break;
                case 3:
                    employee.findBaseOnID();
                    break;
                case 4:
                    employee.updateData();
                    break;
                case 5:
                    employee.deleteData();
                    break;
                case 6:
                    employee.findBaseOnName();
                    break;
                case 7:
                    employee.sortName();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
