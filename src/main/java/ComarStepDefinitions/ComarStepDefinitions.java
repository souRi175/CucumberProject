package ComarStepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ComarStepDefinitions {
    private WebDriver driver;

    @Given("I am on the website {string}")
    public void iAmOnTheWebsite(String url) {
        // Enable logging for Chrome (Optional - Uncomment if needed)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");

        // ChromeOptions options = new ChromeOptions();
        // options.setCapability("goog:loggingPrefs", "{\"browser\": \"ALL\"}");
        // driver = new ChromeDriver(options);
        driver = new ChromeDriver();

        driver.get(url);
    }

    @When("I click on the {string} section")
    public void iClickOnSection(String section) {
        WebElement sectionLink = driver.findElement(By.linkText(section));
        sectionLink.click();
    }

    @Then("the page {string} is opened")
    public void thePageIsOpened(String pageName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + pageName + "')]")));
    }

    @When("I enter {string} in the search form and submit the search")
    public void iEnterSearchQuery(String query) {
        WebElement searchInput = driver.findElement(By.name("searchMeta"));
        searchInput.sendKeys(query);
        searchInput.submit();
    }

    @Then("I should see {string} in the search results")
    public void iShouldSeeSearchResult(String resultText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + resultText + "')]")));
    }

    @After
    public void tearDown() {
        // Close the browser after each scenario
        driver.quit();
    }
}
