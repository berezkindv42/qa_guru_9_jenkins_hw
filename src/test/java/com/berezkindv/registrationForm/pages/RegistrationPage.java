package com.berezkindv.registrationForm.pages;

import com.berezkindv.registrationForm.TestData;
import com.berezkindv.registrationForm.pages.components.CalendarComponent;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    public CalendarComponent calendarComponent = new CalendarComponent();

    private static final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            currentAddressInput = $("#currentAddress"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            genderSelectInput = $("#genterWrapper"),
            hobbiesCheckBoxInput = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            stateFieldSelect = $("#state"),
            stateFieldInput = $("#stateCity-wrapper").$(byText(TestData.state)),
            cityFieldSelect = $("#city"),
            cityFieldInput = $("#stateCity-wrapper").$(byText(TestData.city)),
            submitButtonPush = $("#submit"),
            resultsTableHeader = $("#example-modal-sizes-title-lg"),
            resultsTableBody = $(".modal-body");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage fillSubjectField(String value) {
        subjectInput.setValue(value).pressEnter();
//        $(".subjects-auto-complete__menu #react-select-2-option-0").click();
        return this;
    }

    public RegistrationPage genderSelectGender(String gender) {
        genderSelectInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage hobbiesCheckBoxSelect(String hobbie) {
        hobbiesCheckBoxInput.$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage uploadFile(String filePath) {
        uploadFileInput.uploadFromClasspath(filePath);
        return this;
    }

    public RegistrationPage fillStateField() {
        stateFieldSelect.scrollTo().click();
        stateFieldInput.click();
        return this;
    }

    public RegistrationPage fillCityField() {
        cityFieldSelect.scrollTo().click();
        cityFieldInput.click();
        return this;
    }

    public void pushSubmitButton() {
        submitButtonPush.click();
    }

    public RegistrationPage assertFormTitle(String title) {
        resultsTableHeader.shouldHave(text(title));
        return this;
    }

    public void assertFormTitleNegative() {
        resultsTableHeader.shouldNotBe(visible);
    }

    public RegistrationPage assertsForm(String key, String value) {
        resultsTableBody.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public void closeTable() {
        ElementsCollection closeBannerButton = $$("#close-fixedban");
        if (closeBannerButton.size() > 0 && closeBannerButton.get(0).isDisplayed())
            closeBannerButton.get(0).click();
        $("#closeLargeModal").scrollTo().click();
    }
}
