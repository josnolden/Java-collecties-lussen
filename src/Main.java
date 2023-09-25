import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numeric = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String[] alphabetic = {"een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "nul"};

        Translator vertaler = new Translator(alphabetic, numeric);

        boolean play = true;
        String ongeldig = "ongeldige invoer";
        Scanner scanner = new Scanner(System.in);

        while(play){
            System.out.println("Type 'x' on te stoppen \nType 'v' om te vertalen");
            String input = scanner.nextLine();
            if(input.toLowerCase().equals("x")){
                play = false;
            }
            else if(input.toLowerCase().equals("v")){
                System.out.println("Type een cijfer van 0 t/m 9");
                String numberString = scanner.nextLine();
                try{
                    int number = Integer.parseInt(numberString);
                    scanner.nextLine();
                    if(number < 10){
                        String result = vertaler.translate(number);
                        System.out.println("De vertaling van "+ number + " is " + result);
                    }
                    else{
                        System.out.println(ongeldig);
                    }
                } catch(NumberFormatException e){
                    System.out.println(ongeldig);
                }
            }
            else{
                System.out.println(ongeldig);
            }
        }

    }
}
