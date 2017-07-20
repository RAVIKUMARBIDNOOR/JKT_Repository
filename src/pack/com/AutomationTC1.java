package pack.com;

import org.testng.annotations.Test;

public class AutomationTC1 {
	@Test
	public void test1 () throws InterruptedException
	{
		
	Browsers.common();
	Thread.sleep(2000);
	Browsers.before();
	Browsers.after();
	
	}
}
