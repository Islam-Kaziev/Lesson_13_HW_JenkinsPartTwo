package tests.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationTests extends TestBase {


    @Test
    void StudentRegistrationForm() {
        step("Open registrations form", () -> {
            open("/automation-practice-form");
        });
        step("Fill form", () -> {
            $("#firstName").setValue("Islam");
            $("#lastName").setValue("Kaziev");
            $("#userEmail").setValue("Islam@Vasiya.com");
            $("#gender-radio-1").doubleClick();
            $("#userNumber").setValue("9111111111");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("November");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("1994");
            $(".react-datepicker__day--016").click();
            $("#subjectsInput").click();
            $("#subjectsInput").setValue("English").pressEnter();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Music")).click();
            $("#uploadPicture").uploadFile(new File("src/test/resources/dog.jpeg"));
            $("#currentAddress").setValue("KBR, Nalchik, Lenina, 32, B");
            $("#state").scrollIntoView(false).click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();
        });
        step("Check form results    ", () -> {
            $(".modal-header").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Islam"), text("Kaziev"), text("Islam@Vasiya.com"),
                    text("9111111111"), text("16 November,1994"), text("English, Maths"), text("Music"), text("dog.jpeg"),
                    text("KBR, Nalchik, Lenina, 32, B"), text("NCR Delhi"));
        });
    }
}
