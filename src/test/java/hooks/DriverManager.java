package hooks;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class DriverManager {

	public static WebDriver Driver;

	public static WebDriver getDriver() {
	if(Driver==null) {
	System.setProperty("webdriver.chrome.driver", "src/test/ressources/Drivers/chromedriver.exe");
	Driver = new ChromeDriver();
	Driver.manage().window().maximize();
	Driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	Driver.manage().deleteAllCookies();

	}
	return Driver;

	}
	}

	
