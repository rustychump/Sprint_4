package pageObject.locators;

public class LocMainPage {

    //локатор кнопки заказать ниже на странице лендинга
    public static String locOrderButtonDown = ".//div[@class='Home_FinishButton__1_cWm']/button";
    //локатор кнопки куки
    public static String locCookieButton = "rcc-confirm-button";
    //локаторы выпадающего списка Вопросы о важном
    public static String[] locAccordionArray = {".//div[@id='accordion__heading-0']", ".//div[@id='accordion__heading-1']", ".//div[@id='accordion__heading-2']", ".//div[@id='accordion__heading-3']", ".//div[@id='accordion__heading-4']", ".//div[@id='accordion__heading-5']", ".//div[@id='accordion__heading-6']", ".//div[@id='accordion__heading-7']"};
    //локаторы текста ответов в выпадающем списке Вопросы о важном
    public static String[] locTextAnswersArray = {".//div[@id='accordion__panel-0']/p", ".//div[@id='accordion__panel-1']/p", ".//div[@id='accordion__panel-2']/p", ".//div[@id='accordion__panel-3']/p", ".//div[@id='accordion__panel-4']/p", ".//div[@id='accordion__panel-5']/p", ".//div[@id='accordion__panel-6']/p", ".//div[@id='accordion__panel-7']/p"};
    public static String locMainPageHeader = "Home_Header__iJKdX";
}
