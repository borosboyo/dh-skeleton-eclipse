import java.util.ArrayList;

/**
 * The type Teleport.
 */
public class Teleport {

    private ArrayList<Asteroid> asteroids;

    public Teleport() {
        asteroids = new ArrayList<Asteroid>();
    }

    /**
     * Transfer.
     * If the teleport's pair is placed on another asteroid, then the entity is transfered to it.
     *
     * @param e the entity using the teleport
     */
    public void Transfer(Entity e){

        if (asteroids.size() == 2) {
            if(asteroids.get(0).equals(e.getAsteroid())) {
                asteroids.get(1).Accept(e);
                e.setAsteroid(asteroids.get(1));
            }
            else {
                asteroids.get(0).Accept(e);
                e.setAsteroid(asteroids.get(0));
            }
            e.getAsteroid().RemoveEntity(e);

        }
    }

    /**
     * Remove asteroid.
     *
     * @param a the asteroid to remove
     */
    public void RemoveAsteroid(Asteroid a){
        asteroids.remove(a);
    }

    /**
     * Gets asteroids.
     *
     * @return the asteroids
     */
    public ArrayList<Asteroid> getAsteroids() {
        return asteroids;
    }

    /**
     * Sets asteroids.
     *
     * @param asteroids the asteroids
     */
    public void setAsteroids(ArrayList<Asteroid> asteroids) {
        this.asteroids = asteroids;
    }


}
