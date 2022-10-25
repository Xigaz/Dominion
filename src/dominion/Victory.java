package dominion;

public class Victory extends Card
{
    private VictoryCards card;

    public Victory(String n)
    {
        super(n, VictoryCards.valueOf(n).cost);
        card = VictoryCards.valueOf(n);
    }

    public Victory(VictoryCards c)
    {
        super(c.displayName, c.cost);
        card = c;
    }

    @Override
    public CardEffects play()
    {
        CardEffects c = new CardEffects();
        return c;
    }

    @Override
    public CardType getCardType()
    {
        return card;
    }

    @Override
    public int getVP()
    {
        return card.victoryPoints;
    }
    @Override
    public String toString()
    {
        return card.toString();
    }
}
