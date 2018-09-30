import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SenderReceiverInformation {

    private static WebElement clickButtonContinue;
    private static WebElement addSenderName;
    private static WebElement addBlessing;
    private static WebElement addReceiverName;

    public static void scrollPageDown(AndroidDriver<MobileElement> driver) throws InterruptedException { // לגלול את העמוד למטנה על מנת שתהיה תצוגה נוחה של המסך על מנת למלא פרטים
//         Thread.sleep(5000);
        WebElement scrollPage = driver.findElement(By.id(AppConstants.PAGE_DOWN));
        scrollPage.click();
        clickButtonContinue = driver.findElement(By.id(AppConstants.BUTTON_CONTINUE));
        addSenderName = driver.findElement(By.id(AppConstants.NAME_OF_SENDER));
        addBlessing =driver.findElement(By.id(AppConstants.BLESSING));
        addReceiverName = driver.findElement(By.id(AppConstants.NAME_OF_RECEIVER));
        Thread.sleep(1000);
    }

    public static void receiverName(AndroidDriver<MobileElement> driver) throws InterruptedException { // למלא שם מקבל המתנה
        addReceiverName.sendKeys("Vered");
        Thread.sleep(1000);
    }

    public static void blessing(AndroidDriver<MobileElement> driver) throws InterruptedException { // למלא שדה של כתיבת ברכה
        addBlessing.sendKeys("Happy Birthday");
        Thread.sleep(1000);
    }

    public static void senderName(AndroidDriver<MobileElement> driver) throws InterruptedException { // למלא שם שולח המתנה
        addSenderName.sendKeys("Avital");
        Thread.sleep(1000);
    }

    public static void pressButtonContinue (AndroidDriver<MobileElement> driver) throws InterruptedException { // ללחוץ על כפתור המשך
        //clickButtonContinue = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                //+"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"" + AppConstants.BUTTON_CONTINUE + "\"))"));
        driver.hideKeyboard();
        clickButtonContinue.click();
        Thread.sleep(1000);
    }
}

