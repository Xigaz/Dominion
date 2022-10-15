package dominion;

public enum VictoryCards implements CardType
{
    ESTATE("Estate", 1, 2, new int[] {8, 12, 12}),
    DUCHY("Duchy", 3, 5, new int[] {8, 12, 12}),
    PROVINCE("Province", 6, 8, new int[] {8, 12, 12}),
    CURSE("Curse", -1, 0, new int[] {10, 12, 12});
    final String displayName;
    final int victoryPoints, cost;
    final int[] cardsByPlayer;

    VictoryCards(String d, int vp, int c, int[] nopCards)
    {
        displayName = d;
        victoryPoints = vp;
        cost = c;
        cardsByPlayer = nopCards;
    }

    int getNumberOfCards(int players)
    {
        return cardsByPlayer[players-2];
    }

    @Override
    public String toString()
    {
        return displayName;
    }
}
