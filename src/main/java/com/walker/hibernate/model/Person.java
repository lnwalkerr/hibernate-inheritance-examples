package com.walker.hibernate.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class Person {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private int age;

	    // One-to-One mapping field
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "Pk_Aadhar_as_FK")
	    @ToString.Exclude
	    private AadhaarCard aadhaarCard;


}
