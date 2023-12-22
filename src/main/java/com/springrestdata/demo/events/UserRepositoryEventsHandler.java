package com.springrestdata.demo.events;

import com.springrestdata.demo.model.User;
import com.springrestdata.demo.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

@RepositoryEventHandler
@Service
@Slf4j
public class UserRepositoryEventsHandler {

    @HandleBeforeCreate
    public void handleuserBeforeEventsHandler(User user) {
        if ((user.getName().toUpperCase().charAt(0) >= 'A') && (user.getName().toUpperCase().charAt(0) <= 'M')) {
            log.info("User " + user.getName() + " is to be created goes to the first part of the alphabet");
        }
        else {
            log.info("User " + user.getName() + " is to be created, goes to the second part of the alphabet");
        }
    }

    @HandleAfterCreate
    public void handleUserAfterCreate(User user) {
        log.info("I am so tired to have created "+user.getName());
    }

    @HandleBeforeDelete
    public void handleUserBeforeDelete(User user) {
        log.info("This is just to let you know that " + user.getName() + user.getName() + " is about to be deleted");
    }

    public void handleUserAfterDelete(User user) {
        log.info("Sad but true, "+ user.getName() + " has been deleted");
    }
}
