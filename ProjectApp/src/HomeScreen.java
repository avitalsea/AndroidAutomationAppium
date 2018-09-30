import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomeScreen {

    private static WebElement chooseBusiness;

    public static void clickOnHomeTab(AndroidDriver<MobileElement> driver) throws InterruptedException { // לחיצה על כפתור הבית- העמוד הראשי
        WebElement clickHomeTab = driver.findElement(By.id(AppConstants.HOME_TAB));
        clickHomeTab.click();
    }

    public static void selectCategory(AndroidDriver<MobileElement> driver) throws InterruptedException { // בחירה של קטגוריה של מתנה
//        Thread.sleep(1000);
        WebElement chooseCategory = driver.findElement(By.id(AppConstants.CATEGORY));
        chooseCategory.click();
    }
// גלילה לבית העסק שבוחרים
    public static void scrollToBusiness(AndroidDriver<MobileElement> driver) throws InterruptedException
    {
        Thread.sleep(2000);
        chooseBusiness = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"טאיזו\"))"));
    }

    public static void clickOnBusiness(AndroidDriver<MobileElement> driver) throws InterruptedException { // בחירה של בית עסק
        chooseBusiness.click();
    }
// בחירה של סכום של השובר של המתנה
    public static void enterYourGiftBudget(AndroidDriver<MobileElement> driver) throws InterruptedException
    {
//        Thread.sleep(1000);
        WebElement enterGiftBudget = driver.findElement(By.id(AppConstants.GIFT_BUDGET));
        enterGiftBudget.sendKeys("300");
    }

    public static void pressButtonSelection(AndroidDriver<MobileElement> driver) throws InterruptedException { // לחיצה על כפתור לבחירה
        Thread.sleep(1000);
        WebElement buttonSelection = driver.findElement(By.id(AppConstants.SELECT_BUTTON));
        buttonSelection.click();

    }
}
