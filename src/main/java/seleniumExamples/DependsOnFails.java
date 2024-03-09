package seleniumExamples;

import org.testng.annotations.Test;

public class DependsOnFails {
	
	@Test(timeOut=3000)
	public void ParentsPermission() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Parents permission not given");
	}

	@Test(dependsOnMethods ="ParentsPermission",alwaysRun = true )
	public void LoveMarriage() {
		System.out.println("Marriage Happened");
	}
}
