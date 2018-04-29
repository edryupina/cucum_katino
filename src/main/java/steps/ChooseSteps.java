package steps;
import pages.ChoosePage;
import ru.yandex.qatools.allure.annotations.Step;

public class ChooseSteps {
    @Step("Выбрана минимальная сумма")
    public void stepChooseMinSum() {
        new ChoosePage().minSum.click();
    }
    @Step("Нажата кнопка - Оформить")
    public void stepClickFormalizeButton() {
        new ChoosePage().formalizeButton.click();
    }
}
