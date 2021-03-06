import java.io.ObjectInputStream;
import java.util.Random;

/**
 * The type Robot.
 */
public class Robot extends Entity implements Steppable {

    /**
     * The robot gets blown away if the asteroid it is on explodes.
     */
    @Override
    public void Blow() {
        Move(getAsteroid().GetRandomNeighbour());
    }

    /**
     * The robot dies if it gets hit by sunstorm.
     */
    @Override
    public void Die() {
        getAsteroid().RemoveEntity(this);
        setAsteroid(null);
        Timer.getInstance().RemoveSteppable(this);
    }

    /**
     * The Step function of the robot.
     */
    @Override
    public void Step() {
        Random rand = new Random();
        long crust = getAsteroid().getCrustThickness();
        Teleport teleport = getAsteroid().GetRandomTeleport();

        if ((teleport.getAsteroids().size() == 2) && (rand.nextInt(100) < 30)) {  //Ha van szomszédja az aszteroidának és 30% akkor teleportál
                UseTeleport(teleport);
        } else {
            if (crust != 0) {
                Drill();
            } else {
                Move(getAsteroid().GetRandomNeighbour());
            }
        }
    }
}
