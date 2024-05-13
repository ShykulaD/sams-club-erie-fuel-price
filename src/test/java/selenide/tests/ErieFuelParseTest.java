package selenide.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import selenide.tests.pages.ErieSamsClubPage;
import selenide.tests.testsuites.TestSuiteConst;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Tag(TestSuiteConst.FuelSuite)
public class ErieFuelParseTest {
    private final ErieSamsClubPage erieSamsClubPage = new ErieSamsClubPage();

    @Test
    public void unleadedParseTest() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy, hh:mm a", Locale.US);
        String formattedDateTime = dateFormat.format(currentDate);

        erieSamsClubPage.open();
        String unleadedPrice = erieSamsClubPage.getUnleadedPrice();

        try {
            PrintWriter writerGreetings = new PrintWriter("gasPriceGreetings.txt", StandardCharsets.UTF_8);
            writerGreetings.println("Now local USA time in Erie,PA is " + formattedDateTime + ".");
            writerGreetings.println("Unleaded gas price at Sam's Club Erie is " + unleadedPrice + ".");
            writerGreetings.close();

            PrintWriter justPrice = new PrintWriter("justPrice.txt", StandardCharsets.UTF_8);
            justPrice.println(unleadedPrice);
            justPrice.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
