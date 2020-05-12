package pl.edu.agh.to.lab4;

public abstract class Suspect {
    private String firstName;
    private String lastName;

    protected Suspect(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString(){
        return this.getFirstName() + " " + this.getLastName();
    }

    public abstract boolean isSuspected();

    public abstract int getAge();
}
