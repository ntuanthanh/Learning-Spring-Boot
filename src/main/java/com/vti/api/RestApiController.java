package com.vti.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.NewDTO;

@RestController 
@RequestMapping("/test")
public class RestApiController {
   
	@GetMapping("/a1")
	public ArrayList<NewDTO> getNews(){
		return null;
	}
}
