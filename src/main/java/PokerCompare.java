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

        Set<Character> player1Color = calcColor(player1);
        Set<Character> player2Color = calcColor(player2);

        if(player1Color.size() == 1 || player2Color.size() == 1){
            if (player1Color.size() == 1 && player2Color.size() != 1) {
                return PLAYER1_WIN;
            } else if (player1Color.size() != 1 && player2Color.size() == 1) {
                return PLAYER2_WIN;
            } else {

            }
        }

        boolean player1IsStraight = calcStraight(player1Number, player1PairAmount);
        boolean player2IsStraight = calcStraight(player2Number, player2PairAmount);
        if (player1IsStraight || player2IsStraight) {
            if (player1IsStraight && !player2IsStraight) {
                return PLAYER1_WIN;
            } else if (!player1IsStraight && player2IsStraight) {
                return PLAYER2_WIN;
            } else {

            }
        }

        if (player1PairAmount.size() > 0 && player2PairAmount.size() > 0) {
            String threeSameCard = calcThreeSameCard(player1PairAmount, player2PairAmount);
            if (threeSameCard == "p1") {
                return PLAYER1_WIN;
            } else if (threeSameCard == "p2") {
                return PLAYER2_WIN;
            } else {

            }
        }

        if (player1PairAmount.size() > player2PairAmount.size()) {
            return PLAYER1_WIN;
        }
        if (player1PairAmount.size() < player2PairAmount.size()) {
            return PLAYER2_WIN;
        }
        if (player1PairAmount.size() > 0 && player2PairAmount.size() > 0 && player1PairAmount.size() == player2PairAmount.size()) {
            String pairMax = comparePairMaxNumber(player1PairAmount, player2PairAmount);
            if (pairMax == "p1") {
                return PLAYER1_WIN;
            } else if (pairMax == "p2") {
                return PLAYER2_WIN;
            } else {

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

    private Set<Character> calcColor(List<Poker> player) {
        return player.stream().map(Poker::getColor).collect(Collectors.toSet());
    }

    private boolean calcStraight(List<Integer> playerNumber, Map<Integer, Integer> playerPairAmount) {
        if (Collections.max(playerNumber) - Collections.min(playerNumber) == 4 && playerPairAmount.size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    private String calcThreeSameCard(Map<Integer, Integer> player1PairAmount, Map<Integer, Integer> player2PairAmount) {
        int p1ThreeMax = (new ArrayList<Integer>(player1PairAmount.keySet())).stream().mapToInt(num -> num).max().getAsInt();
        int p2ThreeMax = (new ArrayList<Integer>(player2PairAmount.keySet())).stream().mapToInt(num -> num).max().getAsInt();
        if (player1PairAmount.get(p1ThreeMax) > player2PairAmount.get(p2ThreeMax)) {
            return "p1";
        } else if (player1PairAmount.get(p1ThreeMax) < player2PairAmount.get(p2ThreeMax)) {
            return "p2";
        } else {
            return "same";
        }
    }

    private String comparePairMaxNumber(Map<Integer, Integer> player1PairAmount, Map<Integer, Integer> player2PairAmount) {
        int p1PairMax = (new ArrayList<Integer>(player1PairAmount.keySet())).stream().mapToInt(num -> num).max().getAsInt();
        int p2PairMax = (new ArrayList<Integer>(player2PairAmount.keySet())).stream().mapToInt(num -> num).max().getAsInt();
        if (p1PairMax > p2PairMax) {
            return "p1";
        } else if (p1PairMax < p2PairMax) {
            return "p2";
        } else {
            return "same";
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
