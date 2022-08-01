package pageObject.locators;

public class LocAboutRentPage {
    //локатор выпадающего календаря Когда привезти самокт
    public static String locCalendarField = ".Input_Input__1iN_Z[placeholder = '* Когда привезти самокат']";
    // локатор выпадающего списка Срок аренды
    public static String locRentalPeriodField = "Dropdown-placeholder";
    // локатор кнопки Заказать
    public static String locAboutRentPageOrderButton = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']";
    // локатор кнопки Да
    public static String locYesButton = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']";
    // локатор всплывающего окна с сообщением об успешном создании заказа
    public static String locSeeStatusButton = ".//button[text()='Посмотреть статус']";
    //локатор иконки сегодняшнего числа в выпадающем календаре
    public static String locDatePickerTodayIcon = "react-datepicker__day--today";
    //локатор иконки воскресенья первой недели в выпадающем календаре
    public static String locDatePickerFirstWeekSundayIcon = ".//div[@class='react-datepicker__month']/div[1]/div[last()]";
    //локатор опции Сутки в выпадающем списке Срок аренды
    public static String locDropdownOptionDay = ".//div[@class='Dropdown-option' and text()='сутки']";
    //локатор опции Двое суток в выпадающем списке Срок аренды
    public static String locDropdownOption2Day = ".//div[@class='Dropdown-option' and text()='двое суток']";
    //локатор заголовка страницы
    public static String locOrderHeader = "Order_Header__BZXOb";
}
