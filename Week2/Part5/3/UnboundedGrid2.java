import info.gridworld.grid.*;
import java.util.ArrayList;
import java.util.*;

/**
 * An <code>UnboundedGrid2</code> is a rectangular grid with an unbounded number of rows and
 * columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class UnboundedGrid2<E> extends AbstractGrid<E>
{
    private Object[][] occupants;
    private int dim;
    // dim means the dimension of the current map

    /**
     * Constructs an empty unbounded grid.
     */
    public UnboundedGrid2()
    {
        dim = 16;
        occupants = new Object[dim][dim];
    }

    public int getNumRows()
    {
        return -1;
    }

    public int getNumCols()
    {
        return -1;
    }

    public boolean isValid(Location loc)
    {
        return loc.getRow() >= 0 && loc.getCol() >= 0;
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        // Look at all grid locations.
        for (int r = 0; r < dim; r++)
        {
            for (int c = 0; c < dim; c++)
            {
                // If there's an object at this location, put it in the array.
                Location loc = new Location(r, c);
                if (get(loc) != null)
                    theLocations.add(loc);
            }
        }

        return theLocations;
    }

    public E get(Location loc)
    {
        if (!isValid(loc)){
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }

        if (loc.getCol() >= dim || loc.getRow() >= dim)
        {
            return null;
        }
        return (E) occupants[loc.getRow()][loc.getCol()]; // unavoidable warning
    }

    public E put(Location loc, E obj)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }

        if (loc.getCol() >= dim || loc.getRow() >= dim) {
            resize(loc);
        }

        // Add the object to the grid.
        E oldOccupant = get(loc);
        occupants[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }

    public E remove(Location loc)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }

        if (loc.getCol() >= dim || loc.getRow() >= dim)  {
            return null;
        }
        
        // Remove the object from the grid.
        E r = get(loc);
        occupants[loc.getRow()][loc.getCol()] = null;
        return r;
    }

    // double the grid size until it is large enough to put the object
    private void resize(Location loc) {
        int size = dim;
        while (loc.getRow() >= size || loc.getCol() >= size)
            size *= 2;

        Object[][] temp = new Object[size][size];

        // copy the origin to the new grid
        for (int i = 0; i < dim; i++){
            for (int j = 0; j < dim; j++) {
                temp[i][j] = occupants[i][j];
            }
        }

        occupants = temp;
        dim = size;
    }

}
