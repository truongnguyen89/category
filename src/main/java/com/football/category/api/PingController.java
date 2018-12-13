package com.football.category.api;

import com.football.category.service.area.AreaService;
import com.football.common.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 28-Nov-18
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("api/category/ping")
@RefreshScope
public class PingController {
    @Autowired
    AreaService areaService;

    @RequestMapping(method = GET)
    public ResponseEntity<?> ping() throws Exception {
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<?> importFromExcelFile() throws Exception {
        return new ResponseEntity<Boolean>(areaService.importFromExcelFile(), HttpStatus.OK);
    }
}
