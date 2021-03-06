/**
 * Uranium, the radioactive type of Material.
 */
public class Uranium extends Material{

    /**
     * If the material is triggered the asteroid explodes,
     * that kills all settlers and blows away all robots which are on the asteroid.
     * The trigger happens, if the asteroid is near the sun and the core is exposed.
     */
    @Override
    public void Trigger() {
        asteroid.Explode();
    }
}
