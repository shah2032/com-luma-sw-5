package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.MenPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MenTest extends BaseTest {
    MenPage menPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        menPage= new MenPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        /// Mouse Hover on Men Menu
        menPage.mouseHoverOnMenMenu();

        //Mouse Hover on Bottoms
        menPage.mouseHoverOnBottoms();

        //Click on Pants
        menPage.clickOnPants();

        // Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        menPage.sortByProductName();
        menPage.clickOnCronousSize32();

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        menPage.clickOnCronousBlack();

        // //Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button
        menPage.mouseHoverOnCronusYogaAndClickAddCart();

        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        Assert.assertEquals(menPage.getSuccessMsgText(), "You added Cronus Yoga Pant to your shopping cart.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Click on ‘shopping cart’ Link into message
        menPage.clickOnShoppingCartLink();

        // Verify the text ‘Shopping Cart.’
        Assert.assertEquals(menPage.getShoppingCartText(), "Shopping Cart");

        // Verify the product name ‘Cronus Yoga Pant’
        Assert.assertEquals(menPage.getProductName(), "Cronus Yoga Pant");

        // Verify the product size ‘32’
        Assert.assertEquals(menPage.getProductSize(), "32");

        // Verify the product colour ‘Black’
        Assert.assertEquals(menPage.getProductColour(), "Black");
    }
}


