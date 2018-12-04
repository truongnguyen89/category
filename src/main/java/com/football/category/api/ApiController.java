package com.football.category.api;

import com.football.category.service.api.ApiService;
import com.football.common.constant.Constant;
import com.football.common.exception.CommonException;
import com.football.common.model.api.Api;
import com.football.common.model.log.LogBase;
import com.football.common.util.BeanCommon;
import com.football.common.util.JsonCommon;
import com.football.common.util.StringCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/api/database/api")
public class ApiController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    ApiService apiService;

    @RequestMapping(method = POST)
    @ResponseBody
    public ResponseEntity<?> create(
            @RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
            @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber,
            @Valid @RequestBody Api api) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, POST.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        requestMap.put("api", (Object) api);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        try {
            Api apiResponse = apiService.create(api);
            responseMap.put("api", (Object) apiResponse);
            return new ResponseEntity<Api>(apiResponse, HttpStatus.CREATED);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/api/create", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }

    @RequestMapping(path = "/{id}", method = GET)
    public ResponseEntity<?> findById(
            @RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
            @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber,
            @PathVariable long id) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, GET.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        requestMap.put(Constant.KEY.ID, id);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        Api apiResponse = null;
        try {
            apiResponse = apiService.findById(id);
            responseMap.put("api", (Object) apiResponse);
            return new ResponseEntity<Api>(apiResponse, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/api/findById", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }

    @RequestMapping(path = "/status/{status}", method = GET)
    public ResponseEntity<?> findByStatus(@RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
                                          @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber,
                                          @PathVariable int status) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, GET.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        requestMap.put(Constant.KEY.STATUS, status);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        List<Api> apiList = new ArrayList<>();
        try {
            apiList = apiService.findByStatus(status);
            responseMap.put("apiList", (Object) apiList);
            return new ResponseEntity<List<Api>>(apiList, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/api/status/findByStatus", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }

    @RequestMapping(method = GET)
    public ResponseEntity<?> findAll(@RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
                                     @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, GET.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        Iterable<Api> apis = null;
        try {
            apis = apiService.findAll();
            responseMap.put("apis", (Object) apis);
            return new ResponseEntity<Iterable<Api>>(apis, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/api/findAll", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }

    @RequestMapping(path = "/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
                                    @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber,
                                    @PathVariable long id,
                                    @Valid @RequestBody Api api) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, PUT.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        requestMap.put(Constant.KEY.ID, (Object) id);
        requestMap.put("api", (Object) api);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        try {
            api.setId(id);
            Api apiResponse = apiService.update(api);
            responseMap.put("api", (Object) apiResponse);
            return new ResponseEntity<Api>(apiResponse, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/api/update", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }

    @RequestMapping(path = "/getPage", method = POST)
    @ResponseBody
    public ResponseEntity<?> getPage(
            @RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
            @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber,
            @RequestParam(value = Constant.KEY.SORT_COLUMN, required = false, defaultValue = "") String sortColumn,
            @RequestParam(value = Constant.KEY.SORT_ORDER, required = false, defaultValue = Constant.PAGE.DEFAULT_VALUE.ASC_ORDER) String sortOrder,
            @RequestParam(value = Constant.KEY.PAGE, required = true, defaultValue = Constant.PAGE.DEFAULT_VALUE.PAGE) int page,
            @RequestParam(value = Constant.KEY.SIZE, required = true, defaultValue = Constant.PAGE.DEFAULT_VALUE.SIZE) int size,
            @Valid @RequestBody Api api) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, POST.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        requestMap.put(Constant.KEY.SORT_COLUMN, sortColumn);
        requestMap.put(Constant.KEY.SORT_ORDER, sortOrder);
        requestMap.put(Constant.KEY.PAGE, (Object) page);
        requestMap.put(Constant.KEY.SIZE, (Object) size);
        requestMap.put("api", (Object) api);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        Page<Api> apiPage = null;
        try {
            Sort sort = null;
            if (!StringCommon.isNullOrBlank(sortColumn))
                sort = new Sort(Sort.Direction.valueOf(StringCommon.isNullOrBlank(sortOrder) ? Constant.PAGE.DEFAULT_VALUE.ASC_ORDER : sortOrder.toUpperCase()), sortColumn);
            Pageable pageable = new PageRequest(page, size, sort);
            apiPage = apiService.getPage(api, pageable);
            responseMap.putAll(BeanCommon.convertObjectToMap(apiPage));
            return new ResponseEntity<>(apiPage, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/api/getPage", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }
}
