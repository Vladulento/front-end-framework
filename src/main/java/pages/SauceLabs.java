package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utilities.enums.Direction;

public class SauceLabs extends GenericPage{
    @AndroidFindBy(accessibility = "Sauce Labs Fleece Jacket")
    WebElement sweatshirt;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    WebElement plusButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    WebElement addCart;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    WebElement cart;

    @AndroidFindBy(accessibility = "Confirms products for checkout")
    WebElement checkoutBtn;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    WebElement user;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    WebElement password;

    @AndroidFindBy(id= "com.saucelabs.mydemoapp.android:id/loginBtn")
    WebElement login;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
    WebElement fullName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/address1ET\"]")
    WebElement addressLine;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
    WebElement city;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/zipET\"]")
    WebElement zipCode;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/countryET")
    WebElement country;

    @AndroidFindBy(accessibility = "Saves user info for checkout")
    WebElement payment;



    public void buySweatshirts(){
        scrollToElement(sweatshirt,Direction.UP,true);
        sweatshirt.click();
        scrollToElement(plusButton,Direction.UP,true);
        plusButton.click();
        addCart.click();
        cart.click();
    }

    public void login(){
        checkoutBtn.click();
        waitForVisibility(user);
        user.sendKeys("bod@example.com");
        password.sendKeys("10203040");
        login.click();
    }

    public void checkOut(){
        fullName.sendKeys("John Doe");
        addressLine.sendKeys("Main Street");
        city.sendKeys("Madrid");
        zipCode.sendKeys("28000");
        country.sendKeys("España");
        scrollToElement(payment,Direction.UP,true);
        payment.click();
    }
}
