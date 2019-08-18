public class Poker {
    private Integer number;
    private char color;

    public Poker(Integer number, char color) {
        this.number = number;
        this.color = color;
    }

    public Poker(String card) {
        this.color = card.charAt(1);
        this.number = (int) card.charAt(0);
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
