package Practice;

import org.testng.annotations.Test;

public class testng 
{
	@Test(enabled = false)
	public void Create()
	{
		System.out.println("created");
	}
	@Test(dependsOnMethods = "Create")
	public void Update()
	{
		System.out.println("updated");
	}
	@Test(dependsOnMethods ="Create")
	public void Delete()
	{
		System.out.println("deleted");
	}
	
	}

