package util;
import gherkin.formatter.model.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

    @Override
    public void result(Result result) {
        if (result.getStatus().equals("failed")) {
            takeScreenshot();
        }
        super.result(result);
    }

    @Attachment(type = "image/png", value = "Скрин ошибки")
    public byte[] takeScreenshot (){
        return ((TakesScreenshot) steps.BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
