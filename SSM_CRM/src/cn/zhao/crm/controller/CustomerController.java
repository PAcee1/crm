package cn.zhao.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhao.crm.pojo.BaseDict;
import cn.zhao.crm.pojo.Customer;
import cn.zhao.crm.pojo.QueryVo;
import cn.zhao.crm.service.BaseDictService;
import cn.zhao.crm.service.CustomerService;
import cn.zhao.crm.utils.Page;

/**
 * 	客户管理
 * @author S1
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@Value("${TypeCode.fromType}")
	private String FromType;
	@Value("${TypeCode.industryType}")
	private String IndustryType;
	@Value("${TypeCode.levelType}")
	private String LevelType;
	
	//主页
	@RequestMapping("/customer/list")
	public String list(Model model,QueryVo vo) {
		//一进入页面即调用方法，为select下拉框添加数据
		List<BaseDict> fromType = baseDictService.selectBaseDictByTypeCode(FromType);
		List<BaseDict> industryType = baseDictService.selectBaseDictByTypeCode(IndustryType);
		List<BaseDict> levelType = baseDictService.selectBaseDictByTypeCode(LevelType);
		//添加域中
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		Page<Customer> page = customerService.queryCustomerByQueryVo(vo);
		model.addAttribute("page", page);
		
		//回显
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	//修改页面,注意responseBody
	@RequestMapping("/customer/edit.action")
	public @ResponseBody Customer edit(Integer id) {
		Customer customer = customerService.selectCustomerByID(id);
		return customer;
	}
	
	//保存修改信息
	@RequestMapping("/customer/update.action")
	public @ResponseBody String update(Customer cust) {
		customerService.updateCustomerByID(cust);
		return "ok";
	}
	
	//删除页面
	@RequestMapping("/customer/delete.action")
	public @ResponseBody String delete(Integer id) {
		customerService.deleteCustomerByID(id);
		return "ok";
	}
}
