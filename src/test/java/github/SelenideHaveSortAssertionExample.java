package github;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideHaveSortAssertionExample {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        // Открыть страницу репозитория селенида.
        open ("/selenide/selenide");

        // Перейди в раздел Wiki.
        $("#repository-container-header #wiki-tab").click();

        // Разворачиваем все имеющиеся страницы Pages.
        $(".Layout-sidebar button")
                .shouldBe(Condition.visible)
                .click();

        // Проверка, что в списке страниц (Pages) есть страница SoftAssertions и жмакаем если есть.
        $x("//div[@id='wiki-pages-box']//a[text()='SoftAssertions']")
                .shouldBe(Condition.visible)
                .click();

        // Проверка, что есть пример JUnit5.
        $x("//div[@id='wiki-body']//h4[contains(text(), 'Using JUnit5')]")
                .shouldBe(Condition.exist)
                .sibling(0)
                .shouldHave(
                        text("Class"),
                        text("@"),
                        text("Test"),
                        text("void"));
    }
}
