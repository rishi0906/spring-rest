package com.ecart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "test")
public class DataClass {
		@Id
		@GeneratedValue
		@Column(name = "id", unique = true, nullable = false)
		private Long id;

		@Column(name = "col2", nullable = false)
		private String col2;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCol2() {
			return col2;
		}

		public void setCol2(String col2) {
			this.col2 = col2;
		}

		public String getCol3() {
			return col3;
		}

		public void setCol3(String col3) {
			this.col3 = col3;
		}

		@Column(name = "col3", nullable = false)
		private String col3;



}
