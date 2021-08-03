public class Rectangle extends Shape
{
	private double length, width;
	
	/* Constructor Method */
	public Rectangle(String i, double l, double w)
	{
		super(i);
		length = l;
		width = w;
	}
	// Calculate Area Method (Override from Shape class)
	public double calcArea()
	{
		return length * width;
	}

}
