package latice.model.tiles;

public enum Color {
	GREEN("G"),MAGENTA("M"),YELLOW("Y"),TURQUOISE("T"),NIGHTBLUE("N"),RED("R");

	private String color;
	
	private Color(String color) {
		this.color = color;
	}
	
	public String color() {
		return color;
	}
}
