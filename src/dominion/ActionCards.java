package dominion;

public enum ActionCards implements CardType
{
    SMITHY("Smithy", 3, 0, 0, 0, 4),
    CELLER("Celler", 0, 1, 0, 0, 2),
    VILLAGE("Village", 1, 2, 0, 0, 3),
    FESTIVAL("Festival", 0, 2, 1, 2, 5),
    MARKET("Market", 1, 1, 1, 1, 5),
    LABORATORY("Laboratory", 1, 1, 0, 0, 5),
    POACHER("Poacher", 1, 1, 0, 1, 4),
    MERCHANT("Merchant", 1, 1, 0, 0, 3),
    MOAT("Moat", 2, 0, 0, 0, 2),
    COVEN("Coven", 0, 1, 0, 2, 5);
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
