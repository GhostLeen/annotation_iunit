package denal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ValueSourceAliTest extends TestBase {

    @ParameterizedTest(name = "Отображение фильтра {0} при поисковом запросе Toys")
    @ValueSource(strings = {"Цена", "Бренды"})
    void checkFiltersByToysSearch(String filter) {
        $("#searchInput").setValue("Toys").pressEnter();
        $$(".snow-ali-kit_Typography__base__1shggo").find(text(filter)).shouldHave(text(filter));
    }
}