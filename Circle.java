public class Circle extends Shape
{
	private double radius;
	
	/* Constructor Method */
	public Circle(String i, double r)
	{
		super(i);
		radius = r;
	}
	// Calculate Area Method (Override from Shape class)
	public double calcArea()
	{
		return Math.PI *Math.pow(radius, 2);
	}
}
