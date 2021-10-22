package com.TryCloud.step_definitions;

import com.TryCloud.pages.CommonArea;
import com.TryCloud.pages.LoginPage;
import com.TryCloud.utilities.BrowserUtil;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class loginStepDef {
LoginPage loginPage = new LoginPage();
CommonArea commonArea = new CommonArea();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        loginPage.goTo();
        BrowserUtil.waitFor(2);
    }
    @When("user use username {string} and password {string}")
    public void user_use_username_and_password(String username, String password) {
        loginPage.login(username,password);

    }
    @When("user click login button")
    public void user_click_login_button() {


    }
    @Then("user should be at dashboard page")
    public void user_should_be_at_dashboard_page() {

        assertEquals( "Dashboard - Trycloud", Driver.getDriver().getTitle());
    }

    @When("user provide username {string} and password {string}")
    public void user_provide_username_and_password(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("we should still be at login page")
    public void we_should_still_be_at_login_page() {

    }
    @Then("login error message should be present")
    public void login_error_message_should_be_present() {
        assertTrue(loginPage.errorMsg.isDisplayed());
    }

    @Then("verify the user see the following modules")
    public void verifyTheUserSeeTheFollowingModules(List<String> mainModules) {

        for (int i=0; i<mainModules.size(); i++) {
            String expectedMOdule= mainModules.get(i);
            System.out.println("expected name= "+expectedMOdule);
            commonArea.clickModule(expectedMOdule);
           assertTrue(commonArea.mainModulesIsDisplayed(expectedMOdule));


        }
//        for (int i=0; i<mainModules.size(); i++) {
//            String expectedMOdule= mainModules.get(i);
//            System.out.println("expected name= "+expectedMOdule);
//
//            String actualModule = commonArea.getMainModuleText(expectedMOdule);
//            assertEquals(expectedMOdule, actualModule);
//        }

    }
}
