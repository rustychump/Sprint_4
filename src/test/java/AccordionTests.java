import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;

@RunWith(Parameterized.class)
public class AccordionTests {
    private final String urlScooter = "https://qa-scooter.praktikum-services.ru/";
    private final int num;
    private WebDriver driver;

    public AccordionTests(int num) {
        this.num = num;
    }

    @Parameterized.Parameters
    public static Object[][] getDataAccordion() {
        return new Object[][] {
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7}
        };
    }

    @Test
    public void compareAnswersAccordion() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(urlScooter);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.compareAccordionList(num);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
