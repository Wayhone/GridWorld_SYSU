import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;



public class SparseGridRunner2
{
	public static void main(String[] args){
		ActorWorld world = new ActorWorld();
		// To add Grid Class to the world
		world.addGridClass("SparseBoundedGrid2");
		world.add(new Location(2, 2), new Critter());
		world.show();
	}
}
