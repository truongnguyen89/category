package com.football.category.service.role;

import com.football.common.model.role.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 01-Jun-18
 * Time: 4:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface RolesService {
    Roles create(Roles roles) throws Exception;

    Roles findById(Long id) throws Exception;

    List<Roles> findByStatus(int status) throws Exception;

    Iterable<Roles> findAll() throws Exception;

    Roles update(Roles roles) throws Exception;

    Page<Roles> getPage(Roles roles, Pageable pageable) throws Exception;
}
