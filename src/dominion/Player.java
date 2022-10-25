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

        for(int i = 0; i < 5; i++)
        {
            hand.add(deck.draw());
        }

    }

    public String getName()
    {
        return name;
    }

    public String getHand()
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < hand.size(); i++)
        {
            sb.append((i+1) + ") " + hand.get(i) + "\n");
        }
        sb.append("Play a Card> ");
        return sb.toString();
    }

    @Override
    public String toString()
    {
        return name;
    }
}
