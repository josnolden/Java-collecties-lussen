import java.util.HashMap;

public class Translator {
    HashMap<Integer, String> numericAlpha = new HashMap<>();

    public Translator(String[] alphabetic, int[] numeric){
        for(int i = 0; i < alphabetic.length; i++){
            numericAlpha.put(numeric[i], alphabetic[i]);
        }
    }

    public String translate(int number){
        return numericAlpha.get(number);
    }
}
