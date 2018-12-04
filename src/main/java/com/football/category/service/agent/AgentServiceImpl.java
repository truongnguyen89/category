package com.football.category.service.agent;

import com.football.category.repository.AgentRepository;
import com.football.category.service.BaseService;
import com.football.common.constant.Constant;
import com.football.common.constant.TextConstant;
import com.football.common.exception.CommonException;
import com.football.common.message.MessageCommon;
import com.football.common.model.agent.Agent;
import com.football.common.response.Response;
import com.football.common.util.ArrayListCommon;
import com.football.common.util.StringCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 04-Dec-18
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AgentServiceImpl extends BaseService implements AgentService {
    @Autowired
    AgentRepository agentRepository;

    @Override
    public Agent create(Agent agent) throws Exception {
        if (agent.getId() != null) {
            Agent oldAgent = findById(agent.getId());
            if (oldAgent != null)
                throw new CommonException(Response.OBJECT_IS_EXIST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_EXISTS, Constant.TABLE.AGENT));
        }
        if (!StringCommon.isNullOrBlank(agent.getCode())) {
            List<Agent> agentList = agentRepository.findByCode(agent.getCode());
            if (!ArrayListCommon.isNullOrEmpty(agentList))
                throw new CommonException(Response.OBJECT_IS_EXIST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_EXISTS, Constant.TABLE.AGENT));
        } else {
            throw new CommonException(Response.BAD_REQUEST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_NULL, Constant.TABLE.AGENT));
        }
        return agentRepository.save(agent);
    }

    @Override
    public Agent findById(Long id) throws Exception {
        return agentRepository.findOne(id);
    }

    @Override
    public List<Agent> findByStatus(int status) throws Exception {
        return agentRepository.findByStatus(status);
    }

    @Override
    public Iterable<Agent> findAll() throws Exception {
        return agentRepository.findAll();
    }

    @Override
    public Agent update(Agent agent) throws Exception {
        Agent oldAgent = findById(agent.getId());
        if (oldAgent == null)
            throw new CommonException(Response.OBJECT_IS_EXIST, MessageCommon.getMessage(TextConstant.MESSAGE.NOT_FOUND, Constant.TABLE.AGENT));
        else
            return agentRepository.save(agent);
    }
}
