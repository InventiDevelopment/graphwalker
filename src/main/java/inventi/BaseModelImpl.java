package inventi;

import lombok.SneakyThrows;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.annotation.Model;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

@GraphWalker()
public class BaseModelImpl extends ExecutionContext implements BaseModel {


    @Override
    public void e_clickSignIn() {
        $(linkText("Sign in")).shouldBe(visible).click();
    }

    @Override
    public void e_clickHome() {
        $(linkText("Home")).shouldBe(visible).click();
    }

    @Override
    public void v_homeNotSignedPage() {
        $("h1").shouldBe(visible).shouldHave(text("conduit"));
        $x("//p['A place to share your knowledge.']").shouldBe(visible);
    }

    @Override
    public void e_clickMyProfile() {
        $(linkText("GraphWalker")).shouldBe(visible).click();
    }

    @Override
    public void v_signInPage() {
        $("h1").shouldBe(visible).shouldHave(text("Sign In"));
    }

    @Override
    public void e_submitLoginData() {
        $x("//input[@placeholder='Email']").shouldBe(visible).sendKeys("graphwalker@test.cz");
        $x("//input[@placeholder='Password']").shouldBe(visible).sendKeys("heslohesloheslo");
        $x("//button[@type='submit']").shouldBe(visible).click();
    }

    @Override
    public void v_profilePage() {
        $("h4").shouldBe(visible).shouldHave(text("GraphWalker"));
    }

    @Override
    public void v_homeSignedPage() {
        $(linkText("Your Feed")).shouldBe(visible);
    }

    @Override
    public void e_clickLogout() {
        $x("//button[contains(text(),'Or click here to logout.')]").shouldBe(visible).scrollTo().click();
    }

    @Override
    public void e_clickProfileSettings() {
        $(linkText("Edit Profile Settings")).shouldBe(visible).click();
    }

    @Override
    public void v_profileSettingPage() {
        $("h1").shouldBe(visible).shouldHave(text("Your Settings"));
    }

    @Override
    public void e_openBrowser() {
        open("http://react-redux.realworld.io/");
    }

    @AfterExecution
    public void cleanup() {
        closeWebDriver();
    }
}
