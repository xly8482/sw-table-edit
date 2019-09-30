package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.MainDataEntity;

public interface MainDataService {

	public MainDataEntity addMainData(MainDataEntity mainDataEntity);
	
	public MainDataEntity updateMainData(MainDataEntity mainDataEntity);
	
	public List<MainDataEntity> listMainData(MainDataEntity mainData);

	public int uploadFile(String reportType, List<String> filePathList);
	
	public void countData();
	
	public void deleteAllData();
}
