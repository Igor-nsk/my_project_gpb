import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.cssSelector;

public class MarketPage {
    public static final int NUMBER_ELEMENTS = 12;

    public static SelenideElement computers() {
        return $(new Selectors.ByText("Компьютеры"));
    }

    public static SelenideElement laptops() {
        return $(By.xpath("//ul[@class='_1Y6X2G3jjK']//*[@data-tid-prop='b8bff0b6 4778ddc5' and text()='Ноутбуки']"));
    }

    public static SelenideElement tablets() {
        return $(By.xpath("//ul[@class='_1Y6X2G3jjK']//*[@data-tid-prop='b8bff0b6 4778ddc5' and text()='Планшеты']"));
    }

    public static SelenideElement logoLaptops() {
        return $(cssSelector("[title=Ноутбуки]"));
    }

    public static SelenideElement logoTablets() {
        return $(cssSelector("[title=Планшеты]"));
    }


    public static SelenideElement checkBoxLenovo() {
        return $(By.xpath("//div[@class='LhMupC0dLR']/span[@class='NVoaOvqe58' and text()='Lenovo']"));
    }

    public static SelenideElement checkBoxHP() {
        return $(By.xpath("//div[@class='LhMupC0dLR']/span[@class='NVoaOvqe58' and text()='HP']"));
    }

    public static SelenideElement checkBoxApple() {
        return $(By.xpath("//div[@class='LhMupC0dLR']/span[@class='NVoaOvqe58' and text()='Apple']"));
    }

    public static SelenideElement checkBoxHuawei() {
        return $(By.xpath("//div[@class='LhMupC0dLR']/span[@class='NVoaOvqe58' and text()='HUAWEI']"));
    }

    public static SelenideElement brands() {
        return $(cssSelector(".ShXb4FpS5R"));
    }

    public static SelenideElement displayNumberProductButton() {
        return $(cssSelector(".vLDMfabyVq"));
    }

    public static SelenideElement dropListOption(int s) {
        return $(By.xpath("//button[@data-tid-prop='1badb8e1 65f9fd17' and text()='Показывать по " + s + "']"));
    }

    public static ElementsCollection listDisplayProducts() {
        return $$(By.xpath("//article[@data-autotest-id='product-snippet']//span[@data-tid='ce80a508']"));
    }

    public static ElementsCollection priceDisplayProducts() {
        return $$(By.xpath("//span[@data-autotest-currency='₽']/span"));
    }

    String firstProductOnPage = listDisplayProducts().get(0).getText();
    String firstProductPriceOnPage = priceDisplayProducts().get(0).getText();


    //  public static ElementsCollection priceDisplayProducts_nonspan() {
    //      return $$(By.xpath("//span[@data-autotest-currency='₽']"));
    //  }

    public static SelenideElement minPrice() {
        return $(cssSelector("#glpricefrom"));
    }

    public static SelenideElement maxPrice() {
        return $(cssSelector("#glpriceto"));
    }

    public static SelenideElement price() {
        return $(cssSelector(".babsHy47c5"));
    }

    public static SelenideElement inputSearchProduct() {
        return $(By.xpath("//div[@class='G4KLqAT1vi']/input[@type='text']"));
    }

    public static SelenideElement searchProductButton() {
        return $(cssSelector(".GVhpzCqwVU"));
    }

    public static void choiceComputer() {
        computers().click();
    }

    public static void choiceLaptop() {
        laptops().click();
        logoLaptops().shouldBe(Condition.visible);

    }

    public static void chooseTablet() {
        tablets().click();
        logoTablets().shouldBe(Condition.visible);

    }

    public static void chooseLenovo() {
        checkBoxLenovo().click();
    }

    public static void chooseHP() {
        checkBoxHP().click();
    }

    public static void chooseApple() {
        checkBoxApple().click();
    }

    public static void chooseHuawei() {
        checkBoxHuawei().click();
    }

    public static void scrollToFeaturedBrands() {
        brands().scrollIntoView(true);
    }

    public static void chooseView(int number) {
        displayNumberProductButton().scrollTo().click();
        dropListOption(number).click();
        Selenide.sleep(2000);
        int countElementsOnPage = listDisplayProducts().size();
        assertEquals(NUMBER_ELEMENTS, countElementsOnPage);
    }

    public static void saveNameAndPriceFirstProductOnPage() {
        // String firstProductOnPage = listDisplayProducts().get(0).innerText();
        //String firstProductOnPage = listDisplayProducts().get(0).getText();
        // String firstProductPriceOnPage = priceDisplayProducts().get(0).getText();
        //System.out.println(firstProductOnPage);
        //System.out.println(firstProductOnPage);
        //String firstProductPriceOnPage_inner = priceDisplayProducts().get(0).innerText();
        // String firstProductPriceOnPage_span = priceDisplayProducts_nonspan().get(0).getText();
        //String firstProductPriceOnPage_span_inner = priceDisplayProducts_nonspan().get(0).innerText();
        //System.out.println(firstProductPriceOnPage);
        //System.out.println(firstProductPriceOnPage_span_inner);
        //System.out.println(firstProductPriceOnPage_inner);
        //System.out.println(firstProductPriceOnPage_span);
    }

    public void searchAndCheckPriceFirstProductOnPage() {
        inputSearchProduct().sendKeys(firstProductOnPage);
        searchProductButton().click();
        assertEquals(firstProductOnPage, $$(By.xpath("//article[@data-autotest-id='product-snippet']//span[@data-tid='ce80a508']")).get(0).getText());
        assertEquals(firstProductPriceOnPage, $$(By.xpath("//span[@data-autotest-currency='₽']/span")).get(0).getText()
        );
    }

    public static void setMinPrice(String min) {
        minPrice().sendKeys(min);
    }

    public static void setMaxPrice(String max) {
        maxPrice().sendKeys(max);
    }

    public static void scrollToPrice() {
        price().scrollTo();
    }

}
