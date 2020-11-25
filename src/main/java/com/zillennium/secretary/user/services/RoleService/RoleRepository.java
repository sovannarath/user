package com.zillennium.secretary.user.services.RoleService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.UserRole;

@Repository
public interface RoleRepository extends CrudRepository<UserRole,Long>{

}
