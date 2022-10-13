package dominion;

import java.util.ArrayList;

public class Player
{
    private Deck deck;
    private String name;
    private Board theBoard;
    private ArrayList<Card> hand;

    public Player(String n, Board b)
    {
        name = n;
        deck = new Deck();
        hand = new ArrayList<>();
        theBoard = b;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
