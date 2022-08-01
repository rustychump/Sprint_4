package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pageObject.locators.LocAboutRentPage.*;

public class AboutRentPage {
    private WebDriver driver;
    private By calendarField = By.cssSelector(locCalendarField);
    private By rentalPeriodField = By.className(locRentalPeriodField);
    private By orderButton = By.xpath(locAboutRentPageOrderButton);
    private By yesButton = By.xpath(locYesButton);
    private By seeStatusButton = By.xpath(locSeeStatusButton);

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadAboutRentPage(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className(locOrderHeader)));
    }

    //метод выбирает дату из выпадающего календаря
    public void selectDate(int option) {
        driver.findElement(calendarField).click();
        if (option == 1) {
            driver.findElement(By.className(locDatePickerTodayIcon)).click();
        } else if (option == 2) {
            driver.findElement(By.xpath(locDatePickerFirstWeekSundayIcon)).click();
        }
    }

    //метод выбирает срок аренды из выпадающего списка
    public void selectRentalPeriod(int option) {
        driver.findElement(rentalPeriodField).click();
        if (option == 1) {
            driver.findElement(By.xpath(locDropdownOptionDay)).click();
        } else if (option == 2) {
            driver.findElement(By.xpath(locDropdownOption2Day)).click();
        }
    }

    //метод кликат на кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //метод кликает на кнопку Да
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    //метод проверяет, что появилось всплывающее окно с сообщением об успешном создании заказа
    public void findPopupWindow() {
        driver.findElement(seeStatusButton).click();
    }

    //метод заполняет обязательные поля на странице Про аренду, кликает по кнопке Заказать и проверяет, что появилось всплывающее окно с сообщением об успешном создании заказа
    public void enterAboutRentPage(int option) {
        selectDate(option);
        selectRentalPeriod(option);
        clickOrderButton();
        clickYesButton();
        findPopupWindow();
    }


}
