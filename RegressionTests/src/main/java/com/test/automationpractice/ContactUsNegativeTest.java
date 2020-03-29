package com.test.automationpractice;

import com.pageobjects.AutomationPracticePage.ContactUsPage;
import com.testFramework.core.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ContactUsNegativeTest extends BaseTest {

    ContactUsPage contactUsPage;

    @Before
    public void prepare(){
        contactUsPage = new ContactUsPage(getDriver());
    }


    //Invalid email address
    @Test()
    public void sendAReportToCustomerServiceInvalidEmail(){

        contactUsPage.openContactUsPage();
        contactUsPage.selectSubjectHeading("Customer service");
        contactUsPage.setEmailAddress("chalas");
        contactUsPage.setOrderReference("2020");
        contactUsPage.setMessage("Tengo un problema");
        contactUsPage.sendMessageForm();
        contactUsPage.isInvalidEmailErrorDisplayed();

    }

    @Test()
    public void sendAReportToCustomerServiceWithOutPutEmailAddress(){

        contactUsPage.openContactUsPage();
        contactUsPage.selectSubjectHeading("Customer service");
        contactUsPage.setEmailAddress("");
        contactUsPage.setOrderReference("2020");
        contactUsPage.setMessage("Tengo un problema");
        contactUsPage.sendMessageForm();
        contactUsPage.isInvalidEmailErrorDisplayed();

    }


    @Test()
    public void sendAReportToCustomerServiceWithOutMessage(){

        contactUsPage.openContactUsPage();
        contactUsPage.selectSubjectHeading("Customer service");
        contactUsPage.setEmailAddress("chalas@gmail.com");
        contactUsPage.setOrderReference("2020");
        contactUsPage.setMessage("");
        contactUsPage.sendMessageForm();
        contactUsPage.isMessageBlankErrorDisplayed();

    }


    @Test()
    public void sendAReportToCustomerServiceWithOutSelectSubjectHeading(){

        contactUsPage.openContactUsPage();
        contactUsPage.selectSubjectHeading("-- Choose --");
        contactUsPage.setEmailAddress("chalas@gmail.com");
        contactUsPage.setOrderReference("2020");
        contactUsPage.setMessage("Tengo un problema");
        contactUsPage.sendMessageForm();
        contactUsPage.isSubjectNotSelectedErrorDisplayed();

    }




}
