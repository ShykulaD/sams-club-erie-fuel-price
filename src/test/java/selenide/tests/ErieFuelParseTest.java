package selenide.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import selenide.tests.pages.ErieSamsClubPage;
import selenide.tests.testsuites.TestSuiteConst;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Tag(TestSuiteConst.FuelSuite)
public class ErieFuelParseTest {
    private ErieSamsClubPage erieSamsClubPage = new ErieSamsClubPage();

    @Test
    public void unleadedParseTest() throws FileNotFoundException, UnsupportedEncodingException {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy, hh:mm a", Locale.US);
        String formattedDateTime = dateFormat.format(currentDate);

        erieSamsClubPage.open();
        String unleadedPrice = erieSamsClubPage.getUnleadedPrice();

        PrintWriter writerGreetings = new PrintWriter("gasPriceGreetings.txt", "UTF-8");
        writerGreetings.println("Now local USA time in Erie,PA is " + formattedDateTime + ".");
        writerGreetings.close();

        PrintWriter writerPrice = new PrintWriter("gasPrice.txt", "UTF-8");
        writerPrice.println("Unleaded gas price at Sam's Club Erie is " + unleadedPrice + ".");
        writerPrice.close();
    }
}
