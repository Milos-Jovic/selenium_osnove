
import org.testng.Assert;
import org.testng.annotations.*;
 import retry.BootsnippRetry;


public class BootsnipTests extends BasicTest{


            @Test(priority = 1, retryAnalyzer = BootsnippRetry.class)
            public void doesPageIsOpened() {
                Assert.assertEquals(driver.getTitle(),
                        "Table with Edit and Update Data - Bootsnipp.com",
                        "Error message");
    }


            @Test(priority = 2, retryAnalyzer = BootsnippRetry.class)
            public void editRow() {

                String firstName = "Milos";
                String lastName = "Jovic";
                String middleName = "Jovan";

                Assert.assertEquals(tabelPage.getRowNumber(),
                        2, "Error message");


                updateDialogPage.waitForDialogToBeVisible();
                updateDialogPage.clearAndTypeFirstName(firstName);
                updateDialogPage.clearAndTypeLastName(lastName);
                updateDialogPage.clearAndTypeMiddleName(middleName);
                updateDialogPage.clickOnUpdateButton();
                updateDialogPage.waitForDialogToBeInvisible();


                Assert.assertEquals(tabelPage.getFirstNameColumnValue(0),
                        firstName,
                        "First name should be updated in first row");

                Assert.assertEquals(tabelPage.getLastNameColumnValue(0),
                        lastName, "Last name should be updated in first row");

                Assert.assertEquals(tabelPage.getMiddleNameColumnValue(0),
                        lastName, "Milddle name should be updated in first row");


            }

                @Test(priority = 3, retryAnalyzer = BootsnippRetry.class)
                public void deleteRow(){

                  int rowNumberBeforeDelete =  tabelPage.getRowNumber();

                tabelPage.clickOnDeleteButtonByRowIndex(0);
                deleteDialogPage.waitForDialogToBeVisible();
                Assert.assertEquals(deleteDialogPage.getDialogBodyMessage(),
                        "Are you sure you want to delete this data?"
                        , "Delete dialog message is not valid.");

                    deleteDialogPage.clickOnDeleteButton();;
                    deleteDialogPage.waitForDialogToBeInvisible();

                    int rowNumberAfterDelete = tabelPage.getRowNumber();

                    Assert.assertEquals(rowNumberAfterDelete,rowNumberBeforeDelete - 1,
                            "Row shuld be deleted.");

                }

}

