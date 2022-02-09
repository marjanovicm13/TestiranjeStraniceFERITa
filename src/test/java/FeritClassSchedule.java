import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class FeritClassSchedule {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    By classSchedulePage = By.xpath("/html/body/div[9]/div[1]/div/ul/li[3]/ul/li[2]/a");
    By mainMenu = By.xpath("/html/body/div[9]/div[1]/div/ul/li[3]/a");
    By className = By.cssSelector("#odabir-studija-godine-div > div:nth-child(1) > p:nth-child(6) > a:nth-child(6)");

    public FeritClassSchedule(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        this.action = new Actions(driver);
    }

    public void goToClassSchedule(){
        wait.until(ExpectedConditions.elementToBeClickable(mainMenu));
        String currentTab = driver.getWindowHandle();

        action.moveToElement(driver.findElement(mainMenu)).moveToElement(driver.findElement(classSchedulePage)).click().build().perform();

        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(className));
        driver.findElement(className).click();

        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"raspored\"]")));
        assertEquals("Sveučilišni diplomski studij računarstva -> DRC 1. godina", driver.findElement(By.cssSelector(".odabir-studija-godina")).getText());
    }
}
