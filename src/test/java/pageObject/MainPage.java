package pageObject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static pageObject.locators.LocCommonObjects.*;
import static pageObject.locators.LocMainPage.*;

public class MainPage {
    private WebDriver driver;
    private By orderButtonUp = By.className(locOrderButtonUp);
    private By orderButtonDown = By.xpath(locOrderButtonDown);
    private By yandexLogo = By.xpath(locYandexLogo);
    private By orderStatusButton = By.className(locOrderStatusButton);
    private By orderNumberField = By.className(locOrderNumberField);
    private By goButton = By.className(locGoButton);

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод переходит на страницу заказа
    public void goOrderPage(int option) {
        driver.findElement(By.id(locCookieButton)).click();
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
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(locAccordionArray[num])));
        driver.findElement(By.xpath(locAccordionArray[num])).click();
        MatcherAssert.assertThat(driver.findElement(By.xpath(locTextAnswersArray[num])).getText(),containsString(expectedText[num]));
    }
    //метод кликает по логотипу Яндекс в шапке и проверяет, что в новой странице открылась и загрузилась главная страница Яндекса
    public void clickYandexLogo(){
        driver.findElement(yandexLogo).click();

        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='home-logo__default']")));
        driver.findElement(By.xpath(".//div[@class='home-logo__default']"));
    }
    //метод кликает на кнопку Статуса заказа, вводит несуществующий номер заказа и проверяет переход на страницу такого заказа нет
    public void goPageNoSuchOrder() {
        driver.findElement(By.id(locCookieButton)).click();
        driver.findElement(orderStatusButton).click();
        driver.findElement(orderNumberField).sendKeys("1");
        driver.findElement(goButton).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//img[@alt='Not found']")));
        driver.findElement(By.xpath(".//img[@alt='Not found']"));
    }


}

