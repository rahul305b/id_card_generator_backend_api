package com.id.repositories;

import com.id.entities.IdInformation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IdRepository extends BaseJpaRepository<IdInformation,Long>{

    @Query("select count(e) from IdInformation e")
    long fetchTotalID();

    @Modifying
    @Query("update IdInformation e set e.branch=?2 where e.id=?1")
    public void UpdateTheBranch(Long id,String branch);
}
