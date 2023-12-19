package com.springrestdata.demo.repositories;

import com.springrestdata.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
