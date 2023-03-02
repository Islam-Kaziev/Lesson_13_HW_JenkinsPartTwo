package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class PictureUploader {

    public void uploadPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);
    }
}