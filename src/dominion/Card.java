package dominion;

public abstract class Card
{
    private String name;
    private int cost;

    public Card(String n, int c)
    {
        name = n;
        cost = c;
    }

    public abstract CardEffects play();
    public abstract int getVP();

    public String getName()
    {
        return name;
    }

    public int getCost()
    {
        return cost;
    }
    @Override
    public String toString()
    {
        return name;
    }
}
