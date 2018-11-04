package cn.zhao.crm.service;

import java.util.List;

import cn.zhao.crm.pojo.BaseDict;

/**
 * BaseDict的Service接口
 * @author S1
 *
 */
public interface BaseDictService {

	//根据类别查找数据
	public List<BaseDict> selectBaseDictByTypeCode(String typeCode);
}
