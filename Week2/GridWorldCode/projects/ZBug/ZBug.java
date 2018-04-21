import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug
{
    // steps defines the current steps that a bug has moved on a side
    // sideLength defines the total steps that a bug should move on a side 
    // direction: 0 for right, 1 for left-down, 2 for left, 3 for stop
    private int steps;
    private int sideLength;
    private int direction;

    // Constructor, the ZBug first turn to the east.
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        direction = 0;
        setDirection(Location.EAST);
    }

    // define what a bug should act 
    public void act()
    {
        // direciton = 3 means that the Z move has ended.
        if (direction == 3) 
         {
            return;
         }   

        // if a bug doesn't finish its path on a side and it can move forward, then move
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            // Or else it changes its direction to complete the Z move.
            direction++;
            steps = 0;
            switch (direction)
            {
                case 1:
                    setDirection(Location.SOUTHWEST);
                    break;
                case 2:
                    setDirection(Location.EAST);
                default:
                    break;
            }
        }
    }
}
