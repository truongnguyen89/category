package com.football.category.api;

import com.football.category.service.match.MatchScheduleService;
import com.football.category.service.match.MatchService;
import com.football.common.constant.Constant;
import com.football.common.model.match.Match;
import com.football.common.model.match.MatchSchedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 06-Dec-18
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "/api/category/match")
public class MatchController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    MatchService matchService;

    @RequestMapping(method = POST)
    @ResponseBody
    public ResponseEntity<?> createMatch(
            @Valid @RequestBody Match match) throws Exception {
        return new ResponseEntity<Match>(matchService.create(match), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public ResponseEntity<?> findMatchById(
            @PathVariable long id) throws Exception {
        return new ResponseEntity<Match>(matchService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/status/{status}", method = GET)
    public ResponseEntity<?> findMatchByStatus(@PathVariable int status) throws Exception {
        return new ResponseEntity<List<Match>>(matchService.findByStatus(status), HttpStatus.OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<?> findAllMatch() throws Exception {
        return new ResponseEntity<Iterable<Match>>(matchService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> updateMatch(@PathVariable long id,
                                         @Valid @RequestBody Match match) throws Exception {
        match.setId(id);
        return new ResponseEntity<Match>(matchService.update(match), HttpStatus.OK);
    }

    @Autowired
    MatchScheduleService matchScheduleService;

    @RequestMapping(path = "/schedule", method = POST)
    @ResponseBody
    public ResponseEntity<?> createMatchSchedule(
            @Valid @RequestBody MatchSchedule matchSchedule) throws Exception {
        return new ResponseEntity<MatchSchedule>(matchScheduleService.create(matchSchedule), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/schedule/{id}", method = GET)
    public ResponseEntity<?> findMatchScheduleById(
            @PathVariable long id) throws Exception {
        return new ResponseEntity<MatchSchedule>(matchScheduleService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/schedule/status/{status}", method = GET)
    public ResponseEntity<?> findMatchScheduleByStatus(@PathVariable int status) throws Exception {
        return new ResponseEntity<List<MatchSchedule>>(matchScheduleService.findByStatus(status), HttpStatus.OK);
    }

    @RequestMapping(path = "/schedule", method = GET)
    public ResponseEntity<?> findAllMatchSchedule() throws Exception {
        return new ResponseEntity<Iterable<MatchSchedule>>(matchScheduleService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/schedule/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> updateMatchSchedule(@PathVariable long id,
                                                 @Valid @RequestBody MatchSchedule matchSchedule) throws Exception {
        matchSchedule.setId(id);
        return new ResponseEntity<MatchSchedule>(matchScheduleService.update(matchSchedule), HttpStatus.OK);
    }

}
