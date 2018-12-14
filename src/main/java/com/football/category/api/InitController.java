package com.football.category.api;

import com.football.category.service.area.AreaService;
import com.football.category.service.init.InitService;
import com.football.common.constant.Constant;
import com.football.common.exception.CommonException;
import com.football.common.model.log.LogBase;
import com.football.common.util.JsonCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 19-Jun-18
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "/api/category/init")
public class InitController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    InitService initService;

    @Autowired
    AreaService areaService;

    @RequestMapping(method = GET)
    public ResponseEntity<?> init() throws Exception {
        initService.initCache();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<?> importFromExcelFile() throws Exception {
        return new ResponseEntity<Boolean>(areaService.importFromExcelFile(), HttpStatus.OK);
    }
}
