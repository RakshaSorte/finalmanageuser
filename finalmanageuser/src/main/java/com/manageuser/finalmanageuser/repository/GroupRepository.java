package com.manageuser.finalmanageuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manageuser.finalmanageuser.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>{

}
