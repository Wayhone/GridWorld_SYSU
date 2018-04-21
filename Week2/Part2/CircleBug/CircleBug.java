import info.gridworld.actor.Bug;

public final class CircleBug extends Bug
{
    // steps defines the current steps that a bug has moved on a side
    // sideLength defines the total steps that a bug should move on a side 
    private int steps;
    private int sideLength;

    // Constructor
    public CircleBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    // define what a bug should act 
    public void act()
    {
        // if a bug doesn't finish its path on a side and it can move forward, then move
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            // Or it should turn.
            turn();
            steps = 0;
        }
    }
}
