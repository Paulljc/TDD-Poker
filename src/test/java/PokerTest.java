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

    @Test
    public void should_return_player1_win_when_give_a_pair_and_a_high_card() {
        //given
        List player1 = Arrays.asList(new Poker("3s"), new Poker("3d"), new Poker("5s"), new Poker("6d"), new Poker("7s"));
        List player2 = Arrays.asList(new Poker("4s"), new Poker("9d"), new Poker("6s"), new Poker("5d"), new Poker("3s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("Player1 win", result);
    }

    @Test
    public void should_return_player2_win_when_both_have_a_pair_but_p2_pair_max_than_p1() {
        //given
        List player1 = Arrays.asList(new Poker("3s"), new Poker("3d"), new Poker("5s"), new Poker("6d"), new Poker("7s"));
        List player2 = Arrays.asList(new Poker("4s"), new Poker("4d"), new Poker("6s"), new Poker("5d"), new Poker("3s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("Player2 win", result);
    }

    @Test
    public void should_return_player1_win_when_compare_two_pair_with_a_pair() {
        //given
        List player1 = Arrays.asList(new Poker("3s"), new Poker("3d"), new Poker("4s"), new Poker("4d"), new Poker("7s"));
        List player2 = Arrays.asList(new Poker("4s"), new Poker("4d"), new Poker("6s"), new Poker("5d"), new Poker("3s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("Player1 win", result);
    }

    @Test
    public void should_return_palyer2_win_when_give_two_double_tow__pair_list_and_list1_is_high_than_list() {
        //given
        List player1 = Arrays.asList(new Poker("5s"), new Poker("5d"), new Poker("6s"), new Poker("6d"), new Poker("9s"));
        List player2 = Arrays.asList(new Poker("4s"), new Poker("4d"), new Poker("8s"), new Poker("8d"), new Poker("3s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("Player2 win", result);
    }

    @Test
    public void should_return_player1_win_when_give_two_same_pair_but_p1_single_card_high_than_p2() {
        //given
        List player1 = Arrays.asList(new Poker("4s"), new Poker("4d"), new Poker("6s"), new Poker("6d"), new Poker("8s"));
        List player2 = Arrays.asList(new Poker("4s"), new Poker("4d"), new Poker("6s"), new Poker("6d"), new Poker("7s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("Player1 win", result);
    }

    @Test
    public void should_return_A_draw_win_when_give_two_same_pair_and_same_single_card() {
        //given
        List player1 = Arrays.asList(new Poker("4s"), new Poker("4d"), new Poker("6s"), new Poker("6d"), new Poker("7s"));
        List player2 = Arrays.asList(new Poker("4s"), new Poker("4d"), new Poker("6s"), new Poker("6d"), new Poker("7s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("A draw", result);
    }

    @Test
    public void should_return_player1_win_when_give_a_three_same_card_and_two_pair() {
        //given
        List player1 = Arrays.asList(new Poker("4s"),
                new Poker("4d"), new Poker("4c"), new Poker("6d"), new Poker("7d"));
        List player2 = Arrays.asList(new Poker("3s"),
                new Poker("3d"), new Poker("6s"), new Poker("6d"), new Poker("7s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("Player1 win", result);
    }

    @Test
    public void should_return_player1_win_when_give_two_same_three_card() {
        //given
        List player1 = Arrays.asList(new Poker("4s"),
                new Poker("4d"), new Poker("4c"), new Poker("6d"), new Poker("7d"));
        List player2 = Arrays.asList(new Poker("3s"),
                new Poker("3d"), new Poker("3s"), new Poker("6d"), new Poker("7s"));
        PokerCompare pokerCompare = new PokerCompare();
        //when
        String result = pokerCompare.compareCard(player1, player2);
        //then
        Assert.assertEquals("Player1 win", result);
    }
}
