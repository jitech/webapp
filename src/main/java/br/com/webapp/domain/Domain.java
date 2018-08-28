package br.com.webapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public class Domain {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false, unique = true)
	private Long id;
	
	@Column(name = "INSERT_DATE", nullable = false, updatable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	private Date insertDate;
	
	@Column(name = "UPDATE_DATE", nullable = false, updatable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updateDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}