package latice.model.tiles;

public class Tile {
	private Color color;
	private Shape shape;
	public Position position;
	
	public Tile(Color color, Shape shape,Position position) {
		this.color = color;
		this.shape = shape;
		this.position = position;
	}

	public Color color() {
		return color;
	}
		
	public Shape shape() {
		return shape;
	}
	
	public Position position() {
		return position;
	}

	@Override
	public String toString() {
		return  color.color() + shape.shape();
	}

	
}
