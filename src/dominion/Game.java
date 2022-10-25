package dominion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Game
{
    private ArrayList<Player> players;
    private Player currentPlayer;
    private final Board myBoard;
    private boolean gameOver = false;
    private Scanner input;

    public Game(String n)
    {
        players = new ArrayList<>();
        input = new Scanner(System.in);
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

    public void play() throws InterruptedException
    {
        currentPlayer = players.get(0);

        while(!gameOver)
        {
            System.out.println("ROUND BEGIN!");
            System.out.println("YOUR HAND:");
            System.out.println(currentPlayer.getHand() + "\n");
            System.out.println("\n\nACTION PHASE!\n");
            Thread.sleep(1000);

            while(currentPlayer.hasActionCards() && currentPlayer.getActions() > 0)
            {
                System.out.println(currentPlayer.getHand());
                System.out.print("Play a Card (0 to Proceed to Buy) (" + currentPlayer.getActions() + " Actions) > ");
                int played = input.nextInt();
                if(played == 0)
                    break;
                currentPlayer.play(played);
            }
            if (currentPlayer.getActions() == 0)
            {
                System.out.println("NO MORE ACTIONS!!");
                Thread.sleep(1000);
            }

            System.out.println("YOUR HAND:");
            System.out.println(currentPlayer.getHand() + "\n");
            currentPlayer.playMoney();
            System.out.printf("BUY PHASE!\n\nYou have %d money! and %d Buys!\n\n", currentPlayer.getCoins(), currentPlayer.getBuys());
            Thread.sleep(1000);

            for(int i = currentPlayer.getBuys(); i > 0 && currentPlayer.getCoins() > 0; i--)
            {
                System.out.println("Market:");
                System.out.println(printStore());
                System.out.print("Buy a Card (0 to End Your Turn) $" + currentPlayer.getCoins() + " > ");
                int purchase = input.nextInt();
                if(purchase == 0)
                    break;
                else if(myBoard.store.get(purchase-1).getMyCard().getCost() <= currentPlayer.getCoins())
                {
                    if (!currentPlayer.buy(purchase)) System.out.println("No " + myBoard.store.get(purchase-1).getMyCard() + " Left!");

                }
                else
                {
                    System.out.println("\nThat's Too Expensive! Try Again!");
                    i++;
                }


            }

            currentPlayer.endTurn();

            if(myBoard.getIsGameOver())
                gameOver = true;
        }
        System.out.println("HEY!!! THE GAME IS OVER! " + players.stream().max(Comparator.comparingInt(Player::getVPs)).get()
                + " is the WINNER!!!");
    }

    public String printStore()
    {
        return myBoard.toString();
    }
}
