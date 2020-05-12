package pl.edu.agh.to.lab4;

public class NameSearchStrategy implements ISearchStrategy{
    private String name;

    public NameSearchStrategy(String name){
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return this.name.equals(suspect.getFirstName());
    }

    public void setName(String name){
        this.name = name;
    }
}
