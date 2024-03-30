package com.ftn.TravelOrganisation.listeners;


import com.ftn.realestatemanagement.controller.AuthenticationController;
import com.ftn.realestatemanagement.dto.PersonDto;
import com.ftn.realestatemanagement.model.Person;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.stereotype.Component;



@Component
public class InitHttpSessionListener implements HttpSessionListener {

    /** kod koji se izvrsava po kreiranju sesije */
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("Inicijalizacija sesisje HttpSessionListener...");
//
//		//pri kreiranju sesije inicijalizujemo je ili radimo neke dodatne aktivnosti
        PersonDto logedInUser = null;
        HttpSession session  = arg0.getSession();
        session.setAttribute(AuthenticationController.LOGED_IN_USER, logedInUser);

    }

    /** kod koji se izvrsava po brisanju sesije */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("Brisanje sesisje HttpSessionListener...");

    }


}


