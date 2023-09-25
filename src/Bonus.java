import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {

        // Onderstaande code is uitgecommentarieerd. Haal de code uit de comment (delete /* en */) om aan de slag te gaan met de bonus
        // In de code staan op verschillende plekken comments tussen "/*...*/" als hint wat je moet doen


        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber = setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback(stringnumber);

    }

    public static HashSet<Integer> randomnumbergenerator(){
         /*
        Stappenplan:
        - Maak een nieuwe variabele van type Random. (Tip: Zoek op internet hoe je Random kunt gebruiken)
        - Maak een nieuwe variabele van type HashSet.
        - Schrijf een while-loop om 4 random nummers aan de hashset toe te voegen
        - return de hashset
         */
        Random randomizer = new Random();
        HashSet<Integer> randomNumbers = new HashSet<>();
        while(randomNumbers.size() < 4){
            randomNumbers.add(randomizer.nextInt(10));
        }
        return randomNumbers;
    }

    public static String setToStringConverter(HashSet<Integer> secretnumber){
        /*
        Stappenplan:
        - Maak als eerst een String variabele met als waarde een lege String. (of gebruik een StringBuilder)
        - Schrijf vervolgens een for-loop om de items in de hashset een voor een aan de String variabele toe te voegen.
        - Return de (gevulde) String variabele
         */
        String secret = "";
        for(int number : secretnumber){
            secret += number;
        }
        return secret;
    }



    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);
        boolean nogBezigMetRaden = true;
        while(nogBezigMetRaden) {
            StringBuilder feedback = new StringBuilder();
            System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
            System.out.println("Doe een gok, Let op vul 4 getallen in.");
            String guess = scanner.nextLine();
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
                nogBezigMetRaden = false;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
            }
            System.out.println(feedback.toString());
        }
    }

    //Hashsets zijn hier niet handig voor omdat je er niet zo goed door kan loopen (lussen?) als door arrays
    //en er geen vaste volgorde wordt aangehouden bij het invullen van de hashset zodat je die moeilijk kan controleren,
    //terwijl een array had hier net zo goed gebruikt kunnen worden omdat de lengte al vaststaat (namelijk vier)
    //en je daar goed op kan checken omdat ieder object in de array een vaste plaats heeft.
}
