package myallure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    private final String  url = "https://github.com/",
            repName = "guru_05_temp_01",
            userName = "alexdromanov/guru_05_temp_01",
            findValue = "Issues";
    @Test
    void githubTest() {

        //открываем страницу
        step("Открываем сайт", () -> {
            open(url);
        });

        //заходим в репозиторий
        step("Заходим в репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(repName).pressEnter();
            $(By.linkText(userName)).click();
        });

        //ищем Issues
        step("Ищем и проверяем Issues", () -> {
            $(withText("Issues")).click();
        });


        //Заходим в Issues и проверяем что они открылись
        step("Заходим в Issues и проверяем что они открылись", () -> {
            $(".repository-content").shouldHave(text("Welcome to issues!"));

        });

    }

}