package com.dsaProject.DSAproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commentInfoId;
	@ManyToOne
	@JoinColumn(name = "userInfoId")
	private UserInfo user;

}
