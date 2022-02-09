import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FeritTests {
    public WebDriver driver;
    public String testURL = "https://www.ferit.unios.hr/2021/";
    FeritHomePage homePage;
    FeritLoginPage loginPage;
    FeritClassSchedule classSchedule;
    String stringToSearch = "corona"; //Change this if you want to test another search
    FeritYTChannel ytChannel;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "c:\\drivers\\geckodriver.exe");
        //FirefoxOptions firefoxOptions = new FirefoxOptions();
        //WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.navigate().to(testURL);
        //driver.get(testURL);
    }

    @Test(priority = 1)
    public void verifyHomePage(){
        homePage = new FeritHomePage(driver);
        homePage.verifyHomePage();
    }

    @Test(priority = 2)
    public void userLogin(){
        loginPage = new FeritLoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.enterUserEmail("firstNamelastName@etfos.hr"); //User has to enter their ETFOS email
        loginPage.enterPassword("userPassword"); //User has to enter their ETFOS password
        loginPage.submitData();
    }

    @Test(priority = 3)
    public void checkSchedule(){
        classSchedule = new FeritClassSchedule(driver);
        classSchedule.goToClassSchedule();
    }

    @Test(priority = 4)
    public void searchTest() throws InterruptedException {
        homePage = new FeritHomePage(driver);
        homePage.searchPage(stringToSearch);
    }

    @Test(priority = 5)
    public void YTChannel()  {
        ytChannel = new FeritYTChannel(driver);
        ytChannel.goToYTChannel();
    }

    @AfterMethod
    public void teardownTest() {
    //Close browser and end the session
        driver.quit();
    }
}
