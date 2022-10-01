package dominion;

public class Treasure extends Card
{
    private TreasureCards card;


    public Treasure(String n)
    {
        super(n, TreasureCards.valueOf(n).cost);
        card = TreasureCards.valueOf(n);
    }

    @Override
    public CardEffects play()
    {
        CardEffects c = new CardEffects();
        c.setCoins(card.value);
        return c;
    }

    public int getVP()
    {
        return 0;
    }
}
