import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FeritLoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By loginPage = By.xpath("/html/body/div[9]/div[1]/div/ul/li[7]/a");
    By userEmail = By.name("username");
    By userPassword = By.name("password");
    By submit = By.xpath("/html/body/div/main/form/button");

    public FeritLoginPage(WebDriver driver){
        this.wait = new WebDriverWait(driver,30);
        this.driver = driver;
    }

    public void verifyLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage));
        driver.findElement(loginPage).click();
    }

    public void enterUserEmail(String email){
        driver.findElement(userEmail).sendKeys(email);
    }

    public void enterPassword(String pass){
        driver.findElement(userPassword).sendKeys(pass);
    }

    public void submitData(){
        driver.findElement(submit).click();
    }
}
