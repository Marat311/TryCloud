package com.TryCloud.step_definitions;

import com.TryCloud.pages.FilesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.junit.Assert.*;

public class us5_removeFromFavoriteStepDef {

        FilesPage filesPage = new FilesPage();
    @When("Click {string} option")
    public void click_option(String removeBtn) {

        filesPage.clickAddToFavorite(removeBtn);
  }
    @Then("Verify that the {string} file is removed from Favorites sub-module's table.")
    public void verify_that_the_file_is_removed_from_favorites_sub_module_s_table(String folderName) {

        assertFalse(filesPage.fileIsNotDisplayed(folderName));

         }
    @When("Click the + icon on top")
    public void click_the_icon_on_top() {
        filesPage.plusSign.click();
    }
   @When("Click {string}")

    public void click(String uploadFile) {
       try {
           filesPage.uploadFile(uploadFile);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    @Then("Verify the {string} file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page(String file) {
        assertTrue(filesPage.fileIsNotDisplayed(file));

    }


}
