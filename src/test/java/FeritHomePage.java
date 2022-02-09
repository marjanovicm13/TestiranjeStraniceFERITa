import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;


public class FeritHomePage {
    WebDriver driver;
    WebDriverWait wait;
    By searchBar = By.xpath("/html/body/div[9]/div[1]/div/ul/li[11]/a/i");
    By textBox = By.xpath("/html/body/div[9]/div[2]/form/input[1]");

    public FeritHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
    }

    public void verifyHomePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div[1]/div/h3/b[1]")));
        WebElement homePage = driver.findElement(By.xpath("/html/body/div[12]/div[1]/div/h3/b[1]"));
        String getHomePageText = homePage.getText();
        assertEquals("Linkovi:", getHomePageText);
    }

    public void searchPage(String stringToSearch) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(textBox));
        driver.findElement(textBox).sendKeys(stringToSearch);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[9]/div[2]/div"))));
    }
}
