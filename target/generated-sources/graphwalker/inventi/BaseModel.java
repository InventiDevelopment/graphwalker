// Generated by GraphWalker (http://www.graphwalker.org)
package inventi;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "inventi/BaseModel.json")
public interface BaseModel {

    @Vertex()
    void v_homeNotSignedPage();

    @Edge()
    void e_clickMyProfile();

    @Edge()
    void e_clickLogout();

    @Edge()
    void e_clickProfileSettings();

    @Edge()
    void e_openBrowser();

    @Edge()
    void e_clickSignIn();

    @Edge()
    void e_submitLoginData();

    @Vertex()
    void v_signInPage();

    @Vertex()
    void v_profileSettingPage();

    @Edge()
    void e_clickHome();

    @Vertex()
    void v_profilePage();

    @Vertex()
    void v_homeSignedPage();
}
