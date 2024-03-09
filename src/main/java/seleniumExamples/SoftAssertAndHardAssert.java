package seleniumExamples;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertAndHardAssert {
	@Test(priority=1)
	public void SoftAssertion() {
		System.out.println("Before Soft Assertion"); // Soft assert is just like verify and if it fail also it will continue
		// next testing
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(true, false);  //or assert1.fail();
		System.out.println("After Soft Assertion");
	}


	@Test (priority=2)
	public void HardAssertion() { // Hard assert will not continue in case  if it failed
		System.out.println("Before Hard Assertion");
		Assert.assertEquals(true, false);    // or Assert.fail();
		
		System.out.println("After Hard Assertion");
	}


}
