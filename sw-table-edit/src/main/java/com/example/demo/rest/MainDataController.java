package com.example.demo.rest;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MainDataEntity;
import com.example.demo.service.MainDataService;
import com.example.demo.util.UploadActionUtil;
import com.example.demo.vo.ResultVO;

@RestController
@RequestMapping("/api/mainData")
public class MainDataController {

	@Autowired
	private MainDataService mainDataService;

	/**
	 * 保存数据
	 * 
	 * @param MainData
	 * @return
	 */
	@PostMapping("/save")
	@ResponseBody
	public ResultVO<MainDataEntity> addMainData(MainDataEntity mainData) {
		ResultVO<MainDataEntity> res = new ResultVO<MainDataEntity>();
		if (StringUtils.isEmpty(mainData.getId())) {
			mainData.setId(UUID.randomUUID().toString());
			res.getData().add(mainDataService.addMainData(mainData));
		} else {
			res.getData().add(mainDataService.updateMainData(mainData));
		}

		res.setCount(res.getData().size());
		return res;
	}

	/**
	 * 查询数据
	 * 
	 * @return
	 */
	@GetMapping("/list")
	@ResponseBody
	public ResultVO<MainDataEntity> listMainData(MainDataEntity mainData) {
		ResultVO<MainDataEntity> res = new ResultVO<MainDataEntity>();

		List<MainDataEntity> data = mainDataService.listMainData(mainData);
//		MainDataEntity mde;
//		for (int i = data.size(); i < 200; i++) {
//			mde = new MainDataEntity();
//			mde.setSquNo(i + 1);
//			mde.setImplUnit("自动化公司");
//			data.add(mde);
//		}
		res.setData(data);
		res.setCount(data.size());
		return res;
	}

	/**
	 * 上传文件
	 * 
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/upload")
	@ResponseBody
	public ResultVO<MainDataEntity> upload(HttpServletRequest httpServletRequest, String reportType) throws Exception {
		ResultVO<MainDataEntity> res = new ResultVO<MainDataEntity>();
		List<String> listFilePath = UploadActionUtil.uploadFile(httpServletRequest);
		mainDataService.uploadFile(reportType, listFilePath);

		return res;
	}

	/**
	 * 刷新计算全部数据
	 * 
	 * @return
	 */
	@PostMapping("/countData")
	@ResponseBody
	public ResultVO<MainDataEntity> countData() {
		ResultVO<MainDataEntity> res = new ResultVO<MainDataEntity>();
		mainDataService.countData();
		return res;
	}
}
