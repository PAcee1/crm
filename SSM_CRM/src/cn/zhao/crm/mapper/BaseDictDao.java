package cn.zhao.crm.mapper;

import java.util.List;

import cn.zhao.crm.pojo.BaseDict;

/**
 * 客户基本信息dao
 * @author S1
 *
 */
public interface BaseDictDao {

	
	//根据客户类别代码查询数据
	public List<BaseDict> selectBaseDictByTypeCode(String typeCode);
	
}
