import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import pageobject.ScooterForPage;

public class AddTasks {
    private final String urlScooter = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;

    @Test
    public void mainPageAfterClickLogo() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(urlScooter);

        MainPage objMainPage = new MainPage(driver);
        ScooterForPage objScooterPage = new ScooterForPage(driver);
        objMainPage.goOrderPage(1);
        objScooterPage.clickScooterLogo();
        objScooterPage.checkingOpeningMainPageScooter();
    }

    @Test
    public void newPageYandex() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(urlScooter);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickYandexLogo();
        objMainPage.checkingOpeningMainPageYandex();
    }

    @Test
    public void openPageNoSuchOrderAfterInvalidNumberOrder() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(urlScooter);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.goPageNoSuchOrder();
        objMainPage.checkingOpeningPageNoSuchOrder();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
