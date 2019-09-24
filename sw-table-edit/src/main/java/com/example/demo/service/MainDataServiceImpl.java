package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.dao.MainDataDao;
import com.example.demo.entity.MainDataEntity;
import com.example.demo.util.ClassTransformUtil;
import com.example.demo.util.MyDateUtils;
import com.example.demo.util.MyNumberUtils;
import com.example.demo.util.PoiExcelReport;

@Service
public class MainDataServiceImpl implements MainDataService {

	/**
	 * 数据报表
	 */
	public static String BASE_REPORT = "report100";
	/**
	 * 项目信息报表
	 */
	public static String BASE_INFO_REPORT = "report200";
	/**
	 * 项目信息报表
	 */
	public static String BASE_RECEIVABLES_REPORT = "report201";
	/**
	 * 财务报表
	 */
	public static String FINANCE_REPORT = "report300";
	/**
	 * 数值预设值
	 */
	public static String DEFAULT_NUMS = "0.00";

	@Autowired
	private MainDataDao mainDataDao;

	@Override
	public List<MainDataEntity> listMainData(MainDataEntity mainData) {
		return mainDataDao.select(mainData);
	}

	@Override
	public MainDataEntity addMainData(MainDataEntity mainDataEntity) {
		return mainDataDao.save(mainDataEntity);
	}

	@Override
	public MainDataEntity updateMainData(MainDataEntity mainDataEntity) {
		return mainDataDao.update(mainDataEntity);
	}

	@Override
	public int uploadFile(String reportType, List<String> filePathList) {
		int resNums = 0;
		PoiExcelReport poiExcelReport;
		List<MainDataEntity> dataList = null;
		for (String path : filePathList) {
			poiExcelReport = new PoiExcelReport(path);

			if (reportType.equals(BASE_REPORT)) {
				dataList = getReport100Data(poiExcelReport);
			} else if (reportType.equals(BASE_INFO_REPORT)) {
				dataList = getReport200Data(poiExcelReport);
			} else if (reportType.equals(FINANCE_REPORT)) {
				// TODO 财务报表未得到
			} else if (reportType.equals(BASE_RECEIVABLES_REPORT)) {
				dataList = getReport201Data(poiExcelReport);
			}
		}

		List<MainDataEntity> existList = mainDataDao.selectAll();
		if (dataList != null) {
			for (MainDataEntity mde : dataList) {
				mde = compareToExistData(mde, existList, reportType);

				if (StringUtils.isEmpty(mde.getId())) {
					mde.setId(UUID.randomUUID().toString());
					this.addMainData(mde);
				} else {
					this.updateMainData(mde);
				}

			}
		}

		return resNums;
	}

	// 获取项目信息报表数据
	private List<MainDataEntity> getReport100Data(PoiExcelReport poiExcelReport) {
		List<MainDataEntity> dataList = new ArrayList<MainDataEntity>();

		Sheet sheet = poiExcelReport.getSheet(0);
		Row row;
		MainDataEntity mde;
		int cellIdx = 0;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);

			cellIdx = 0;
			mde = new MainDataEntity();
			mde.setSquNo(i);
			mde.setProjectNo(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setDrawingNo(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setProjectName(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setOwnerUnit(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setImplUnit(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setContractPrice(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPrincSupplier(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setProvAmount(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setTaxedIncome(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setNoneTaxedIncome(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setProjectState(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setRateOfMonth(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setActualOutputOfMonth(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setCumulaActRate(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setCumulaActOutput(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setSupervReOfMonth(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setSupervReOutOfMonth(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setSetIncomeOfMonth(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setCumulaSupOutOfMonth(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setCumulaFinSetIncome(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setCumulaFinIncomeRate(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setUnFinIncome(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setIncomeOfMonth(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setCumulaIncome(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPayRateOfContract(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPaRaOfConIncome(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPaRaOfConDeficit(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setReceIncome(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPayAmount(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setProPlanTalCost(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setProPlanProfit(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setProPlanProfitRate(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setSettleCostNow(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setGrossProfitNow(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setGrossRateNow(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPreExamineAmount(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPreActTolIncome(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPreActCost(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPreActGroProfit(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setPreActGroRate(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setExamineAmount(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setExaActTolIncome(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setExaActCost(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setExaActGroProfit(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setExaActGroRate(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setDirCharPerson(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setLeaderOfBranch(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
			mde.setRemark(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));

			dataList.add(mde);
		}

		return dataList;
	}

	// 获取文件中的数据
	private List<MainDataEntity> getReport200Data(PoiExcelReport poiExcelReport) {
		List<MainDataEntity> dataList = new ArrayList<MainDataEntity>();

		Sheet sheet = poiExcelReport.getSheet(0);
		Row row;
		MainDataEntity mde;
		int cellIdx = 0;
		int squDo = 1;
		String proNo;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			cellIdx = 0;
			row = sheet.getRow(i);

			mde = new MainDataEntity();
			mde.setSquNo(squDo++);

			proNo = poiExcelReport.getCellValueStr(row.getCell(cellIdx++));
			if (!StringUtils.isEmpty(proNo)) {
				mde.setProjectNo(proNo);
				mde.setProjectName(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
				mde.setTaxRate(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
				mde.setContractPrice(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
				cellIdx++;
				mde.setOwnerUnit(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
				mde.setImplUnit("自动化公司");

				dataList.add(mde);
			}
		}

		return dataList;
	}

	// 解析工程收款报表
	private List<MainDataEntity> getReport201Data(PoiExcelReport poiExcelReport) {
		Date nowDate = new Date();
		List<MainDataEntity> dataList = new ArrayList<MainDataEntity>();

		Sheet sheet = poiExcelReport.getSheet(0);
		Row row;
		MainDataEntity mde;
		int cellIdx = 0;
		int squDo = 1;
		String proNo;
		String dateTimeStr;
		String dateFormatStr = "yyyy年MM月dd日";
		String incomeOfMonth = "";
		Double doIncomeOfMonth = 0.0;
		Double cumulaIncome = 0.0;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			cellIdx = 0;
			incomeOfMonth = "";
			doIncomeOfMonth = 0.0;
			cumulaIncome = 0.0;
			row = sheet.getRow(i);

			mde = new MainDataEntity();
			mde.setSquNo(squDo++);

			proNo = poiExcelReport.getCellValueStr(row.getCell(cellIdx++));
			if (!StringUtils.isEmpty(proNo)) {
				mde.setProjectNo(proNo);
				mde.setProjectName(poiExcelReport.getCellValueStr(row.getCell(cellIdx++)));
				incomeOfMonth = poiExcelReport.getCellValueStr(row.getCell(cellIdx++));
				dateTimeStr = poiExcelReport.getCellValueStr(row.getCell(cellIdx++));

				// 本月收款金额
				if (MyDateUtils.sameMonth(nowDate, MyDateUtils.strToDate(dateTimeStr, dateFormatStr))) {
					mde.setIncomeOfMonth(incomeOfMonth);
				} else {
					mde.setIncomeOfMonth(DEFAULT_NUMS);
				}

				for (MainDataEntity eMde : dataList) {
					if (eMde.getProjectNo().equals(mde.getProjectNo())) {
						if (!mde.getIncomeOfMonth().equals(DEFAULT_NUMS)) {
							doIncomeOfMonth = Double.parseDouble(eMde.getIncomeOfMonth())
									+ Double.parseDouble(mde.getIncomeOfMonth());
							eMde.setIncomeOfMonth(doIncomeOfMonth.toString());

							cumulaIncome = Double.parseDouble(eMde.getCumulaIncome())
									+ Double.parseDouble(mde.getIncomeOfMonth());
							eMde.setCumulaIncome(cumulaIncome.toString());
							continue;
						}

						cumulaIncome = Double.parseDouble(eMde.getCumulaIncome()) + Double.parseDouble(incomeOfMonth);
						eMde.setCumulaIncome(cumulaIncome.toString());

						continue;
					}
				}

				mde.setCumulaIncome(incomeOfMonth);
				dataList.add(mde);
			}
		}

		return dataList;
	}

	// 与现有数据做比较，判断导入数据是否与现有数据有关联性
	private MainDataEntity compareToExistData(MainDataEntity addMde, List<MainDataEntity> existList,
			String reportType) {
		for (MainDataEntity extMde : existList) {
			// 1 比对工程编号(合同号)
			if (extMde.getProjectNo().equals(addMde.getProjectNo())) {
				if (reportType.equals(BASE_REPORT)) {
					// 导入本表格数据时，使用全员覆盖
					addMde = ClassTransformUtil.copy(extMde, addMde, new String[] { "id" });
				} else {
					// 导入其他数据表格时，采用未赋值覆盖
					addMde = ClassTransformUtil.copy(extMde, addMde, true, new String[] { "id" });
				}
			}

			// 2对比工程名称 TODO

		}

		return addMde;
	}

	@Override
	public void countData() {
		List<MainDataEntity> allDataList = this.listMainData(new MainDataEntity());

		// 需计算的数值
		Double taxedIncome = 0.0;
		Double noneTaxedIncome = 0.0;
		Double actualOutputOfMonth = 0.0;
		Double cumulaActOutput = 0.0;
		Double supervReOfMonth = 0.0;
		Double cumulaFinIncomeRate = 0.0;
		Double unFinIncome = 0.0;
		Double paRaOfConIncome = 0.0;
		Double paRaOfConDeficit = 0.0;
		Double receIncome = 0.0;
		Double proPlanProfit = 0.0;
		Double proPlanProfitRate = 0.0;
		Double grossProfitNow = 0.0;
		Double grossRateNow = 0.0;
		Double preActGroProfit = 0.0;
		Double preActGroRate = 0.0;
		Double exaActGroProfit = 0.0;
		Double exaActGroRate = 0.0;

		// 开始计算
		for (MainDataEntity mde : allDataList) {
			// 合同价款 7
			if (strIsEmptyOrZero(mde.getContractPrice())) {
				mde.setContractPrice(DEFAULT_NUMS);
			}
			// 甲供主材 8
			if (strIsEmptyOrZero(mde.getPrincSupplier())) {
				mde.setPrincSupplier(DEFAULT_NUMS);
			}
			// 暂定金 9
			if (strIsEmptyOrZero(mde.getProvAmount())) {
				mde.setProvAmount(DEFAULT_NUMS);
			}
			// 计算含税工程收入 10
			taxedIncome = 0.0;
			taxedIncome = Double.parseDouble(mde.getContractPrice()) - Double.parseDouble(mde.getPrincSupplier())
					- Double.parseDouble(mde.getProvAmount());
			mde.setTaxedIncome(MyNumberUtils.doubleRounding(2, taxedIncome).toString());

			// 税率50
			if (strIsEmptyOrZero(mde.getTaxRate())) {
				mde.setTaxRate(DEFAULT_NUMS);
			}
			// 计算除税工程收入 11
			noneTaxedIncome = 0.0;
			noneTaxedIncome = taxedIncome / (1 + (Double.parseDouble(mde.getTaxRate()) / 100));
			mde.setNoneTaxedIncome(MyNumberUtils.doubleRounding(2, noneTaxedIncome).toString());

			// 工程状态 12
			if (strIsEmptyOrZero(mde.getProjectState())) {
				mde.setProjectState("未开始");
			}

			// 当月实际进度 (%) 13
			if (strIsEmptyOrZero(mde.getRateOfMonth())) {
				mde.setRateOfMonth(DEFAULT_NUMS);
			}
			// 计算当月实际施工产值 14
			actualOutputOfMonth = 0.0;
			actualOutputOfMonth = (Double.parseDouble(mde.getRateOfMonth()) / 100) * taxedIncome;
			mde.setActualOutputOfMonth(MyNumberUtils.doubleRounding(2, actualOutputOfMonth).toString());

			// 累计实际进度(%) 15
			if (strIsEmptyOrZero(mde.getCumulaActRate())) {
				mde.setCumulaActRate(DEFAULT_NUMS);
			}
			// 计算累计实际施工产值 16
			cumulaActOutput = 0.0;
			cumulaActOutput = (Double.parseDouble(mde.getCumulaActRate()) / 100) * taxedIncome;
			mde.setCumulaActOutput(MyNumberUtils.doubleRounding(2, cumulaActOutput).toString());

			// 当月监理月报产值 18
			if (strIsEmptyOrZero(mde.getSupervReOutOfMonth())) {
				mde.setSupervReOutOfMonth(DEFAULT_NUMS);
			}
			// 计算当月监理月报(%) 17
			supervReOfMonth = 0.0;
			if (taxedIncome != 0.0) {
				supervReOfMonth = (Double.parseDouble(mde.getSupervReOutOfMonth()) * 100) / taxedIncome;
			}
			mde.setSupervReOfMonth(MyNumberUtils.doubleRounding(2, supervReOfMonth).toString());

			// 当月结算收入(除税) 19
			if (strIsEmptyOrZero(mde.getSetIncomeOfMonth())) {
				mde.setSetIncomeOfMonth(DEFAULT_NUMS);
			}

			// 累计监理月报产值 20
			if (strIsEmptyOrZero(mde.getCumulaSupOutOfMonth())) {
				mde.setCumulaSupOutOfMonth(DEFAULT_NUMS);
			}

			// 累计财务结算收入(除税) 21
			if (strIsEmptyOrZero(mde.getCumulaFinSetIncome())) {
				mde.setCumulaFinSetIncome(DEFAULT_NUMS);
			}
			// 计算累计结算收入占比(%) 22
			cumulaFinIncomeRate = 0.0;
			if (noneTaxedIncome != 0.0) {
				cumulaFinIncomeRate = (Double.parseDouble(mde.getCumulaFinSetIncome()) * 100) / noneTaxedIncome;
			}
			mde.setCumulaFinIncomeRate(MyNumberUtils.doubleRounding(2, cumulaFinIncomeRate).toString());

			// 计算未结算收入(除税) 23
			unFinIncome = 0.0;
			unFinIncome = noneTaxedIncome - Double.parseDouble(mde.getCumulaFinSetIncome());
			mde.setUnFinIncome(MyNumberUtils.doubleRounding(2, unFinIncome).toString());

			// 本月收款金额 24
			if (strIsEmptyOrZero(mde.getIncomeOfMonth())) {
				mde.setIncomeOfMonth(DEFAULT_NUMS);
			}

			// 累计收款金额 25
			if (strIsEmptyOrZero(mde.getCumulaIncome())) {
				mde.setCumulaIncome(DEFAULT_NUMS);
			}

			// 合同约定支付比例 26 (%)
			if (strIsEmptyOrZero(mde.getPayRateOfContract())) {
				mde.setPayRateOfContract(DEFAULT_NUMS);
			}
			// 计算按合同支付比例应收款 27
			paRaOfConIncome = 0.0;
			paRaOfConIncome = Double.parseDouble(mde.getCumulaSupOutOfMonth())
					* (Double.parseDouble(mde.getPayRateOfContract()) / 100);
			mde.setPaRaOfConIncome(MyNumberUtils.doubleRounding(2, paRaOfConIncome).toString());

			// 计算按合同支付比例欠收款 28
			paRaOfConDeficit = 0.0;
			paRaOfConDeficit = paRaOfConIncome - Double.parseDouble(mde.getCumulaIncome());
			mde.setPaRaOfConDeficit(MyNumberUtils.doubleRounding(2, paRaOfConDeficit).toString());

			// 计算应收账款 29
			receIncome = 0.0;
			receIncome = Double.parseDouble(mde.getCumulaSupOutOfMonth()) - Double.parseDouble(mde.getCumulaIncome());
			mde.setReceIncome(MyNumberUtils.doubleRounding(2, receIncome).toString());

			// 应付账款 30
			if (strIsEmptyOrZero(mde.getPayAmount())) {
				mde.setPayAmount(DEFAULT_NUMS);
			}

			// 工程计划总成本 31
			if (strIsEmptyOrZero(mde.getProPlanTalCost())) {
				mde.setProPlanTalCost(DEFAULT_NUMS);
			}
			// 计算工程计划毛利润 32
			proPlanProfit = 0.0;
			proPlanProfit = noneTaxedIncome - Double.parseDouble(mde.getProPlanTalCost());
			mde.setProPlanProfit(MyNumberUtils.doubleRounding(2, proPlanProfit).toString());

			// 计算工程计划毛利率 33
			proPlanProfitRate = 0.0;
			if (noneTaxedIncome != 0.0) {
				proPlanProfitRate = proPlanProfit / noneTaxedIncome;
			}
			mde.setProPlanProfitRate(MyNumberUtils.doubleRounding(2, proPlanProfitRate).toString());

			// 工程现阶段已结转成本 34
			if (strIsEmptyOrZero(mde.getSettleCostNow())) {
				mde.setSettleCostNow(DEFAULT_NUMS);
			}
			// 计算工程现阶段毛利润 35
			grossProfitNow = 0.0;
			grossProfitNow = Double.parseDouble(mde.getCumulaFinSetIncome())
					- Double.parseDouble(mde.getSettleCostNow());
			mde.setGrossProfitNow(MyNumberUtils.doubleRounding(2, grossProfitNow).toString());

			// 计算工程现阶段毛利率 36
			grossRateNow = 0.0;
			if (!mde.getCumulaFinSetIncome().equals(DEFAULT_NUMS)) {
				grossRateNow = grossProfitNow / Double.parseDouble(mde.getCumulaFinSetIncome());
			}
			mde.setGrossRateNow(MyNumberUtils.doubleRounding(2, grossRateNow).toString());

			// 工程预估审定金额(含税) 37
			if (strIsEmptyOrZero(mde.getPreExamineAmount())) {
				mde.setPreExamineAmount(DEFAULT_NUMS);
			}

			// 工程预估实际总收入(除税) 38
			if (strIsEmptyOrZero(mde.getPreActTolIncome())) {
				mde.setPreActTolIncome(DEFAULT_NUMS);
			}

			// 工程预估实际总成本 39
			if (strIsEmptyOrZero(mde.getPreActCost())) {
				mde.setPreActCost(DEFAULT_NUMS);
			}

			// 计算工程预估实际毛利润 40
			preActGroProfit = 0.0;
			preActGroProfit = Double.parseDouble(mde.getPreActTolIncome()) - Double.parseDouble(mde.getPreActCost());
			mde.setPreActGroProfit(MyNumberUtils.doubleRounding(2, preActGroProfit).toString());

			// 计算工程预估实际毛利率 41
			preActGroRate = 0.0;
			if (!mde.getPreActTolIncome().equals(DEFAULT_NUMS)) {
				preActGroRate = preActGroProfit / Double.parseDouble(mde.getPreActTolIncome());
			}
			mde.setPreActGroRate(MyNumberUtils.doubleRounding(2, preActGroRate).toString());

			// 工程审定金额 42
			if (strIsEmptyOrZero(mde.getExamineAmount())) {
				mde.setExamineAmount(DEFAULT_NUMS);
			}

			// 工程审计后实际总收入 43
			if (strIsEmptyOrZero(mde.getExaActTolIncome())) {
				mde.setExaActTolIncome(DEFAULT_NUMS);
			}

			// 工程审计后实际总成本 44
			if (strIsEmptyOrZero(mde.getExaActCost())) {
				mde.setExaActCost(DEFAULT_NUMS);
			}

			// 计算工程审计后实际毛利润 45
			exaActGroProfit = 0.0;
			exaActGroProfit = Double.parseDouble(mde.getExaActTolIncome()) - Double.parseDouble(mde.getExaActCost());
			mde.setExaActGroProfit(MyNumberUtils.doubleRounding(2, exaActGroProfit).toString());

			// 计算工程审计后实际毛利率 46
			exaActGroRate = 0.0;
			if (!mde.getExaActTolIncome().equals(DEFAULT_NUMS)) {
				exaActGroRate = exaActGroProfit / Double.parseDouble(mde.getExaActTolIncome());
			}
			mde.setExaActGroRate(MyNumberUtils.doubleRounding(2, exaActGroRate).toString());

			this.updateMainData(mde);
		}
	}
	
	private boolean strIsEmptyOrZero(String str) {
		return (StringUtils.isEmpty(str) || str.equals("0") || str.equals("0.0") || str.equals("0.00") || str.equals("0.000"));
	}

}
