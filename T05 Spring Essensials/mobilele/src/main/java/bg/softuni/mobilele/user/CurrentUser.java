package bg.softuni.mobilele.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
@Component
@SessionScope
public class CurrentUser {
    private String name;
    private boolean isLoggedIn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void clear() {
        isLoggedIn = false;
        name = null;
    }

    public boolean isAnnonymous() {
        return !isLoggedIn;
    }
}
