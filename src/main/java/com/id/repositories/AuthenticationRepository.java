package com.id.repositories;

import com.id.entities.Authentication;

public interface AuthenticationRepository extends BaseJpaRepository<Authentication,Long>{

    Authentication findByUserNameAndPassword(String userName,String password);
}
