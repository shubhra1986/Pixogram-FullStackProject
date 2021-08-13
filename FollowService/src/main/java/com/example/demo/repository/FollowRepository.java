package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Follow;

@Repository
public interface FollowRepository extends CrudRepository<Follow, Integer> {

	List<Follow> getByMyid(Integer myid);
	
	List<Follow> getByUserid(Integer userid);
	
	@Transactional
	void deleteByMyidAndUserid(Integer myid, Integer userid);
}
