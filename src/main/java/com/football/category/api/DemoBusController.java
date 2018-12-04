package com.football.category.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 28-Nov-18
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("api/v3/demobus")
@RefreshScope
public class DemoBusController {
    @Value("${demo.bus}")
    private String valueConfig;

    @RequestMapping(path = "/demobus", method = GET)
    public ResponseEntity<?> getAbc(
            @RequestParam(value = "value", required = false, defaultValue = "value = ") String value) throws Exception {
        return new ResponseEntity<String>(value + valueConfig, HttpStatus.OK);
    }
}
