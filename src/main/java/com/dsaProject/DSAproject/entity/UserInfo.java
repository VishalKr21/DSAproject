package com.dsaProject.DSAproject.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userInfoId;
	private String userInfoName;
	private String userInfoEmail;
	@OneToMany
	@JoinColumn(name = "commentInfoId")
	private List<CommentsInfo> userComInfo;

}
