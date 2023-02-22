package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class TestCleanWebForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "720x880";
    }

    @Test
    void FullTest() {
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ivan").pressTab();
        $("#lastName").setValue("Kuzmin").pressTab();
        $("#userEmail").setValue("mail@muil.ru").pressTab();
        $(byTagAndText("Label", "Female")).click();
        $("#currentAddress").setValue("Lenina Street").pressTab().pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $(byTagAndText("Label", "Music")).click();

        File pictures = new File("src/test/resources/skrin/379-scaled.jpg");
        $("#uploadPicture").uploadFile(pictures);

        $("#state").click();
        $("#react-select-3-option-0").click();

        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#userNumber").setValue("9876543211").click();

        $("#submit").pressEnter();

        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Ivan"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Kuzmin"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("mail@muil.ru"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Female"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("9876543211"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Chemistry"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Music"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("379-scaled.jpg"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Lenina Street"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("NCR Delhi"));

    }
}
