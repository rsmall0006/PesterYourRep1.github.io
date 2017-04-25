package com.pester.controllers;

//import com.pester.entities.LogInUser;
import com.pester.entities.User;
import com.pester.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Merlin on 4/21/17.
 */
@Controller
public class PesterYourRepController {


    @Autowired
    UserRepository users;

/*    @RequestMapping(path="/splash", method = RequestMethod.GET)
    public String splash(Model model, HttpSession session) {
        return "redirect:/splash.html";
    }
*/

/*
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        //model.addAttribute("name", session.getAttribute("firstName"));
        return "login.html";
    }

    @RequestMapping(path = "/index", method = RequestMethod.POST)
    public String home2(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("firstName"));
        return "index.html";
    }
*/

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session,
                        @RequestParam String emailAddress,
                        @RequestParam String password
                        ) throws Exception {
        User user = users.findFirstByEmailAddress(emailAddress);
        if (!emailAddress.equals(user.getEmailAddress())) {
            throw new Exception("Invalid email, please SIGN UP");
        } else if (!password.equals(user.getPassword())) {
            throw new Exception("Incorrect password");
        } else {
//            session.setAttribute("emailAddress", emailAddress);
            return "redirect:/repSearch.html";
        }
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/signUp", method = RequestMethod.POST)
    public String signUp(HttpSession session,
                         @RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String emailAddress,
                         @RequestParam String password
                         ) throws Exception {
        User user2 = new User(firstName, lastName, emailAddress, password);
        users.save(user2);
        User user1 = users.findFirstByEmailAddress(emailAddress);
        if (!emailAddress.equals(user1.getEmailAddress())) {
           //add user to the database

        }
            return "redirect:/repSearch.html";

    }
}
