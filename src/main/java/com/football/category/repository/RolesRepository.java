package com.football.category.repository;

import com.football.common.model.role.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
public interface RolesRepository extends CrudRepository<Roles, Long> {
    List<Roles> findByStatus(int status);

    @Query(value = "SELECT a FROM Roles a WHERE upper(a.agentId) = :agentId and upper(a.apiId) = :apiId ")
    List<Roles> findById(@Param("agentId") Long agentId,
                         @Param("apiId") Long apiId);

    @Query(value = "SELECT a FROM Roles a WHERE 1 = 1 "
            + "AND(:agentId IS NULL OR a.agentId = :agentId)"
            + "AND(:apiId IS NULL OR a.apiId = :apiId)"
            + "AND(:status IS NULL OR a.status = :status)"
    )
    Page<Roles> getPage(@Param("agentId") Long agentId,
                        @Param("apiId") Long apiId,
                        @Param("status") Integer status,
                        Pageable pageable
    );
}
