import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run {
    @Rule
    public TestName name = new TestName();
    private static ExtentReports extent;
    private static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void setUp() throws IOException {
        //read configuration XML file
        String appPackage = ReadFile.getData("appPackage");
        System.out.println("appPackage: " + appPackage);
        String appActivity = ReadFile.getData("appActivity");
        System.out.println("appActivity: " + appActivity);
        String reportPath= ReadFile.getData("reportPath");
        System.out.println("reportPath: " + reportPath);

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");


        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01_clickOnGoogleButton() throws InterruptedException {
        ExtentTest test = extent.createTest("Login", "Click on Google button");
        test.log(Status.INFO, "Click on Google button");

        RegistrationScreen.clickOnGoogleButtonIfFound(driver);
        RegistrationScreen.clickOnProfileTab(driver);

        takeScreenShot(test, driver, name,"1");
    }


    @Test
    public void test02_clickOnHomeTab() throws InterruptedException {
        HomeScreen.clickOnHomeTab(driver);
    }

    @Test
    public void test03_selectCategory() throws InterruptedException {
        ExtentTest test = extent.createTest("Select Category", "Select category");
        test.log(Status.INFO, "Select category");

        HomeScreen.selectCategory(driver);

        takeScreenShot(test, driver, name,"2");
    }

    @Test
    public void test04_selectBusiness() throws InterruptedException {
        ExtentTest test = extent.createTest("Select Business", "Select business");
        test.log(Status.INFO, "Select business");

        HomeScreen.scrollToBusiness(driver);
        takeScreenShot(test, driver, name,"3");

        HomeScreen.clickOnBusiness(driver);
    }

    @Test
    public void test05_enterYourGiftBudget() throws InterruptedException {
        ExtentTest test = extent.createTest("Enter your gift budget", "Enter the amount of your gift budget");
        test.log(Status.INFO, "Enter the amount of your gift budget");

        HomeScreen.enterYourGiftBudget(driver);

        takeScreenShot(test, driver, name,"4");
    }

    @Test
    public void test06_pressButtonSelection() throws InterruptedException {
        HomeScreen.pressButtonSelection(driver);
    }

    @Test
    public void test07_scrollPageDown() throws InterruptedException {
        SenderReceiverInformation.scrollPageDown(driver);
    }

    @Test
    public void test08_senderName() throws InterruptedException {
        SenderReceiverInformation.senderName(driver);
    }

    @Test
    public void test09_blessing() throws InterruptedException {
        SenderReceiverInformation.blessing(driver);
    }

    @Test
    public void test10_receiverName() throws InterruptedException {
        ExtentTest test = extent.createTest("Receiver name", "Enter receiver name");
        test.log(Status.INFO, "Enter receiver name");

        SenderReceiverInformation.receiverName(driver);

        takeScreenShot(test, driver, name,"5");
     }

    @Test
    public void test11_pressButtonContinue() throws InterruptedException {
        SenderReceiverInformation.pressButtonContinue(driver);
    }

    @Test
    public void test12_clickButtonAfterPayment() throws InterruptedException {
        SendScreen.clickButtonAfterPayment(driver);
    }

    @Test
    public void test13_pickSendViaEmail() throws InterruptedException {
        SendScreen.pickSendViaEmail(driver);
    }

    @Test
    public void test14_enterReceiverEmail() throws InterruptedException {
        ExtentTest test = extent.createTest("Enter Receiver Email", "Enter receiver email");
        test.log(Status.INFO, "Enter receiver email");

        SendScreen.enterReceiverEmail(driver);

        takeScreenShot(test, driver, name,"6");
    }

    @Test
    public void test15_pressButtonContinue() throws InterruptedException {
        SendScreen.pressButtonContinue(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        extent.flush();
    }


    public static void takeScreenShot(ExtentTest test, AndroidDriver<MobileElement> driver, TestName name, String imageNumber) {
        try {
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShotInner(driver, name.getMethodName() + imageNumber)).build());
            Thread.sleep(1000);
        }
        catch (Exception exp) { }
    }

    public static String takeScreenShotInner(AndroidDriver<MobileElement> driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile); // jar: commons-codec-1.10
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
}
