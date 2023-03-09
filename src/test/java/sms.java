import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
/*

public class sms {
    AndroidDriver driver ;
@BeforeTest
  public void setCap() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Pixel 6 API 33");
        caps.setCapability("appPackage", "com.google.android.apps,messaging");
        //caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability("app", System.getProperty("C:\\Users\\2211\\IdeaProjects\\untitled3"+"/app/app.apk"));
        driver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
    @Test
    public void sendSms(){
        driver.sendSMS("01127108853","automation testing");
    }
}*/

