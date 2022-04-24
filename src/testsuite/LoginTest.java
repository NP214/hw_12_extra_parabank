package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void openBrowser(){
        setUpBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

// Enter valid username
        sendTextToElement((By.name("username")),"abcn");
//Enter valid password
       sendTextToElement((By.name("password")),"abcn123");
//Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));
//Verify the ‘Accounts Overview’ text is display
        verifyTextWithAssert("Accounts Overview",((By.xpath("//h1[contains(text(),'Accounts Overview')]"))),"Error is not displayed");

 }
 @Test
        public void verifyTheErrorMessage() {
//Enter invalid username
          sendTextToElement((By.name("username")),"dfg");
//Enter invalid password
            sendTextToElement((By.name("password")),"ddd123");
//Click on Login button
          clickOnElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));
//Verify the error message ‘The username and password could not be verified.’

            verifyTextWithAssert("The username and password could not be verified.",((By.xpath("//p[contains(text(),'The username and password could not be verified.')]"))),"Error is not displayed");

        }
        @Test
        public void userShouldLogOutSuccessfully () {
            //Enter valid username
             sendTextToElement((By.name("username")),"ddd");
//Enter valid password
            sendTextToElement((By.name("password")),"ddd123");
//Click on ‘LOGIN’ button
            clickOnElement((By.xpath("//div[@id='loginPanel']/form/div[3]/input")));
//Click on ‘Log Out’ link
            clickOnElement((By.xpath("//a[contains(text(),'Log Out')]")));
//Verify the text ‘Customer Login’
         verifyTextWithAssert("Customer Login",((By.xpath("Customer Login"))),"Error is not displayed");

        }
        @After
    public void tearDown(){
        closeBrowser();
        }
    }
