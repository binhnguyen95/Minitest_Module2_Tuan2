package frame;

public class Parttime extends Staff{
    private int workTime;

    public Parttime() {
    }

    public Parttime(int workTime) {
        this.workTime = workTime;
    }

    public Parttime(int staffId, String name, int age, int phoneNumber, String email, int workTime) {
        super(staffId, name, age, phoneNumber, email);
        this.workTime = workTime;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "Parttime{" +
                "workTime=" + workTime +
                '}';
    }

    @Override
    public double getNetWage() {
        double wage = getWorkTime() * 5;
        return wage;
    }
}
