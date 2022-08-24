package com.vti.service.impl;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.converter.NewConverter;
import com.vti.dto.NewDTO;
import com.vti.entity.CategoryEntity;
import com.vti.entity.NewEntity;
import com.vti.repository.CategoryRepository;
import com.vti.repository.NewRepository;
import com.vti.service.INewService;
import java.util.List; 

@Service
public class NewService implements INewService{
    @Autowired
    private NewRepository newRepository;
    
    @Autowired
    private CategoryRepository categoryRepository; 
    
    @Autowired
    private NewConverter newConverter; 
    
	@Override
	public NewDTO save(NewDTO newDTO) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode()); 
		NewEntity newEntity = newConverter.toEntity(newDTO); 
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity); 
		return newConverter.toDTO(newEntity);
	}

	@Override
	public NewDTO update(NewDTO newDTO) {
		// Get old NewEntity
		NewEntity oldNewEntity = newRepository.findOne(newDTO.getId()); 
	    // update NewEntity 
		NewEntity newEntity = newConverter.toEntity(newDTO, oldNewEntity); 
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode()); 
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity); 
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
		   newRepository.delete(item);
		}		
	}    
	// Test 1 
	@Override
	public int testJpaRepository() {
		 ArrayList<NewEntity> news = new ArrayList<>();
		 news = (ArrayList<NewEntity>) newRepository.findAll(); 		 
		 return news.size();
	}
	// GetNewByid
	@Override
	public NewDTO getNewDTO(long ids) {
		NewEntity newEntity = newRepository.findOne(ids);
		return newConverter.toDTO(newEntity); 
	}
	
	// trường hợp 1 là từ list New entity thì chuyền sang dto thì được 
	// getNewDTOList
	@Override
	public List<NewDTO> getNewDTOList() {
		// list NewDTO 
		List<NewDTO> newDTOList = new ArrayList<NewDTO>(); 
		// List NewEntity 
		List<NewEntity> newEntityList = newRepository.findAll(); 
		for (NewEntity newEntity : newEntityList) {
		    NewDTO newDTO = newConverter.toDTO(newEntity); 
		    newDTOList.add(newDTO); 
		}
		return newDTOList; 
	}	
	// getNewEntityList
	public List<NewEntity> getNewList() {
		// list NewDTO 
		List<NewEntity> newEntityList = newRepository.findAll(); 
		// List NewEntity 
		return newEntityList; 
	}

}

