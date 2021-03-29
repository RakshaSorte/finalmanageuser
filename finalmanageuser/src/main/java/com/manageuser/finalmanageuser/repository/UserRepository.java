package com.manageuser.finalmanageuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manageuser.finalmanageuser.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
