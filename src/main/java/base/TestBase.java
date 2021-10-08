package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	
	public static WebDriver driver;
	
	public TestBase() {
		
	}
	 
	public static void initializeDriver() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");
		}
	
	public void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException{
		TakesScreenshot ts=((TakesScreenshot)driver);
		File scourceFile=ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat formatter=new SimpleDateFormat("MMddyy_HHmmss");
		Date date=new Date();
		String lable=formatter.format(date);
		String currentDirectory=System.getProperty("user.dir");
		//FileUtils.copyFile(scourceFile, new File(currentDirectory + "/screenshot/"+ System.currentTimeMillis()+".png"));
		FileUtils.copyFile(scourceFile, new File(currentDirectory + "/screenshot/"+ lable +".png"));
	}
}
