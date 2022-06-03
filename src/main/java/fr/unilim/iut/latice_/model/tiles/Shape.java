package fr.unilim.iut.latice_.model.tiles;

public enum Shape {
	BIRD("B"),TURTLE("T"),DOLPHIN("D"),FEATHER("P"),FLOWER("F"),GECKO("G");

	private String shape;
	
	private Shape(String shape) {
		this.shape = shape;
	}
	
	public String shape() {
		return shape;
	}
}

