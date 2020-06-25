package com.demo.spring.springselenium.visatest;

import com.demo.spring.springselenium.SpringBaseTestNGTest;
import com.demo.spring.springselenium.entity.User;
import com.demo.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.demo.spring.springselenium.page.visa.VisaRegistrationPage;
import com.demo.spring.springselenium.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;

public class UserVisaTest extends SpringBaseTestNGTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserVisaTest.class);

    @LazyAutowired
    private VisaRegistrationPage registrationPage;

    @LazyAutowired
    private UserRepository userRepository;

    @Test(dataProvider = "getData")
    public void visaTest(User u) {
        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
        this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();

        LOGGER.info("Request confirmation # INFO: " + this.registrationPage.getConfirmationNumber());
        LOGGER.warn("Request confirmation # WARN: " + this.registrationPage.getConfirmationNumber());
    }

    @DataProvider
    public Object[] getData(ITestContext context) {
        return this.userRepository.findByDobBetween(
                Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo"))
        )
                .stream()
                .limit(1)
                .toArray();
    }

    //    @Test
//    public void visaTest() {
//        List<User> users = this.userRepository.findByDobBetween(Date.valueOf("1995-01-01"), Date.valueOf("1999-01-01"))
//                .stream()
//                .limit(3)
//                .collect(Collectors.toList());
//
//        for (User u : users) {
//            this.registrationPage.goTo();
//            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
//            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
//            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
//            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
//            this.registrationPage.setComments(u.getComments());
//            this.registrationPage.submit();
//            System.out.println(this.registrationPage.getConfirmationNumber());
//        }
//    }

//    @Test
//    public void visaTest() {
//        this.userRepository.findById(85)
//                .ifPresent(user -> System.out.println(user.getFirstName()));
//    }

//    @Test
//    public void visaTest() {
//        System.out.println(
//                this.userRepository.findAll().size()
//        );
//    }

}
