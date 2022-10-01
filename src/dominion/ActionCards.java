package dominion;

public enum ActionCards
{
    SMITHY("Smithy", 3, 0, 0, 0, 0),
    CELLER("Celler", 0, 1, 0, 0, 3),
    VILLAGE("Village", 1, 2, 0, 0, 6);
    final String displayName;
    final int cards, actions, buys, money, cost;

    ActionCards(String d, int ca, int a, int b, int m, int c)
    {
        displayName = d;
        cards = ca;
        actions = a;
        buys = b;
        money = m;
        cost = c;
    }

    @Override
    public String toString()
    {
        return displayName;
    }
}
