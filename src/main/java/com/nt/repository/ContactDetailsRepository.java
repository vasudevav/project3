package com.nt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.entity.ContactDetailsEntity;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetailsEntity,Integer> {
	
	  @Transactional
	  @Modifying
	  @Query("update ContactDetailsEntity set status=:sts where contactId=:cid")
	  public void updateRecord(String sts,Integer cid);
	 
}
