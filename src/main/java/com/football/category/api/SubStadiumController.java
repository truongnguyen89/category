package com.football.category.api;

import com.football.category.service.stadium.SubStadiumService;
import com.football.common.constant.Constant;
import com.football.common.model.stadium.SubStadium;
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
@RequestMapping(value = "/api/category/subStadium")
public class SubStadiumController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    SubStadiumService subStadiumService;

    @RequestMapping(method = POST)
    @ResponseBody
    public ResponseEntity<?> create(
            @Valid @RequestBody SubStadium subStadium) throws Exception {
        return new ResponseEntity<SubStadium>(subStadiumService.create(subStadium), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public ResponseEntity<?> findById(
            @PathVariable long id) throws Exception {
        return new ResponseEntity<SubStadium>(subStadiumService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/status/{status}", method = GET)
    public ResponseEntity<?> findByStatus(@PathVariable int status) throws Exception {
        return new ResponseEntity<List<SubStadium>>(subStadiumService.findByStatus(status), HttpStatus.OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<?> findAll() throws Exception {
        return new ResponseEntity<Iterable<SubStadium>>(subStadiumService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable long id,
                                    @Valid @RequestBody SubStadium subStadium) throws Exception {
        subStadium.setId(id);
        return new ResponseEntity<SubStadium>(subStadiumService.update(subStadium), HttpStatus.OK);
    }
}
