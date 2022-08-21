/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sars.gov.za.user.mb;

import sars.gov.za.user.domain.User;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author S2028398
 */
@ManagedBean
@SessionScoped
public class ActiveUser implements Serializable {

    private String name;
    private String surname;
    private String username;
    private String moduleWelcomeMessage;
    private boolean userLoginIndicator;

    public ActiveUser() {
        userLoginIndicator = Boolean.FALSE;
    }

    public void setLogonUserSession(User user) {
        this.setName(getName());
        this.setSurname(getSurname());
        this.setUserLoginIndicator(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getModuleWelcomeMessage() {
        return moduleWelcomeMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setModuleWelcomeMessage(String moduleWelcomeMessage) {
        this.moduleWelcomeMessage = moduleWelcomeMessage;
    }

    public boolean isUserLoginIndicator() {
        return userLoginIndicator;
    }

    public void setUserLoginIndicator(boolean userLoginIndicator) {
        this.userLoginIndicator = userLoginIndicator;
    }
    
    
}
