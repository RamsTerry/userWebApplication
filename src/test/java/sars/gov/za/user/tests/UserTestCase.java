/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sars.gov.za.user.tests;

import sars.gov.za.user.config.TestDataSourceConfiguration;
import sars.gov.za.user.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import sars.gov.za.user.service.UserServiceLocal;

/**
 *
 * @author S2028398
 */
@EnableJpaAuditing
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class UserTestCase {

    @Autowired
    private UserServiceLocal userService;

    public UserTestCase() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testScenarioA() {
        User user = BootStrapHelper.getUser("TRamurebiwa", "P@sswords.","Terry Khudani","Ramurebiwa","TRamurebiwa@sars.gov.za","0799035403");
        userService.save(user);
    }
}
