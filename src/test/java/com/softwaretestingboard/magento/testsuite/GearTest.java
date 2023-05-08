package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.GearPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class GearTest extends BaseTest {
    GearPage gearPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        gearPage=new GearPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // * Mouse Hover on Gear Menu
        Thread.sleep(2000);
        gearPage.mouseHoverOnGear();

        //* Click on Bags
        gearPage.clickOnBags();

        //* Click on Product Name ‘Overnight Duffle’
        gearPage.clickOnProductName();

        //* Change Qty 3
        gearPage.changeQty();

        //* Click on ‘Add to Cart’ Button.
        gearPage.clickOnAddToCart();

        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        Assert.assertEquals(gearPage.getTextAddedDuffleToCart(), "You added Overnight Duffle to your shopping cart.");
        // Click on ‘shopping cart’ Link into message
        gearPage.clickOnShoppingCart();

        //Verify the product name ‘Overnight Duffle’
        Assert.assertEquals(gearPage.getProductNameText(), "Overnight Duffle");

        // Verify the Qty is ‘3’
        Assert.assertEquals(gearPage.getQty3Text(), "3");

        //* Change Qty to ‘5’
        gearPage.changeQty5();

        //Click on ‘Update Shopping Cart’ button
        gearPage.updateCart();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        //Verify the product price ‘$225.
        Assert.assertEquals(gearPage.getProductPrice(), "$225.00");

    }
}

