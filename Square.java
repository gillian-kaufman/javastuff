public class Square extends Shape
{
	private double side;
	
	/* Constructor Method */
	public Square(String i, double s)
	{
		super(i);
		side = s;
	}
	// Calculate Area Method (Override from Shape class)
	public double calcArea()
	{
		return side * side;
	}
}
