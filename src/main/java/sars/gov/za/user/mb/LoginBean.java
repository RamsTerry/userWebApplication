/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sars.gov.za.user.mb;

import sars.gov.za.user.domain.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import sars.gov.za.user.service.UserServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@RequestScoped
public class LoginBean extends BaseBean<User> {

    @Autowired
    private UserServiceLocal userService;
    private String loginParam;
    private String password;

    public void signIn() {
        User user = userService.findByUsernameAndPassword(loginParam, password);
        if (user != null) {
            getActiveUser().setLogonUserSession(user);
            getActiveUser().setName(user.getName());
            getActiveUser().setSurname(user.getSurname());
            redirect("home");
        } else {
            addErrorMessage("User does not exist on the system!");
        }
    }

    public String getLoginParam() {
        return loginParam;
    }

    public void setLoginParam(String loginParam) {
        this.loginParam = loginParam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

}
