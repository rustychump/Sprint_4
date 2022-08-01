import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.AboutRentPage;
import pageObject.MainPage;
import pageObject.ScooterForPage;

@RunWith(Parameterized.class)
public class SmokeSamokatTests {
    private final String name;
    private final String surname;
    private final String address;
    private final int option;
    private final String phone;
    private WebDriver driver;

    public SmokeSamokatTests(String name, String surname, String address, int option, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.option = option; //для выбора кнопки заказать на главной странице, выбора станции метро на странице Для кого самокат, выбора даты и срока аренды на странице Про аренду использовал параметр option
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getDataPages() {
        return new Object[][] {
                {"Иван", "Иванов", "Пушкина, 1", 1, "89991112233"},
                {"Петр", "Петров", "Гоголя, 2", 2, "89994445566"}
        };
    }

    @Test
    public void smokeTest() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.goOrderPage(option);

        ScooterForPage objScooterForPage = new ScooterForPage(driver);
        objScooterForPage.waitForLoadScooterForPage();
        objScooterForPage.enterScooterForPage(name,surname,address, option, phone);

        AboutRentPage objAboutRentPage = new AboutRentPage(driver);
        objAboutRentPage.waitForLoadAboutRentPage();
        objAboutRentPage.enterAboutRentPage(option);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
