package com.springrestdata.demo.events;

import com.springrestdata.demo.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
public class RepositoryEventListener extends AbstractRepositoryEventListener<User> {

    @Override
    public void onBeforeCreate(User user) {
        log.info("I'll make an effort to create this User " + user.getName());
    }

    @Override
    public void onAfterCreate(User user) {
        log.info("I did my best and I was able to create " + user.getName());
    }

    @Override
    public void onBeforeSave(User user) {
        log.info("I'll take a breath and I will save " + user.getName());
    }

    @Override
    public void onAfterSave(User user) {
        log.info("Hard, hard to save " + user.getName());
    }

    @Override
    public void onBeforeDelete(User user) {
        log.info("I'll delete " + user.getName() + ", you might never see him/her again ");
    }

    @Override
    public void onAfterDelete(User user) {
        log.info("Say good-bye to " + user.getName() + ", I deleted him/her");
    }
}
