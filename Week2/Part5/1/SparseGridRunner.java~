import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;



public class SparseGridRunner
{
	public static void main(String[] args){
		ActorWorld world = new ActorWorld();
		// To add 3 Grid Class to the world
		world.addGridClass("SparseBoundedGrid");
		world.addGridClass("SparseBoundedGrid2");
		world.addGridClass("UnboundedGrid2");
		world.add(new Location(2, 2), new Critter());
		world.show();
	}
}