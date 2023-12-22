package com.springrestdata.demo.repositories;

import com.springrestdata.demo.model.User;
import com.springrestdata.demo.model.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

//@RepositoryRestResource(path = "users", exported = false)  // The commented out code will prevent the execution of the users in the given path
@RepositoryRestResource(excerptProjection = UserProjection.class)
public interface UserRepository extends JpaRepository<User, Long> {

/*
    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(User entity);
*/
}
