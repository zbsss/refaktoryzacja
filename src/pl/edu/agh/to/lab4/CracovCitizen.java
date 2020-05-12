package pl.edu.agh.to.lab4;

public class CracovCitizen extends Suspect{

    private int age;

    public CracovCitizen(String firstName, String lastName, int age) {
        super(firstName, lastName);
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean isSuspected() {
        return this.age >= 18;
    }
}
