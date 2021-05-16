package daniel.nofulla.homework4;

/**
 * This is the GraphException class
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
@SuppressWarnings("serial")
public class GraphException extends Exception {
	
	/**
	 * Constructs a Graph Exception with a message. The message is passed on to the
	 * superclass' constructor (The Exception Class constructor, which is part of
	 * Java)
	 * 
	 * @param msg The message to be displayed by the Exception
	 */
	public GraphException(String msg) {
		super(msg);
	}
	
}
