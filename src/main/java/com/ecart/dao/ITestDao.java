package com.ecart.dao;

import com.ecart.model.DataClass;

public interface ITestDao {

	boolean saveOrUpdateCustomer(DataClass dataClass);

	DataClass loadDataClassRowId(Long customerId);

}
