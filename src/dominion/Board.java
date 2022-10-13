package dominion;

import java.util.ArrayList;

public class Board
{
    ArrayList<Pile> store;
    public Board(ActionCards[] ac, int nop)
    {
        store = new ArrayList<>();

        createVsAndTs(nop);

        //Actions
        for(ActionCards c : ac)
        {
            store.add(new Pile(c, nop));
        }

    }

    public Board(String[] ac, int nop)
    {
        store = new ArrayList<>();

        createVsAndTs(nop);

        //Actions
        for(String c : ac)
        {
            store.add(new Pile(c, nop));
        }

    }

    private void createVsAndTs(int nop)
    {
        //Victory Points
        store.add(new Pile(VictoryCards.ESTATE, nop));
        store.add(new Pile(VictoryCards.DUCHY, nop));
        store.add(new Pile(VictoryCards.PROVINCE, nop));
        store.add(new Pile(VictoryCards.CURSE, nop));


        //Treasure Cards
        store.add(new Pile(TreasureCards.COPPER, nop));
        store.add(new Pile(TreasureCards.SILVER, nop));
        store.add(new Pile(TreasureCards.GOLD, nop));
    }

    @Override
    public String toString()
    {
        String returnValue = "";
        for(int i = 0; i < store.size(); i++)
        {
            returnValue += i + ") " + store.get(i).toString() + "\n";
        }
        return returnValue;
    }

}
