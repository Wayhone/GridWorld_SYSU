import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Bug;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Jumper extends Actor
{
    // Constructor
    public Jumper()
    {
        setColor(Color.BLUE);
    }

    // Constructor with initial color
    public Jumper(Color jumperColor)
    {
        setColor(jumperColor);
    }

    // Define what a jumper would do
    public void act()
    {
        if (canJump())
        {
            jump();
        }
        else
        {
            turn();
        }
    }

    // Turn act
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    // Jump act
    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
        {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location nextJump = next.getAdjacentLocation(getDirection());
        // if jump to a valid loaction then jump
        if (gr.isValid(nextJump))
        {
            if ((gr.get(nextJump) instanceof Bug) || (gr.get(nextJump) instanceof Jumper))
            {
                gr.get(nextJump).removeSelfFromGrid();
            }
            moveTo(nextJump);
        }
        // else remove itself
        else
        {
            removeSelfFromGrid();
        }
    }

    // To check whether the jumper can jump to a valid location
    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
        {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location nextJump = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(nextJump))
        {
            return false;
        }
        Actor neighbor = gr.get(nextJump);
        return (neighbor == null) || (neighbor instanceof Flower) || (neighbor instanceof Bug) || (neighbor instanceof Jumper);
        // ok to jump into empty location or onto flower
        // not ok to jump onto any other actor
    }
}
