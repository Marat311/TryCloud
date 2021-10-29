package com.TryCloud.step_definitions;


import com.TryCloud.pages.FilesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class us4_addFavoriteFileStepDefs {

FilesPage file = new FilesPage();

    @When("Choose {string} option")
    public void choose_option(String addToFavorites) {
    file.clickAddToFavorite(addToFavorites);

    }
    @When("Click {string} sub-module on the left side")
    public void click_sub_module_on_the_left_side(String favoritesOption) {
        file.clickOption(favoritesOption);
    }
    @Then("Verify the chosen file {string} is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table(String folderName) {
        System.out.println("file.fileIsDisplayed(folderName) = " + file.fileIsDisplayed(folderName));
       assertTrue(file.fileIsDisplayed(folderName));


    }


}
