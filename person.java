package packagePerson;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;


public class person implements Comparable<person>{

    public String name;
    public String lastName;
    public String dateOfBirth;

    // Constructor method
    public person(String name, String lastName, String dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    // Class instance for converting dates to compatible format
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // The compareTo method is implemented to be able to handle the Collections.sort method
    public int compareTo(person iperson) {

        try {
            Date thisDate = sdf.parse(this.dateOfBirth);
            Date auxDate = sdf.parse(iperson.dateOfBirth);

            // Dates are compared
            if (thisDate.before(auxDate)) {
                return -1;
            } else if (thisDate.after(auxDate)) {
                return 1;
            } else {
                return 0;
            }
        } catch (ParseException e) {
            System.err.println("Error parsing dates: " + e.getMessage());
            return 0;
        }

    }

}