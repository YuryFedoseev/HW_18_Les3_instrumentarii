package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestSpisan {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    //Configuration.browserSize = "1920*1080";
    @Test
    void demoQa() {
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("TestFirstName");
        $("#lastName").setValue("TestLastName");
        $("#userEmail").setValue("testUserEmail@test.ru");
        $("#genterWrapper").$(byText("Male")).click();;
        $("#userNumber").setValue("1735342525");
        $("#dateOfBirthInput").click();
        $(by("class", "react-datepicker__year-select")).$(byText("1996")).click();
        $(by("class", "react-datepicker__month-select")).$(byText("January")).click();
        $(by("class", "react-datepicker__month-container")).$(byText("27")).click();


        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();;
        $("#uploadPicture").uploadFromClasspath("pictures/ToolForm.png");

        $("#currentAddress").setValue("Moscow never sleep");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        //$("#react-select-3-option-2").click();
        //$(".css-1wa3eu0-placeholder").click();
        //$("#react-select-4-option-1").click();
        $("#submit").click();

        //Проверка
        $(".modal-body").shouldHave(text("TestFirstName TestLastName"));
        $(".modal-body").shouldHave(text("testUserEmail@test.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("1735342525"));
        $(".modal-body").shouldHave(text("27 January "));
        $(".modal-body").shouldHave(text("History"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("ToolForm.png"));
        $(".modal-body").shouldHave(text("Moscow never sleep"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
}}
