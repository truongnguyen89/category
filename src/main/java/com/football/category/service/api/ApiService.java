package com.football.category.service.api;

import com.football.common.model.api.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApiService {
    Api create(Api api) throws Exception;

    Api findById(long id) throws Exception;

    List<Api> findByStatus(int status) throws Exception;

    Iterable<Api> findAll() throws Exception;

    Api update(Api api) throws Exception;

    Page<Api> getPage(Api api, Pageable pageable) throws Exception;
}
