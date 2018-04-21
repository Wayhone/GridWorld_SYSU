import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

import java.util.ArrayList;

/*
  The implementation of this class is testable on the AP CS A and AB exams.
 */
public class RockHound extends Critter
{
    /*
    A RockHound gets the actors to be processed in the same way as a Critter. 
    It removes any rocks in that list from the grid. 
    A RockHound moves like a Critter.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor it: actors)
        {
            if (it instanceof Rock)
            {
                it.removeSelfFromGrid();
            }
        }
    }

}
