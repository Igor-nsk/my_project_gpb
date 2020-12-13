import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;


public class OneTest {


    @Test
    public void SearchFirstLaptopFromListOnMarketPageForChooseBrands() {
        HomePage.openHomePage(HomePage.BASE_URL);
        HomePage.choiceMarket();
        MarketPage.choiceComputer();
        MarketPage.choiceLaptop();
        MarketPage.scrollToFeaturedBrands();
        MarketPage.chooseLenovo();
        MarketPage.chooseHP();
        MarketPage.chooseView(MarketPage.NUMBER_ELEMENTS);
        MarketPage.searchAndCheckPriceFirstProductOnPage();
    }

    @Test
    public void testsTwo() {
        HomePage.openHomePage(HomePage.BASE_URL);
        HomePage.choiceMarket();
        MarketPage.choiceComputer();
        MarketPage.chooseTablet();
        MarketPage.scrollToPrice();
        MarketPage.setMinPrice("20000");
        MarketPage.setMaxPrice("25000");
        MarketPage.chooseApple();
        MarketPage.chooseHuawei();
        Selenide.sleep(1000);
    }
}