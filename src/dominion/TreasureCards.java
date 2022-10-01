package dominion;

public enum TreasureCards
{
    COPPER("Copper", 1, 0),
    SILVER("Silver", 2, 3),
    GOLD("Gold", 3, 6);
    final String displayName;
    final int value, cost;

    TreasureCards(String d, int v, int c)
    {
        displayName = d;
        value = v;
        cost = c;
    }

    @Override
    public String toString()
    {
        return displayName;
    }

}
