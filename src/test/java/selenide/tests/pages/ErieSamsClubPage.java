package selenide.tests.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import selenide.tests.pages.common.CommonPage;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ErieSamsClubPage extends CommonPage {
    public static final String PAGE_URL = Configuration.baseUrl + "club/erie-pa-sams-club/6675?GAS=aL";

    public SelenideElement unleadedGas = $("[aria-label*='Unleaded']");

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
        return Objects.requireNonNull(Objects.requireNonNull(unleadedGas.shouldBe(visible.because("Unleaded gas price should be present on the page"))
                .getAttribute("aria-label")).substring(9));
    }

}
