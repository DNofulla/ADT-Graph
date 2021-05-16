package daniel.nofulla.homework4;

import java.io.FileNotFoundException;

/**
 * This is the Driver Class
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class Driver {
	
	/**
	 * This is the main method for the driver class. This executes every time the
	 * program runs. Helper Class's start method is invoked.
	 * 
	 * @param args Command Line Arguments
	 * @throws GraphException        Throws the GraphException
	 * @throws FileNotFoundException Throws the FileNotFoundException
	 */
	public static void main(String[] args) throws GraphException, FileNotFoundException {
		Helper.start();
	}

}
