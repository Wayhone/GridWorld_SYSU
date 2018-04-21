import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int direction;
    // direction: 0 for right, 1 for left-down, 2 for left, 3 for stop;

    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        direction = 0;
        setDirection(Location.EAST);
    }

    public void act()
    {
        if (direction == 3) return;

        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
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
