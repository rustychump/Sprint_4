import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.AboutRentPage;
import pageobject.MainPage;
import pageobject.ScooterForPage;

@RunWith(Parameterized.class)
public class PositiveOrderScooterTest {
    private final String urlScooter = "https://qa-scooter.praktikum-services.ru/";
    private final String name;
    private final String surname;
    private final String address;
    private final int orderButtonSelection;
    private final int metroStationSelection;
    private final int dateSelection;
    private final int rentalPeriodSelection;
    private final String phone;
    private WebDriver driver;

    public PositiveOrderScooterTest(String name, String surname, String address, int orderButtonSelection, String phone, int metroStationSelection, int dateSelection, int rentalPeriodSelection) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.orderButtonSelection = orderButtonSelection;
        this.phone = phone;
        this.metroStationSelection = metroStationSelection;
        this.dateSelection = dateSelection;
        this.rentalPeriodSelection = rentalPeriodSelection;
    }

    @Parameterized.Parameters
    public static Object[][] getDataPages() {
        return new Object[][] {
                {"Иван", "Иванов", "Пушкина, 1", 1, "89991112233", 1, 1, 1},
                {"Петр", "Петров", "Гоголя, 2", 2, "89994445566", 2, 2, 2}
        };
    }

    @Test
    public void positiveOrderScooter() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(urlScooter);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.goOrderPage(orderButtonSelection);

        ScooterForPage objScooterForPage = new ScooterForPage(driver);
        objScooterForPage.waitForLoadScooterForPage();
        objScooterForPage.enterScooterForPage(name,surname,address, metroStationSelection, phone);

        AboutRentPage objAboutRentPage = new AboutRentPage(driver);
        objAboutRentPage.waitForLoadAboutRentPage();
        objAboutRentPage.enterAboutRentPage(dateSelection, rentalPeriodSelection);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
