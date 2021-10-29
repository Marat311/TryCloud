package com.TryCloud.step_definitions;

import com.TryCloud.pages.CommonArea;
import com.TryCloud.pages.FilesPage;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileTitleStepDefs {

     CommonArea area = new CommonArea();
     FilesPage filesPage = new FilesPage();

    @Then("Verify the page tile is {string}")
    public void verify_the_page_tile_is(String title) {
        area.filesModule.click();
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("Driver.getDriver().getTitle() = " + actualTitle);
        assertEquals(title, actualTitle);
    }


    @When("user click the top left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filesPage.fileCheckbox.click();
    }

    @Then("user should see all the files are selected")
    public void user_should_see_all_the_files_are_selected() {
        assertTrue(filesPage.checkboxIsSelected());

    }

}
