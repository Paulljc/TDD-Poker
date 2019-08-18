import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.Collections.sort;

public class PokerCompare {

    public static final String PLAYER1_WIN = "Player1 win";
    public static final String PLAYER2_WIN = "Player2 win";
    public static final String A_DRAW = "A draw";

    public String compareCard(List<Poker> player1, List<Poker> player2) {
        List<Integer> player1Number = sortNumber(player1);
        List<Integer> player2Number = sortNumber(player2);



        int player1MaxNumber = getMaxNumber(player1);
        int player2MaxNumber = getMaxNumber(player2);
        if(player1MaxNumber > player2MaxNumber){
            return PLAYER1_WIN;
        }else if (player1MaxNumber < player2MaxNumber){
            return PLAYER2_WIN;
        }else {
            return A_DRAW;
        }
    }

    private static List<Integer> sortNumber(List<Poker> list) {
        List<Integer> numList = list.stream().map(Poker::getNumber).collect(Collectors.toList());
        sort(numList);
        return numList;
    }
    private static int getMaxNumber(List<Poker> list) {
        return list.stream().mapToInt(Poker::getNumber).max().getAsInt();
    }
}
