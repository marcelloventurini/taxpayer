package entities;

public class Company extends Taxpayer {
    private int numberOfEmployees;

    public Company(String name, double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double calculateTax() {
        if (numberOfEmployees > 10) {
            return getAnualIncome() * 0.14;
        }

        return getAnualIncome() * 0.16;
    }
}
