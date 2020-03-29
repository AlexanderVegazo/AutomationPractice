package com.test.automationpractice;

import com.pageobjects.AutomationPracticePage.ContactUsPage;
import com.testFramework.core.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class ContactUsTest extends BaseTest {

    ContactUsPage contactUsPage;

    @Before
    public void prepare(){
        contactUsPage = new ContactUsPage(getDriver());
    }

    @Test()
    public void sendAReportToCustomerService(){

        contactUsPage.openContactUsPage();
        contactUsPage.selectSubjectHeading("Customer service");
        contactUsPage.setEmailAddress("chalas@gmail.com");
        contactUsPage.setOrderReference("2020");
        contactUsPage.setMessage("Tengo un problema");
        contactUsPage.sendMessageForm();
        contactUsPage.isMessageSentSuccessfully();

    }

    @Test()
    public void sendAReportToCustomerServiceWithOutOrderReference(){

        contactUsPage.openContactUsPage();
        contactUsPage.selectSubjectHeading("Customer service");
        contactUsPage.setEmailAddress("chalas@gmail.com");
        contactUsPage.setOrderReference("");
        contactUsPage.setMessage("Tengo un problema");
        contactUsPage.sendMessageForm();
        contactUsPage.isMessageSentSuccessfully();

    }





}
