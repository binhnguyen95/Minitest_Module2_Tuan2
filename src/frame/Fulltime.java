package frame;

public class Fulltime extends Staff{
    private double bonus;
    private double fines;
    private double wage;

    public Fulltime(){
    }

    public Fulltime( double bonus, double fines, double wage) {
        this.bonus = bonus;
        this.fines = fines;
        this.wage = wage;
    }

    public Fulltime(int staffId, String name, int age, int phoneNumber, String email, double bonus, double fines, double wage) {
        super(staffId, name, age, phoneNumber, email);
        this.bonus = bonus;
        this.fines = fines;
        this.wage = wage;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFines() {
        return fines;
    }

    public void setFines(double fines) {
        this.fines = fines;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public double getNetWage() {
        double wage = getWage() + ( getBonus() - getFines() ) ;
        return wage;
    }

    @Override
    public String toString() {
        return "Fulltime{" +
                "bonus=" + bonus +
                ", fines=" + fines +
                ", wage=" + wage +
                '}';
    }


}

