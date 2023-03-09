import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class login {
    AppiumDriver driver;
    AndroidDriver dri;
    AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    boolean flag;

    @BeforeMethod
    public void login() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Pixel 6 API 33");
        //caps.setCapability("appPackage", "com.saib.saib.MainActivity");
        //caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability("app",
                System.getProperty("user.dir") + "/app/app.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    /*

         WebElement UserName=driver.findElement(By.xpath("//*[@text='Username']"));
         WebElement password=driver.findElement(By.xpath("//*[@text='Password']"));
         WebElement loginButton=driver.findElement(new AppiumBy.ByAccessibilityId("LET'S START!"));
         WebElement passwordNameErr=driver.findElement(By.xpath("//android.view.View[@content-desc=\"Please enter your password\"]"));
         WebElement userNameErr=driver.findElement(By.xpath("//android.view.View[@content-desc='Please enter your username.']"));
        WebElement unauth = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"401: Unauthorized\"])"));
    */
   @Test(priority = '1')
    public void validScenario() {
        // driver.findElement(By.className("android.widget.EditText")).sendKeys("b512alam");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement UserName = driver.findElement(By.xpath("//*[@text='Username']"));
        WebElement password = driver.findElement(By.xpath("//*[@text='Password']"));
        WebElement loginButton = driver.findElement(new AppiumBy.ByAccessibilityId("LET'S START!"));
        WebElement dummyclick = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Welcome to SAIB Employee\"]"));

        UserName.click();
        UserName.sendKeys("b512alam");
        dummyclick.click();
        password.click();
        password.sendKeys("Zakhnoon@4553");
        dummyclick.click();
        loginButton.click();
        //sendSms();
        WebElement actualsuccessLogin = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]"));
        boolean actualsuccessLoginvisible = actualsuccessLogin.isDisplayed();
        Assert.assertEquals(actualsuccessLoginvisible, true);
        actualsuccessLogin.click();
        WebElement wall = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Wall\"]\n"));
        wall.click();



    }


    @Test(priority = '2')
    public void empty() {
       /* WebElement UserName = driver.findElement(By.xpath("//*[@text='Username']"));
        WebElement password = driver.findElement(By.xpath("//*[@text='Password']"));*/
        WebElement loginButton = driver.findElement(new AppiumBy.ByAccessibilityId("LET'S START!"));
       // WebElement dummyclick = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Welcome to SAIB Employee\"]"));

        // expected Results
        String expectedUserError = "Please enter your username.";
        String expectedPasswordError = "Please enter your password";
        //login and assertion
      /*  UserName.click();
        UserName.sendKeys("");
        dummyclick.click();
        password.click();
        password.sendKeys("");
        dummyclick.click();*/
        loginButton.click();
        WebElement userNameErr = driver.findElement(By.xpath("//android.view.View[@content-desc='Please enter your username.']"));
        String actualuserError = userNameErr.getTagName();
        System.out.println("actualUserName :" + actualuserError);
        Assert.assertEquals(actualuserError, expectedUserError);
        WebElement passwordNameErr = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Please enter your password\"]"));
        String actualpassError = passwordNameErr.getTagName();
        System.out.println("actualPassword :" + actualpassError);
        Assert.assertEquals(actualpassError, expectedPasswordError);

    }

    @Test(priority = '3')
    public void Invaliduser() {
        WebElement UserName = driver.findElement(By.xpath("//*[@text='Username']"));
        WebElement password = driver.findElement(By.xpath("//*[@text='Password']"));
        WebElement loginButton = driver.findElement(new AppiumBy.ByAccessibilityId("LET'S START!"));
        WebElement dummyclick = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Welcome to SAIB Employee\"]"));
        String expectedMsg = "401: Unauthorized";
        UserName.click();
        UserName.sendKeys("peter");
        dummyclick.click();
        password.click();
        password.sendKeys("Zakhnoon@4553");
        dummyclick.click();
        loginButton.click();
        WebElement unauth = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"401: Unauthorized\"]"));
        String actualMsg = unauth.getTagName();
        Assert.assertEquals(actualMsg, expectedMsg);

    }

    @Test(priority = '4')
    public void Invalidpassword() {
        WebElement UserName = driver.findElement(By.xpath("//*[@text='Username']"));
        WebElement password = driver.findElement(By.xpath("//*[@text='Password']"));
        WebElement loginButton = driver.findElement(new AppiumBy.ByAccessibilityId("LET'S START!"));
        WebElement dummyclick = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Welcome to SAIB Employee\"]"));
        String expectedMsg = "401: Unauthorized";
        UserName.click();
        UserName.sendKeys("b512alam");
        dummyclick.click();
        password.click();
        password.sendKeys("peter");
        dummyclick.click();
        loginButton.click();
        WebElement unauth = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"401: Unauthorized\"]"));
        String actualMsg = unauth.getTagName();
        Assert.assertEquals(actualMsg, expectedMsg);

    }

    @Test(priority = '5')
    public void Invaliduserandpassword() {
        WebElement UserName = driver.findElement(By.xpath("//*[@text='Username']"));
        WebElement password = driver.findElement(By.xpath("//*[@text='Password']"));
        WebElement loginButton = driver.findElement(new AppiumBy.ByAccessibilityId("LET'S START!"));
        WebElement dummyclick = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Welcome to SAIB Employee\"]"));

        String expectedMsg = "401: Unauthorized";
        UserName.click();
        UserName.sendKeys("peter");
        dummyclick.click();
        password.click();
        password.sendKeys("peter");
        dummyclick.click();
        loginButton.click();
        WebElement unauth = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"401: Unauthorized\"]"));
        String actualMsg = unauth.getTagName();
        Assert.assertEquals(actualMsg, expectedMsg);

    }
   // @Test(priority = '6')
    public void loginUSER() {
        // driver.findElement(By.className("android.widget.EditText")).sendKeys("b512alam");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement UserName = driver.findElement(By.xpath("//*[@text='Username']"));
        WebElement password = driver.findElement(By.xpath("//*[@text='Password']"));
        WebElement loginButton = driver.findElement(new AppiumBy.ByAccessibilityId("LET'S START!"));
        WebElement dummyclick = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Welcome to SAIB Employee\"]"));
        UserName.click();
        UserName.sendKeys("b512alam");
        dummyclick.click();
        password.click();
        password.sendKeys("Zakhnoon@4553");
        dummyclick.click();
        loginButton.click();
        //sendSms();
        WebElement actualsuccessLogin = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]"));
        boolean actualsuccessLoginvisible = actualsuccessLogin.isDisplayed();
        Assert.assertEquals(actualsuccessLoginvisible, true);

    }

    @Test(priority = '7')
    public void logout() {
        loginUSER();
        WebElement more = driver.findElement(By.xpath("//android.view.View[@content-desc=\"More\"]\n"));
        more.click();
        WebElement logout = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Log out\"]\n"));
        logout.click();

    }


    @AfterMethod
    public void teardown() {
       if (null!=driver){

           service.stop();

       }

    }
}


