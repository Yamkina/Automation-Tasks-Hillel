import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.beans.Visibility;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTestSuite {

    @Test
    public void checkGoogleSearch(){
      final DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName","Alexandra");
      caps.setCapability("udid","LC55BYH03305");
      caps.setCapability("platformName","Android");
      caps.setCapability("platformVersion","5.0.2");
      caps.setCapability("browserName","Chrome");

      System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        try {
            final AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
            driver.get("https://google.com");
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            final WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
            searchInput.sendKeys("Hillel",Keys.ENTER);
            final WebElement firstSearchLink = driver.findElement(By.xpath("(//div[@role='heading'])[1]"));
            Assert.assertEquals("There is incorrect link text provided!",firstSearchLink.getText(),"Компьютерная школа Hillel");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginToSnapchat() throws MalformedURLException {
        final DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","Alexandra");
        caps.setCapability("udid","LC55BYH03305");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","5.0.2");
        caps.setCapability("noReset","false");
        caps.setCapability("appPackage","com.snapchat.android");
        caps.setCapability("appActivity","com.snapchat.android.LandingPageActivity");

        final AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        final WebElement logIn = driver.findElementById("com.snapchat.android:id/login_and_signup_page_fragment_login_button");
        logIn.click();
        final WebElement usernameInput = driver.findElementById("com.snapchat.android:id/username_or_email_field");
        usernameInput.sendKeys("Testblala25@gmail.com");
        final WebElement passwordInput = driver.findElementById("com.snapchat.android:id/password_field");
        passwordInput.sendKeys("000");
        final WebElement logInButton = driver.findElementById("com.snapchat.android:id/registration_nav_container");
        logInButton.click();
        final WebElement errorWindow = driver.findElementById("com.snapchat.android:id/login_email_or_username_or_password_error_message");
        Assert.assertEquals("There is incorrect result displayed!",
                String.valueOf("Oops! Your username/email or password is incorrect."),
                errorWindow.getText());
    }


    @Test
    public void checkAndroidCalculator(){
        try {
            final DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName","Alexandra");
            caps.setCapability("udid","LC55BYH03305");
            caps.setCapability("platformName","Android");
            caps.setCapability("platformVersion","5.0.2");
            caps.setCapability("noReset","false");
            caps.setCapability("appPackage", "com.android.calculator2");
            caps.setCapability("appActivity", "com.android.calculator2.Calculator");
            final AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            MobileElement buttonSeven=(MobileElement)driver.findElement(By.id("com.android.calculator2:id/digit_7"));
            buttonSeven.click();
            MobileElement buttonPlus=(MobileElement)driver.findElement(By.id("com.android.calculator2:id/op_add"));
            buttonPlus.click();
            MobileElement buttonTwo=(MobileElement)driver.findElement(By.id("com.android.calculator2:id/digit_2"));
            buttonTwo.click();
            MobileElement buttonEquals=(MobileElement)driver.findElement(By.id("com.android.calculator2:id/eq"));
            buttonEquals.click();
            MobileElement inputField=(MobileElement)driver.findElement(By.className("android.widget.EditText"));
            Assert.assertEquals("There is incorrect result displayed!", String.valueOf("9"), inputField.getText());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
}
