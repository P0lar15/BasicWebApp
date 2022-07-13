package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        } else if (query.contains("numbers") && query.contains("largest")){ // TODO extend the programm here
            String[] temp = query.split(" ");
            int[] integers = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                try {
                    integers[i] = Integer.parseInt(temp[i]);
                }
                catch (NumberFormatException e) {
                    integers[i] = -1;
                }
            }
            int highest = integers[0];
            for (int i = 0; i < integers.length; i++) {
                if (integers[i] > highest) {
                    highest = integers[i];
                }
            }
            return "" + highest;
        }
        else {
            return "V";
        }
    }
}
