
package com.football.category.api;

import com.football.category.service.stadium.StadiumManagerService;
import com.football.common.constant.Constant;
import com.football.common.model.stadium.StadiumManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/api/database/stadiumManager")
public class StadiumManagerController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    StadiumManagerService stadiumManagerService;

    @RequestMapping(method = POST)
    @ResponseBody
    public ResponseEntity<?> create(
            @Valid @RequestBody StadiumManager stadiumManager) throws Exception {
        return new ResponseEntity<StadiumManager>(stadiumManagerService.create(stadiumManager), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public ResponseEntity<?> findById(
            @PathVariable long id) throws Exception {
        return new ResponseEntity<StadiumManager>(stadiumManagerService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/status/{status}", method = GET)
    public ResponseEntity<?> findByStatus(@PathVariable int status) throws Exception {
        return new ResponseEntity<List<StadiumManager>>(stadiumManagerService.findByStatus(status), HttpStatus.OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<?> findAll() throws Exception {
        return new ResponseEntity<Iterable<StadiumManager>>(stadiumManagerService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable long id,
                                    @Valid @RequestBody StadiumManager stadiumManager) throws Exception {
        stadiumManager.setId(id);
        return new ResponseEntity<StadiumManager>(stadiumManagerService.update(stadiumManager), HttpStatus.OK);
    }
}