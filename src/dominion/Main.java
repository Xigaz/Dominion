package dominion;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
//        CardType t = VictoryCards.PROVINCE;
//
//        if(t == VictoryCards.PROVINCE)
//            System.out.println("Yes!");
//        else System.out.println("NO!");

        Game g = new Game("Bryce");
        g.play();
    }
}