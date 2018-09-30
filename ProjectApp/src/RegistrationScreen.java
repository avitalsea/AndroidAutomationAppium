import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RegistrationScreen {
    public static void clickOnGoogleButtonIfFound(AndroidDriver<MobileElement> driver) throws InterruptedException { // הרשמה או לוג אין לחשבון של האפליקציה

        ////        //first time registration
////        Thread.sleep(1000);
////        WebElement registrationOrLogin = driver.findElement(By.id(AppConstants.LOGIN));
////        registrationOrLogin.click();
////        Thread.sleep(1000);
////        WebElement clickGoogleAccount = driver.findElement(By.id(AppConstants.GOOGLE_ACCOUNT));
////        clickGoogleAccount.click();
////        WebElement selectUser = driver.findElement(By.id(AppConstants.USER));
//////        selectUser.click();


        try {
            WebElement clickGoogleButton = driver.findElement(By.id(AppConstants.GOOGLE_BUTTON));
            clickGoogleButton.click();
        } catch (Exception exp) {
            System.out.println("Did not find google login button - maybe its already logged in...");
        }

    }

        public static void clickOnProfileTab(AndroidDriver<MobileElement> driver) throws InterruptedException { // להכנס לאזור אישי
        WebElement clickProfileTab = driver.findElement(By.id(AppConstants.PROFILE_TAB));
        clickProfileTab.click();
        Thread.sleep(2000);
    }
}
