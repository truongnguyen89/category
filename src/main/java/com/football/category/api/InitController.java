package com.football.category.api;

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

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 19-Jun-18
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "/api/database/init")
public class InitController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    InitService initService;


    @RequestMapping(method = GET)
    public ResponseEntity<?> init(@RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
                                  @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, GET.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        try {
            initService.initCache();
            responseMap.put("HttpStatus", (Object) HttpStatus.OK.value());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "InitController.init", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }
}
