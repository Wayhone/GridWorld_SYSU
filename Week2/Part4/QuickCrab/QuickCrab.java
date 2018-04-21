import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;
import java.awt.Color;

/*
  The implementation of this class is testable on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter
{
    /*
    A QuickCrab processes actors the same way a CrabCritter does. 
    A QuickCrab moves to one of the two locations randomly, that are two spaces to its right or left, 
    if that location and the intervening location are both empty. 
    Otherwise, a QuickCrab moves like a CrabCritter.
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        
        addLocs(locs, getDirection() + Location.LEFT);
        addLocs(locs, getDirection() + Location.RIGHT);

        if (locs.size() == 0) 
        {
            return super.getMoveLocations();
        }
        else
        {
            return locs;
        }        
    }

    private void addLocs(ArrayList<Location> loc, int dir)
    {
        Grid grid = getGrid();

        Location next = getLocation().getAdjacentLocation(dir);
        if (grid.isValid(next) && grid.get(next) == null)
        {
            Location next2 = next.getAdjacentLocation(dir);
            if (grid.isValid(next2) && grid.get(next2) == null)
                loc.add(next2);
        }
    }

}
