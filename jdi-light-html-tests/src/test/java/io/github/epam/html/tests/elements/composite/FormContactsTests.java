package io.github.epam.html.tests.elements.composite;

import io.github.com.entities.Contacts;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static com.epam.jdi.light.common.FormFilters.ALL;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FormContactsTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
    }

    @DataProvider(name = "contacts")
    public static Object[][] createContacts() {
        return new Object[][] {
                {generateContact(getRandomNumberString())},
                {generateContact(getRandomNumberString())},
                {generateContact(getRandomNumberString())},
                {generateContact(getRandomNumberString())},
                {generateContact(getRandomNumberString())},
                {generateContact(getRandomNumberString())},
                {generateContact(getRandomNumberString())}
        };
    }


    @Test(dataProvider = "contacts")
    public void fillContactFormTest(Contacts contact) {
        main.contactForm.fill(contact);
        main.contactForm.check(contact);
    }

    @Test
    public void submitTextToContactFormTest() {
        main.contactForm.submit("Roman");
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void submitEntityToContactFormTest(Contacts contact) {
        main.contactForm.submit(contact);
        main.contactForm.check(contact);
        checkContactFormSubmitted();
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        main.contactForm.submit("Roman", "custom");
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitTextToContactFormUsingNonExistentButtonTest() {
        main.contactFormCustom.submit("Roman", "nonExistent");
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void submitEntityToContactFormUsingCustomButtonTest(Contacts contact) {
        main.contactForm.submit(contact, "custom");
        main.contactForm.check(contact);
        checkContactFormSubmitted();
    }

    @Test
    public void submitEntityToContactFormUsingNonExistentButtonTest() {
        main.contactFormCustom.submit(DEFAULT_CONTACT, "nonExistent");
    }

    @Test(dataProvider = "contacts")
    public void plainSubmitTest(Contacts contact) {
        main.contactForm.fill(contact);
        main.contactForm.submit();
        main.contactForm.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void pressButtonTest(Contacts contact) {
        main.contactFormCustom.fill(contact);
        main.contactFormCustom.pressButton("custom");
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void verifyMethodPositiveTest(Contacts contact) {
        main.contactForm.fill(contact);
        List<String> verified = main.contactForm.verify(contact);
        assertEquals(verified.size(), 0);
    }

    @Test
    public void verifyMethodNegativeTest() {
        main.contactForm.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = main.contactForm.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 1);
        assertTrue(verified.get(0).contains("Roman"));
    }

    @Test(dataProvider = "contacts")
    public void checkMethodPositiveTest(Contacts contact) {
        main.contactForm.fill(contact);
        main.contactForm.check(contact);
        assertEquals(main.contactForm.verify(contact).size(), 0);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void checkMethodNegativeTest() {
        main.contactForm.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        TIMEOUTS.element.set(1);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test(dataProvider = "contacts")
    public void sendMethodTest(Contacts contact) {
        main.contactFormCustom.fill(contact);
        main.contactFormCustom.send();
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void sendEntityMethodTest(Contacts contact) {
        main.contactFormCustom.send(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void addEntityMethodTest(Contacts contact) {
        main.contactFormCustom.add(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void publishMethodTest(Contacts contact) {
        main.contactFormCustom.publish(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void saveMethodTest(Contacts contact) {
        main.contactFormCustom.save(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void updateMethodTest(Contacts contact) {
        main.contactFormCustom.update(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void cancelMethodTest(Contacts contact) {
        main.contactFormCustom.cancel(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void closeMethodTest(Contacts contact) {
        main.contactFormCustom.close(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void backMethodTest(Contacts contact) {
        main.contactFormCustom.back(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void selectMethodTest(Contacts contact) {
        main.contactFormCustom.select(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void nextMethodTest(Contacts contact) {
        main.contactFormCustom.next(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "contacts")
    public void searchMethodTest(Contacts contact) {
        main.contactFormCustom.search(contact);
        main.contactFormCustom.check(contact);
        checkContactFormSubmitted();
    }

    @Test
    public void onlyMandatoryOptionTest() {
        main.contactFormCustom.onlyMandatory().fill(DEFAULT_CONTACT);
        main.contactFormCustom.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactFormCustom.getFilter(), ALL);
    }

    @Test
    public void onlyOptionalOptionTest() {
        main.contactFormCustom.onlyOptional().fill(DEFAULT_CONTACT);
        main.contactFormCustom.check(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactFormCustom.getFilter(), ALL);
    }

    @Test
    public void overriddenFillActionTest() {
        main.contactFormCustomFill.fill(DEFAULT_CONTACT);
        main.contactFormCustomFill.check(UPPER_CASE_NAME_CONTACT);
    }

    @Test(dataProvider = "contacts")
    public void uiFormTest(Contacts contact) {
        main.contactFormUI.submit(contact);
        main.contactFormUI.check(contact);
        checkContactFormSubmitted();
    }

    @Test
    public void overriddenGetActionTest() {
        main.contactFormCustomGet.fill(DEFAULT_CONTACT);
        main.contactFormCustomGet.check(LOWER_CASE_NAME_CONTACT);
    }

    private void checkContactFormSubmitted() {
        lastLogEntry.assertThat()
                .text(containsString("submit:button clicked"));
    }

    // It will generate 6 digit random Number
    private static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
