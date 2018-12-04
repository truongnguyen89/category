package com.football.category.service.role;

import com.football.category.repository.RolesRepository;
import com.football.category.service.BaseService;
import com.football.common.constant.Constant;
import com.football.common.constant.TextConstant;
import com.football.common.exception.CommonException;
import com.football.common.message.MessageCommon;
import com.football.common.model.role.Roles;
import com.football.common.response.Response;
import com.football.common.util.ArrayListCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 01-Jun-18
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RolesServiceImpl extends BaseService implements RolesService {
    @Autowired
    RolesRepository rolesRepository;

    @Override
    public Roles create(Roles roles) throws Exception {
        if (roles.getId() != null) {
            Roles oldRoles = findById(roles.getId());
            if (oldRoles != null)
                throw new CommonException(Response.OBJECT_IS_EXIST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_EXISTS, Constant.TABLE.ROLES));
        }
        if (roles.getAgentId() == null || roles.getApiId() == null) {
            throw new CommonException(Response.BAD_REQUEST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_NULL, Constant.TABLE.ROLES));
        } else {
            List<Roles> rolesList = rolesRepository.findById(roles.getAgentId(), roles.getApiId());
            if (!ArrayListCommon.isNullOrEmpty(rolesList))
                throw new CommonException(Response.OBJECT_IS_EXIST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_EXISTS, Constant.TABLE.ROLES));
        }
        return rolesRepository.save(roles);
    }

    @Override
    public Roles findById(Long id) throws Exception {
        return rolesRepository.findOne(id);
    }

    @Override
    public List<Roles> findByStatus(int status) throws Exception {
        return rolesRepository.findByStatus(status);
    }

    @Override
    public Iterable<Roles> findAll() throws Exception {
        return rolesRepository.findAll();
    }

    @Override
    public Roles update(Roles roles) throws Exception {
        if (roles.getId() == null) {
            throw new CommonException(Response.BAD_REQUEST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_NULL, Constant.TABLE.ROLES));
        } else {
            Roles oldRoles = findById(roles.getId());
            if (oldRoles == null) {
                throw new CommonException(Response.NOT_FOUND, MessageCommon.getMessage(TextConstant.MESSAGE.NOT_FOUND, Constant.TABLE.ROLES));
            } else {
                roles.setCreatedAt(oldRoles.getCreatedAt());
            }
        }
        return rolesRepository.save(roles);
    }

    @Override
    public Page<Roles> getPage(Roles roles, Pageable pageable) throws Exception {
        if (roles == null)
            throw new CommonException(Response.BAD_REQUEST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_NULL, Constant.TABLE.API));
        else {
            return rolesRepository.getPage(roles.getAgentId(),
                    roles.getApiId(),
                    roles.getStatus(),
                    pageable);
        }
    }
}
