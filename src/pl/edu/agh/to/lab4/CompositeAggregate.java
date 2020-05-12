package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CompositeAggregate implements ISuspectAggregate{

    private final ArrayList<ISuspectAggregate> suspectAggregates = new ArrayList<>();

    public void add(ISuspectAggregate suspectAggregate){
        this.suspectAggregates.add(suspectAggregate);
    }

    @Override
    public Iterator<Suspect> iterator() {
        List<Suspect> suspects = new LinkedList<>();

        for(ISuspectAggregate suspectAggregate : suspectAggregates){
            Iterator<Suspect> iterator = suspectAggregate.iterator();

            while (iterator.hasNext()){
                suspects.add(iterator.next());
            }
        }

        return suspects.iterator();
    }
}
