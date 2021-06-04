package com.id.repositories;

import com.id.entities.IdInformation;
import org.springframework.stereotype.Repository;

@Repository
public interface IdRepository extends BaseJpaRepository<IdInformation,Long>{
}
