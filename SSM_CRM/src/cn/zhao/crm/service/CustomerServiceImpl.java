package cn.zhao.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhao.crm.mapper.CustomerDao;
import cn.zhao.crm.pojo.Customer;
import cn.zhao.crm.pojo.QueryVo;
import cn.zhao.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo vo) {
		//创建Page对象
		Page<Customer> page = new Page<>();
		//设置每页数，注意！
		vo.setSize(10);
		page.setSize(vo.getSize());
		
		//处理传来的客户名称数据，因为是自己填写的，所以有可能带有空格，把空格去除
		if(vo != null) {
			//判断当前页是否存在
			if(vo.getPage()!=null) {
				page.setPage(vo.getPage());
				//设置起始页
				vo.setStart((vo.getPage()-1)*vo.getSize());
			}
			if( vo.getCustName()!=null && !vo.getCustName().trim().equals("")) {
				vo.setCustName(vo.getCustName().trim());
			}
			//向page对象保存结果集
			page.setRows(customerDao.selectCustomerByQueryVo(vo));
			//将count总条目存入page
			page.setTotal(customerDao.queryCountByQueryVo(vo));
		}
		
		return page;
	}

	@Override
	public Customer selectCustomerByID(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.selectCustomerByID(id);
	}

	@Override
	public void updateCustomerByID(Customer cust) {
		// TODO Auto-generated method stub
		customerDao.updateCustomerByID(cust);
	}

	@Override
	public void deleteCustomerByID(Integer id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomerByID(id);
	}

}
