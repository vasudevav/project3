package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;




@Entity
@Data
@Table(name = "contact_details")
public class ContactDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10,name = "contact_id")
    private Integer contactId;
    @Column(length =20,name = "contact_name" )
    private String contactName;
    @Column(length = 30,name = "email")
    private String email;
    @Column(length = 12,name = "phone_number")
    private Long phNo;
    @Column(length=5,name = "status")
    private String status;
}
