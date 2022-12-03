package denal;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CsvSourceAliTest extends TestBase {

    @ParameterizedTest(name = "Проверка соответствия заголовка страницы {1} при переходе по имени категории {0} ")
    @CsvSource(value = {"Спорт и развлечения|Спорт и развлечения", "Компьютеры и офис|Компьютеры и офис"},
            delimiter = '|')
    @Tag("Critical")
    void checkCategoryMatching(String categoryName, String categoryHeader) {
        $x("//span[contains(text(),'" + categoryName + "')]/preceding-sibling::div").click();
        $(".SnowSearchHeading_SnowSearchHeading__searchHeading__b9qvy").shouldBe(visible).shouldHave(text(categoryHeader));
    }
}