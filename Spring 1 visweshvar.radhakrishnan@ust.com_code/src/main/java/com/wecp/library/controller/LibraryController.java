package com.wecp.library.controller;

import com.wecp.library.controller.exception.UserNotSubscribedException;
import com.wecp.library.domain.Issue;
import com.wecp.library.domain.User;
import com.wecp.library.repository.IssueRepository;
import com.wecp.library.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST controller for managing library system process
 */
@RestController
@RequestMapping("/api/v1")
public class LibraryController {

    /**
     * {@code POST  /issueBook} : Create a new issue.
     *
     * @param issue the issue to create.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the user, or if does not exist, return with status "noContent".
     * If user is not subscribed, throw {@link UserNotSubscribedException}
     */

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/issue-book")
    public ResponseEntity<Issue> issueBook(@RequestBody Issue issue) {
        Optional<User> userOptional = userRepository.findById(issue.getUser().getId());
        if(userOptional.isPresent() && userOptional.get().getSubscribed()){
            Issue res = issueRepository.save(issue);
            return ResponseEntity.ok(res);
        } else {
            throw new UserNotSubscribedException("User subscription has expired");
        }
        // return ResponseEntity.noContent().build();
    }

    /**
     * {@code POST  /user} : Create a new user.
     *
     * @param user the user to create.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the new user
     */
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User res = userRepository.save(user);
        return ResponseEntity.ok(res);
    }

    /**
     * {@code GET  /renew-user-subscription/:id} :  Send userId, set user subscription to true
     *
     * @param id the id of the user to renew subscription.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the user, or if does not exist, return with status "noContent".
     */
    @GetMapping("renew-user-subscription/{id}")
    public ResponseEntity<User> renewUserSubscription(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User res = userOptional.get();
            res.setSubscribed(true);
            userRepository.save(res);
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
