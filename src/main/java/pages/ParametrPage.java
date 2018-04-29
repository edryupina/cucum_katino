package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class ParametrPage {

    @FindBy(name = "insured0_surname")
    WebElement insured0Surname;

    @FindBy(name = "insured0_name")
    WebElement insured0Name;

    @FindBy(name = "insured0_birthDate")
    WebElement insured0BirthDate;

    @FindBy(name = "surname")
    WebElement surname;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(name = "female")
    public WebElement female;

    @FindBy(name = "passport_series")
    WebElement passportseries;

    @FindBy(name = "passport_number")
    WebElement passportnumber;

    @FindBy(name = "issueDate")
    WebElement issuedate;

    @FindBy(name = "issuePlace")
    WebElement issueplace;

    @FindBy(xpath = "//span[text()='Продолжить']")
    public WebElement nextReg;

    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    public WebElement errorMassage;


    public ParametrPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);

        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(birthDate));
        wait.until(ExpectedConditions.visibilityOf(nextReg));
}

    public void filledData(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                filledData(insured0Surname, value);
                break;
            case "Имя застрахованного":
                filledData(insured0Name, value);
                break;
            case "Дата рождения застрахованного":
                filledData(insured0BirthDate, value);
                break;
            case "Фамилия страхователя":
                filledData(surname, value);
                break;
            case "Имя страхователя":
                filledData(name, value);
                break;
            case "Отчество страхователя":
                filledData(middlename, value);
                break;
            case "Дата рождения страхователя":
                birthDate.click();
                filledData(birthDate, value);
                break;
            case "Пол страхователя":
                female.click();
                break;
            case "Серия паспорта":
                filledData(passportseries, value);
                break;
            case "Номер паспорта":
                filledData(passportnumber, value);
                break;
            case "Дата выдачи паспорта":
                filledData(issuedate, value);
                break;
            case "Кем выдан":
                filledData(issueplace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }


    public void filledData(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public String getCheckField(String checkFieldName) {
        switch (checkFieldName) {
            case "Фамилия застрахованного":
                return insured0Surname.getAttribute("value");
            case "Имя застрахованного":
                return insured0Name.getAttribute("value");
            case "Дата рождения застрахованного":
                return insured0BirthDate.getAttribute("value");
            case "Фамилия страхователя":
                return surname.getAttribute("value");
            case "Имя страхователя":
                return name.getAttribute("value");
            case "Отчество страхователя":
                return middlename.getAttribute("value");
            case "Дата рождения страхователя":
                return birthDate.getAttribute("value");
            case "Пол страхователя":
                if (female.isSelected()){
                    return "";
                }
                else {return "Неверный пол";}
            case "Серия паспорта":
                return passportseries.getAttribute("value");
            case "Номер паспорта":
                return passportnumber.getAttribute("value");
            case "Дата выдачи паспорта":
                return issuedate.getAttribute("value");
            case "Кем выдан":
                return issueplace.getAttribute("value");

        }
        throw new AssertionError("Поле не объявлено на странице");
    }


}

