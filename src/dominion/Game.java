package dominion;

import java.util.ArrayList;

public class Game
{
    private ArrayList<Player> players;
    private Player currentPlayer;
    private final Board myBoard;

    public Game(String n)
    {
        players = new ArrayList<>();

        myBoard = new Board(ActionCards.values(), 4);

        players.add(new Player(n, myBoard));
        players.add(new Player("Luke", myBoard));
        players.add(new Player("Obi-wan", myBoard));
        players.add(new Player("Yoda", myBoard));

    }

    public String printStore()
    {
        return "";
    }
}
