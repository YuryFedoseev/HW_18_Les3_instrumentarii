package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestWebForm {
    @Test
    void smoakTest() {
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Иван").pressTab();
        $("#lastName").setValue("Фамилию").pressTab();
        $("#userEmail").setValue("mail@muil.ru").pressTab();
        $(byTagAndText("Label", "Female")).click();
        $("#userNumber").setValue("9876543211").click();
        $("#dateOfBirthInput").doubleClick().pressEnter();

        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Иван"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Фамилию"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("mail@muil.ru"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Female"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("9876543211"));

    }

    @Test
    void fullTest() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Иван").pressTab();
        $("#lastName").setValue("Фамилию").pressTab();
        $("#userEmail").setValue("mail@muil.ru").pressTab();
        $(byTagAndText("Label", "Female")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__day--0" + "01").click();

        $("#currentAddress").setValue("Мира и Гагарина").pressTab().pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $(byTagAndText("Label", "Music")).click();

        File pictures = new File("src/test/resources/skrin/379-scaled.jpg");
        $("#uploadPicture").uploadFile(pictures);
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#userNumber").setValue("9876543211").pressEnter();

        //Проверка финальной формы
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Иван"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Фамилию"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("mail@muil.ru"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Female"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("9876543211"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Chemistry"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Music"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("379-scaled.jpg"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Мира и Гагарина"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("NCR Delhi"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("01 January,2000"));
    }
}
