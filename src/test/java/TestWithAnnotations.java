import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestWithAnnotations {

//    @BeforeAll
//    static void beforeAll() {
//        Configuration.browser = "firefox";
//    }

    @DisplayName("Тест с анотациями")
    @Test
    void issue2712ShouldBeVisible() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        StepAnnotations stepAnnotations = new StepAnnotations();

        stepAnnotations.openWedSite();
        stepAnnotations.findInSearchLine("selenide");
        stepAnnotations.redirectInRepositorySelenideFromResultPage();
        stepAnnotations.goToIssueTabInRepositoryPage();
        stepAnnotations.assertThatIssueWithNumberExist(2712);

    }
}
