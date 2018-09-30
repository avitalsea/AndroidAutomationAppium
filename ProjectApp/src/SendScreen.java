import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SendScreen {


    public static void clickButtonAfterPayment(AndroidDriver<MobileElement> driver) throws InterruptedException { // לבחור אופציה של תשלום מיד אחרי מילוי הפרטים
//        Thread.sleep(5000);
        WebElement buttonAfterPayment = driver.findElement(By.id(AppConstants.AFTER_PAYMENT_BUTTON));
        buttonAfterPayment.click();
    }

    public static void pickSendViaEmail(AndroidDriver<MobileElement> driver) throws InterruptedException { //  לבחור אוםציה של שליחת המתנה דרך המייל
//        Thread.sleep(5000);
//        WebElement sendViaEmail = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"במייל\"))"));
//        WebElement clickSendViaEmail = driver.findElement(By.id(AppConstants.SEND_EMAIL));
        WebElement sendViaEmail = driver.findElement(By.id(AppConstants.SEND_EMAIL)).findElement(By.id(AppConstants.SEND_EMAIL_CLICK));
        sendViaEmail.click();
    }

    public static void enterReceiverEmail(AndroidDriver<MobileElement> driver) throws InterruptedException { // למלא את שדה של המייל של מקבל המתנה
//        Thread.sleep(5000);
        WebElement addReceiverEmail = driver.findElement(By.id(AppConstants.RECEIVER_EMAIL));
        addReceiverEmail.sendKeys("vered123@gmail.com");
    }

    public static void pressButtonContinue(AndroidDriver<MobileElement> driver) throws InterruptedException { // ללחוץ על כפתור המשך
//        Thread.sleep(5000);
        try
        {
            driver.hideKeyboard();
        } catch (Exception exp) {
        }

        WebElement pressTheButtonContinue = driver.findElement(By.id(AppConstants.BUTTON_CONTINUE_PRESS));
        pressTheButtonContinue.click();
    }
}
