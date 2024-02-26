package stepsdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.EcommercePage;

public class EcommerceSteps {

    WebDriver driver = new ChromeDriver();
    EcommercePage ecommerce = new EcommercePage(driver);

    @Given("^navigate$")
    public void navigateToEcommerce(){
        ecommerce.navigateToEcommerceWeb();
    }

    @And("^see the article$")
    public void lookTheArticle(){
        ecommerce.clickTheArticle();

    }
    @When("^the article opens add it to the shopping cart$")
    public void addTheArticleShoppingCart(){
        String actualPrice = ecommerce.getTextPriceArticle();
        String expectedPrice = "$28.72";
        Assert.assertEquals(expectedPrice,actualPrice);
        ecommerce.clickTheArticleShopping();

    }

    @And("^see shopping cart$")
    public void checkShoppingCart(){
        ecommerce.checkoutModalCart();
        //wait
        String actualTitle = ecommerce.getAssertTitleShopping();
        String expectedTitle = "SHOPPING CART";
        Assert.assertEquals(expectedTitle,actualTitle);

        ecommerce.clickProceedCheckout();
    }

    @But("^complete the form personal information (.+),(.+) and (.+)$")
    public void personalInformationForm(String firstName,String lastName,String email){

        String actualTitle = ecommerce.getTitleFormPersonal();
        String expectedTitle = "1 PERSONAL INFORMATION";
        Assert.assertEquals(expectedTitle,actualTitle);

        ecommerce.checkboxSocialPersonal();

        ecommerce.writeFieldsNamePersonal(firstName,lastName,email);

        ecommerce.checkboxPartnerForm();
        ecommerce.checkboxNewsletterForm();
        ecommerce.checkboxPrivacyForm();

        ecommerce.clickSectionPersonalForm();
    }
    @And("^complete the form Address (.+), (.+), (.+) and (.+)$")
    public void  AddressesForm(String adresses, String addressComple, String city, String post){
        String actualTitle = ecommerce.getTitleAddressesForm();
        String expectedTitle = "2 ADDRESSES";
        Assert.assertEquals(expectedTitle,actualTitle);

        ecommerce.writeFieldsAddress(adresses,addressComple,city);

        ecommerce.dropdownStateAddressForm();

        ecommerce.writeFieldZipPost(post);

        ecommerce.dropdpwnCountryAddressForm();

        ecommerce.clickSectionAddresses();


    }
    @And("^complete the form shipping$")
    public void ShippingForm(){
        String actualTitle = ecommerce.getTitleShippingForm();
        String expectedTitle = "3 SHIPPING METHOD";
        Assert.assertEquals(expectedTitle,actualTitle);

        ecommerce.writeTextAreaShippingForm();

        ecommerce.clickSectionShipping();

    }
    @And("^complete the form pay$")
    public void payForm(){
        String actualTitle = ecommerce.getTitlePayForm();
        String expectedTitle = "4 PAYMENT";
        Assert.assertEquals(expectedTitle,actualTitle);

        ecommerce.checkboxByPay();
        ecommerce.checkboxTerms();

        ecommerce.clickSectionPay();

    }
    @Then("^make the payment$")
    public void verifyPayment(){
        String actualTitle = ecommerce.getTitleOrderFinal();
        String expectedTitle = "\uE876YOUR ORDER IS CONFIRMED";
        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
