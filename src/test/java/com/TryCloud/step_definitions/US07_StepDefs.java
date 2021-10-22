package com.TryCloud.step_definitions;

import com.TryCloud.pages.CommonArea;
import com.TryCloud.pages.DeletedPage;
import com.TryCloud.pages.FilesPage;
import com.TryCloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class US07_StepDefs {
    CommonArea area = new CommonArea();
    FilesPage filesPage = new FilesPage();
    public static String expectedFileText = "dfdfd";

    @When("Clicks action-icon from any file on the page")
    public void click_action_icon_from_any_file_on_the_page() {
    //    BrowserUtil.waitFor(2);

        area.filesModule.click();
        expectedFileText = filesPage.fileForDelete.getText();
        System.out.println("expectedFileText = " + expectedFileText);
        filesPage.action_icon.click();
     //   BrowserUtil.waitFor(1);
        filesPage.deleteFile.click();
      //  BrowserUtil.waitFor(1);

    }

    @When("Choose “delete files” option")
    public void choose_delete_files_option() {

        filesPage.deletedFiles.click();
    //    BrowserUtil.waitFor(1);

    }

    @Then("Verify the deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_no_the_page() {

        DeletedPage deletedPage = new DeletedPage();
        boolean delFile = deletedPage.deletedFile.isDisplayed();

        System.out.println("delFile = " + delFile);

      //  BrowserUtil.waitFor(1);

        assertTrue(delFile);

        if(delFile){
            deletedPage.restore.click();
        //    BrowserUtil.waitFor(1);
        }

    }
}