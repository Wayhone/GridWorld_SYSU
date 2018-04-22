import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

/*
  The implementation of this class is testable on the AP CS A and AB exams.
 */
public class KingCrab extends CrabCritter
{
    /*
    A KingCrab causes each actor that it processes to move one location further away from the KingCrab. 
    If the actor cannot move away, the KingCrab removes it from the grid. 
    When the KingCrab has completed processing the actors, it moves like a CrabCritter.
     */
    public void processActors(ArrayList<Actor> actors){
        for (Actor other : actors)
        {
            if (!canMoveOneLocation(other))
            {
                other.removeSelfFromGrid();
            }
        }
    }

    public boolean canMoveOneLocation(Actor it){
        Location kings = getLocation();
        Location loc = it.getLocation();
        int dir = loc.getDirectionToward(kings) + Location.HALF_CIRCLE;
        Location next = loc.getAdjacentLocation(dir);

        Grid<Actor> gr = getGrid();
        if (gr.isValid(next))
        {
            it.moveTo(next);
            return true;        
        }
        else
        {
            it.removeSelfFromGrid();
            return false;
        }

    }

}
