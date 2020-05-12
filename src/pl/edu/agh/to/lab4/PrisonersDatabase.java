package pl.edu.agh.to.lab4;

import java.util.*;

public class PrisonersDatabase implements ISuspectAggregate{

    private final Map<String, Collection<Prisoner>> prisoners = new HashMap<String, Collection<Prisoner>>();

    public PrisonersDatabase() {
        addPrisoner("Wiezienie krakowskie", new Prisoner("Jan", "Kowalski", "87080452357", 2005, 7));//33
        addPrisoner("Wiezienie krakowskie", new Prisoner("Anita", "Wiercipieta", "84080452357", 2009, 3));//36
        addPrisoner("Wiezienie krakowskie", new Prisoner("Janusz", "Zlowieszczy", "92080445657", 2001, 10));//28
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Janusz", "Zamkniety", "802104543357", 2010, 5));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Adam", "Future", "880216043357", 2020, 5));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Zbigniew", "Nienajedzony", "90051452335", 2011, 1));
        addPrisoner("Wiezienie centralne", new Prisoner("Jan", "Przedziwny", "91103145223", 2009, 4));
        addPrisoner("Wiezienie centralne", new Prisoner("Janusz", "Podejrzany", "85121212456", 2012, 1));
    }

    public Map<String, Collection<Prisoner>> findAll() {
        return prisoners;
    }

    public Collection<String> getAllPrisons() {
        return prisoners.keySet();
    }

    public void addPrisoner(String category, Prisoner prisoner) {
        if (!prisoners.containsKey(category))
            prisoners.put(category, new ArrayList<Prisoner>());
        prisoners.get(category).add(prisoner);
    }

    private class FlatIterator implements Iterator{

        //Iterator over categories
            //Iterate over prisoners inside category

        Iterator<Map.Entry<String, Collection<Prisoner>>> categoryIterator = prisoners.entrySet().iterator();
        Iterator<Prisoner> prisonerIterator;

        @Override
        public boolean hasNext() {
            if(prisonerIterator == null )
                if(categoryIterator.hasNext())
                    prisonerIterator = categoryIterator.next().getValue().iterator();
                else
                    return false;

            return categoryIterator.hasNext() || prisonerIterator.hasNext();
        }

        @Override
        public Object next() {
            if(prisonerIterator.hasNext()){
                return prisonerIterator.next();
            }
            else if(categoryIterator.hasNext()){
                prisonerIterator = categoryIterator.next().getValue().iterator();
                return this.next();
            }
            return null;
        }
    }

    @Override
    public Iterator<Suspect> iterator() {
        return new FlatIterator();
    }
}
