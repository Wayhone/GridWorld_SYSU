import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    // turnArray defines the turns that every time a bug should make 
    // sideLength defines the total steps that a bug should move on a side 
    private int[] turnArray;
    private int step;

    // Constructor
    public DancingBug(int turns[])
    {
        turnArray = new int[turns.length];
        System.arraycopy(turns, 0, turnArray, 0, turns.length);
        step = 0;
    }

    // define what a bug should act 
    public void act()
    {
        if (step == turnArray.length)
        {
            step = 0;
        }
        
        // Make turns
        for (int i = 0; i < turnArray[step]; i++)
        {
            turn();
        }
        
        step++;

        // After making turn, move forward
        if (canMove()) 
        {
            move();
        }
        else
        {
            turn();
        }
    }
}
