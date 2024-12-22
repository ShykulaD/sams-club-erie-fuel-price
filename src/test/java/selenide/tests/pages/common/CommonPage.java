package selenide.tests.pages.common;

import selenide.Utils;

public class CommonPage {

    public void validateBasicLayout() {
        Utils.documentReadyStateComplete();
    }

}
