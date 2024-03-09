package seleniumExamples;

import org.testng.Assert;
import org.testng.annotations.Test;
public class TestCase {
	
	@Test(retryAnalyzer = RetryAnalyser.class)
	public void Testcase1() {
	Assert.assertEquals(true, false);
	}
	
	@Test
	public void TestCase2() {
		Assert.assertEquals(false, false);
	}

}
