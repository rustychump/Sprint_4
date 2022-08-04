package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ScooterForPage {
    private WebDriver driver;
    private By nameField = By.cssSelector(".Input_Input__1iN_Z[placeholder = '* Имя']");//поле ввода Имя
    private By surnameField = By.cssSelector(".Input_Input__1iN_Z[placeholder = '* Фамилия']");//поле ввода Фамилия
    private By addressField = By.cssSelector(".Input_Input__1iN_Z[placeholder = '* Адрес: куда привезти заказ']");//поле ввода Адрес
    private By metroField = By.className("select-search__input");//поле выбора Станции метро
    private By phoneField = By.cssSelector(".Input_Input__1iN_Z[placeholder = '* Телефон: на него позвонит курьер']");//поле ввода Телефона
    private By nextButton = By.className("Button_Middle__1CSJM");//кнопка Далее
    private By samokatLogo = By.xpath(".//img[@alt='Scooter']");//заголовок страницы
    private By orderHeader = By.className("Order_Header__BZXOb");
    private By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");//кнопка заказать внизу главной страницы




    public ScooterForPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadScooterForPage(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
    }

    //метод заполняет поле ввода Имя
    public void inputNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //метод заполняет поле ввода Фамилмя
    public void inputSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    //метод заполняет поле ввода Фамилмя
    public void inputAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //метод заполняет поле ввода Метро
    public void inputMetroField(int metroStationSelection) {
        driver.findElement(metroField).click();
        //тут попробовал через option сделать через клавиши на клавиатуре для выбора разного значения в поле ввода станции метро на странице Для кого самокат
        for (int i = 0; i < metroStationSelection; i++) {
            driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        }
        driver.findElement(metroField).sendKeys(Keys.ENTER);
        //driver.findElement(By.className("select-search__select")).click();
    }

    //метод заполняет поле ввода Телефон
    public void inputPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    //метод кликает по кнопке Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //метод заполняет обязательные поля на странице Для кого самокат и кликает по кнопке Далее
    public void enterScooterForPage(String name, String surname, String address, int metroStationSelection, String phone){
        inputNameField(name);
        inputSurnameField(surname);
        inputAddressField(address);
        inputMetroField(metroStationSelection);
        inputPhoneField(phone);
        clickNextButton();
    }
    //метод кликает по логотипу Самокат в шапке
    public void clickScooterLogo(){
        driver.findElement(samokatLogo).click();
    }

    //метод проверяет, что загрузилась главная страница
    public void checkingOpeningMainPageScooter() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonDown));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonDown));
        driver.findElement(orderButtonDown).click();
    }


}
