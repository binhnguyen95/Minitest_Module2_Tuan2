import frame.Fulltime;
import frame.Parttime;
import frame.Staff;

public class Staff_Manager {
    public static void main(String[] args) {
        Staff[] employees = new Staff[8];

        employees[0] = new Fulltime(1, "Trong", 18, 984426498, "tronglu@yahoo.com", 70, 50, 1450);
        employees[1] = new Fulltime(36, "Phuong", 19, 984472498, "phuong@yahoo.com", 100, 70, 890);
        employees[2] = new Fulltime(43, "Hiep", 18, 984426498, "hiep@yahoo.com", 30, 50, 344);
        employees[3] = new Fulltime(43, "Dung", 17, 984426498, "dung@yahoo.com", 50, 50, 560);

        employees[4] = new Parttime(69, "Hieu", 15, 981126498, "hieu@yahoo.com", 80);
        employees[5] = new Parttime(34, "Nam", 18, 984426498, "nam@yahoo.com", 80);
        employees[6] = new Parttime(77, "Hoang", 19, 984426498, "hoang@yahoo.com", 70);
        employees[7] = new Parttime(77, "Quang Anh", 19, 984426498, "quanganh@yahoo.com", 100);


        double fullTime = netWageFulltime((Fulltime) employees[0]);
        System.out.println(fullTime);

        double partTime = netWageParttime((Parttime) employees[4]);
        System.out.println(partTime);


        double totalPart = totalWageParttime(employees);
        System.out.println("Tong so luong phai tra cho nhan vien ban thoi gian la: " + totalPart);

        getBelowAvg(employees);

        sortAscendingFull(employees);
    }


    //Tinh luong part time
    static double netWageParttime(Parttime employPart) {
        double wage;
        wage = employPart.getWorkTime() * 5;
        return wage;
    }

    //Tinh luong full time
    static double netWageFulltime(Fulltime employFull) {
        double net;
        net = (employFull.getWage() + (employFull.getBonus() - employFull.getFines()));
        return net;
    }

    //Tong luong phai tra cua part time
    static double totalWageParttime(Staff[] array) {
        double sum = 0;
        for (Staff employ : array) {
            if (employ instanceof Parttime) {
                sum += netWageParttime((Parttime) employ);
            }
        }
        return sum;
    }

    //Tinh luong trung binh
    static double getAvgWage(Staff[] array) {
        double sum1 = 0;
        double sum2 = 0;
        for (Staff employ : array) {
            if (employ instanceof Fulltime) {
                sum1 += netWageFulltime((Fulltime) employ);
            } else if (employ instanceof Parttime) {
                sum2 += netWageParttime((Parttime) employ);
            }
        }
        double total = sum1 + sum2;
        return total / array.length;
    }


    //Cac nhan vien duoi muc luong trung binh
    static void getBelowAvg(Staff[] array) {
        System.out.println("Cac nhan vien duoi muc luong trung binh:");
        for (Staff employ : array) {
            if (employ instanceof Fulltime) {
                if (netWageFulltime((Fulltime)employ) < getAvgWage(array)) {
                    System.out.println(employ.getName());
                }
            }
        }
    }

    //Sap xep thu tu
    static void sortAscendingFull(Staff[] array) {
        Staff temp;
        System.out.println("Sap xep luong nhan vien Fulltime tu thap den cao: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] instanceof Fulltime && array[j] instanceof Fulltime ) {
                    double salary1 = netWageFulltime((Fulltime) array[i]);
                    double salary2 = netWageFulltime((Fulltime) array[j]);
                    if (salary1 > salary2) {
                        temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                    }
                }
            }

        }
        for (Staff employ : array) {
            if (employ instanceof Fulltime) {
                System.out.println(employ.getName());
            }
        }
    }
}





