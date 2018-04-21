import java.awt.Color;


import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        world.add(alice);
        Jumper bob = new Jumper();
        bob.setColor(Color.RED);
        world.add(bob);
        world.add(new Bug());
        world.add(new Rock());
        world.show();
    }
}
