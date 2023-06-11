package com.dsaProject.DSAproject.entity;

import java.util.Date;
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
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long blogId;
	private String blogTitle;
	private Date bolgDate;
	private String blogLongDesc;
	private String blogShortDesc;
	private String userName;
	@OneToMany
	@JoinColumn(name="commentInfoId")
	private List<CommentsInfo> comInfos;
	

}
