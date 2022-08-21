/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sars.gov.za.user.service;

import sars.gov.za.user.domain.User;
import java.util.List;

/**
 *
 * @author S2028398
 */
public interface UserServiceLocal {

    User save(User user);

    User findById(Long id);

    User update(User user);

    User deleteById(Long id);

    List<User> listAll();

    User findByUsernameAndPassword(String username, String password);
}
