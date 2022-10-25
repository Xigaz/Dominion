package dominion;

public enum TreasureCards implements CardType
{
    COPPER("Copper", 1, 0, 60),
    SILVER("Silver", 2, 3, 40),
    GOLD("Gold", 3, 6, 30);
    final String displayName;
    final int value, cost, pileSize;

    TreasureCards(String d, int v, int c, int noCards)
    {
        displayName = d;
        value = v;
        cost = c;
        pileSize = noCards;
    }

    public int getCost()
    {
        return cost;
    }
    @Override
    public String toString()
    {
        return displayName;
    }

}
