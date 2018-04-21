import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

/*
  The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
    /*
    A BlusterCritter looks at all of the neighbors within two steps of its current location. 
    It counts the number of critters in those locations. 
    If there are fewer than c critters, the BlusterCritter’s color gets brighter (color values increase). 
    If there are c or more critters, the BlusterCritter’s color darkens (color values decrease). 
     */
    private int c;
    private static final double DARKENING_FACTOR = 0.05;

    // Modify the constructor
    public BlusterCritter(int c){
        super();
        this.c = c;
    }

    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = getLocation();

        for (int i = loc.getRow() - 2; i <= loc.getRow() + 2; i++)
            for (int j = loc.getCol() - 2; j <= loc.getCol() + 2; j++)
            {
                if (i == loc.getRow() && j == loc.getCol())
                {
                    continue;
                }
                Location around = new Location(i, j);
                if (getGrid().isValid(around))
                {
                    if (getGrid().get(around) != null)
                    {
                        actors.add(getGrid().get(around));
                    }
                }
            }

        return actors;
    }

    public void processActors(ArrayList<Actor> actors){
        int num = 0;
        for (Actor it : actors)
        {
            if (it instanceof Critter)
            {
                num++;
            }
        }

        Color itsColor = getColor();

        if (num < c)
        {
            // brighter color
            int red = (int) (itsColor.getRed());
            int green = (int) (itsColor.getGreen());
            int blue = (int) (itsColor.getBlue());
            if (red < 255) {
                red++;
            }
            if (blue < 255) {
                blue++;
            }
            if (green < 255){
                green++;
            }

            setColor(new Color(red, green, blue));
        }
        else 
        {
            // darken color
            int red = (int) (itsColor.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (itsColor.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (itsColor.getBlue() * (1 - DARKENING_FACTOR));

            setColor(new Color(red, green, blue));
        }

    }

}
