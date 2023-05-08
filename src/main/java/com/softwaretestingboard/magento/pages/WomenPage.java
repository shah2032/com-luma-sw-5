package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class WomenPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-4']//span[contains(text(),'Women')]")
    WebElement womenMenu;

    @CacheLookup
    @FindBy(linkText = "Tops")
    WebElement tops;

    @CacheLookup
    @FindBy(linkText = "Jackets")
    WebElement clickOnJackets;

    @CacheLookup
    @FindBy(xpath = "//div[2]//div[3]//select[1]")
    WebElement selectByFilterProductName;

    @CacheLookup
    @FindBy(xpath = "//select[@id='sorter']")
    WebElement selectByFilterPrice;


    public void mouseHoverOnWomen() {
        mouseHoverToElement(womenMenu);
        CustomListeners.test.log(Status.PASS, "mouse hover on Women");
        Reporter.log("mouse hover on Women" + womenMenu.toString());
    }

    public void mouseHoverOnTop() {
        mouseHoverToElement(tops);
        CustomListeners.test.log(Status.PASS, "mouse hover on Top");
        Reporter.log("mouse hove on Top" + tops.toString());
    }

    public void clickOnJacket() {
        clickOnElement(clickOnJackets);
        CustomListeners.test.log(Status.PASS, "click on jackets");
        Reporter.log("click on jackets" + clickOnJackets.toString());
    }

    public void selectFiletrFromDropDownList() {
        clickOnElement(selectByFilterProductName);
        CustomListeners.test.log(Status.PASS, "select filter from dropdown list");
        Reporter.log("select filter from dropdown list" + selectByFilterProductName.toString());
    }

    @CacheLookup
    @FindBy(xpath = "//strong[@class='product name product-item-name']")
    List<WebElement> productList;

    @CacheLookup
    @FindBy(xpath = "//span[@class='price-wrapper ']//span")
    List<WebElement> priceList;


    public void setSelectByFilterPrice() {
        selectByValueFromDropDown(selectByFilterPrice, "price");
        CustomListeners.test.log(Status.PASS, "select filter price");
        Reporter.log("select filter price" + selectByFilterPrice.toString());
    }

    public void getPriceLowToHigh() {
        List<WebElement> multiElement = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        System.out.println("Total Items are: " + multiElement.size());
        double tmpValue = 0;
        for (WebElement list : multiElement) {
            String name1 = list.getText().replaceAll("[$]", "");
            System.out.println(name1);
            double itemValue = Double.valueOf(name1);
        }
    }

    public ArrayList<String> defaultProductList() {
        // Get all the products name and stored into array list
        List<WebElement> jacketsElementsList = productList;
        ArrayList<String> jacketsNameListBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsNameListBefore.add(e.getText());
        }
        System.out.println(jacketsNameListBefore);
        CustomListeners.test.log(Status.PASS, "get product name and store in array list");
        Reporter.log("get product name and store in array list" + productList.toString());
        return jacketsNameListBefore;

    }

    public ArrayList<String> afterSortingByProductName() {
        List<WebElement> jacketElementsList = productList;
        ArrayList<String> jacketNameAfter = new ArrayList<>();
        for (WebElement value : jacketElementsList) {
            jacketNameAfter.add(value.getText());
        }
        System.out.println(jacketNameAfter);
        CustomListeners.test.log(Status.PASS, "after sort jacket list");
        Reporter.log("after sort jacket list" + productList.toString());
        return jacketNameAfter;

    }

    public ArrayList<Double> defaultProductsPriceList() {
        // Get all the products name and stored into array list
        List<WebElement> jacketsElementsList = priceList;
        ArrayList<Double> jacketsPriceListBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsPriceListBefore.add(Double.valueOf(e.getText().replace("$", "")));
        }
        System.out.println(jacketsPriceListBefore);
        Reporter.log("Default Product list" + priceList.toString());
        CustomListeners.test.log(Status.PASS, "Default Product list");
        return jacketsPriceListBefore;
    }


    public ArrayList<Double> afterSortingByProductsPriceList() {
        List<WebElement> jacketElementsList = priceList;
        ArrayList<Double> jacketPriceAfter = new ArrayList<>();
        for (WebElement value : jacketElementsList) {
            jacketPriceAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }
        System.out.println(jacketPriceAfter);
        Reporter.log("Product list after sort by Price" + priceList.toString());
        CustomListeners.test.log(Status.PASS, "Product list after sort by Price");
        return jacketPriceAfter;
    }
}