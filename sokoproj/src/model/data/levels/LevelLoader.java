package model.data.levels;


import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Liat Skladman 308437128
 * a. The separation between the data creator and the data representative was implemented by
 * 	  the method loadLevel that creates instance of Level.
 * b. this separation enables to keep Open / Closed Principle  because now we can create loader to any input structure
 * c.that can also keep Liskov Substitution Principle because we override common methods and get differnt behaviors
 *   for different loaders and we can use all of the loaders under same Class LevelLoader without casting
 * d.we chose to use InputStream and not String filename in order to keep level file format generic.
 *
 */
public interface LevelLoader{

	public Level loadLevel (InputStream is) throws IOException, ClassNotFoundException;
}
