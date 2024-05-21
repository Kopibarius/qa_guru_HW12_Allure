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
import static io.qameta.allure.Allure.step;

public class TestWithLambda {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
    }

    @DisplayName("Тест с лямбда степами")
    @Test
    void issue2712ShouldBeVisible() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу Github", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий по названию 'selenide'", () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue("selenide").pressEnter();
        });

        step("Переходим в репозиторий selenide/selenide", () -> {
            $("a[href='/selenide/selenide']").click();
        });

        step("Переходим в раздел 'issue'", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем что у нас отображается issue с номером '#2712'", () -> {
            $(withText("#2712")).shouldBe(Condition.visible);
        });

    }
}
