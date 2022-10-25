package dominion;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> deck, discard;

    public Deck()
    {
        deck = new ArrayList<>();
        discard = new ArrayList<>();

        for(int i = 0; i < 7; i++ )
        {
            deck.add(new Treasure("COPPER"));
        }

        for(int i = 0; i < 3; i++ )
        {
            deck.add(new Victory("ESTATE"));
        }

        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);

    }

    /**
     * Add an ArrayList of Cards to the discard pile.
     * @param d - ArrayList of Cards to discard
     */
    public void discard(ArrayList<Card> d)
    {
        discard.addAll(d);
    }

    /**
     * Add a Card to the discard pile
     * @param d - Card to be added to the discard pile
     */
    public void discard(Card d)
    {
        discard.add(d);
    }


    public Card draw()
    {
        if (deck.size() == 0)
        {
            deck.addAll(discard);
            discard.clear();

            Collections.shuffle(deck);
            Collections.shuffle(deck);
            Collections.shuffle(deck);
            Collections.shuffle(deck);
            Collections.shuffle(deck);
            Collections.shuffle(deck);
            Collections.shuffle(deck);
        }

        return deck.size() > 0 ? deck.remove(0) : null;

    }

    private void combine()
    {
        deck.addAll(discard);
        discard.clear();
    }

    public int getVPs()
    {
        int points = 0;
        combine();
        for(Card c : deck)
        {
            points += c.getVP();
        }
        return points;
    }
}
