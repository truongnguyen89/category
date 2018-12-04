package com.football.category.service.agent;

import com.football.common.model.agent.Agent;
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
public interface AgentService {
    Agent create(Agent agent) throws Exception;

    Agent findById(Long id) throws Exception;

    List<Agent> findByStatus(int status) throws Exception;

    Iterable<Agent> findAll() throws Exception;

    Agent update(Agent agent) throws Exception;
}
