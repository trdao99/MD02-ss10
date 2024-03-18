package ra.entity;

import ra.confic.Message;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Employee implements CRUD {
    private int employCode;
    private String employName;
    private LocalDate employDoB;
    private String employAdress;
    private int employPhone;
    private int employSalary;
    private double Productivity;

    public Employee(int employCode, String employName, LocalDate employDoB, String employAdress, int employPhone, int employSalary, int productivity) {
        this.employCode = employCode;
        this.employName = employName;
        this.employDoB = employDoB;
        this.employAdress = employAdress;
        this.employPhone = employPhone;
        this.employSalary = employSalary;
        Productivity = productivity;
    }

    public Employee() {
    }

    public int getEmployCode() {
        return employCode;
    }

    public void setEmployCode(int employCode) {
        this.employCode = employCode;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    public LocalDate getEmployDoB() {
        return employDoB;
    }

    public void setEmployDoB(LocalDate employDoB) {
        this.employDoB = employDoB;
    }

    public String getEmployAdress() {
        return employAdress;
    }

    public void setEmployAdress(String employAdress) {
        this.employAdress = employAdress;
    }

    public int getEmployPhone() {
        return employPhone;
    }

    public void setEmployPhone(int employPhone) {
        this.employPhone = employPhone;
    }

    public int getEmploySalary() {
        return employSalary;
    }

    public void setEmploySalary(int employSalary) {
        this.employSalary = employSalary;
    }

    public double getProductivity() {
        return Productivity;
    }

    public void setProductivity(double productivity) {
        Productivity = productivity;
    }

    Employee[] employeeArr = new Employee[100];
    int Length = 0;

    public void inputEmploy() throws ParseException {
        System.out.println(Message.INPUTEMPLOY_LABEL);
        Scanner sc = new Scanner(System.in);
        for (int i = Length; i <= Length; i += 2) {
            employeeArr[i] = new Employee();
            Length++;
            System.out.println(Message.INPUTEMPLOY_CODE);
            employeeArr[i].setEmployCode(Integer.parseInt(sc.nextLine()));
            System.out.println(Message.INPUTEMPLOY_NAME);
            employeeArr[i].setEmployName(sc.nextLine());
            System.out.println(Message.INPUTEMPLOY_BIRTH);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(sc.nextLine(), formatter);
            employeeArr[i].setEmployDoB(date);
            System.out.println(Message.INPUTEMPLOY_ADRESS);
            employeeArr[i].setEmployAdress(sc.nextLine());
            System.out.println(Message.INPUTEMPLOY_PHONE);
            employeeArr[i].setEmployPhone(Integer.parseInt(sc.nextLine()));
            System.out.println(Message.INPUTEMPLOY_SALARY);
            employeeArr[i].setEmploySalary(Integer.parseInt(sc.nextLine()));
            System.out.println(Message.INPUTEMPLOY_PRODUCTIVITY);
            employeeArr[i].setProductivity(Double.parseDouble(sc.nextLine()));
        }
    }

    @Override
    public void displayData() {
        for (int i = 0; i < Length; i++) {
            System.out.println(employeeArr[i].toString());
        }
    }

    @Override
    public String toString() {
        return "id: " + this.getEmployCode() +
                "\n name: " + this.getEmployName() +
                "\n birth: " + this.getEmployDoB() +
                "\n adress: " + this.getEmployAdress() +
                "\n phone: " + this.getEmployPhone() +
                "\n salary: " + this.getEmploySalary() +
                "\n productivity: " + this.getProductivity();
    }

    @Override
    public void updateData() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Message.CHANGE_CODE);
        int ID = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < Length; i++) {
            if (ID == employeeArr[i].getEmployCode()) {
                System.out.println(Message.CHANGE_LABEL);
                System.out.println(Message.CHANGE_NAME);
                employeeArr[i].setEmployName(sc.nextLine());
                System.out.println(Message.CHANGE_BIRTH);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate date = LocalDate.parse(sc.nextLine(), formatter);
                employeeArr[i].setEmployDoB(date);
                System.out.println(Message.CHANGE_ADRESS);
                employeeArr[i].setEmployAdress(sc.nextLine());
                System.out.println(Message.CHANGE_PHONE);
                employeeArr[i].setEmployPhone(Integer.parseInt(sc.nextLine()));
                System.out.println(Message.CHANGE_SALARY);
                employeeArr[i].setEmploySalary(Integer.parseInt(sc.nextLine()));
                System.out.println(Message.CHANGE_PRODUCTIVITY);
                employeeArr[i].setProductivity(Double.parseDouble(sc.nextLine()));
            }
            displayData();
        }
    }

    @Override
    public void findBaseOnID() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Message.LOOKINGFOR_CODE);
        int ID = sc.nextInt();
        for (int i = 0; i < Length; i++) {
            if (ID == employeeArr[i].getEmployCode()) {
                System.out.println(employeeArr[i].toString());
                break;
            }
        }
    }
    @Override
    public void deleteData() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Message.DALETE_CODE);
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < Length; i++) {
            if (employeeArr[i].getEmployCode() == id) {
                for (int j = i; j < Length - 1; j++) {
                    employeeArr[j] = employeeArr[j + 1];
                }
                employeeArr[Length - 1] = null;
                Length--;
                break;
            }
        }
    }
    @Override
    public void findBaseOnName() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Message.FIND_NAME);
        String name = sc.nextLine();
        for (int i = 0; i < Length; i++) {
            if (employeeArr[i].getEmployName().toLowerCase().equals(name.toLowerCase())) {
                System.out.println(employeeArr[i].toString());
            }
        }
    }
    @Override
    public void sortName() {
        for (int i = 0; i < Length - 1; i++) {
            for (int j = i; j < Length + 1; j++) {
                if(employeeArr[i].getEmployName().compareTo(employeeArr[j].getEmployName()) > 0){
                    Employee employee = new Employee();
                    employee = employeeArr[i];
                    employeeArr[i] = employeeArr[j];
                    employeeArr[j] = employee;
                }
            }
        }
        displayData();
    }
}
