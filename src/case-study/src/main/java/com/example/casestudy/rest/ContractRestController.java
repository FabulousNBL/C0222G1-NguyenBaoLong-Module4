package com.example.casestudy.rest;

import com.example.casestudy.model.contract.AttachService;
import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.service.contract.IAttachService;
import com.example.casestudy.service.contract.IContractService;
import com.example.casestudy.service.contractDetail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contract-rest")
public class ContractRestController {
    @Autowired
    private IAttachService attachService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService detailService;

    @GetMapping("/{contractId}")
    public ResponseEntity<?> findAttachList(@PathVariable int contractId){
        List<AttachService> attachServiceList= new ArrayList<>();

       List<Integer> attachListId = attachService.attachId(contractId);
        for (Integer item:attachListId) {
            attachServiceList.add(attachService.findById(item));
        }

        return new ResponseEntity<>(attachServiceList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addNewAttach(@RequestBody ContractDetail contractDetail,@RequestParam(value = "page", defaultValue = "0") int page){
//        attachService.save(contractDetail.getAttachService());
        detailService.save(contractDetail);
        List<Contract> contracts = contractService.findAllContract(PageRequest.of(page,2)).getContent();
        return new ResponseEntity<>(contracts, HttpStatus.CREATED);
    }
}
