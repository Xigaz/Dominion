package dominion;

public class Treasure extends Card
{
    private TreasureCards card;


    public Treasure(String n)
    {
        super(n, TreasureCards.valueOf(n).cost);
        card = TreasureCards.valueOf(n);
    }
    public Treasure(TreasureCards c)
    {
        super(c.displayName, c.cost);
        card = c;
    }
    @Override
    public CardEffects play()
    {
        CardEffects c = new CardEffects();
        c.setCoins(card.value);
        return c;
    }
    @Override
    public CardType getCardType()
    {
        return card;
    }
    public int getVP()
    {
        return 0;
    }
    @Override
    public String toString()
    {
        return card.toString();
    }
}
