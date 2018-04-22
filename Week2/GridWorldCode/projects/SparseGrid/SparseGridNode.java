public class SparseGridNode{
	// Node porperties, included the object and its column number, and its next object.
	private Object occupant;
	private int col;
	private SparseGridNode next;

	// constructor
	public SparseGridNode(Object obj, int colNum, SparseGridNode nextNode) {
		occupant = obj;
		col = colNum;
		next = nextNode;
	}

	// interface for occupant, col and next
	public void setOccupant(Object obj) {
		occupant = obj;
	}
	public Object getOccupant() {
		return occupant;
	}

	public int getColNum() {
		return col;
	}

	public void setNext(SparseGridNode nextNode) {
		next = nextNode;
	}
	public SparseGridNode getNext() {
		return next;
	}

}