package com.smart.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CONTACT")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Contact implements Serializable {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String cid;
	private String name;
	private String secondName;
	private String work;
	private String email;
	private String phone;
	private String image;
	@Column(length = 1000)
	private String description;

	@ManyToOne
	private User user;
}
