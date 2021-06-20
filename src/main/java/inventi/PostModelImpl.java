package inventi;

import org.graphwalker.core.machine.ExecutionContext;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.linkText;

public class PostModelImpl extends ExecutionContext implements PostModel {
    @Override
    public void v_postDetailPage() {
        $("h1").shouldBe(visible).shouldHave(text("Graph Walker article"));
    }

    @Override
    public void e_clickNewPost() {
        $(linkText("New Post")).shouldBe(visible).click();
    }

    @Override
    public void e_submitNewPost() {
        $x("//input[@placeholder='Article Title']").shouldBe(visible).sendKeys("Graph Walker article");
        $x("//input[@class='form-control']").shouldBe(visible).sendKeys("Graph Walker article description");
        $x("//textarea[@placeholder='Write your article (in markdown)']").shouldBe(visible).sendKeys("Lorem ipsum");
        $x("//button[@type='button']").shouldBe(visible).click();
    }

    @Override
    public void e_clickHome() {
        $(linkText("Home")).shouldBe(visible).click();
    }

    @Override
    public void v_homeSignedPage() {
        $(linkText("Your Feed")).shouldBe(visible);
    }

    @Override
    public void v_addPostPage() {
        $x("//input[@placeholder='Article Title']").shouldBe(visible);
    }

}
