package steps;
import org.openqa.selenium.WebElement;
import pages.ParametrPage;
import ru.yandex.qatools.allure.annotations.Step;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParametrSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String fieldName, String value) {
        new ParametrPage().filledData(fieldName, value);
    }


    @Step("поле {0} заполнено значением {1}")
    public void stepCheckFillField(String field, String value) {

        String actual = new ParametrPage().getCheckField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("Пол заполнен верно")
    public void stepCheckMale(WebElement female){
        new ParametrPage().female.click();
        assertTrue("Неверно заполнен пол", female.isSelected());
    }


    @Step("Выполнено нажатие на кнопку - Продолжить")
    public void stepClickButtonNextReg() {
        new ParametrPage().nextReg.click();
    }

    @Step("Выполнена проверка сообщения об ошибке")
    public void stepCheckMassegeError(String expecteErrorMassage) {
        String actualErrorMassage = new ParametrPage().errorMassage.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualErrorMassage, expecteErrorMassage), expecteErrorMassage, actualErrorMassage);
    }

}
