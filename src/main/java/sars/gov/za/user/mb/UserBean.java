/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sars.gov.za.user.mb;

import sars.gov.za.user.domain.User;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import sars.gov.za.user.service.UserServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class UserBean extends BaseBean<User> {

    @Autowired
    private UserServiceLocal userService;

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PostConstruct
    public void init() {
        reset().setList(true);
        setPanelTitleName("Users");
        addCollections(userService.listAll());
    }

    public void addOrUpdate(User user) {
        reset().setAdd(true);
        if (user != null) {
            setPanelTitleName("Update User");
            user.setUpdatedBy(getActiveUser().getName());
            user.setUpdatedDate(new Date());
        } else {
            setPanelTitleName("Add User");
            user = new User();
            user.setCreatedBy(getActiveUser().getName());
            user.setCreatedDate(new Date());
            addCollection(user);
        }
        addEntity(user);
    }

    public void save(User user) {
        if (user.getId() != null) {
            userService.update(user);
            addInformationMessage("User was successfully updated.");
        } else {
            userService.save(user);
            addInformationMessage("User was successfully created.");
        }
        reset().setList(true);
        setPanelTitleName("Users");
    }

    public void cancel(User user) {
        if (user.getId() == null) {
            if (getCollections().contains(user)) {
                getCollections().remove(user);
            }
        }
        this.reset().setList(true);
        setPanelTitleName("Users");
    }

    public void delete(User user) {
        userService.deleteById(user.getId());
        synchronize(user);
        addInformationMessage("User successfully deleted");
        reset().setList(true);
        setPanelTitleName("Users");
    }

    public void synchronize(User user) {
        Iterator<User> userList = getCollections().iterator();
        while (userList.hasNext()) {
            if (userList.next().getId().equals(user.getId())) {
                userList.remove();
            }
        }
    }

}
