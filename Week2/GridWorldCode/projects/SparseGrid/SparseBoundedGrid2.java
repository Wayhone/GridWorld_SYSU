import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * An <code>SparseBoundedGrid2</code> is a rectangular grid with a bounded number of rows and
 * columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */

public class SparseBoundedGrid2<E> extends AbstractGrid<E>
{
	private Map<Location, E> occupants;
	private int row;
	private int col;

	public SparseBoundedGrid2(int rows, int cols)
	{
        if (rows <= 0) {
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0) {
            throw new IllegalArgumentException("cols <= 0");
        }
        
        row = rows;
        col = cols;
        occupants = new HashMap<Location, E>();
	}

	public int getNumRows() {
        return row;
    }

    public int getNumCols() {
        return col;
    }

    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        // Look for all occupied location
        for (Location loc : occupants.keySet())
            theLocations.add(loc);

        return theLocations;
    }

    public E get(Location loc)
    {
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }

        return occupants.get(loc);
        // unavoidable warning
    }

    public E put(Location loc, E obj)
    {
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }

        // Add the object to the grid
        return occupants.put(loc, obj);
    }

    public E remove(Location loc)
    {
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        return occupants.remove(loc);
    }
}