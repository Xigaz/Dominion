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

    public boolean getIsGameOver()
    {
        return store.stream().filter(e -> e.getMyCard() == VictoryCards.PROVINCE).filter(e -> e.getCardsLeft() == 0).count() == 1 || store.stream().filter(e -> !(e.getMyCard() instanceof TreasureCards)).filter(e -> e.getCardsLeft() == 0).count() >= 3;
    }

    @Override
    public String toString()
    {
        String returnValue = "";
        CardType types = ActionCards.CELLER;

        for(int i = 0; i < store.size(); i++)
        {
            if(store.get(i).getMyCard() instanceof VictoryCards && !(types instanceof VictoryCards))
            {
                types = VictoryCards.ESTATE;
                returnValue += "\nVictory Cards:\n";
            }
            else if(store.get(i).getMyCard() instanceof TreasureCards && !(types instanceof TreasureCards))
            {
                types = TreasureCards.COPPER;
                returnValue += "\nTresure Cards:\n";
            }
            else if(store.get(i).getMyCard() instanceof ActionCards && !(types instanceof ActionCards))
            {
                types = ActionCards.CELLER;
                returnValue += "\nActions Cards:\n";
            }

            returnValue += i + ") " + store.get(i).toString() + "\n";
        }
        return returnValue;
    }

}
