import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepAnnotations {

    @Step("Открываем главную страницу")
    public void openWedSite() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий по названию 'selenide'")
    public void findInSearchLine(String nameOfFindingRepository) {
        $(".header-search-button").click();
        $("#query-builder-test").setValue(nameOfFindingRepository).pressEnter();
    }

    @Step("Переходим в репозиторий selenide/selenide")
    public void redirectInRepositorySelenideFromResultPage() {
        $("a[href='/selenide/selenide']").click();
    }

    @Step("Переходим в раздел 'issue'")
    public void goToIssueTabInRepositoryPage() {
        $("#issues-tab").click();
    }

    @Step("Проверяем что у нас отображается issue с номером '#2712'")
    public void assertThatIssueWithNumberExist(Integer numberOfIssue) {
        $(withText("#" + numberOfIssue)).shouldBe(Condition.visible);

    }
}
