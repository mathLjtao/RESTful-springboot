package com.ljtao.RESTfulspringboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ljtao.RESTfulspringboot.domain.Dep;
public interface DepDao {
	@Select("select * from dep")
	public List<Dep> getAll();
}
