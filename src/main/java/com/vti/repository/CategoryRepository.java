package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vti.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>{
    // Query Creation 
	CategoryEntity findOneByCode(String code); 
	
	// Sử dụng @Query Native ( Cách 1 : dùng ?1 để setId )  
	@Query(value = "select * from  Category where id = ?1", nativeQuery = true) 
	CategoryEntity myFindOneByCode(int id); 
	// Sử dụng @Query Native ( Cách 2 : có thể đặt tên cho tham số )  
		@Query(value = "select * from  Category where id = :cid", nativeQuery = true) 
    CategoryEntity myFindOneByCode2(@Param("cid") int id); 
}
