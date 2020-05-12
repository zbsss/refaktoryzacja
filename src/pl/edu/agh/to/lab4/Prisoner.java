package pl.edu.agh.to.lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Prisoner extends Suspect{
    private int judgementYear;

    private int sentenceDuration;

    private final String pesel;


    public Prisoner(String firstName, String lastName, String pesel, int judgementYear, int sentenceDuration) {
        super(firstName, lastName);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    @Override
    public boolean isSuspected() {
        return judgementYear + sentenceDuration < getCurrentYear();
    }

    @Override
    public int getAge() {
        String birthdayString = this.pesel.substring(0,6);
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        try {
            Date birthdate = format.parse(birthdayString);

            Calendar c = Calendar.getInstance();
            c.setTime(birthdate);

            LocalDate bd = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DATE));
            Period diff = Period.between(bd, LocalDate.now());

            return diff.getYears();
        }
        catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public String getPesel() {
        return pesel;
    }
}
