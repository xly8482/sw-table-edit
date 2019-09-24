package com.example.demo.entity;

import java.io.Serializable;

public class MainDataEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6113169264584616475L;

	/**
	 * id 0
	 */
	private String id;

	/**
	 * 序号 1
	 */
	private Integer squNo;

	/**
	 * 工程编号 2
	 */
	private String projectNo;

	/**
	 * 图纸编号 3
	 */
	private String drawingNo;

	/**
	 * 工程名称 4
	 */
	private String projectName;

	/**
	 * 业主单位 5
	 */
	private String ownerUnit;

	/**
	 * 实施单位 6
	 */
	private String implUnit;

	/**
	 * 合同价款 7
	 */
	private String contractPrice;

	/**
	 * 甲供主材 8
	 */
	private String princSupplier;

	/**
	 * 暂定金 9
	 */
	private String provAmount;

	/**
	 * 含税工程收入 10
	 */
	private String taxedIncome;

	/**
	 * 除税工程收入 11
	 */
	private String noneTaxedIncome;

	/**
	 * 工程状态 12
	 */
	private String projectState;

	/**
	 * 当月实际进度 (%) 13
	 */
	private String rateOfMonth;

	/**
	 * 当月实际施工产值 14
	 */
	private String actualOutputOfMonth;

	/**
	 * 累计实际进度(%) 15
	 */
	private String cumulaActRate;

	/**
	 * 累计实际施工产值 16
	 */
	private String cumulaActOutput;

	/**
	 * 当月监理月报(%) 17
	 */
	private String supervReOfMonth;

	/**
	 * 当月监理月报产值 18
	 */
	private String supervReOutOfMonth;

	/**
	 * 当月结算收入(除税) 19
	 */
	private String setIncomeOfMonth;

	/**
	 * 累计监理月报产值 20
	 */
	private String cumulaSupOutOfMonth;

	/**
	 * 累计财务结算收入(除税) 21
	 */
	private String cumulaFinSetIncome;

	/**
	 * 累计结算收入占比(%) 22
	 */
	private String cumulaFinIncomeRate;

	/**
	 * 未结算收入(除税) 23
	 */
	private String unFinIncome;

	/**
	 * 本月收款金额 24
	 */
	private String incomeOfMonth;

	/**
	 * 累计收款金额 25
	 */
	private String cumulaIncome;

	/**
	 * 合同约定支付比例 26
	 */
	private String payRateOfContract;

	/**
	 * 按合同支付比例应收款 27
	 */
	private String paRaOfConIncome;

	/**
	 * 按合同支付比例欠收款 28
	 */
	private String paRaOfConDeficit;

	/**
	 * 应收账款 29
	 */
	private String receIncome;

	/**
	 * 应付账款 30
	 */
	private String payAmount;

	/**
	 * 工程计划总成本 31
	 */
	private String proPlanTalCost;

	/**
	 * 工程计划毛利润 32
	 */
	private String proPlanProfit;

	/**
	 * 工程计划毛利率 33
	 */
	private String proPlanProfitRate;

	/**
	 * 工程现阶段已结转成本 34
	 */
	private String settleCostNow;

	/**
	 * 工程现阶段毛利润 35
	 */
	private String grossProfitNow;

	/**
	 * 工程现阶段毛利率 36
	 */
	private String grossRateNow;

	/**
	 * 工程预估审定金额(含税) 37
	 */
	private String preExamineAmount;

	/**
	 * 工程预估实际总收入(除税) 38
	 */
	private String preActTolIncome;

	/**
	 * 工程预估实际总成本 39
	 */
	private String preActCost;

	/**
	 * 工程预估实际毛利润 40
	 */
	private String preActGroProfit;

	/**
	 * 工程预估实际毛利率 41
	 */
	private String preActGroRate;

	/**
	 * 工程审定金额 42
	 */
	private String examineAmount;

	/**
	 * 工程审计后实际总收入 43
	 */
	private String exaActTolIncome;

	/**
	 * 工程审计后实际总成本 44
	 */
	private String exaActCost;

	/**
	 * 工程审计后实际毛利润 45
	 */
	private String exaActGroProfit;

	/**
	 * 工程审计后实际毛利率 46
	 */
	private String exaActGroRate;

	/**
	 * 直接负责人 47
	 */
	private String dirCharPerson;

	/**
	 * 分管领导 48
	 */
	private String leaderOfBranch;

	/**
	 * 备注 49
	 */
	private String remark;

	/**
	 * 税率(补充,单位%) 50
	 */
	private String taxRate;

	/**
	 * 收款时间 51
	 */
	private String incomeDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the squNo
	 */
	public Integer getSquNo() {
		return squNo;
	}

	/**
	 * @param squNo the squNo to set
	 */
	public void setSquNo(Integer squNo) {
		this.squNo = squNo;
	}

	/**
	 * @return the projectNo
	 */
	public String getProjectNo() {
		return projectNo;
	}

	/**
	 * @param projectNo the projectNo to set
	 */
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	/**
	 * @return the drawingNo
	 */
	public String getDrawingNo() {
		return drawingNo;
	}

	/**
	 * @param drawingNo the drawingNo to set
	 */
	public void setDrawingNo(String drawingNo) {
		this.drawingNo = drawingNo;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the ownerUnit
	 */
	public String getOwnerUnit() {
		return ownerUnit;
	}

	/**
	 * @param ownerUnit the ownerUnit to set
	 */
	public void setOwnerUnit(String ownerUnit) {
		this.ownerUnit = ownerUnit;
	}

	/**
	 * @return the implUnit
	 */
	public String getImplUnit() {
		return implUnit;
	}

	/**
	 * @param implUnit the implUnit to set
	 */
	public void setImplUnit(String implUnit) {
		this.implUnit = implUnit;
	}

	/**
	 * @return the contractPrice
	 */
	public String getContractPrice() {
		return contractPrice;
	}

	/**
	 * @param contractPrice the contractPrice to set
	 */
	public void setContractPrice(String contractPrice) {
		this.contractPrice = contractPrice;
	}

	/**
	 * @return the princSupplier
	 */
	public String getPrincSupplier() {
		return princSupplier;
	}

	/**
	 * @param princSupplier the princSupplier to set
	 */
	public void setPrincSupplier(String princSupplier) {
		this.princSupplier = princSupplier;
	}

	/**
	 * @return the provAmount
	 */
	public String getProvAmount() {
		return provAmount;
	}

	/**
	 * @param provAmount the provAmount to set
	 */
	public void setProvAmount(String provAmount) {
		this.provAmount = provAmount;
	}

	/**
	 * @return the taxedIncome
	 */
	public String getTaxedIncome() {
		return taxedIncome;
	}

	/**
	 * @param taxedIncome the taxedIncome to set
	 */
	public void setTaxedIncome(String taxedIncome) {
		this.taxedIncome = taxedIncome;
	}

	/**
	 * @return the noneTaxedIncome
	 */
	public String getNoneTaxedIncome() {
		return noneTaxedIncome;
	}

	/**
	 * @param noneTaxedIncome the noneTaxedIncome to set
	 */
	public void setNoneTaxedIncome(String noneTaxedIncome) {
		this.noneTaxedIncome = noneTaxedIncome;
	}

	/**
	 * @return the projectState
	 */
	public String getProjectState() {
		return projectState;
	}

	/**
	 * @param projectState the projectState to set
	 */
	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

	/**
	 * @return the rateOfMonth
	 */
	public String getRateOfMonth() {
		return rateOfMonth;
	}

	/**
	 * @param rateOfMonth the rateOfMonth to set
	 */
	public void setRateOfMonth(String rateOfMonth) {
		this.rateOfMonth = rateOfMonth;
	}

	/**
	 * @return the actualOutputOfMonth
	 */
	public String getActualOutputOfMonth() {
		return actualOutputOfMonth;
	}

	/**
	 * @param actualOutputOfMonth the actualOutputOfMonth to set
	 */
	public void setActualOutputOfMonth(String actualOutputOfMonth) {
		this.actualOutputOfMonth = actualOutputOfMonth;
	}

	/**
	 * @return the cumulaActRate
	 */
	public String getCumulaActRate() {
		return cumulaActRate;
	}

	/**
	 * @param cumulaActRate the cumulaActRate to set
	 */
	public void setCumulaActRate(String cumulaActRate) {
		this.cumulaActRate = cumulaActRate;
	}

	/**
	 * @return the cumulaActOutput
	 */
	public String getCumulaActOutput() {
		return cumulaActOutput;
	}

	/**
	 * @param cumulaActOutput the cumulaActOutput to set
	 */
	public void setCumulaActOutput(String cumulaActOutput) {
		this.cumulaActOutput = cumulaActOutput;
	}

	/**
	 * @return the supervReOfMonth
	 */
	public String getSupervReOfMonth() {
		return supervReOfMonth;
	}

	/**
	 * @param supervReOfMonth the supervReOfMonth to set
	 */
	public void setSupervReOfMonth(String supervReOfMonth) {
		this.supervReOfMonth = supervReOfMonth;
	}

	/**
	 * @return the supervReOutOfMonth
	 */
	public String getSupervReOutOfMonth() {
		return supervReOutOfMonth;
	}

	/**
	 * @param supervReOutOfMonth the supervReOutOfMonth to set
	 */
	public void setSupervReOutOfMonth(String supervReOutOfMonth) {
		this.supervReOutOfMonth = supervReOutOfMonth;
	}

	/**
	 * @return the setIncomeOfMonth
	 */
	public String getSetIncomeOfMonth() {
		return setIncomeOfMonth;
	}

	/**
	 * @param setIncomeOfMonth the setIncomeOfMonth to set
	 */
	public void setSetIncomeOfMonth(String setIncomeOfMonth) {
		this.setIncomeOfMonth = setIncomeOfMonth;
	}

	/**
	 * @return the cumulaSupOutOfMonth
	 */
	public String getCumulaSupOutOfMonth() {
		return cumulaSupOutOfMonth;
	}

	/**
	 * @param cumulaSupOutOfMonth the cumulaSupOutOfMonth to set
	 */
	public void setCumulaSupOutOfMonth(String cumulaSupOutOfMonth) {
		this.cumulaSupOutOfMonth = cumulaSupOutOfMonth;
	}

	/**
	 * @return the cumulaFinSetIncome
	 */
	public String getCumulaFinSetIncome() {
		return cumulaFinSetIncome;
	}

	/**
	 * @param cumulaFinSetIncome the cumulaFinSetIncome to set
	 */
	public void setCumulaFinSetIncome(String cumulaFinSetIncome) {
		this.cumulaFinSetIncome = cumulaFinSetIncome;
	}

	/**
	 * @return the cumulaFinIncomeRate
	 */
	public String getCumulaFinIncomeRate() {
		return cumulaFinIncomeRate;
	}

	/**
	 * @param cumulaFinIncomeRate the cumulaFinIncomeRate to set
	 */
	public void setCumulaFinIncomeRate(String cumulaFinIncomeRate) {
		this.cumulaFinIncomeRate = cumulaFinIncomeRate;
	}

	/**
	 * @return the unFinIncome
	 */
	public String getUnFinIncome() {
		return unFinIncome;
	}

	/**
	 * @param unFinIncome the unFinIncome to set
	 */
	public void setUnFinIncome(String unFinIncome) {
		this.unFinIncome = unFinIncome;
	}

	/**
	 * @return the incomeOfMonth
	 */
	public String getIncomeOfMonth() {
		return incomeOfMonth;
	}

	/**
	 * @param incomeOfMonth the incomeOfMonth to set
	 */
	public void setIncomeOfMonth(String incomeOfMonth) {
		this.incomeOfMonth = incomeOfMonth;
	}

	/**
	 * @return the cumulaIncome
	 */
	public String getCumulaIncome() {
		return cumulaIncome;
	}

	/**
	 * @param cumulaIncome the cumulaIncome to set
	 */
	public void setCumulaIncome(String cumulaIncome) {
		this.cumulaIncome = cumulaIncome;
	}

	/**
	 * @return the payRateOfContract
	 */
	public String getPayRateOfContract() {
		return payRateOfContract;
	}

	/**
	 * @param payRateOfContract the payRateOfContract to set
	 */
	public void setPayRateOfContract(String payRateOfContract) {
		this.payRateOfContract = payRateOfContract;
	}

	/**
	 * @return the paRaOfConIncome
	 */
	public String getPaRaOfConIncome() {
		return paRaOfConIncome;
	}

	/**
	 * @param paRaOfConIncome the paRaOfConIncome to set
	 */
	public void setPaRaOfConIncome(String paRaOfConIncome) {
		this.paRaOfConIncome = paRaOfConIncome;
	}

	/**
	 * @return the paRaOfConDeficit
	 */
	public String getPaRaOfConDeficit() {
		return paRaOfConDeficit;
	}

	/**
	 * @param paRaOfConDeficit the paRaOfConDeficit to set
	 */
	public void setPaRaOfConDeficit(String paRaOfConDeficit) {
		this.paRaOfConDeficit = paRaOfConDeficit;
	}

	/**
	 * @return the receIncome
	 */
	public String getReceIncome() {
		return receIncome;
	}

	/**
	 * @param receIncome the receIncome to set
	 */
	public void setReceIncome(String receIncome) {
		this.receIncome = receIncome;
	}

	/**
	 * @return the payAmount
	 */
	public String getPayAmount() {
		return payAmount;
	}

	/**
	 * @param payAmount the payAmount to set
	 */
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * @return the proPlanTalCost
	 */
	public String getProPlanTalCost() {
		return proPlanTalCost;
	}

	/**
	 * @param proPlanTalCost the proPlanTalCost to set
	 */
	public void setProPlanTalCost(String proPlanTalCost) {
		this.proPlanTalCost = proPlanTalCost;
	}

	/**
	 * @return the proPlanProfit
	 */
	public String getProPlanProfit() {
		return proPlanProfit;
	}

	/**
	 * @param proPlanProfit the proPlanProfit to set
	 */
	public void setProPlanProfit(String proPlanProfit) {
		this.proPlanProfit = proPlanProfit;
	}

	/**
	 * @return the proPlanProfitRate
	 */
	public String getProPlanProfitRate() {
		return proPlanProfitRate;
	}

	/**
	 * @param proPlanProfitRate the proPlanProfitRate to set
	 */
	public void setProPlanProfitRate(String proPlanProfitRate) {
		this.proPlanProfitRate = proPlanProfitRate;
	}

	/**
	 * @return the settleCostNow
	 */
	public String getSettleCostNow() {
		return settleCostNow;
	}

	/**
	 * @param settleCostNow the settleCostNow to set
	 */
	public void setSettleCostNow(String settleCostNow) {
		this.settleCostNow = settleCostNow;
	}

	/**
	 * @return the grossProfitNow
	 */
	public String getGrossProfitNow() {
		return grossProfitNow;
	}

	/**
	 * @param grossProfitNow the grossProfitNow to set
	 */
	public void setGrossProfitNow(String grossProfitNow) {
		this.grossProfitNow = grossProfitNow;
	}

	/**
	 * @return the grossRateNow
	 */
	public String getGrossRateNow() {
		return grossRateNow;
	}

	/**
	 * @param grossRateNow the grossRateNow to set
	 */
	public void setGrossRateNow(String grossRateNow) {
		this.grossRateNow = grossRateNow;
	}

	/**
	 * @return the preExamineAmount
	 */
	public String getPreExamineAmount() {
		return preExamineAmount;
	}

	/**
	 * @param preExamineAmount the preExamineAmount to set
	 */
	public void setPreExamineAmount(String preExamineAmount) {
		this.preExamineAmount = preExamineAmount;
	}

	/**
	 * @return the preActTolIncome
	 */
	public String getPreActTolIncome() {
		return preActTolIncome;
	}

	/**
	 * @param preActTolIncome the preActTolIncome to set
	 */
	public void setPreActTolIncome(String preActTolIncome) {
		this.preActTolIncome = preActTolIncome;
	}

	/**
	 * @return the preActCost
	 */
	public String getPreActCost() {
		return preActCost;
	}

	/**
	 * @param preActCost the preActCost to set
	 */
	public void setPreActCost(String preActCost) {
		this.preActCost = preActCost;
	}

	/**
	 * @return the preActGroProfit
	 */
	public String getPreActGroProfit() {
		return preActGroProfit;
	}

	/**
	 * @param preActGroProfit the preActGroProfit to set
	 */
	public void setPreActGroProfit(String preActGroProfit) {
		this.preActGroProfit = preActGroProfit;
	}

	/**
	 * @return the preActGroRate
	 */
	public String getPreActGroRate() {
		return preActGroRate;
	}

	/**
	 * @param preActGroRate the preActGroRate to set
	 */
	public void setPreActGroRate(String preActGroRate) {
		this.preActGroRate = preActGroRate;
	}

	/**
	 * @return the examineAmount
	 */
	public String getExamineAmount() {
		return examineAmount;
	}

	/**
	 * @param examineAmount the examineAmount to set
	 */
	public void setExamineAmount(String examineAmount) {
		this.examineAmount = examineAmount;
	}

	/**
	 * @return the exaActTolIncome
	 */
	public String getExaActTolIncome() {
		return exaActTolIncome;
	}

	/**
	 * @param exaActTolIncome the exaActTolIncome to set
	 */
	public void setExaActTolIncome(String exaActTolIncome) {
		this.exaActTolIncome = exaActTolIncome;
	}

	/**
	 * @return the exaActCost
	 */
	public String getExaActCost() {
		return exaActCost;
	}

	/**
	 * @param exaActCost the exaActCost to set
	 */
	public void setExaActCost(String exaActCost) {
		this.exaActCost = exaActCost;
	}

	/**
	 * @return the exaActGroProfit
	 */
	public String getExaActGroProfit() {
		return exaActGroProfit;
	}

	/**
	 * @param exaActGroProfit the exaActGroProfit to set
	 */
	public void setExaActGroProfit(String exaActGroProfit) {
		this.exaActGroProfit = exaActGroProfit;
	}

	/**
	 * @return the exaActGroRate
	 */
	public String getExaActGroRate() {
		return exaActGroRate;
	}

	/**
	 * @param exaActGroRate the exaActGroRate to set
	 */
	public void setExaActGroRate(String exaActGroRate) {
		this.exaActGroRate = exaActGroRate;
	}

	/**
	 * @return the dirCharPerson
	 */
	public String getDirCharPerson() {
		return dirCharPerson;
	}

	/**
	 * @param dirCharPerson the dirCharPerson to set
	 */
	public void setDirCharPerson(String dirCharPerson) {
		this.dirCharPerson = dirCharPerson;
	}

	/**
	 * @return the leaderOfBranch
	 */
	public String getLeaderOfBranch() {
		return leaderOfBranch;
	}

	/**
	 * @param leaderOfBranch the leaderOfBranch to set
	 */
	public void setLeaderOfBranch(String leaderOfBranch) {
		this.leaderOfBranch = leaderOfBranch;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}

}
