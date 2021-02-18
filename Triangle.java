/*
	Where I've recieve help from and what it helped me with
	-stackoverflow: null pointer excepction
	-Chase Lindquist: just to make sure I'm right
	-Java 11 API: radical to degrees


*/







public class Triangle 
{
	//private variables
	private double sideA;
	private double sideB;
	private double sideC;
	
	public static final double DEFAULT_SIDE = 1;
	
	//the methods that will check whether the triangle is actually a triangle
	public static boolean isTriangle (double a, double b, double c)
	{
		//first if statement keeps negative values out
		if (a > 0 && b > 0 && c > 0)
		{
			//second makes sure that the numbers comply with the 
			//triangle inequalities
			if ((a + b > c) && (b + c > a) && (c + a > b))
			{
				return true;
			}
		}
		
		return false;
	}

	public static boolean isTriangle (double[] sides)
	{
		
		if(sides == null || sides.length != 3)
		{
			return false;
		}
		
		if (sides[0] > 0 && sides[1] > 0 && sides[2] > 0  && (isTriangle(sides[0], sides[1], sides[2])))
		{
			return true;
		}
		
		return false;
		
	}
	
	public static double lawOfCosines (double a, double b, double c)
	{
		double angleC = Math.acos(((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2*a*b)));

		angleC = Math.toDegrees(angleC);

			return angleC;
	}
	
	
	//Triangle constructor methods
	public Triangle ()
	{
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	
	public Triangle (double sideA, double sideB, double sideC)
	{

		//check to see if the sides are positive
		//if not, the sides will be equal to DEFAULT_SIDE
		if(isTriangle(sideA, sideB, sideC))
		{
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		}
		else
		{
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		
	}
	
	public Triangle (double[] sides) 
	{
		if(isTriangle(sides))
		{
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
		}
		else
		{
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	public Triangle (Triangle triangle) 
	{

		if(triangle != null)
		{
			this.sideA = triangle.sideA;
			this.sideB = triangle.sideB;
			this.sideC = triangle.sideC;
		}
		else
		{
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	
	//get sides methods
	public double getSideA ()
	{
		return sideA;
	}
	
	public double getSideB ()
	{
		return sideB;
	}
	
	public double getSideC ()
	{
		return sideC;
	}
	
	public double[] getSides ()
	{
		double[] sides = new double[3];
		sides[0] = sideA;
		sides[1] = sideB;
		sides[2] = sideC;

		return sides;
	}
	
	//get angle methods
	public double getAngleA ()
	{
		double a = sideA;
		double b = sideB;
		double c = sideC;

		double angleA = Triangle.lawOfCosines(c, b, a);

		return angleA;
	}
	
	public double getAngleB ()
	{
		double a = sideA;
		double b = sideB;
		double c = sideC;

		double angleB = Triangle.lawOfCosines(a, c, b);

		return angleB;
	}
	
	public double getAngleC ()
	{
		double a = sideA;
		double b = sideB;
		double c = sideC;

		double angleC = Triangle.lawOfCosines(a, b, c);

		return angleC;
	}
	
	public double[] getAngles ()
	{
		double[] sidesAngles = new double [3];

		sidesAngles[0] = getAngleA();
		sidesAngles[1] = getAngleB();
		sidesAngles[2] = getAngleC();
		
		return sidesAngles;
	}
	
	
	//set sides methods 
	public boolean setSideA (double sideA)
	{		
		if( isTriangle(sideA, this.sideB, this.sideC))
		{
			this.sideA = sideA;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean setSideB (double sideB)
	{
		if( isTriangle(this.sideA, sideB, this.sideC))
		{
			this.sideB = sideB;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean setSideC (double sideC)
	{
		if( isTriangle(this.sideA, this.sideB, sideC))
		{
			this.sideC = sideC;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean setSides (double[] sides)
	{
		if(isTriangle(sides))
		{
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//toString method
	public String toString ()
	{
		String str = "Triangle(%.3f, %.3f, %.3f)";

		return String.format(str, this.sideA, this.sideB, this.sideC);
	}
}
