import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.cssSelector;

public class HomePage {

    public static SelenideElement market() {return $(By.xpath("//div[@class='services-new__item-title' and text()='Маркет']"));}
    public static SelenideElement logoMarket() {return $(cssSelector("#logoPartMarket"));}
    public static final String BASE_URL = "https://yandex.ru/";


    public static void openHomePage(String url) {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open(url);
    }
    public static void choiceMarket() {
       market().click();
       switchTo().window(1);
       logoMarket().shouldBe(Condition.visible);

    }
}
