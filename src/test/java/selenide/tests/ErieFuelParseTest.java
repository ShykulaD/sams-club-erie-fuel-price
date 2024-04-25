package selenide.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import selenide.tests.pages.ErieSamsClubPage;
import selenide.tests.testsuites.TestSuiteConst;

import java.time.LocalDate;

@Tag(TestSuiteConst.FuelSuite)
public class ErieFuelParseTest {
    private ErieSamsClubPage erieSamsClubPage = new ErieSamsClubPage();

    @Test
    public void unleadedParseTest() {
        LocalDate currentDate = LocalDate.now();

        erieSamsClubPage.open();
        String unleadedPrice = erieSamsClubPage.getUnleadedPrice();
        System.out.println("Now local USA time in Erie,PA is " + currentDate + " and Unleaded gas price is " + unleadedPrice);
    }
}
