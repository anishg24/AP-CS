package Classes;

public class Runner
{
	static void Example_1() //Rectangle
	{
		Rectangle temp = new Rectangle();
		temp.print();
		System.out.println();
		
		temp.setLength(2.5);
		temp.setWidth(3.0);
		//Consider how your rectangle will change after setting the length and width to specific values.
		temp.print();
		
		System.out.println();
		
		Rectangle r = new Rectangle(3.5,2);
		r.print();
	}
	
	static void Example_2() // Circle
	{
		// Math.PI is how you use pi
		Circle c = new Circle();
	
		c.print();
		
		System.out.println();
		
		c.set_radius(3);
		c.print();
		
		System.out.println();
		
		//This is acceptable, but you need to be VERY careful when writing code like this.
		Circle circle = new Circle(1.1);
		circle.print();
	}
	
	static void Example_3() // Triangle
	{
		Triangle T = new Triangle();
		T.print();

		System.out.println();

		Triangle Tri = new Triangle(2.1,2);
		Tri.print();
	}


	public static void Example_4()
	{
		Triangle Tri = new Triangle();
		Tri.print();

		System.out.println();

		// LOOK carefully at the output
		Tri.setBase(5.0);
		Tri.setHeight(6.0);
		Tri.print();
	}

	
	public static void main(String[] args)
	{
//		Example_1();
//		Example_2();
//		Example_3();
		Example_4();
		
	}

}
