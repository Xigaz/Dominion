package dominion;

import java.util.ArrayList;
import java.util.Collections;

public class Game
{
    private ArrayList<Player> players;
    private Player currentPlayer;
    private final Board myBoard;
    private boolean gameOver = false;

    public Game(String n)
    {
        players = new ArrayList<>();

        myBoard = new Board(ActionCards.values(), 4);

        players.add(new Player(n, myBoard));
        players.add(new Player("Luke", myBoard));
        players.add(new Player("Obi-wan", myBoard));
        players.add(new Player("Yoda", myBoard));
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);

    }

    public void play()
    {
        currentPlayer = players.get(0);

        while(!gameOver)
        {
            System.out.println(printStore());

            System.out.println(currentPlayer.getHand());

            if(myBoard.getIsGameOver())
                gameOver = true;
            break;
        }
    }

    public String printStore()
    {
        return myBoard.toString();
    }
}
