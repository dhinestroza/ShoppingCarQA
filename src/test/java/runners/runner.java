package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import page.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepsdefinitions",
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        monochrome = true,
        tags = "@qa"
)
public class runner {
    @AfterClass
    public static void cleanBrowser(){
        BasePage.closeBrowser();
    }
}
