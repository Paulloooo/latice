package latice.model.tiles;

public enum Shape {
	BIRD("B"),TURTLE("T"),DOLPHIN("D"),FEATHER("P"),FLEUR("F"),GECKO("G");

	private String shape;
	
	private Shape(String shape) {
		this.shape = shape;
	}
	
	public String shape() {
		return shape;
	}
}

