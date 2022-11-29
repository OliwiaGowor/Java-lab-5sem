/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Model class of the application responsible for list of users data.
 *
 * @author Oliwia Gowor
 * @version 4.0
 */
public class UsersList {

    /**
     * List of users.
     */
    private List<User> usersList;

    /**
     * Non-parameter UsersList class constructor.
     */
    public UsersList() {
        this.usersList = new ArrayList();
        initialize();
    }

    /**
     * UsersList class constructor.
     *
     * @param usersList parameter represents list of users
     */
    public UsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    /**
     * Method initializes list with some data.
     */
    public void initialize() {
        User user1 = new User("admin", "admin");
        User user2 = new User("guest", "guest");
        this.usersList.add(user1);
        this.usersList.add(user2);

    }

    /**
     * Method returns usersList class parameter.
     *
     * @return parameter representing list of users
     */
    public List<User> getUsersList() {
        return usersList;
    }

    /**
     * Method sets usersList class parameter.
     *
     * @param usersList parameter representing list of orders
     */
    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    /**
     * Method responsible for adding new user to the list.
     *
     * @param user parameter representing user to add to the list
     * @return true if user was added properly, false if user wasn't added properly
     */
    public Boolean addUser(User user) {
        if ( usersList.add(user)) {
            return true;
        } else {
            return false;
        }
    }
}