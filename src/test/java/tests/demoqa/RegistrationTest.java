package tests.demoqa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static tests.demoqa.TestData.*;;

public class RegistrationTest extends TestBase {

    @Test
    void studentRegistrationForm() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = genderRandom(),
                phone = faker.phoneNumber().subscriberNumber(10),
                birthDay = String.format("%02d", faker.number().numberBetween(1,28)),
                birthMonth =  monthRandom(),
                birthYear = String.valueOf(faker.number().numberBetween(1970, 2010)),
                firstSubjects = sobjectRandom(),
                secondSubjects = sobjectRandom(),
                hobbies = hobbiesRandom(),
                picture = "dog.jpeg",
                currentAddress = faker.address().fullAddress(),
                state = "Rajasthan",
                city = "Jaiselmer";

        registrationPage.openPage();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
                registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(firstSubjects, secondSubjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth",  birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", firstSubjects + ", " + secondSubjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
        //checking the data after sending
    }
}

