package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class StudentFormTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1200x800";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("James");
        $("#lastName").setValue("Bond");
        $("#userEmail").setValue("jb@007.gb");
        $("[for=gender-radio-3]").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$("[value='11']").click();
        $(".react-datepicker__year-select [value='1900']").click();
        $(".react-datepicker__day--0" + "21").click();
        $("#subjectsInput").setValue("A").pressTab();
        $("#subjectsInput").setValue("ar").pressTab();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("Picture/Picture.pic");
        $("#currentAddress").setValue("Wellington Square, 25");
        $("#react-select-3-input").setValue("ha").pressTab();
        $("#react-select-4-input").setValue("k").pressTab();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("James Bond"),
                text("jb@007.gb"),
                text("0123456789"),
                text("Picture.pic"),
                text("Wellington Square, 25"));
        $("#closeLargeModal").click();
        $(".modal-open").shouldNotBe(visible);
    }
}
