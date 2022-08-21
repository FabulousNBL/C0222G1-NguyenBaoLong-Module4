package com.example.casestudy.repository.contract;

import com.example.casestudy.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {

    @Query(value = "select attach_service_id from contract_detail where contract_id = :id", nativeQuery = true)
    List<Integer> attachId (@Param("id") int id);

    @Query(value = "select * from attach_service where id = :id", nativeQuery = true)
    AttachService findById(@Param("id") int id);
}
