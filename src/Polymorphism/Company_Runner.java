package Polymorphism;

import java.io.*;
import java.util.ArrayList;

public class Company_Runner
{
	
	public static void main(String[] args)
	{
		Manager owner = new Manager("Anish");
		
		// 1. Set yourself as the owner, make your salary 200,000  
		owner.setSalary(200000);
		
		// 2. The owner decided he needed to hire 5 employees each for annual salary of $80k. All hires are the owner's subordinates.
		for(int i = 1; i <= 5; i++){
			owner.addEmployee();
		}
		
		// 3. They all compete for one managerial position that manages the other 4 employees. (Make whoever you want the manager)
		Manager man_1 = owner.makeManager(1, 50000);
		for(Employee e : owner.getSubordinates()){
			if (!(e.ID == man_1.ID)) man_1.addEmployee(e);
		}
		
		// 4. The owner says that he wants to hire 5 new employees and wants 1 more manager from the 4 subordinates of the first manager.
		for(int i = 1; i <= 5; i++){
			owner.addEmployee();
		}
		man_1.makeManager(3, 50000);
		

	}

}
