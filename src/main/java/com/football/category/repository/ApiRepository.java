package com.football.category.repository;

import com.football.common.model.api.Api;
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
public interface ApiRepository extends CrudRepository<Api, Long> {
    List<Api> findByStatus(int status);

    @Query(value = "SELECT a FROM Api a WHERE upper(a.url) LIKE :url and upper(a.method) = :method ")
    List<Api> findByUrlMethod(@Param("url") String url,
                              @Param("method") String method);

    @Query(value = "SELECT a FROM Api a WHERE 1 = 1"
            + "AND(:url IS NULL OR upper(a.url) = trim(upper(:url)))"
            + "AND(:method IS NULL OR upper(a.method) = trim(upper(:method)))"
            + "AND(:status IS NULL OR a.status = :status)"
            + "AND(:name IS NULL OR upper(a.name) = trim(upper(:name)))"
    )
    Page<Api> getPage(@Param("url") String url,
                      @Param("method") String method,
                      @Param("status") Integer status,
                      @Param("name") String name, Pageable pageable
    );
}
