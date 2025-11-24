package tests.lesson10;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

@Epic("Allure Test")
@Feature("Проверка работы Allure")
public class SimpleAllureTest {

    @Test
    @Description("Простой тест для проверки генерации Allure отчетов")
    @Severity(SeverityLevel.CRITICAL)
    public void testAllureReporting() {
        step("Шаг 1: Начало теста");
        step("Шаг 2: Проверка работы");
        step("Шаг 3: Завершение теста");
        System.out.println("Allure тест выполнен!");
    }
}