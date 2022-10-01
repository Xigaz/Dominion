package dominion;

public class Victory extends Card
{
    private VictoryCards card;

    public Victory(String n)
    {
        super(n, VictoryCards.valueOf(n).cost);
        card = VictoryCards.valueOf(n);
    }

    @Override
    public CardEffects play()
    {
        CardEffects c = new CardEffects();
        return c;
    }

    @Override
    public int getVP()
    {
        return card.victoryPoints;
    }
}
