# Test Report for GridWorld

------
**Test A:**
Explanation: Test for a normal jump act.  
Expection:   The jumper move 2 cells forwards.  
```java
	@Test
	public void testJump() {
		world.add(new Location(5, 5), jumper1);
		jumper1.act();
		Location loc = jumper1.getLocation();
		Location dest = new Location(3, 5);
		assertEquals(loc, dest);
	}
```

**Test B:**  
Explanation: Test what will a jumper do if the location in front of it is empty, but the location two cells in front contains a flower.  
Expection:   The jumper would jump over the flower.  
```java
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
```

**Test C:**  
Explanation: Test what will a jumper do if the location in front of it is empty, but the location two cells in front contains a rock.  
Expection:   The jumper would turn 45 degree to the right.  
```java
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
```

**Test D:**  
Explanation: Test what will a jumper do if the location two cells in front of the jumper is out of the grid.  
Expection:   The jumper would turn 45 degree to the right.  
```java
	@Test
	public void testOutOfGrid() {
		world.add(new Location(1, 5), jumper1);
		jumper1.act();
		int direc = jumper1.getDirection();
		Location loc = jumper1.getLocation();
		Location dest= new Location(1, 5);
		assertTrue(loc.equals(dest) && direc == Location.NORTHEAST);
	}
```
**Test E:**  
Explanation: Test what will a jumper do if it is facing an edge of the grid.
Expection:   The jumper would turn 45 degree to the right.  
```java
	@Test
	public void testFacingEdge() {
		world.add(new Location(0, 5), jumper1);
		jumper1.act();
		int direc = jumper1.getDirection();
		Location loc = jumper1.getLocation();
		Location dest = new Location(0, 5);
		assertTrue(loc.equals(dest) && direc == Location.NORTHEAST);
	}
```



**Test F:**  
Explanation: Test what will a jumper do if another actor (not a flower or a rock) is in the cell that is two cells in front of the jumper
Expection:   The jumper will replace it.  
```java
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
```

**Test G:**  
Explanation: Test what will a jumper do if the location two cells in front of the jumper is empty, but the cell in front of the jumper is a rock.  
Expection:   The jumper will jump over it.    
```java
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
```


---
