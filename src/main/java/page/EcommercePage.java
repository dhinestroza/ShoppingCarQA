package page;

import org.openqa.selenium.WebDriver;

public class EcommercePage extends BasePage{

    private String theArticle = "//article[@class='product-miniature js-product-miniature'][2]";
    private String priceArticle = "//span[@content='28.72']";
    private String btnAddToCart = "//button[@class='btn btn-primary add-to-cart']";
    private String btnCheckoutCart = "//a[@href='//www.testingyes.com/onlineshop/cart?action=show' and @class]";
    private String verifyTitleShopping = "//h1[@class='h1']";
    private String btnProceedCart = "//a[@href='http://www.testingyes.com/onlineshop/order']";

    //personal information
    private String verifyTitleForm = "//section[@id='checkout-personal-information-step']//h1";
    private String checkboxSocial = "//input[@name='id_gender' and @value='1']";
    private String textFieldFirstName ="//input[@class='form-control' and @name='firstname']";
    private String textFieldLastName ="//input[@class='form-control' and @name='lastname']";
    private String textFieldEmail = "//input[@class='form-control' and @name='email']";
    private String checkboxPartner = "//input[@name='optin']";
    private String checkboxNewsletter = "//input[@name='newsletter']";
    private String checkboxPrivacy = "//input[@name='psgdpr']";
    private String btnOrderContinue = "//button[@class='continue btn btn-primary float-xs-right' and @name='continue']";


    //section addresses
    private String verifyTitleAddresses = "//section[@id='checkout-addresses-step']//h1";
    private String textFieldAddress = "//input[@class='form-control' and @name='address1']";
    private String textFieldAddressComple = "//input[@class='form-control' and @name='address2']";
    private String textFieldCity = "//input[@class='form-control' and @name='city']";
    private String dropdownState = "//select[@class='form-control form-control-select' and @name='id_state']";
    private String textFieldPost = "//input[@class='form-control' and @name='postcode']";
    private String dropdownCountry = "//select[@class='form-control form-control-select js-country' and @name='id_country']";
    private String btnAddressContinue = "//button[@type='submit' and @name='confirm-addresses']";


    //section shipping method
    private String verifyTitleShipping = "//section[@id='checkout-delivery-step']//h1";
    private String textAreaComment = "//textarea[@id='delivery_message']";
    private String btnShippingContinue = "//button[@type='submit' and @name='confirmDeliveryOption']";

    //section payment
    private String verifyTitlePayment = "//section[@id='checkout-payment-step']//h1";
    private String checkboxPay = "//input[@id='payment-option-1']";
    private String checkTermsOfService = "//input[@id='conditions_to_approve[terms-and-conditions]']";
    private String btnPayment = "//button[@type='submit' and @class='btn btn-primary center-block']";


    private String confirmTitleOrder = "//div[@class='col-md-12']//h3[@class='h1 card-title']";

    public EcommercePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToEcommerceWeb(){
        navigateTo("http://www.testingyes.com/onlineshop/");
    }
    public void clickTheArticle(){
        clickElement(theArticle);
    }

    public String getTextPriceArticle(){
        return getElement(priceArticle);
    }

    public void clickTheArticleShopping(){
        clickElement(btnAddToCart);
    }

    public void checkoutModalCart(){
        clickElement(btnCheckoutCart);
    }

    public String getAssertTitleShopping(){
        return getElement(verifyTitleShopping);
    }

    public void clickProceedCheckout(){
        clickElement(btnProceedCart);
    }

    public String getTitleFormPersonal(){
        return getElement(verifyTitleForm);
    }

    public void checkboxSocialPersonal(){
        isSelectedCheckbox(checkboxSocial);
    }

    public void writeFieldsNamePersonal(String firstName, String lastName,String email){
        writeToElement(textFieldFirstName,firstName);
        writeToElement(textFieldLastName,lastName);
        writeToElement(textFieldEmail,email);
    }

    public void checkboxPartnerForm(){
        isSelectedCheckbox(checkboxPartner);
    }
    public void checkboxNewsletterForm(){
        isSelectedCheckbox(checkboxNewsletter);
    }

    public void checkboxPrivacyForm(){
        isSelectedCheckbox(checkboxPrivacy);
    }

    public void clickSectionPersonalForm(){
        clickElement(btnOrderContinue);
    }

    public String getTitleAddressesForm(){
        return getElement(verifyTitleAddresses);
    }

    public void writeFieldsAddress(String addresses,String addressComple,String city){
        writeToElement(textFieldAddress,addresses);
        writeToElement(textFieldAddressComple,addressComple);
        writeToElement(textFieldCity,city);

    }

    public void dropdownStateAddressForm(){
        selectedFromDropdownByIndex(dropdownState,4);
    }

    public void writeFieldZipPost(String postal){
        writeToElement(textFieldPost,postal);
    }

    public void dropdpwnCountryAddressForm(){
        selectedFromDropdownByIndex(dropdownCountry,1);
    }

    public void clickSectionAddresses(){
        clickElement(btnAddressContinue);
    }

    public String getTitleShippingForm(){
        return getElement(verifyTitleShipping);
    }

    public void writeTextAreaShippingForm(){
        writeToElement(textAreaComment,"make it as soon as possible");
    }

    public void clickSectionShipping(){
        clickElement(btnShippingContinue);
    }

    public String getTitlePayForm(){
        return getElement(verifyTitlePayment);

    }

    public void checkboxByPay(){
        isSelectedCheckbox(checkboxPay);
    }

    public void checkboxTerms(){
        isSelectedCheckbox(checkTermsOfService);
    }

    public void clickSectionPay(){
        clickElement(btnPayment);
    }

    public String getTitleOrderFinal(){
        return getElement(confirmTitleOrder);
    }

}
