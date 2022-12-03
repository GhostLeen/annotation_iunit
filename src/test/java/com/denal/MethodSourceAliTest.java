package com.denal;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MethodSourceAliTest extends TestBase {

    static Stream<Arguments> checkFiltersByCategory() {
        return Stream.of(
                Arguments.of("Строительство и ремонт",
                        List.of("Электрика", "Бытовая техника", "Освещение", "Крепеж и фурнитура, клея и герметики",
                                "Сантехника", "Строительные материалы", "Все для кухни", "Краски и подготовка стен",
                                "Водоснабжение", "Умный дом")),
                Arguments.of("Продукты",
                        List.of("Зерновые продукты", "Кофе", "Чай", "Пищевые консервы", "Вода/соки/напитки",
                                "Бакалея", "Варенье и мёд", "Сушеные фрукты", "Орехи и семечки",
                                "Хлеб и кондитерские изделия", "Молоко и яйца"))
        );
    }

    @ParameterizedTest(name = "Проверка доступных подкатегорий {1} по категории {0}")
    @MethodSource
    void checkFiltersByCategory(String categoryName, List<String> filters) {
        $x("//span[contains(text(),'" + categoryName + "')]/preceding-sibling::div").click();
        $(".snow-ali-kit_Button-Secondary__button__4468ot").click();
        $$(".SnowSearchSubcategories_CategoriesSnippets__link__14ap2").filter(visible).
                shouldHave(CollectionCondition.texts(filters));
    }
}