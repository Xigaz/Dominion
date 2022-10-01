package dominion;

public class Player
{
    private Deck deck;
    private String name;
    private Game g;

    public Player(String n, Game g)
    {
        name = n;
        deck = new Deck();
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
