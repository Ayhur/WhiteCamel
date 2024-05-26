package com.white.camel.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wh_test")
public class MenuData {
	
	@Id
	@Column(name = "wh_test_id")
	private Integer id;
	
	@Column(name = "wh_test_titulo")
	private String titulo;

}
