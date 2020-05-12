package pl.edu.agh.to.lab4;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrisonerDatabaseTest {

    private PrisonersDatabase prisonersDatabase = new PrisonersDatabase();

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonersDatabase.getAllPrisons().size());
    }

    @Test
    public void testIterator(){
        Set<Suspect> prisoners = new HashSet<>();

        Iterator<Suspect> iter = prisonersDatabase.iterator();

        while (iter.hasNext()){
            Suspect prisoner = iter.next();
            prisoners.add(prisoner);
        }

        int size = 0;
        for (Collection<Prisoner> prisonerCollection : prisonersDatabase.findAll().values()) {
            for (Prisoner prisoner : prisonerCollection) {
                assertTrue(prisoners.contains(prisoner));
                size++;
            }
        }

        assertEquals(size, prisoners.size());
    }
}
