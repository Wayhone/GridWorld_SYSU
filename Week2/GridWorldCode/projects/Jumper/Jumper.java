//package info.gridworld.actor;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Bug;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Jumper extends Actor
{

    public Jumper()
    {
        setColor(Color.BLUE);
    }

    public Jumper(Color JumperColor)
    {
        setColor(JumperColor);
    }

    public void act()
    {
        if (canJump())
            jump();
        else
            turn();
    }

    public void turn()
    {
        setDirection(getDirection() + Location.RIGHT);
    }

    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location nextJump = next.getAdjacentLocation(getDirection());
        if (gr.isValid(nextJump))
        {
            if ((gr.get(nextJump) instanceof Bug) || (gr.get(nextJump) instanceof Jumper))
                gr.get(nextJump).removeSelfFromGrid();
            moveTo(nextJump);
        }
        else
            removeSelfFromGrid();
    }


    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location nextJump = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(nextJump))
            return false;
        Actor neighbor = gr.get(nextJump);
        return (neighbor == null) || (neighbor instanceof Flower) || (neighbor instanceof Bug) || (neighbor instanceof Jumper);
        // ok to jump into empty location or onto flower
        // not ok to jump onto any other actor
    }
}
