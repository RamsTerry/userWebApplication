/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sars.gov.za.user.tests;

import sars.gov.za.user.domain.User;
import java.util.Date;

/**
 *
 * @author S2028398
 */
public class BootStrapHelper {

    public static User getUser(String username, String password, String name, String surname, String emailAddress, String contactNumber) {
        User user = new User();
        user.setCreatedBy("Terry");
        user.setCreatedDate(new Date());
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setEmailAddress(emailAddress);
        user.setContactNumber(contactNumber);
        user.setPassword(password);
        return user;
    }
}
