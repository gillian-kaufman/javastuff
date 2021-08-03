public class Shape implements Comparable<Shape>
{
	private double area;
	private String id;
	
	/* Constructor Method*/
	public Shape(String i)
	{
		id = i;
		area = 0;
	}
	//Calculate Area Method
	public double calcArea()
	{
		return area;
	}
	//toString Method
	public String toString()
	{
		return "Shape " + id;
	}
	/* compareTo method */
	public int compareTo(Shape b)
	{
		if (this.calcArea() > b.calcArea())
			return 1;
		else if (this.calcArea() < b.calcArea())
			return -1;
		else
			return 0;
	}
}
