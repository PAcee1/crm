package cn.zhao.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhao.crm.mapper.BaseDictDao;
import cn.zhao.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;
	
	@Override
	public List<BaseDict> selectBaseDictByTypeCode(String typeCode) {
		// TODO Auto-generated method stub
		return baseDictDao.selectBaseDictByTypeCode(typeCode);
	}

}
