package dominion;

public enum VictoryCards
{
    ESTATE("Estate", 1, 2),
    DUCHY("Duchy", 3, 5),
    PROVINCE("Province", 6, 8);
    final String displayName;
    final int victoryPoints, cost;

    VictoryCards(String d, int vp, int c)
    {
        displayName = d;
        victoryPoints = vp;
        cost = c;
    }

    @Override
    public String toString()
    {
        return displayName;
    }
}
