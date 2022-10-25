package dominion;

import java.util.ArrayList;

public class Player
{
    private Deck deck;
    private String name;
    private Board theBoard;
    private ArrayList<Card> hand, playedCards;
    private int cards, actions = 1, buys = 1, coins;


    public Player(String n, Board b)
    {
        name = n;
        deck = new Deck();
        hand = new ArrayList<>();
        playedCards = new ArrayList<>();
        theBoard = b;

        for(int i = 0; i < 5; i++)
        {
            hand.add(deck.draw());
        }
        hand.add(new Action(ActionCards.SMITHY));

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
            sb.append((i+1) + ") " + hand.get(i) + (hand.get(i).getCardType() instanceof ActionCards ? " (Action)" : "") + "\n");
        }
        return sb.toString();
    }

    public void play(int slot)
    {
        slot--;
        actions--;
        Card myCard = hand.remove(slot);
        CardEffects playing = myCard.play();
        actions += playing.getActions();
        buys += playing.getBuys();
        cards += playing.getCards();
        coins += playing.getCoins();

        for(; cards > 0; cards--)
            hand.add(deck.draw());

        playedCards.add(myCard);


    }

    public void endTurn()
    {
        deck.discard(playedCards);
        playedCards.clear();
        deck.discard(hand);
        hand.clear();
        actions = 1;
        buys = 1;
        coins = 0;
        cards = 0;

        for(int i = 0; i < 5; i++)
        {
            hand.add(deck.draw());
        }
    }

    public boolean buy(int slot)
    {
        Card newCard = theBoard.store.get(slot-1).buy();
        if(newCard != null)
        {
            coins -= newCard.getCardType().getCost();
            buys--;
            deck.discard(newCard);
        }
        else
            return false;

        //System.out.println("New Card: " + newCard);
        return true;
    }
    @Override
    public String toString()
    {
        return name;
    }

    public boolean hasActionCards()
    {
        return hand.stream().anyMatch(e -> e.getCardType() instanceof ActionCards);
    }

    public int getActions()
    {
        return actions;
    }

    public void playMoney()
    {
        for(int i = 0; i < hand.size(); i++)
        {
            Card cCard = hand.get(i);
            if(cCard instanceof Treasure)
            {
                coins += cCard.play().getCoins();
                playedCards.add(hand.remove(i));
                i--;
            }
        }
    }

    public int getCoins()
    {
        return coins;
    }

    public int getBuys()
    {
        return buys;
    }

    public int getVPs()
    {
        deck.discard(hand);
        deck.discard(playedCards);
        hand.clear();
        playedCards.clear();
        return deck.getVPs();
    }

}
