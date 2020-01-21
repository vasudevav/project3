package com.nt.command;

import lombok.Data;

@Data
public class Contact {
	private Integer contactId;
    private String contactName;
    private String email;
    private Long phNo;
    private String status;
}
