package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MenPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-5']//span[contains(text(),'Men')]")
    WebElement menMenu;

    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-18']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")
    WebElement bottoms;

    // By bottoms = By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]");

    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-23']//span[contains(text(),'Pants')]")
    WebElement clickOnPants;

    @CacheLookup
    @FindBy(xpath = "//select[@id='sorter']")
    WebElement selectFromDropDown;
    @CacheLookup
    @FindBy(xpath = "//strong[@class='product name product-item-name']//a[@class='product-item-link']")
    WebElement cronusYogaPant;

    @CacheLookup
    @FindBy(xpath = "//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']")
    WebElement CronusPant32;

    @CacheLookup
    @FindBy(xpath = "//div[@class='swatch-opt-880']//div[@id='option-label-color-93-LnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9tZW4vYm90dG9tcy1tZW4vcGFudHMtbWVuLmh0bWw_cHJvZHVjdF9saXN0X29yZGVyPW5hbWU%2C/product/880/']//button[@class='action tocart primary']")
    WebElement blackColour;

    @CacheLookup
    @FindBy(xpath = "//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']")
    WebElement CronusBlackColour;
    @CacheLookup
    @FindBy(xpath = "//form[@action='https://magento.softwaretestingboard.com/checkout/cart/add/uenc/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9tZW4vYm90dG9tcy1tZW4vcGFudHMtbWVuLmh0bWw_cHJvZHVjdF9saXN0X29yZGVyPW5hbWU%2C/product/880/']//button[@class='action tocart primary']")
    WebElement buttonAddToCart;
    @CacheLookup
    @FindBy(xpath = "//span[text() ='Add to Cart'])[1]")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath="//div[@data-product-id='880']")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='page messages']//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;
    @CacheLookup
    @FindBy(xpath = "//select[@id='sorter']")
    WebElement selectByProductName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='message-success success message']")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath = "//main[@id='maincontent']//h1")
    WebElement verifyShoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")
    WebElement verifyProductName;
    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'32')]")
    WebElement verifyProductSize;
    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'Black')]")
    WebElement verifyProductColour;


    public void mouseHoverOnMenMenu(){
        mouseHoverToElement(menMenu);
        CustomListeners.test.log(Status.PASS, "mouse hover on Men menu");
        Reporter.log("mouse hove on Men menu" + menMenu.toString());
    }
    public void mouseHoverOnBottoms(){
        mouseHoverToElement(bottoms);
        CustomListeners.test.log(Status.PASS, "mouse hover on Bottoms");
        Reporter.log("mouse hover on Bottoms" + bottoms.toString());
    }
    public void clickOnPants(){
        clickOnElement(clickOnPants);
        CustomListeners.test.log(Status.PASS, "click on pants");
        Reporter.log("click on pants" + clickOnPants.toString());
    }

    public void cronusYogaPantAndClickOnSize32(){
        mouseHoverToElementAndClick(cronusYogaPant);
        CustomListeners.test.log(Status.PASS, "click on size 32");
        Reporter.log("click on size 32" + cronusYogaPant.toString());
    }

    public void cronusYogaPantAndColourBlack(){
        mouseHoverToElementAndClick(blackColour);
        CustomListeners.test.log(Status.PASS, "click on black colour");
        Reporter.log("click on black colour" + blackColour.toString());
    }
    public void mouseHoverOnProductName(){
        mouseHoverToElementAndClick(productName);
        CustomListeners.test.log(Status.PASS, "click on product name");
        Reporter.log("click on product name" + productName.toString());
    }
    public void addToCart(){
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "click on add to cart");
        Reporter.log("click on add to cart" + addToCart.toString());
        //mouseHoverToElementAndClick(addToCart,"Add to Cart");
        List<WebElement> multiElement = driver.findElements(By.xpath("//div[@class='message-success success message']"));

        System.out.println("Total Items are: " + multiElement.size());
        for (WebElement list : multiElement) {
            String name1 = list.getText();
            System.out.println(name1);

        }

    }
    public void clickOnShoppingCartLink(){
        clickOnElement(shoppingCart);
        CustomListeners.test.log(Status.PASS, "click on shopping cart link");
        Reporter.log("click on shopping cart link" + shoppingCart.toString());
    }

    public void sortByProductName() {
        selectByValueFromDropDown(selectByProductName, "name");
        CustomListeners.test.log(Status.PASS, "sort by product name");
        Reporter.log("sort by product name" + selectByProductName.toString());
    }

    public void clickOnCronousSize32() {
        clickOnElement(CronusPant32);
        CustomListeners.test.log(Status.PASS, "click on cronus size 32");
        Reporter.log("click on cronus size 32" + CronusPant32.toString());
    }
    public void clickOnCronousBlack() {
        clickOnElement(CronusBlackColour);
        CustomListeners.test.log(Status.PASS, "click on cronus cronus black");
        Reporter.log("click on cronus cronus black" + CronusBlackColour.toString());
    }

    public void mouseHoverOnCronusYogaAndClickAddCart() {
        mouseHoverToElement(productName);
        clickOnElement(buttonAddToCart);
        CustomListeners.test.log(Status.PASS, "click on Add to cart");
        Reporter.log("click on Add to cart" + buttonAddToCart.toString());
    }

    public String getSuccessMsgText() {
        CustomListeners.test.log(Status.PASS, "verify success message");
        Reporter.log("verify success message" + successMessage.toString());
        return getTextFromElement(successMessage);

    }

    public String getShoppingCartText() {
        CustomListeners.test.log(Status.PASS, "verify shopping cart text");
        Reporter.log("verify shopping cart text" + verifyShoppingCartText.toString());
        return getTextFromElement(verifyShoppingCartText);
    }

    public String getProductName() {
        CustomListeners.test.log(Status.PASS, "verify product text");
        Reporter.log("verify product text" + verifyProductName.toString());
        return getTextFromElement(verifyProductName);
    }

    public String getProductSize() {
        CustomListeners.test.log(Status.PASS, "verify product size");
        Reporter.log("verify product size" + verifyProductSize.toString());
        return getTextFromElement(verifyProductSize);
    }

    public String getProductColour() {
        CustomListeners.test.log(Status.PASS, "verify product colour");
        Reporter.log("verify product colour" + verifyProductColour.toString());
        return getTextFromElement(verifyProductColour);
    }

}
