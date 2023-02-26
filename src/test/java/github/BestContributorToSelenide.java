package github;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class BestContributorToSelenide {

    @Test
    void andreiSolntsevShouldBeTheFirstContributor() {
        Configuration.browserSize="800x400";
        Configuration.browser="firefox";

        // открыть страницу репозитория селенида
        open ("https://github.com/selenide/selenide");
        // подвести мышку к первому аватару из блока contributors
        $("div.Layout-sidebar").$(byText("Contributors"))
//                .closest("div.BorderGrid-cell").$$("ul li").first().hover();
            .closest("h2").sibling(0).$$("li").first().hover();

//        $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
        Selenide.sleep(3000);
        // проверка: во всплывающем окне есть текст Andrei Solntsev

    }
}
