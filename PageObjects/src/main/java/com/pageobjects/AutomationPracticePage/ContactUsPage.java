package com.pageobjects.AutomationPracticePage;

import com.testFramework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage{

    String url = "http://automationpractice.com/index.php?controller=contact";


    @FindBy(how = How.XPATH, using = "//span[@class='navigation_page'][contains(text(),'Contact')]")
    public WebElement navigationContactLbl;

    @FindBy(how = How.ID, using = "id_contact")
    public WebElement subjectHeadingDrop;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailAddressTxt;

    @FindBy(how = How.ID, using = "id_order")
    public WebElement orderReferenceTxt;

    @FindBy(how = How.ID, using = "fileUpload")
    public WebElement fileUploadBtn;

    @FindBy(how = How.ID, using = "message")
    public WebElement messageTxt;

    @FindBy(how = How.ID, using = "submitMessage")
    public WebElement sendBtn;

    @FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
    public WebElement messageSentLbl;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']/p[contains(text(),'There is 1 error')]")
    public WebElement errorTitleLbl;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']/ol/li[contains(text(),'The message cannot be blank.')]")
    public WebElement errorMessageBlankLbl;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']/ol/li[contains(text(),'Invalid email address.')]")
    public WebElement errorInvalidEmailLbl;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']/ol/li[contains(text(),'Please select a subject from the list provided.')]")
    public WebElement errorSubjectNotSelectedLbl;




    public ContactUsPage(WebDriver driver) {
        super(driver);
    }


    public void openContactUsPage() {
        driver.get(url);
    }

    public void selectSubjectHeading(String subjectHeading){
       // waitForElementToBeLoaded(subjectHeadingDrop);
        Select categories = new Select(subjectHeadingDrop);
        categories.selectByVisibleText(subjectHeading);
    }


    public void setEmailAddress(String emailAddress){
        waitForElementToBeLoaded(emailAddressTxt);
        emailAddressTxt.sendKeys(emailAddress);

    }

    public void setOrderReference(String orderReference){
        waitForElementToBeLoaded(orderReferenceTxt);
        orderReferenceTxt.sendKeys(orderReference);

    }

    public void attachFile (String filePath){
        waitForElementToBeLoaded(fileUploadBtn);
        fileUploadBtn.sendKeys(filePath);

    }


    public void setMessage (String message){
        waitForElementToBeLoaded(messageTxt);
        messageTxt.sendKeys(message);

    }

    public void sendMessageForm( ){
        waitForElementToBeLoaded(sendBtn);
        sendBtn.click();

    }

    public void isMessageSentSuccessfully() {
        waitForElementToBePresent(messageSentLbl);
        assert messageSentLbl.isDisplayed();
    }


    public void isErrorDisplayed() {
        waitForElementToBePresent(errorTitleLbl);
        assert errorTitleLbl.isDisplayed();
    }

    public void isMessageBlankErrorDisplayed() {
        waitForElementToBePresent(errorMessageBlankLbl);
        assert errorMessageBlankLbl.isDisplayed();
    }

    public void isInvalidEmailErrorDisplayed() {
        waitForElementToBePresent(errorInvalidEmailLbl);
        assert errorInvalidEmailLbl.isDisplayed();
    }

    public void isSubjectNotSelectedErrorDisplayed() {
        waitForElementToBePresent(errorSubjectNotSelectedLbl);
        assert errorSubjectNotSelectedLbl.isDisplayed();
    }


}
