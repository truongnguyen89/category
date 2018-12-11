package com.football.category.repository;

import com.football.common.model.email.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 11-Dec-18
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
}
