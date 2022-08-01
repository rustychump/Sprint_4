import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;
import pageObject.ScooterForPage;

public class AddTasks {
    private WebDriver driver;

    @Test
    public void MainPageAfterClickLogo() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        ScooterForPage objScooterPage = new ScooterForPage(driver);
        objMainPage.goOrderPage(1);
        objScooterPage.clickSamokatLogo();
    }

    @Test
    public void NewPageYandex() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickYandexLogo();
    }

    @Test
    public void OpenPageNoSuchOrderAfterInvalidNumberOrder() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.goPageNoSuchOrder();

    }

    @After
    public void teardown(){
        driver.quit();
    }
}
