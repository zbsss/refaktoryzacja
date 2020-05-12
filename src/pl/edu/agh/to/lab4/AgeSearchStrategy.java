package pl.edu.agh.to.lab4;

public class AgeSearchStrategy implements ISearchStrategy{
    public enum Type {E, G, L}

    private int age;
    private Type type;

    public AgeSearchStrategy(int age, Type type){
        this.age = age;
        this.type = type;
    }

    @Override
    public boolean filter(Suspect suspect) {
        if(this.type == Type.L)
            return suspect.getAge() < this.age;
        else if(this.type == Type.G)
            return suspect.getAge() > this.age;
        else
            return suspect.getAge() == this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
