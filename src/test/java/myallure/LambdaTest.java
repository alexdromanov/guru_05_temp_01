package myallure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    private String  url = "https://github.com/",
            nameOfRepos = "guru_05_temp_01",
            userName = "alexdromanov",
            findText = "Issues";
    @Test
    void githubTest() {

        //открываем страницу
        step("Открываем сайт", () -> {
            open(url);
        });

        //заходим в репозиторий
        step("Заходим в репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(nameOfRepos).pressEnter();
            $(".repo-list-item").$(byText(userName)).click();
        });

        //ищем Issues
        step("Ищем и проверяем Issues", () -> {
            $(".js-repo-nav").shouldHave(text(findText));
            $(".js-repo-nav").$(byText(findText)).click();
        });


        //Заходим в Issues и проверяем что они открылись
        step("Заходим в Issues и проверяем что они открылись", () -> {
            $(".repository-content").shouldHave(text("Welcome to issues!"));

        });

    }

}