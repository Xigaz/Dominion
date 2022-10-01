package dominion;

public class CardEffects
{
    private int cards, actions, buys, coins;

    public CardEffects(int ca, int a, int b, int co)
    {
        cards = ca;
        actions = a;
        buys = b;
        coins = co;
    }

    public CardEffects()
    {}

    public void setCards(int cards)
    {
        this.cards = cards;
    }

    public void setActions(int actions)
    {
        this.actions = actions;
    }

    public void setBuys(int buys)
    {
        this.buys = buys;
    }

    public void setCoins(int coins)
    {
        this.coins = coins;
    }

    public int getCards()
    {
        return cards;
    }

    public int getActions()
    {
        return actions;
    }

    public int getBuys()
    {
        return buys;
    }

    public int getCoins()
    {
        return coins;
    }
}
