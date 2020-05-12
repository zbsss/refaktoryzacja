package pl.edu.agh.to.lab4;

import java.util.List;

public class Application {

    public static void print(List<Suspect> suspectList){
        System.out.println("Znalazlem " + suspectList.size() + " pasujacych podejrzanych!");
        for (Suspect suspect : suspectList) {
            System.out.println(suspect + " wiek: "+ suspect.getAge());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CompositeAggregate compositeAggregate = new CompositeAggregate();
        compositeAggregate.add(new PrisonersDatabase());
        compositeAggregate.add(new PersonDataProvider());

        Finder finder = new Finder(compositeAggregate);

        List<Suspect> suspectList = finder.findAll(new NameSearchStrategy("Janusz"));
        print(suspectList);

        suspectList = finder.findAll(new AgeSearchStrategy(30, AgeSearchStrategy.Type.L));
        print(suspectList);
    }
}
