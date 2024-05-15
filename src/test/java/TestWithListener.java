import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithListener {

    @Test
    void issue2712ShouldBeVisible() {

        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("a[href='/selenide/selenide']").click();
        $("#issues-tab").click();
        $(withText("#2712")).shouldBe(Condition.visible);
    }
}
