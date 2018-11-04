package cn.zhao.crm.mapper;

import java.util.List;

import cn.zhao.crm.pojo.Customer;
import cn.zhao.crm.pojo.QueryVo;

public interface CustomerDao {

	//根据查询条件查询总条目
	public Integer queryCountByQueryVo(QueryVo vo);
	
	//根据查询条件查询分页查询
	public List<Customer> selectCustomerByQueryVo(QueryVo vo);
	
	//根据ID查询对象
	public Customer selectCustomerByID(Integer id);

	//根据Id修改对象
	public void updateCustomerByID(Customer cust);
	
	//根据Id删除对象
	public void deleteCustomerByID(Integer id);
}
