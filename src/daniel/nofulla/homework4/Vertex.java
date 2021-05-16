package daniel.nofulla.homework4;

/**
 * This is the Vertex Class
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class Vertex {

	/**
	 * The Vertex value
	 */
	private int value;

	/**
	 * The Vertex color
	 */
	private Enum<Color> color;

	/**
	 * Constructs a new 'white' vertex with default value 0
	 */
	public Vertex() {
		setColor(Color.WHITE);
		setValue(0);
	}

	/**
	 * Constructs a new 'white' vertex with an assigned value
	 * 
	 * @param value Value to be assigned to the vertex
	 */
	public Vertex(int value) {
		setValue(value);
		setColor(Color.WHITE);
	}

	/**
	 * Constructs a new vertex with default value 0 and an assigned color
	 * 
	 * @param color Color to be assigned to the vertex
	 */
	public Vertex(Enum<Color> color) {
		setValue(0);
		setColor(color);
	}

	/**
	 * Constructs a new vertex and assigns a value and a color
	 * 
	 * @param value Value to be assigned to the vertex
	 * @param color Color to be assigned to the vertex
	 */
	public Vertex(int value, Enum<Color> color) {
		setValue(value);
		setColor(color);
	}

	/**
	 * Getter method for the value of the Vertex
	 * 
	 * @return Returns the value of the vertex
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Setter method for the value of the vertex
	 * 
	 * @param value The value to be assigned to the vertex
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Getter method for the color of the vertex
	 * 
	 * @return Returns the color of the vertex
	 */
	public Enum<Color> getColor() {
		return this.color;
	}

	/**
	 * Setter method for the color of the vertex
	 * 
	 * @param color The color to be assigned to the vertex
	 */
	public void setColor(Enum<Color> color) {
		this.color = color;
	}

}
