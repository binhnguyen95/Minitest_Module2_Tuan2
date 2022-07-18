import frame.Fulltime;
import frame.Parttime;
import frame.Staff;

import java.util.ArrayList;
import java.util.Comparator;

public class Staff_Test {
    public static void main(String[] args) {

        Staff QuangAnh = new Fulltime(1, "Quang Anh", 17, 988463313, "quanganh@yahoo.com" ,70, 50, 1450);
        Staff Phuong = new Fulltime(1, "Phuong", 18, 983785968, "phuong@yahoo.com" ,100, 70, 890);
        Staff Trong = new Fulltime(1, "Trong", 19, 938648278, "trong@yahoo.com" ,50, 30 ,560);
        Staff Dinh = new Parttime(63);
        Staff Hiep = new Parttime(71);
        Staff Ba = new Parttime(57);

        ArrayList<Staff> employees = new ArrayList<>();
        employees.add(QuangAnh);
        employees.add(Phuong);
        employees.add(Trong);
        employees.add(Dinh);
        employees.add(Hiep);
        employees.add(Ba);

        System.out.println("Tong luong phai tra cho nhan vien parttime: ");
        System.out.println(totalWageParttime(employees) + "$");

        System.out.println("Luong trung binh cua cac nhan vien: ");
        System.out.println(averageWage(employees));

        System.out.println("Nhan vien duoi muc luong trung binh: ");
        belowAverage(employees);

        //Sap xep luong tang dan
        employees.sort((Comparator.comparingDouble(Staff::getNetWage)));
        System.out.print(employees);
    }

    //Tong luong phai tra cho Parttime
    public static double totalWageParttime(ArrayList<Staff> array) {
        int sum = 0;
        for (Staff employ: array) {
            if (employ instanceof Parttime) {
                sum += employ.getNetWage();
            }
        }
        return sum;
    }

    //Tinh luong trung binh
    public static float averageWage(ArrayList<Staff> array) {
        int sum = 0;
        for (Staff employ : array) {
            sum += employ.getNetWage();
        }
        return sum / array.size();
    }

    //Nhan vien Fulltime duoi luong trung binh
    public static void belowAverage(ArrayList<Staff> array) {
        for (int i = 0; i < array.size(); i++) {
            if ( array.get(i) instanceof Fulltime ) {
                if (array.get(i).getNetWage() < averageWage(array)) {
                    System.out.println(array.get(i));
                }
            }
        }
    }
}
