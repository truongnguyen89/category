package com.football.category.repository;

import com.football.common.model.agent.Agent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 04-Dec-18
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {
    List<Agent> findByStatus(int status);

    List<Agent> findByCode(String code);
}
