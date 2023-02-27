package github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class CheckDropDownSolutions {

    @Test
    void shouldFindEnterpriseSolution() {
        // Открываем главную страницу GitHub.
        open("https://github.com");

        // Задерживаем мышку над пунктом Solutions.
        $(withTagAndText("button", "Solutions"))
                .shouldBe(visible)
                .hover();

        // Жмакаем на Enterprize
        $(Selectors.withTagAndText("a", "Enterprise"))
                .shouldBe(visible)
                .click();

        // Проверяем, что перешлия в страницу Enterprise.
        $(".enterprise-hero > div").shouldHave(
                text("GitHub for enterprises"),
                text("Build like the best"),
                text("Build like the best"),
                text("Start a free trial")
        );
        Assertions.assertTrue(WebDriverRunner.url().contains("/enterprise"));
    }
}
