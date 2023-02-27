package the.internet;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class DragAndDrop {

    @Test
    void testDragAndDropWithActionsSimple() {
        //!!! Текущий способ не работает.

        // Открываем сайт.
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Инициализация прямоугольников А и В?
        SelenideElement rectangleA = $("#column-a");
        SelenideElement rectangleB = $("#column-b");

        // Проверяем, что прямоугольник А слева, В - справа и присваиваем их переменным
        rectangleA.shouldHave(text("A"));
        rectangleB.shouldHave(text("B"));

        // Перенесите прямоугольник А на место В.
        actions().clickAndHold(rectangleA).moveToElement(rectangleB).release().build().perform();

        //  Проверьте, что прямоугольники действительно поменялись
        rectangleA.shouldHave(text("B"));
        rectangleB.shouldHave(text("A"));
    }

    @Test
    void testDragAndDropWithActionsDragAndDrop() {
        //!!! Текущий способ не работает.

        // Открываем сайт.
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Инициализация прямоугольников А и В?
        SelenideElement rectangleA = $("#column-a");
        SelenideElement rectangleB = $("#column-b");

        // Проверяем, что прямоугольник А слева, В - справа и присваиваем их переменным
        rectangleA.shouldHave(text("A"));
        rectangleB.shouldHave(text("B"));

        // Перенесите прямоугольник А на место В.
        actions().dragAndDrop(rectangleA, rectangleB).build().perform();

        //  Проверьте, что прямоугольники действительно поменялись
        rectangleA.shouldHave(text("B"));
        rectangleB.shouldHave(text("A"));
    }

    @Test
    void testDragAndDropWithDragAndDrop() {
        // Текущий способ работает.

        // Открываем сайт.
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Инициализация прямоугольников А и В?
        SelenideElement rectangleA = $("#column-a");
        SelenideElement rectangleB = $("#column-b");

        // Проверяем, что прямоугольник А слева, В - справа и присваиваем их переменным
        rectangleA.shouldHave(text("A"));
        rectangleB.shouldHave(text("B"));

        // Перенесите прямоугольник А на место В.
        rectangleA.dragAndDropTo(rectangleB);

        //  Проверьте, что прямоугольники действительно поменялись
        rectangleA.shouldHave(text("B"));
        rectangleB.shouldHave(text("A"));

        Selenide.sleep(5000);
    }
}
