package com.maukaz.infotech.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="electionapp")
public class ElectionApp {

	@Id
	private Integer srNo;
	
	private Integer wardNo;
	
	private Integer aCNo;

	private Integer partNo;

	private Integer slNoInPart;

	private String ePICNo;

	private String name;

	private Integer age;

	private String gender;

	private String rLnName;

	private String rLnType;

}
