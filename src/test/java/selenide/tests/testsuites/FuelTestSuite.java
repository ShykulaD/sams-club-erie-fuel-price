package selenide.tests.testsuites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages({"selenide"})
@IncludeTags(TestSuiteConst.FuelSuite)
@SuiteDisplayName("Fuel Test Suite")
public class FuelTestSuite {
}
