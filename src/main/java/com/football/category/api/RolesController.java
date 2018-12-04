package com.football.category.api;

import com.football.category.service.role.RolesService;
import com.football.common.constant.Constant;
import com.football.common.exception.CommonException;
import com.football.common.model.log.LogBase;
import com.football.common.model.role.Roles;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 01-Jun-18
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "/api/database/roles")
public class RolesController {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    RolesService rolesService;

    @RequestMapping(method = POST)
    @ResponseBody
    public ResponseEntity<?> create(
            @RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
            @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber,
            @Valid @RequestBody Roles roles
    ) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, POST.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        requestMap.put("roles", (Object) roles);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        try {
            Roles r = rolesService.create(roles);
            responseMap.put("roles", (Object) r);
            return new ResponseEntity<Roles>(r, HttpStatus.CREATED);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/roles/create", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }

    @RequestMapping(path = "/{id}", method = GET)
    public ResponseEntity<?> findById(
            @RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
            @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber,
            @PathVariable long id
    ) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, GET.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        requestMap.put("id", (Object) id);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        try {
            Roles r = rolesService.findById(id);
            responseMap.put("roles", (Object) r);
            return new ResponseEntity<Roles>(r, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/roles/findById", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }

    @RequestMapping(path = "/status/{status}", method = GET)
    public ResponseEntity<?> findByStatus(
            @RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
            @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber,
            @PathVariable int status
    ) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, GET.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        requestMap.put(Constant.KEY.STATUS, (Object) status);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        try {
            List<Roles> r = rolesService.findByStatus(status);
            responseMap.put("roles", (Object) r);
            return new ResponseEntity<List<Roles>>(r, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/roles/findByStatus", startDate, endDate, requestStatus, requestMap, responseMap);
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
        try {
            Iterable<Roles> r = rolesService.findAll();
            responseMap.put("roles", (Object) r);
            return new ResponseEntity<Iterable<Roles>>(r, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/roles/findAll", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }

    @RequestMapping(path = "/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> update(
            @RequestParam(value = Constant.KEY.EDONG, required = false, defaultValue = "0912345678") String edong,
            @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false, defaultValue = "123456789") long auditNumber,
            @PathVariable long id, @RequestBody Roles roles
    ) throws Exception {
        Date startDate = new Date();
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        requestMap.put(Constant.KEY.REQUEST_METHOD, PUT.name());
        requestMap.put(Constant.KEY.EDONG, edong);
        requestMap.put(Constant.KEY.AUDIT_NUMBER, (Object) auditNumber);
        requestMap.put("roles", roles);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        roles.setId(id);
        try {
            Roles r = rolesService.update(roles);
            responseMap.put("roles", (Object) r);
            return new ResponseEntity<Roles>(r, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/roles/update", startDate, endDate, requestStatus, requestMap, responseMap);
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
            @Valid @RequestBody Roles roles) throws Exception {
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
        requestMap.put("roles", (Object) roles);
        String requestStatus = Constant.LOG_APPENDER.STATUS.SUCCESS;
        Page<Roles> rolesPage = null;
        try {
            Sort sort = null;
            if (!StringCommon.isNullOrBlank(sortColumn))
                sort = new Sort(Sort.Direction.valueOf(StringCommon.isNullOrBlank(sortOrder) ? Constant.PAGE.DEFAULT_VALUE.ASC_ORDER : sortOrder.toUpperCase()), sortColumn);
            Pageable pageable = new PageRequest(page, size, sort);
            rolesPage = rolesService.getPage(roles, pageable);
            responseMap.putAll(BeanCommon.convertObjectToMap(rolesPage));
            return new ResponseEntity<>(rolesPage, HttpStatus.OK);
        } catch (CommonException e) {
            requestStatus = Constant.LOG_APPENDER.STATUS.EXCEPTION;
            responseMap.put(Constant.KEY.EXCEPTION, e.getMessage());
            return new ResponseEntity<>(e.toString(), e.getResponse().getStatus());
        } finally {
            Date endDate = new Date();
            LogBase logBase = new LogBase(auditNumber, "/api/database/roles/getPage", startDate, endDate, requestStatus, requestMap, responseMap);
            LOGGER.info(JsonCommon.objectToJsonNotNull(logBase));
        }
    }
}
