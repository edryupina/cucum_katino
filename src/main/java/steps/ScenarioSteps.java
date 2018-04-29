package steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    TravelSteps travelSteps = new TravelSteps();
    ChooseSteps chooseSteps = new ChooseSteps();
    ParametrSteps parametrSteps = new ParametrSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMainMenuItem(String menuName) {
        mainSteps.stepSelectMainMenu(menuName);
    }

    @Then("^выбран пункт меню Страхование путешественников$")
    public void selectSubMenuItem() {
        mainSteps.stepSelectSubMenu();
    }

    @When("^выполнена проверка заголовка - \"(.+)\"$")
    public void checkTitle(String title) {
        travelSteps.stepCheckTitle(title);
    }

    @Then("^выполнено нажатие на кнопку - Оформить Онлайн$")
    public void clickSendButton() {
        travelSteps.stepSendButton();
    }


    @When("^выбрана минимальная сумма$")
    public void checkMinSum() {
        chooseSteps.stepChooseMinSum();
    }

    @Then("^выполнено нажатие на кнопку - Оформить$")
    public void clickFormalizeButton() {
        chooseSteps.stepClickFormalizeButton();
    }

    @When("^заполняются поля:$")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> parametrSteps.stepFillField(key, value));
    }

    @Then("^значения полей равны:$")
    public void checkFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (field, value) -> parametrSteps.stepCheckFillField(field, value)
        );
    }

    @When("^выполнено нажатие на кнопку - Продолжить$")
    public void clickNext() {
        parametrSteps.stepClickButtonNextReg();
    }

    @Then("^выполнена проверка ошибочного сообщения - \"(.+)\"$")
    public void checkMassage(String massageErr) {
        parametrSteps.stepCheckMassegeError(massageErr);
    }

}
