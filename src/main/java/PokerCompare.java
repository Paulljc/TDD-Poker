import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.sort;

public class PokerCompare {

    public static final String PLAYER1_WIN = "Player1 win";
    public static final String PLAYER2_WIN = "Player2 win";
    public static final String A_DRAW = "A draw";

    public String compareCard(List<Poker> player1, List<Poker> player2) {
        List<Integer> player1Number = sortNumber(player1);
        List<Integer> player2Number = sortNumber(player2);

        Map<Integer, Integer> player1PairAmount = calcPairAmount(player1Number);
        Map<Integer, Integer> player2PairAmount = calcPairAmount(player2Number);



        if (player1PairAmount.size() > player2PairAmount.size()) {
            return PLAYER1_WIN;
        }
        if (player1PairAmount.size() < player2PairAmount.size()) {
            return PLAYER2_WIN;
        }
        if (player1PairAmount.size() == player2PairAmount.size()) {
            if (comparePairMaxNumber(player1PairAmount, player2PairAmount)) {
                return PLAYER1_WIN;
            }else{
                return PLAYER2_WIN;
            }
        }

        int player1MaxNumber = getMaxNumber(player1);
        int player2MaxNumber = getMaxNumber(player2);
        if (player1MaxNumber > player2MaxNumber) {
            return PLAYER1_WIN;
        } else if (player1MaxNumber < player2MaxNumber) {
            return PLAYER2_WIN;
        } else {
            return A_DRAW;
        }
    }

    private boolean comparePairMaxNumber(Map<Integer, Integer> player1PairAmount, Map<Integer, Integer> player2PairAmount) {
        int p1PairMax = (new ArrayList<Integer>(player1PairAmount.keySet())).stream().mapToInt(num -> num).max().getAsInt();
        int p2PairMax = (new ArrayList<Integer>(player2PairAmount.keySet())).stream().mapToInt(num -> num).max().getAsInt();
        if (p1PairMax > p2PairMax) {
            return true;
        } else {
            return false;
        }
    }

    private Map<Integer, Integer> calcPairAmount(List<Integer> playerNumber) {
        Set<Integer> distinctNumber = new HashSet<>(playerNumber);
        Map<Integer, Integer> playerPair = new HashMap();
        for (Integer number : distinctNumber) {
            int amount = Collections.frequency(playerNumber, number);
            if (amount > 1) {
                playerPair.put(number, amount);
            }
        }
        return playerPair;
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
