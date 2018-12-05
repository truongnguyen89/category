package com.football.category.repository;

import com.football.common.model.stadium.Stadium;
import com.football.common.model.stadium.StadiumManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumManagerRepository extends CrudRepository<StadiumManager, Long> {
    List<StadiumManager> findByStatus(int status);
}
