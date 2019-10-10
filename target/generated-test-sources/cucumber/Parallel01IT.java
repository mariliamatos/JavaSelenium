import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"C:/Users/gsw.mariliam/eclipse-workspace/testes-automatizados2/src/test/resources/functionalTests/Enriquecimento.feature"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:C:/Users/gsw.mariliam/eclipse-workspace/testes-automatizados2/target/cucumber-reports/html/1.html", "json:C:/Users/gsw.mariliam/eclipse-workspace/testes-automatizados2/target/cucumber-reports/1.json", "html:C:/Users/gsw.mariliam/eclipse-workspace/testes-automatizados2/target/cucumber-reports/1", "rerun:C:/Users/gsw.mariliam/eclipse-workspace/testes-automatizados2/target/cucumber-reports/1.txt", "pretty"},
        monochrome = true,
        tags = {"@teste6_e"},
        glue = {"stepDefinitions"})
public class Parallel01IT extends AbstractTestNGCucumberTests {
}
