package com.manageuser.finalmanageuser.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manageuser.finalmanageuser.exception.ResourceNotFoundException;
import com.manageuser.finalmanageuser.model.Group;
import com.manageuser.finalmanageuser.model.GroupUser;
import com.manageuser.finalmanageuser.repository.GroupRepository;
import com.manageuser.finalmanageuser.repository.GroupUserRepository;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private GroupUserRepository groupUserRepository;
	
	//http://localhost:8089/api/groups/
	@GetMapping("/")
	public List<Group> getAllGroup()
	{
		return groupRepository.findAll();
	}
	//http://localhost:8089/api/groups/
	@PostMapping("/") 
	public Group createGroup(@RequestBody Group group) { 
		return groupRepository.save(group);
	
	 
		}
	//get group by id
	@GetMapping("/{id}")
	public ResponseEntity<Group> getGroupById(@PathVariable int id) throws ResourceNotFoundException {
		Group group=groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("group not found"));
				
	return  ResponseEntity.ok(group);
	}

	//update user rest api
	@PutMapping("/{id}")
	public ResponseEntity<Group> updateGroup(@PathVariable int id,@RequestBody Group groupDetails) throws ResourceNotFoundException
	{
		Group group=groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("group not found"));
	group.setGroupname(groupDetails.getGroupname());
	Group updatedgroup =groupRepository.save(group);
	return ResponseEntity.ok(updatedgroup);
	}
	//delete group rest api
		@DeleteMapping("/{id}")
		public ResponseEntity< Map<String,Boolean>> deleteGroup(@PathVariable int id) throws ResourceNotFoundException
		{
			Group group=groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("group not found"));
			
			groupRepository.delete(group);
			Map<String,Boolean> response=new HashMap<>();
			response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		}
}
