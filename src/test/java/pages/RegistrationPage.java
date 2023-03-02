package pages;

import pages.components.CalendarComponent;
import pages.components.PictureUploader;
import pages.components.RegistrationResultsModal;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

    public class RegistrationPage {
        private final String TITLE_TEXT = "Student Registration Form";
        private CalendarComponent calendarComponent = new CalendarComponent();
        private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
        private PictureUploader pictureUploader = new PictureUploader();
        private SelenideElement
                firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                dateOfBirthInput = $("#dateOfBirthInput"),
                subjectsInput = $("#subjectsInput"),
                userEmail = $("#userEmail"),
                genderInput = $("#genterWrapper"),
                userNumber = $("#userNumber");

        public RegistrationPage openPage() {
            open("/automation-practice-form");

            return this;
        }

        public RegistrationPage setFirstName(String value) {
            firstNameInput.setValue(value);

            return this;
        }

        public RegistrationPage setLastName(String value) {
            lastNameInput.setValue(value);

            return this;
        }

        public RegistrationPage setEmail(String value) {
            userEmail.setValue(value);

            return this;
        }

        public RegistrationPage setGender(String gender) {
            genderInput.$(byText(gender)).click();

            return this;
        }

        public RegistrationPage setPhone(String value) {
            userNumber.setValue(value);

            return this;
        }

        public RegistrationPage setBirthDate(String day, String month, String year) {
            dateOfBirthInput.click();
            calendarComponent.setDate(day, month, year);

            return this;
        }

        public RegistrationPage verifyResultsModalAppears() {
            registrationResultsModal.verifyModalAppears();

            return this;
        }

        public RegistrationPage verifyResult(String key, String value) {
            registrationResultsModal.verifyResult(key, value);

            return this;
        }

        public RegistrationPage setSubjects(String firstSubjects, String secondSubjects) {
            subjectsInput.click();
            subjectsInput.setValue(firstSubjects).pressEnter();
            subjectsInput.setValue(secondSubjects).pressEnter();

            return this;
        }


        public RegistrationPage setHobbies(String value) {
            $("#hobbiesWrapper").$(byText(value)).click();

            return this;
        }
        public RegistrationPage uploadPicture(String picture) {
            pictureUploader.uploadPicture(picture);

            return this;
        }


        public RegistrationPage setAddress(String value) {
            $("#currentAddress").setValue(value);

            return this;
        }

        public RegistrationPage setState(String state) {
            $("#state").click();
            $("#react-select-3-option-3").click();

            return this;
        }

        public RegistrationPage setCity(String city) {
            $("#city").click();
            $("#react-select-4-option-1").click();

            return this;
        }

        public RegistrationPage submitForm() {
            $("#submit").click();

            return this;
        }
    }
