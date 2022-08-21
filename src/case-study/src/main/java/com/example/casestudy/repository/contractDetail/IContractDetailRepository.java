package com.example.casestudy.repository.contractDetail;

import com.example.casestudy.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Query(value = "select * from contract_detail", nativeQuery =true)
    Page<ContractDetail> findAll(Pageable pageable);

    @Query(value = "select * from contract_detail where contract_id = :id", nativeQuery = true)
    ContractDetail findByContract(@Param("id") int id);
}
