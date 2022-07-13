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

            query.indexOf(":");
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
        }//Received query "e49a3410: what is 12 plus 4"
        else if (query.contains("what") && query.contains("plus")) {
            String[] temp = query.split(" plus ");
            String[] temp2 = temp[0].split(" ");
            int number1 = -1;
            try {
                number1 = Integer.parseInt(temp2[temp2.length-1]);
            }
            catch (NumberFormatException e) {
                number1 = -1;
            }
            int number2 = -1;
            try {
                number2 = Integer.parseInt(temp[temp.length-1]);
            }
            catch (NumberFormatException e) {
                number2 = -1;
            }
            return "" + number1 + number2;
        }
        else {
            return "V";
        }
    }
}
