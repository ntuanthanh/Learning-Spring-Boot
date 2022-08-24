package com.vti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vti.dto.NewDTO;
import com.vti.entity.NewEntity;

@Service
public interface INewService {
    NewDTO save(NewDTO newDTO);
    NewDTO update(NewDTO newDTO); 
    void delete(long [] ids); 
    int testJpaRepository(); 
    NewDTO getNewDTO(long ids); 
    List<NewDTO> getNewDTOList(); 
    List<NewEntity> getNewList(); 
}
