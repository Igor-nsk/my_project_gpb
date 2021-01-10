import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;


public class TestYandexMarket {


    @Test
    public void SearchFirstLaptopsFromListOnMarketPageForChooseBrands() {
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
    public void FilteredTwoBrandsAndCheckPriceBetweenRange() {
        HomePage.openHomePage(HomePage.BASE_URL);
        HomePage.choiceMarket();
        MarketPage.choiceComputer();
        MarketPage.chooseTablet();
        MarketPage.scrollToPrice();
        MarketPage.chooseApple();
        MarketPage.chooseHuawei();
        MarketPage.setMinPrice("20000");
        MarketPage.setMaxPrice("25000");
        Selenide.sleep(3000);
        MarketPage.checkPriceBetweenRange();
    }
}