package OrangeHRM;

import org.openqa.selenium.By;

public class OrangeHRMDashBoardPage {
    public By adminTab=By.xpath("//span[text()='Admin']");
    public By mandaUser=By.xpath("//p[text()='manda user']");
    public By logoutLink=By.xpath("//a[text()='Logout']");
    public By profilePic=By.xpath("//img[@alt='profile picture']");

    public By getProfilePic() {
        return profilePic;
    }

    public By getAdminTab() {
        return adminTab;
    }

    public By getMandaUser() {
        return mandaUser;
    }

    public By getLogoutLink() {
        return logoutLink;
    }
}
