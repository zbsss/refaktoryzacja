package pl.edu.agh.to.lab4;

import java.util.*;

public class Finder {

    private final ISuspectAggregate suspectAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.suspectAggregate = compositeAggregate;
    }

    public List<Suspect> findAll(ISearchStrategy searchStrategy){
        List<Suspect> suspectList = new ArrayList<>();
        Iterator<Suspect> iterator = this.suspectAggregate.iterator();

        while (iterator.hasNext()){
            Suspect suspect = iterator.next();

            if(suspect.isSuspected() && searchStrategy.filter(suspect)){
                suspectList.add(suspect);
            }
        }

        return suspectList;
    }
}
