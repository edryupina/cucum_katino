package steps;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("Выбран пункт меню - Застраховать себя и имущество")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Выбран пункт меню - Страхование путешественников")
    public void stepSelectSubMenu() {
        new MainPage().selectSubMenu();
    }
}
