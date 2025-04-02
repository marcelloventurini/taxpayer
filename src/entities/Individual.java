package entities;

public class Individual extends Taxpayer {
    private double medicalExpenses;

    public Individual(String name, double anualIncome, double medicalExpenses) {
        super(name, anualIncome);
        this.medicalExpenses = medicalExpenses;
    }

    public double getMedicalExpenses() {
        return medicalExpenses;
    }

    public void setMedicalExpenses(double medicalExpenses) {
        this.medicalExpenses = medicalExpenses;
    }

    @Override
    public double calculateTax() {
        if (getAnualIncome() <= 20000) {
            return (getAnualIncome() * 0.15) - (medicalExpenses * 0.5);
        } else {
            return (getAnualIncome() * 0.25) - (medicalExpenses * 0.5);
        }
    }
}
