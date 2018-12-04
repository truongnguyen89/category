package com.football.category.service.api;

import com.ecpay.common.constant.Constant;
import com.ecpay.common.constant.TextConstant;
import com.ecpay.common.exception.CommonException;
import com.ecpay.common.message.MessageCommon;
import com.ecpay.common.model.api.Api;
import com.ecpay.common.response.Response;
import com.ecpay.common.util.ArrayListCommon;
import com.ecpay.common.util.StringCommon;
import com.ecpay.database.repository.api.ApiRepository;
import com.ecpay.database.service.BaseService;
import com.ecpay.database.service.api.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class ApiServiceImpl extends BaseService implements ApiService {
    @Autowired
    ApiRepository apiRepository;

    @Override
    public Api create(Api api) throws Exception {
        if (StringCommon.isNullOrBlank(api.getMethod()) || StringCommon.isNullOrBlank(api.getUrl()))
            throw new CommonException(Response.BAD_REQUEST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_NULL, Constant.TABLE.API));
        else {
            List<Api> apiList = apiRepository.findByUrlMethod("%" + api.getUrl().trim().toUpperCase() + "%", api.getMethod().trim().toUpperCase());
            if (!ArrayListCommon.isNullOrEmpty(apiList))
                throw new CommonException(Response.OBJECT_IS_EXIST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_EXISTS, Constant.TABLE.API));
        }

        if (api.getId() != null) {
            Api oldApi = findById(api.getId());
            if (oldApi != null)
                throw new CommonException(Response.OBJECT_IS_EXIST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_EXISTS, Constant.TABLE.API));
        }
        try {
            RequestMethod requestMethod = RequestMethod.valueOf(api.getMethod());
        } catch (Exception e) {
            throw new CommonException(Response.BAD_REQUEST, MessageCommon.getMessage(TextConstant.MESSAGE.NOT_FOUND, "RequestMethod"));
        }
        return apiRepository.save(api);
    }

    @Override
    public Api findById(long id) throws Exception {
        return apiRepository.findOne(id);
    }

    @Override
    public List<Api> findByStatus(int status) throws Exception {
        return apiRepository.findByStatus(status);
    }

    @Override
    public Iterable<Api> findAll() throws Exception {
        return apiRepository.findAll();
    }

    @Override
    public Api update(Api api) throws Exception {
        if (api == null)
            throw new CommonException(Response.BAD_REQUEST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_NULL, Constant.TABLE.API));
        else {
            Api apiOld = apiRepository.findOne(api.getId());
            if (apiOld == null)
                throw new CommonException(Response.NOT_FOUND, MessageCommon.getMessage(TextConstant.MESSAGE.NOT_FOUND, Constant.TABLE.API));
            else {
                apiOld.setName(!StringCommon.isNullOrBlank(api.getName()) ? api.getName() : apiOld.getName());
                apiOld.setStatus(api.getStatus());
                apiOld.setCreatedAt(!(api.getCreatedAt() == null) ? api.getCreatedAt() : apiOld.getCreatedAt());
                apiOld.setMethod(!StringCommon.isNullOrBlank(api.getMethod()) ? api.getMethod() : apiOld.getMethod());
                apiOld.setUpdatedAt(!(api.getUpdatedAt() == null) ? api.getUpdatedAt() : apiOld.getUpdatedAt());
                apiOld.setUrl(!StringCommon.isNullOrBlank(api.getUrl()) ? api.getUrl() : apiOld.getUrl());

                return apiRepository.save(apiOld);
            }
        }
    }

    @Override
    public Page<Api> getPage(Api api, Pageable pageable) throws Exception {
        if (api == null)
            throw new CommonException(Response.BAD_REQUEST, MessageCommon.getMessage(TextConstant.MESSAGE.IS_NULL, Constant.TABLE.API));
        else {
            return apiRepository.getPage(api.getUrl(),
                    api.getMethod(),
                    api.getStatus(),
                    api.getName(),
                    pageable);
        }
    }
}
