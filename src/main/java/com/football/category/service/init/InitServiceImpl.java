package com.football.category.service.init;

import com.football.category.service.BaseService;
import com.football.category.service.agent.AgentService;
import com.football.category.service.api.ApiService;
import com.football.category.service.param.ParamService;
import com.football.category.service.role.RolesService;
import com.football.common.cache.Cache;
import com.football.common.constant.Constant;
import com.football.common.model.agent.Agent;
import com.football.common.model.api.Api;
import com.football.common.model.param.Param;
import com.football.common.model.role.Roles;
import com.football.common.response.Response;
import com.football.common.util.ArrayListCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 19-Jun-18
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class InitServiceImpl extends BaseService implements InitService {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.APPLICATION);

    @Autowired
    ParamService paramService;

    @Autowired
    AgentService agentService;

    @Autowired
    ApiService apiService;

    @Autowired
    RolesService rolesService;

    @Override
    public void initCache() throws Exception {
        long id = System.currentTimeMillis();
        LOGGER.info("[B]---------------------------------INIT---------------------------------");
        //Load param cache
        List<Param> paramList = paramService.findByStatus(Constant.STATUS_OBJECT.ACTIVE_INT);
        if (ArrayListCommon.isNullOrEmpty(paramList))
            LOGGER.error("Param active not found");
        else
            LOGGER.info("Response when load param cache : " + Cache.setParamCache(paramList).toString());

        //Load agent
        List<Agent> agentList = agentService.findByStatus(Constant.STATUS_OBJECT.ACTIVE_INT);
        if (ArrayListCommon.isNullOrEmpty(agentList))
            LOGGER.error("Agent active not found");
        else
            LOGGER.info("Response when load agent cache : " + Cache.setAgentCache(agentList).toString());

        //Load api rest
        List<Api> apiList = apiService.findByStatus(Constant.STATUS_OBJECT.ACTIVE_INT);
        if (ArrayListCommon.isNullOrEmpty(apiList))
            LOGGER.error("Api active not found");
        else {
            Cache.setApiListCache(apiList);
            LOGGER.info("Response when load api cache : " + Response.OK.toString());
        }

        //Load roles
        List<Roles> rolesList = rolesService.findByStatus(Constant.STATUS_OBJECT.ACTIVE_INT);
        if (ArrayListCommon.isNullOrEmpty(rolesList))
            LOGGER.error("Roles active not found");
        else
            LOGGER.info("Response when load roles cache : " + Cache.setRolesCache(rolesList).toString());
        LOGGER.info("[E][Duration = " + (System.currentTimeMillis() - id) + "]---------------------------------INIT---------------------------------");
    }
}
