package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRentPage {
    private WebDriver driver;
    private By calendarField = By.cssSelector(".Input_Input__1iN_Z[placeholder = '* Когда привезти самокат']"); //выпадающий календарь Когда привезти самокт
    private By rentalPeriodField = By.className("Dropdown-placeholder"); //выпадающий список Срок аренды
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"); //кнопка Заказать
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']"); //кнопка Да
    private By seeStatusButton = By.xpath(".//button[text()='Посмотреть статус']");  //кнопка Посмотреть статус
    private By orderHeader = By.className("Order_Header__BZXOb"); //заголовок страницы
    private By datePickerTodayIcon = By.className("react-datepicker__day--today");//иконка сегодняшнего дня в выпадающем календаре
    private By datePickerFirstWeekSundayIcon = By.xpath(".//div[@class='react-datepicker__month']/div[1]/div[last()]"); //иконка воскресенья первой недели в выпадающем календаре
    private By dropdownOptionDay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");//опция Сутки в выпадающем списке Срок аренды
    private By dropdownOption2Day = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");//опция Двое суток в выпадающем списке Срок аренды

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadAboutRentPage(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
    }

    //метод выбирает дату из выпадающего календаря
    public void selectDate(int dateSelection) {
        driver.findElement(calendarField).click();
        if (dateSelection == 1) {
            driver.findElement(datePickerTodayIcon).click();
        } else if (dateSelection == 2) {
            driver.findElement(datePickerFirstWeekSundayIcon).click();
        }
    }

    //метод выбирает срок аренды из выпадающего списка
    public void selectRentalPeriod(int rentalPeriodSelection) {
        driver.findElement(rentalPeriodField).click();
        if (rentalPeriodSelection == 1) {
            driver.findElement(dropdownOptionDay).click();
        } else if (rentalPeriodSelection == 2) {
            driver.findElement(dropdownOption2Day).click();
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
    public void enterAboutRentPage(int dateSelection, int rentalPeriodSelection) {
        selectDate(dateSelection);
        selectRentalPeriod(rentalPeriodSelection);
        clickOrderButton();
        clickYesButton();
        findPopupWindow();
    }


}
