package cn.zhao.crm.service;

import cn.zhao.crm.pojo.Customer;
import cn.zhao.crm.pojo.QueryVo;
import cn.zhao.crm.utils.Page;

/**
 * 客户Service
 * @author S1
 *
 */
public interface CustomerService {

	//根据查询条件 查询所有客户
	public Page<Customer> queryCustomerByQueryVo(QueryVo vo);
	
	//根据ID查询对象
	public Customer selectCustomerByID(Integer id);

	//根据ID修改对象
	public void updateCustomerByID(Customer cust);

	//根据Id删除对象
	public void deleteCustomerByID(Integer id);
}
