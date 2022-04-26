package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseurl = "http://the-internet.herokuapp.com/login";

    // click on login link
    @Before
    public void set() {
        openbrowser(baseurl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // find login click and click on login click

        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        // find emailfield

        sendTextToElement(By.xpath("//input[@id='username']"), "tomsmith");
        //find password field

        sendTextToElement(By.xpath("//input[@id='password']"), "SuperSecretPassword!");
        //click on login button

        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        // varify login button
        String expectedMessage = "Secure Area";

        String actualMessage1 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        //varify
        Assert.assertEquals("login sucessful", expectedMessage, actualMessage1);


    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //user name enter

        sendTextToElement(By.xpath("//input[@id='username']"), "//input[@id='username']");
        //password enter

        sendTextToElement(By.xpath("//input[@id='password']"), "SuperSecretPassword!");
        //login button

        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        // varify assert message
        String expextedmessage = "Your username is invalid!\n" +
                "×";


        String actualmessage1 = getTextFromElement(By.xpath("//div[@id='flash']"));
        //ascerting actual and expected
        Assert.assertEquals("Your userNmae is invalid", expextedmessage, actualmessage1);

    }

    @Test
    public void verifyThePasswordErrorMessage() {

        // user name

        sendTextToElement(By.xpath("//input[@id='username']"), "tomsmith");
        // invalid password field

        sendTextToElement(By.xpath("//input[@id='password']"), "SuperSecretPassword");
        //log in button

        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        // varify error message
        String expextederrormsg = "Your password is invalid!\n" +
                "×";

        String actualmessage1 = getTextFromElement(By.xpath("//div[@id='flash']"));
        //varify actual and expected message
        Assert.assertEquals("Your password is invalid", expextederrormsg, actualmessage1);


    }

    @After
    public void testdown() {
        closebrowser();
    }


}
