package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void openBrowser(){
        setUpBrowser(baseUrl);
    }
    @Test
    public void  verifyThatSigningUpPageDisplay(){
// click on the ‘Register’ link
        clickOnElement(By.linkText("Register"));
// Verify the text ‘Signing up is easy!’
verifyTextWithAssert("Signing up is easy!",((By.xpath("//h1[@class='title']"))),"text is displayed");

    }
    @Test
    public void userSholdRegisterAccountSuccessfully() {
// click on the ‘Register’ link
      clickOnElement(By.linkText("Register"));
// Enter First name
    sendTextToElement((By.id("customer.firstName")),"abc");
// Enter Last name
        sendTextToElement((By.id("customer.lastName")),"patel");
// Enter Address
       sendTextToElement((By.name("customer.address.street")),"alvarado Rd.");
//  Enter City
        sendTextToElement((By.id("customer.address.city")),"phoenix");
//  Enter State
        sendTextToElement((By.id("customer.address.state")),"Arizona");
// Enter Zip Code
        sendTextToElement((By.id("customer.address.zipCode")),"85035");
// Enter Phone
        sendTextToElement((By.id("customer.phoneNumber")),"+15751234567");
// Enter SSN
       sendTextToElement((By.id("customer.ssn")),"123456789");
// Enter Username
       sendTextToElement((By.id("customer.username")),"prish");
// Enter Password
        sendTextToElement((By.id("customer.password")),"abc123");
// Enter Confirm
       sendTextToElement((By.id("repeatedPassword")),"abc123");
//Click on REGISTER button
       clickOnElement((By.xpath("//input[@type='submit']")));
// Verify the text 'Your account was created successfully. You are now logged in.'
verifyTextWithAssert("Your account was created successfully. You are now logged in.",((By.xpath("//div[@id='bodyPanel']/div[2]/p"))),"Error is not displayed");

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
