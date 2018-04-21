import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    private int[] turnArray;
    private int step;

    public DancingBug(int turns[])
    {
        turnArray = turns;
        step = 0;
    }

    public void act()
    {
        if (step == turnArray.length)
            step = 0;
        
        for (int i = 0; i < turnArray[step]; i++)
            turn();
        
        step++;

        if (canMove()) 
            move();
        else
            turn();
    }
}
