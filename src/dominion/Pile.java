package dominion;

import java.util.ArrayList;

public class Pile
{
    private ArrayList<Card> cards;
    private CardType myCard;

    public Pile(String c, int numOfPlayers)
    {
        cards = new ArrayList<>();
        try
        {
            createPile(TreasureCards.valueOf(c), numOfPlayers);
            return;
        }catch(IllegalArgumentException ignored)
        {}

        try
        {
            createPile(VictoryCards.valueOf(c), numOfPlayers);
            return;
        }catch(IllegalArgumentException ignored)
        {}

        try
        {
            createPile(ActionCards.valueOf(c));
        }catch(IllegalArgumentException ignored)
        {}

    }
    public Pile(VictoryCards vc, int nop)
    {
        cards = new ArrayList<>();
        createPile(vc, nop);
    }

    public Pile(TreasureCards tc, int nop)
    {
        cards = new ArrayList<>();
        createPile(tc, nop);
    }

    public Pile(ActionCards ac, int nop)
    {
        cards = new ArrayList<>();
        createPile(ac);
    }

    private void createPile(TreasureCards c, int nop)
    {

        for(int i = 0; i < c.pileSize; i++)
            cards.add(new Treasure(c));
        myCard = c;
    }

    private void createPile(VictoryCards c, int nop)
    {
        for(int i = 0; i < c.getNumberOfCards(nop); i++)
            cards.add(new Victory(c));
        myCard = c;
    }

    private void createPile(ActionCards c)
    {
        for(int i = 0; i < 10; i++)
            cards.add(new Action(c));
        myCard = c;
    }

    public int getCardsLeft()
    {
        return cards.size();
    }
    public CardType getMyCard()
    {
        return myCard;
    }


    @Override
    public String toString()
    {
        return myCard.toString() + " (" + cards.size() + ")";
    }
}
