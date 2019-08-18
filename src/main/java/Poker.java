import java.util.HashMap;
import java.util.Map;

public class Poker {
    private Integer number;
    private char color;

    public Poker(Integer number, char color) {
        this.number = number;
        this.color = color;
    }

    public Poker(String card) {
        this.color = card.charAt(1);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('T', 10);
        map.put('J', 11);
        map.put('Q', 12);
        map.put('K', 13);
        map.put('A', 14);
        char number = card.charAt(0);
        if (map.containsKey(number)) {
            this.number = map.get(number);
        } else {
            this.number = (int) number - 48;
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
}
