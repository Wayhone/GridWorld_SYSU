import static org.junit.Assert.*;

import org.junit.Test;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.awt.Color;

public class JumperTest {
	private ActorWorld world = new ActorWorld();
	private Jumper jumper1 = new Jumper(Color.RED);
	private Jumper jumper2 = new Jumper(Color.BLUE);
	private Bug bug = new Bug();
	private Rock rock = new Rock();
	private Flower flower = new Flower();

	// Test A: test for a normal jump act.
	// Expection: The jumper move 2 cells forwards.
	@Test
	public void testJump() {
		world.add(new Location(5, 5), jumper1);
		jumper1.act();
		Location loc = jumper1.getLocation();
		Location dest = new Location(3, 5);
		assertEquals(loc, dest);
	}

	// Test B: If the location in front of it is empty, but the location two cells in front contains a flower.
	// Expection: The jumper would jump over the flower.  
	@Test
	public void testJumpFlower() {
		world.add(new Location(5, 5), jumper1);
		world.add(new Location(3, 5), flower);
		jumper1.act();
		int direc = jumper1.getDirection();
		Location loc = jumper1.getLocation();
		Location dest = new Location(3, 5);
		assertTrue(loc.equals(dest) && direc == Location.NORTH);
	}
	
	// Test C: If the location in front of it is empty, but the location two cells in front contains a rock.
	// Expection:   The jumper would turn 45 degree to the right.  
	@Test
	public void testJumpRock() {
		world.add(new Location(5, 5), jumper1);
		world.add(new Location(3, 5), rock);
		jumper1.act();
		int direc = jumper1.getDirection();
		Location loc = jumper1.getLocation();
		Location dest = new Location(5, 5);
		assertTrue(loc.equals(dest) && direc == Location.NORTHEAST);
	}
	
	// Test D: If the location two cells in front of the jumper is out of the grid.
	// Expection:   The jumper would turn 45 degree to the right.
	@Test
	public void testOutOfGrid() {
		world.add(new Location(1, 5), jumper1);
		jumper1.act();
		int direc = jumper1.getDirection();
		Location loc = jumper1.getLocation();
		Location dest= new Location(1, 5);
		assertTrue(loc.equals(dest) && direc == Location.NORTHEAST);
	}
	
	// Test E: If it is facing an edge of the grid.
	// Expection:   The jumper would turn 45 degree to the right.  
	@Test
	public void testFacingEdge() {
		world.add(new Location(0, 5), jumper1);
		jumper1.act();
		int direc = jumper1.getDirection();
		Location loc = jumper1.getLocation();
		Location dest = new Location(0, 5);
		assertTrue(loc.equals(dest) && direc == Location.NORTHEAST);
	}
	
	// Test F: If another actor (not a flower or a rock) is in the cell that is two cells in front of the jumper
	// Expection:   The jumper will replace it.  
	@Test
	public void testFacingJumper() {
		world.add(new Location(3, 5), jumper1);
		world.add(new Location(1, 5), jumper2);
		jumper1.act();
		jumper2.act();
		int direc = jumper1.getDirection();
		Location loc = jumper1.getLocation();
		Location dest = new Location(1, 5);
		assertTrue(loc.equals(dest) && direc == Location.NORTH);
	}

	// Test G: If the location two cells in front of the jumper is empty, but the cell in front of the jumper is a rock.
	// Expection:   The jumper will jump over it. 
	@Test
	public void testJumpOverRock() {
		world.add(new Location(3, 5), jumper1);
		world.add(new Location(2, 5), rock);
		jumper1.act();
		int direc = jumper1.getDirection();
		Location loc = jumper1.getLocation();
		Location dest = new Location(1, 5);
		assertTrue(loc.equals(dest) && direc == Location.NORTH);
	}
}