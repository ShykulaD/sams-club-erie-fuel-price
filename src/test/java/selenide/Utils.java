package selenide;

import com.codeborne.selenide.Selenide;

import java.time.Duration;
import java.util.Objects;

public class Utils {

    public static void documentReadyStateComplete() {
        documentReadyStateCompleteWithTimeout(20);
    }

    public static void documentReadyStateCompleteWithTimeout(int seconds) {
        Selenide.Wait()
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(200))
                .until(webDriver ->
                        Objects.requireNonNull(Selenide.executeJavaScript("return document.readyState"))
                                .toString().equalsIgnoreCase("complete")
                );
    }

}
