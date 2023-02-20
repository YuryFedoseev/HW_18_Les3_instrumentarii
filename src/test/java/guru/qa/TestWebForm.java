package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class TestWebForm {
    @Test
    void SmoakSearch() {
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Иван").pressTab();
        $("#lastName").setValue("Фамилию").pressTab();
        $("#userEmail").setValue("mail@muil.ru").pressTab();
        $(byTagAndText("Label", "Female")).click();
        $("#userNumber").setValue("9876543211").click();
        $("#dateOfBirthInput").doubleClick().pressEnter();
        //$("# css-2b097c-container").setValue("Мира");
        //$("#Current Address").setValue("Мира и гагарина");
        //$("#dateOfBirthInput").contextClick().clear();
        //$("#dateOfBirthInput").doubleClick().clear();
        //$("#dateOfBirthInput").setValue("18 Feb 2022").pressTab();
        //$("#subjects-label").setValue("Какой-то Sub");
        //$(byTagAndText("#col-md-9 col-sm-12","Reading")).click();

        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Иван"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Фамилию"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("mail@muil.ru"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Female"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("9876543211"));


    }
}
