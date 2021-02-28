package com.fetchR.step_definitions;

import com.fetchR.pages.FakeFinderPage;
import com.fetchR.utilities.ConfigurationReader;
import com.fetchR.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FakeBarFinder_StepDefinitions {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    FakeFinderPage fakeFinderPage = new FakeFinderPage();
    WebElement fakeBar=null;

    @Given("Algorithm is on the landing page")
    public void Algorithm_is_on_the_landing_page(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
String expectedtitle = "React App";
String currentURL = "http://ec2-54-208-152-154.compute-1.amazonaws.com/";

        Assert.assertTrue("Title verification Failed",Driver.getDriver().getTitle().equals(expectedtitle));
        Assert.assertTrue("URL verification Failed",Driver.getDriver().getCurrentUrl().equals(currentURL));

    }

    @When("Algorithm places bar numbers in the boxes and asserts the fake bar group")
    public void algorithmPlacesBarNumbersInTheBoxesAndAssertsTheFakeBarGroup() {
        wait.until(ExpectedConditions.visibilityOf(fakeFinderPage.left0));
        //place 123 on left  456 on right
        fakeFinderPage.left0.sendKeys("1");
        fakeFinderPage.left1.sendKeys("2");
        fakeFinderPage.left2.sendKeys("3");
       fakeFinderPage.right0.sendKeys("4");
        fakeFinderPage.right1.sendKeys("5");
        fakeFinderPage.right2.sendKeys("6");

        Driver.waiter(1000);
        fakeFinderPage.weigh.click();
        //assert the sign in the response box
        wait.until(ExpectedConditions.visibilityOf(fakeFinderPage.responseTableRow1));
        String line1Response = fakeFinderPage.responseTableRow1.getText();
        Driver.waiter(1000);

        if(line1Response.contains("=")){
            wait.until(ExpectedConditions.visibilityOf(fakeFinderPage.reset));
            Driver.waiter(1000);

            fakeFinderPage.reset.click();

            fakeFinderPage.left0.sendKeys("7");
            fakeFinderPage.right0.sendKeys("8");

            wait.until(ExpectedConditions.elementToBeClickable(fakeFinderPage.weigh));

            fakeFinderPage.weigh.click();
            Driver.waiter(1000);

            wait.until(ExpectedConditions.visibilityOf(fakeFinderPage.responseTableRow2));
            String line2Response = fakeFinderPage.responseTableRow2.getText();
            Driver.waiter(1000);
                if(line2Response.contains("=")){
                    fakeBar = fakeFinderPage.coin_0;
                }else if(line2Response.contains(">")){
                    fakeBar=fakeFinderPage.coin_8;
                }else{
                    fakeBar=fakeFinderPage.coin_7;
                }

        }else if(line1Response.contains(">")){
           wait.until(ExpectedConditions.visibilityOf(fakeFinderPage.reset));
            Driver.waiter(1000);

            fakeFinderPage.reset.click();
            Driver.waiter(1000);

            fakeFinderPage.left0.sendKeys("4");
            fakeFinderPage.right0.sendKeys("5");
            Driver.waiter(1000);

            fakeFinderPage.weigh.click();
            Driver.waiter(1000);

            wait.until(ExpectedConditions.visibilityOf(fakeFinderPage.responseTableRow2));
            String line2Response = fakeFinderPage.responseTableRow2.getText();
                if(line2Response.contains("=")){
                    fakeBar = fakeFinderPage.coin_6;
                }else if(line2Response.contains(">")){
                    fakeBar=fakeFinderPage.coin_5;
                }else{
                    fakeBar=fakeFinderPage.coin_4;
                }

        } else if(line1Response.contains("<")){
            wait.until(ExpectedConditions.visibilityOf(fakeFinderPage.reset));
            Driver.waiter(1000);

            fakeFinderPage.reset.click();
            Driver.waiter(1000);

            fakeFinderPage.left0.sendKeys("1");
            fakeFinderPage.right0.sendKeys("2");
            Driver.waiter(1000);

            fakeFinderPage.weigh.click();
            Driver.waiter(1000);

            wait.until(ExpectedConditions.visibilityOf(fakeFinderPage.responseTableRow2));
            String line2Response = fakeFinderPage.responseTableRow2.getText();
            if(line2Response.contains("=")){
                fakeBar = fakeFinderPage.coin_3;
            }else if(line2Response.contains(">")){
                fakeBar=fakeFinderPage.coin_2;
            }else{
                fakeBar=fakeFinderPage.coin_1;
            }

        }


    }

    @Then("Algorithm detects the fake bar")
    public void algorithmDetectsTheFakeBar() {
        wait.until(ExpectedConditions.visibilityOf(fakeFinderPage.coin_0));
        Driver.waiter(1000);

        fakeBar.click();
      Driver.waiter(1000);
        Alert alert = Driver.getDriver().switchTo().alert();
        Driver.waiter(1000);

        String alertMessasge = alert.getText();
        String expectedAlertMessasge = "Yay! You find it!";
        Driver.waiter(1000);

        Assert.assertTrue("Alert Message FAILED" ,alertMessasge.contains(expectedAlertMessasge));
        Driver.waiter(1000);
        //System.out.println(alertMessasge);

        alert.accept();

        Driver.waiter(1000);
        Driver.getDriver().close();

    }
}

