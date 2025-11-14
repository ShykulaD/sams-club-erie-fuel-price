package selenide.tests.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import selenide.tests.pages.common.CommonPage;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ErieSamsClubPage extends CommonPage {
    public static final String PAGE_URL = Configuration.baseUrl + "club/erie-pa-sams-club/6675?GAS=aL";

    public SelenideElement unleadedGas = $x("//div[contains(text(), 'Unleaded')]/..//span");

    public ErieSamsClubPage open() {
        Selenide.open(PAGE_URL);
        assertIsOpened();
        return this;
    }

    public ErieSamsClubPage assertIsOpened() {
        validateBasicLayout();
        return this;
    }

    public String getUnleadedPrice() {
        return Objects.requireNonNull(
                unleadedGas
                        .shouldBe(visible.because("Unleaded gas price should be present on the page"))
                        .getText()
        ).substring(9);
    }

}
