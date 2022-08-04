package pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;

public class MainPage {
    private WebDriver driver;
    private By orderButtonUp = By.className("Button_Button__ra12g");//кнопка Заказать в шапке страницы
    private By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");//кнопка заказать внизу страницы
    private By cookieButton = By.id("rcc-confirm-button");//кнопки принятия куки
    private By yandexLogo = By.xpath(".//img[@alt='Yandex']");//логотип Яндекса в шапке
    private By orderStatusButton = By.className("Header_Link__1TAG7");//кнопка Статус заказа
    private By orderNumberField = By.className("Input_Input__1iN_Z");//поле ввода Введите номер заказа
    private By goButton = By.className("Header_Button__28dPO");//кнопка Go!
    //массив, содержащий элементы спойлера вопросов о важном
    public static By[] accordionArray = {By.xpath(".//div[@id='accordion__heading-0']"), By.xpath(".//div[@id='accordion__heading-1']"), By.xpath(".//div[@id='accordion__heading-2']"), By.xpath(".//div[@id='accordion__heading-3']"), By.xpath(".//div[@id='accordion__heading-4']"), By.xpath(".//div[@id='accordion__heading-5']"), By.xpath(".//div[@id='accordion__heading-6']"), By.xpath(".//div[@id='accordion__heading-7']")};
    //массив, содержащий текст ответов на вопросы о важном
    public static By[] textAnswersArray = {By.xpath(".//div[@id='accordion__panel-0']/p"), By.xpath(".//div[@id='accordion__panel-1']/p"), By.xpath(".//div[@id='accordion__panel-2']/p"), By.xpath(".//div[@id='accordion__panel-3']/p"), By.xpath(".//div[@id='accordion__panel-4']/p"), By.xpath(".//div[@id='accordion__panel-5']/p"), By.xpath(".//div[@id='accordion__panel-6']/p"), By.xpath(".//div[@id='accordion__panel-7']/p")};


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод переходит на страницу заказа
    public void goOrderPage(int option) {
        driver.findElement(cookieButton).click();
        if (option == 1) {
            driver.findElement(orderButtonUp).click();
        } else if (option == 2) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonDown));
            driver.findElement(orderButtonDown).click();
        }
    }
    //метод сравнивает ответы в блоке Вопросы о важном внизу главной страницы
    public void compareAccordionList(int num) {
        String[] expectedText = {"Сутки — 400 рублей", "Пока что у нас так: один заказ", "Допустим, вы оформляете заказ на 8 мая", "Только начиная с завтрашнего дня", "Пока что нет! Но если что-то срочное", "Самокат приезжает к вам с полной зарядкой", "Да, пока самокат не привезли. Штрафа не будет", "Да, обязательно. Всем самокатов! И Москве"};
        driver.findElement(cookieButton).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(accordionArray[num]));
        driver.findElement(accordionArray[num]).click();
        MatcherAssert.assertThat(driver.findElement(textAnswersArray[num]).getText(), containsString(expectedText[num]));
    }
    //метод кликает по логотипу Яндекс в шапке
    public void clickYandexLogo(){
        driver.findElement(yandexLogo).click();
    }

    //метод проверяет, что в новой странице открылась и загрузилась главная страница Яндекса
    public void checkingOpeningMainPageYandex() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='home-logo__default']")));
        driver.findElement(By.className("input__input")).sendKeys("123");
    }

    //метод кликает на кнопку Статуса заказа, вводит несуществующий номер заказа и кликает на кнопку Go
    public void goPageNoSuchOrder() {
        driver.findElement(cookieButton).click();
        driver.findElement(orderStatusButton).click();
        driver.findElement(orderNumberField).sendKeys("1");
        driver.findElement(goButton).click();
    }

    //метод проверяет переход на страницу Такого заказа нет
    public void checkingOpeningPageNoSuchOrder() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("Track_Input__1g7lq")));
        driver.findElement(By.className("Track_Input__1g7lq")).sendKeys("123");
    }


}

