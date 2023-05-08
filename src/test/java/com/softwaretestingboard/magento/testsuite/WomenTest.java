package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.WomenPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(CustomListeners.class)
public class WomenTest extends BaseTest {
    WomenPage womenPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        womenPage= new WomenPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //* Mouse Hover on Women Menu
        womenPage.mouseHoverOnWomen();

        //* Mouse Hover on Tops
        Thread.sleep(1000);
        womenPage.mouseHoverOnTop();

        //* Click on Jackets
        womenPage.clickOnJacket();

        //* Verify the products name display in alphabetical order
        List<WebElement> jacketsElementsList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        ArrayList<String> jacketsNameListBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsNameListBefore.add(e.getText());
        }
        System.out.println(jacketsNameListBefore);
        jacketsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);
        //* Select Sort By filter “Product Name”
        womenPage.selectFiletrFromDropDownList();

        //* Verify the products name display in alphabetical order
        Assert.assertEquals(womenPage.afterSortingByProductName(),womenPage.defaultProductList());

    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //* Mouse Hover on Women Menu
        womenPage.mouseHoverOnWomen();

        //* Mouse Hover on Tops
        womenPage.mouseHoverOnTop();

        //* Click on Jackets
        womenPage.clickOnJacket();

        Thread.sleep(2000);
        List<WebElement> jacketsElementsList = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        ArrayList<Double> jacketsPriceListBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsPriceListBefore.add(Double.valueOf(e.getText().replace("$", "")));
        }
        System.out.println(jacketsPriceListBefore);
        //* Select Sort By filter “Price”
        womenPage.setSelectByFilterPrice();

        //* Verify the products price display in Low to High
        Thread.sleep(2000);
        Assert.assertEquals(womenPage.defaultProductsPriceList(),womenPage.afterSortingByProductsPriceList());
    }
}
