package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Setup {

public static WebDriver Driver;

@Before

public void initial() {


Driver =DriverManager.getDriver(); 

                 }
@BeforeStep
public void affichage() {
System.out.println("etape en cours");

}

   // @AfterStep
   // public void TakeScreenshot(Scenario scenario) {
   // final byte [] screenshot=((TakesScreenshot)Driver).getScreenshotAs(OutputType.BYTES);
   // scenario.attach(screenshot,"image/png", "image");
   // }
   
@After

       public void TakeScreenshot(Scenario scenario) {
	   final byte [] screenshot=((TakesScreenshot)Driver).getScreenshotAs(OutputType.BYTES);
	   scenario.attach(screenshot,"image/png", "image");
	   Driver.close(); 
	   }
	
     //  public void terminal() {
     //  Driver.close();    }

      }

