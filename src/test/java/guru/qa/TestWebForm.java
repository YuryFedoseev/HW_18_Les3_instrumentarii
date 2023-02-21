package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

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

    @Test
    void FullTest() {
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Иван").pressTab();
        $("#lastName").setValue("Фамилию").pressTab();
        $("#userEmail").setValue("mail@muil.ru").pressTab();
        $(byTagAndText("Label", "Female")).click();
        $("#currentAddress").setValue("Мира и Гагарина").pressTab().pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $(byTagAndText("Label", "Music")).click();

        File pictures = new File("src/test/resources/skrin/379-scaled.jpg");
        $("#uploadPicture").uploadFile(pictures);

        $("#state").click();
        $("#react-select-3-option-0").click();
/*      $("#css-1uccc91-singleValue").setValue("Haryana").pressEnter().click();
        $("#state").setValue("Haryana").pressEnter();
        $("#city").setValue("Karnal").pressEnter();
        Доделать, так не работает выбор нужного элемента*/


        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#userNumber").setValue("9876543211").pressEnter();

//Выбор даты от учителя
       /* $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("option[value='3']").click();
        $(".react-datepicker__year-select").click();
        $("option[value='2005']").click();
        $("div[aria-label='Choose Sunday, April 3rd, 2005']").click();*/

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

    }
}
