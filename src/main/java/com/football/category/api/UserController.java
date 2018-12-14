package com.football.category.api;

import com.football.category.service.user.UserService;
import com.football.common.constant.Constant;
import com.football.common.model.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by IntelliJ IDEA.
 * UserRepository: Truong Nguyen
 * Date: 26-Nov-18
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    UserService userService;

    @RequestMapping(method = POST)
    @ResponseBody
    public ResponseEntity<?> create(
            @Valid @RequestBody User user
    ) throws Exception {
        return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<?> findAll() throws Exception {
        return new ResponseEntity<Iterable<User>>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable long id,
                                    @Valid @RequestBody User user) throws Exception {
        user.setId(id);
        return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);
    }
}
