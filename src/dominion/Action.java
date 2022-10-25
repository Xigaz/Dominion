package dominion;

public class Action extends Card
{
    private ActionCards card;

    public Action(String n, int c)
    {
        super(n, ActionCards.valueOf(n).cost);
        card = ActionCards.valueOf(n);
    }

    public Action(ActionCards c)
    {
        super(c.displayName, c.cost);
        card = c;
    }

    @Override
    public CardEffects play()
    {
        CardEffects c = new CardEffects(card.cards, card.actions, card.buys, card.money);
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
        return 0;
    }
    @Override
    public String toString()
    {
        return card.toString();
    }
}
