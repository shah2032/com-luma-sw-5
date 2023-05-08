package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class GearPage extends Utility {
    @CacheLookup
    //@FindBy(xpath = "//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[7]")
    @FindBy(xpath = "//span[normalize-space()='Gear']")
    WebElement gearMenu;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Bags']")
    WebElement bags;
    @CacheLookup
    @FindBy(xpath = "//strong[@class='product name product-item-name']//a[contains(text(),'Overnight Duffle ')]")
    WebElement overnightDuffle;
    @CacheLookup
    @FindBy(id = "qty")
    WebElement changeQty;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class='control qty']//input")
    WebElement changeQty5;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Update Shopping Cart')]")
    WebElement upDateCart;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement clickOnShoppingCart;
    @CacheLookup
    @FindBy(xpath = "//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement txtAddedDuffleToCart;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//td[@class='col subtotal']//span[@class='price']")
    WebElement verifyProductPrice;
    @CacheLookup
    @FindBy(xpath = "//input[@value = '3']")
    WebElement qtyChangeTo3;

    public void mouseHoverOnGear() {
        mouseHoverToElement(gearMenu);
        CustomListeners.test.log(Status.PASS, "mouse hover on Gear");
        Reporter.log("mouse hover on Gear" + gearMenu.toString());
    }

    public void clickOnBags() {
        clickOnElement(bags);
        CustomListeners.test.log(Status.PASS, "click on Bags");
        Reporter.log("click on Bags" + bags.toString());
    }

    public void clickOnProductName() {
        clickOnElement(overnightDuffle);
        CustomListeners.test.log(Status.PASS, "click on productname");
        Reporter.log("click on productname" + overnightDuffle.toString());
    }

    public void changeQty() {
        changeQty.clear();
        changeQty.sendKeys("3");
        CustomListeners.test.log(Status.PASS, "change quantity");
        Reporter.log("change quantity" + changeQty.toString());

    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "click on add to cart");
        Reporter.log("click on add to cart" + addToCart.toString());
    }

    // Change Qty to ‘5’
    public void changeQty5() {
        changeQty5.clear();
        changeQty5.sendKeys("5");
        CustomListeners.test.log(Status.PASS, "change qty to 5");
        Reporter.log("change qty to 5" + changeQty5.toString());
    }

    public void updateCart() {
        clickOnElement(upDateCart);
        CustomListeners.test.log(Status.PASS, "update cart");
        Reporter.log("update cart" + upDateCart.toString());
    }

//    private void verify(String xpath, String msg) {
//        List<WebElement> m1Element = driver.findElements(By.xpath("//strong[@class='product-item-name']"));
//        for (WebElement list : m1Element) {
//            String name1 = list.getText();
//            System.out.println(name1);
//        }
//    }

    public void clickOnShoppingCart() {
        clickOnElement(clickOnShoppingCart);
        CustomListeners.test.log(Status.PASS, "click on shopping cart");
        Reporter.log("click on Shopping cart" + clickOnShoppingCart.toString());
    }

    public String getProductNameText() {
        CustomListeners.test.log(Status.PASS, "verify product name text");
        Reporter.log("verify product name text" + productName.toString());
        return getTextFromElement(productName);

    }

    public String getTextAddedDuffleToCart() {
        CustomListeners.test.log(Status.PASS, "verify added duffle to cart");
        Reporter.log("verify added duffle to cart" + txtAddedDuffleToCart.toString());
        return getTextFromElement(txtAddedDuffleToCart);
    }

    public String getQty3Text() {
        String expectedmessage = "3";
        WebElement actualTextElement = qtyChangeTo3;
        String actualMessage = actualTextElement.getAttribute("value");
        CustomListeners.test.log(Status.PASS, "change quantity to 3");
        Reporter.log("change quantity to 3" + qtyChangeTo3.toString());
        return actualMessage;
    }

    public String getProductPrice() {
        CustomListeners.test.log(Status.PASS, "verify product price");
        Reporter.log("verify product price" + verifyProductPrice.toString());
        return getTextFromElement(verifyProductPrice);

    }
}

