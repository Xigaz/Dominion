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
            deck.add(new Treasure("Copper"));
        }

        for(int i = 0; i < 3; i++ )
        {
            deck.add(new Victory("Estate"));
        }

        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);

    }

    public void discard(ArrayList<Card> d)
    {
        discard.addAll(d);
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

        return deck.size() > 0 ? deck.get(0) : null;

    }
}
