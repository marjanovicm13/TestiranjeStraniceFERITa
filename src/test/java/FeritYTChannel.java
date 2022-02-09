import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;


public class FeritYTChannel {
    WebDriver driver;
    WebDriverWait wait;
    By YTChannel = By.xpath("/html/body/div[9]/div[1]/div/ul/li[10]/a/i");
    By YTChannelTitle = By.id("//*[@id=\"button\"]");

    public FeritYTChannel(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
    }

    public void goToYTChannel(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(YTChannel));
        String currentTab = driver.getWindowHandle();
        driver.findElement(YTChannel).click();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ytd-channel-name.ytd-c4-tabbed-header-renderer > div:nth-child(1) > div:nth-child(1) > yt-formatted-string:nth-child(1)")));
    }
}
