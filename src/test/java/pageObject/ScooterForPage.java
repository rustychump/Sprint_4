package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pageObject.locators.LocMainPage.locMainPageHeader;
import static pageObject.locators.LocScooterForPage.*;
import static pageObject.locators.LocCommonObjects.*;

public class ScooterForPage {
    private WebDriver driver;
    private By nameField = By.cssSelector(locNameField);
    private By surnameField = By.cssSelector(locSurnameField);
    private By addressField = By.cssSelector(locAddressField);
    private By metroField = By.className(locMetroField);
    private By phoneField = By.cssSelector(locPhoneField);
    private By nextButton = By.className(locNextButton);
    private By samokatLogo = By.xpath(locSamokatLogo);
    private By mainPageHeader = By.className(locMainPageHeader);




    public ScooterForPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadScooterForPage(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className(locOrderHeader)));
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
    public void inputMetroField(int option) {
        driver.findElement(metroField).click();
        //тут попробовал через option сделать через клавиши на клавиатуре для выбора разного значения в поле ввода станции метро на странице Для кого самокат
        /*for (int i = 0; i < option; i++) {
            driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        }
        driver.findElement(metroField).sendKeys(Keys.ENTER);*/
        driver.findElement(By.className("select-search__select")).click();
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
    public void enterScooterForPage(String name, String surname, String address, int option, String phone){
        inputNameField(name);
        inputSurnameField(surname);
        inputAddressField(address);
        inputMetroField(option);
        inputPhoneField(phone);
        clickNextButton();
    }
    //метод кликает по логотипу Самокат в шапке и проверяет, что загрузилась главная страница
    public void clickSamokatLogo(){
        driver.findElement(samokatLogo).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(mainPageHeader));
        driver.findElement(mainPageHeader);
    }


}
