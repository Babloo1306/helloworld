package hello.test;

import com.magenic.jmaqs.selenium.BaseSeleniumTest;
import hello.pagemodels.HomePageModel;
import hello.pagemodels.LoginPageModel;
import com.magenic.jmaqs.utilities.helper.exceptions.ExecutionFailedException;
import com.magenic.jmaqs.utilities.helper.exceptions.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseSeleniumTest {

  @Test
  public void openPageTest() {
    LoginPageModel page = new LoginPageModel(this.getTestObject());
    page.openLoginPage();
    Assert.assertTrue(page.isPageLoaded());
  }

  @Test
  public void enterValidCredentialsTest() throws InterruptedException, TimeoutException, ExecutionFailedException {
    String username = "Ted";
    String password = "123";
    LoginPageModel page = new LoginPageModel(this.getTestObject());
    page.openLoginPage();
    HomePageModel homepage = page.loginWithValidCredentials(username, password);
    Assert.assertTrue(homepage.isPageLoaded());
  }

  @Test
  public void enterInvalidCredentials() throws InterruptedException, TimeoutException, ExecutionFailedException {
    String username = "NOT";
    String password = "Valid";
    LoginPageModel page = new LoginPageModel(this.getTestObject());
    page.openLoginPage();
    Assert.assertTrue(page.loginWithInvalidCredentials(username, password));
  }
}