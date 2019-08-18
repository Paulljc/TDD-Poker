import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerTest {

    @Test
    public void should_return_player2_win_when_give_two_high_list() {
        //given
        List player1 = Arrays.asList(new Poker("4s"), new Poker("3d"), new Poker("5s"), new Poker("6d"), new Poker("8s"));
        List player2 = Arrays.asList(new Poker("4s"), new Poker("9d"), new Poker("8s"), new Poker("5d"), new Poker("3s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("Player2 win", result);
    }

    @Test
    public void should_return_A_draw_when_give_same_high_list() {
        //given
        List player1 = Arrays.asList(new Poker("2s"), new Poker("3d"), new Poker("5s"), new Poker("9d"), new Poker("7s"));
        List player2 = Arrays.asList(new Poker("4s"), new Poker("9d"), new Poker("8s"), new Poker("5d"), new Poker("3s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("A draw", result);
    }
}