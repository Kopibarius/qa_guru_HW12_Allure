import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithListener {

//    @BeforeAll
//    static void beforeAll() {
//        Configuration.browser = "firefox";
//    }

    @DisplayName("Тест просто с алюром")
    @Test
    void issue2712ShouldBeVisible() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("a[href='/selenide/selenide']").click();
        $("#issues-tab").click();
        $(withText("#2712")).shouldBe(Condition.visible);
    }
}
