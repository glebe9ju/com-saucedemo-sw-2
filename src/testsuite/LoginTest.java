package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void  userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” username
        WebElement standardUserName = driver.findElement(By.name("user-name"));
        standardUserName.sendKeys("standard_user");
        //Enter “secret_sauce” password
        WebElement secretSaucePassword = driver.findElement(By.id("password"));
        secretSaucePassword.sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        //Verify the text “PRODUCTS”
        WebElement products =driver.findElement(By.className("title"));
        Assert.assertEquals("Incorrect loging detail" , "PRODUCTS", products.getText());
    }
    /*

*
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify that six products are displayed on page
     */
@Test
public void  verifyThatSixProductsAreDisplayedOnPage(){
    //Enter “standard_user” username
    WebElement standardUserName = driver.findElement(By.name("user-name"));
    standardUserName.sendKeys("standard_user");
    //Enter “secret_sauce” password
    WebElement secretSaucePassword = driver.findElement(By.id("password"));
    secretSaucePassword.sendKeys("secret_sauce");
    //Click on ‘LOGIN’ button
    WebElement login = driver.findElement(By.id("login-button"));
    login.click();
    //Verify the text “PRODUCTS”
    WebElement products =driver.findElement(By.className("title"));
    Assert.assertEquals("Incorrect loging detail" , "PRODUCTS", products.getText());
    //create iteamlist by xpath
    List<WebElement> itemList = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']"));
    //number of iteam displayed
    System.out.println("Number of item displayed : " + itemList.size());
    //if you enter wrong number then number of items are not six message will appear
    Assert.assertTrue("Number of items display are not six",itemList.size()==6);
    for (WebElement item: itemList) {
        System.out.println(item.getText() + "is dispayed? : "  +  item.isDisplayed());
    }
}
    @After
    public void tearDown() {
       // closeBrowsers();
    }
}
