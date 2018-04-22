import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * An <code>SparseBoundedGrid</code> is a rectangular grid with a bounded number of rows and
 * columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */

public class SparseBoundedGrid<E> extends AbstractGrid<E>
{
	private SparseGridNode[] occupants;
	private int row;
	private int col;

	public SparseBoundedGrid(int rows, int cols)
	{
        if (rows <= 0) {
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0) {
            throw new IllegalArgumentException("cols <= 0");
        }
        
        row = rows;
        col = cols;
        occupants = new SparseGridNode[row];
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

        // Look at all grid locations.
        for (int i = 0; i < getNumRows(); i++)
        {
        	// Traverse the row
            SparseGridNode p = occupants[i];
            while (p != null){
            	theLocations.add(new Location(i, p.getColNum()));
            	p = p.getNext();
            }
        }

        return theLocations;
    }

    public E get(Location loc)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc  + " is not valid");
        }

        // Traverse the row to get the object
        SparseGridNode p = occupants[loc.getRow()];
        while (p != null){
            if (loc.getCol() == p.getColNum()) {
            	return (E)p.getOccupant();
            }
            p = p.getNext();
        }

        return null;
        // unavoidable warning
    }

    public E put(Location loc, E obj)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc  + " is not valid");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }

        // Add the object to the grid, meanwhile add it to the front of the node list.
        E oldOccupant = remove(loc);
        occupants[loc.getRow()] = new SparseGridNode(obj, loc.getCol(), occupants[loc.getRow()]);
        return oldOccupant;
    }

    public E remove(Location loc)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc  + " is not valid");
        }
        
        // Remove the object from the grid.
        E r = get(loc);
        if (r == null) {
        	return null;
        }

        SparseGridNode p = occupants[loc.getRow()];
        if (p != null) {
        	if (p.getColNum() == loc.getCol()) {
        		// check the head of the node
        		// if match, remove the head
        		occupants[loc.getRow()] = p.getNext();
        	}
        	else
        	{
        		// Traverse the row to find
        		SparseGridNode next = p.getNext();
		        while (next != null && next.getColNum() != loc.getCol()){
		            next= next.getNext();
		            p = p.getNext();
		        }

		        if (next != null) {
		        	// The object is found
		        	p.setNext(next.getNext());
		        }
        	}
        }
        return r;
    }
}