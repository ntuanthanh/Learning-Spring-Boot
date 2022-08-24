package com.vti.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.NewDTO;
import com.vti.entity.NewEntity;
import com.vti.service.INewService;

//@Controller
@CrossOrigin
@RestController
public class NewAPI {
  
  @Autowired
  private INewService newService; 
  
  //  @ResponseBody // Khi sử dụng RestController thì không cần dùng Anotation này nữa
  //  @RequestMapping(value = "/new", method = RequestMethod.POST) = @PostMapping 
  @PostMapping(value = "/new")
  public NewDTO createNew(@RequestBody NewDTO model) {
	  return newService.save(model); 
  } 
    
  @PutMapping(value = "/new/{id}")
  public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
	  model.setId(id); 
	  return newService.update(model); 
  }
  
  @DeleteMapping(value = "/new")
  public void deleteNew(@RequestBody long[] ids) {
	  newService.delete(ids); 
  }
  
  @GetMapping("/new/{id}")
  public NewDTO getNew(@PathVariable("id") long id) {
	  return newService.getNewDTO(id); 
  }
  // đây là th1 
  @GetMapping("/new") 
  public List<NewDTO> getNewDTOList(){
	  return newService.getNewDTOList(); 
  }
  // trường hợp 2 : 
  @GetMapping("/new2") 
  public List<NewEntity> getNewEntityList(){
	  return newService.getNewList();
  }
  // Learning Jpa Repository
  @GetMapping(value = "/test")
  public int testNew() {
	  return newService.testJpaRepository();
  }
  
}

// 