package com.example.demo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 产生Excel报表文档，使用Apache POI
 * 
 * @author hewenfa
 *
 */
public class PoiExcelReport {
	protected Workbook wb;

	/**
	 * 读取报表构造方法
	 * 
	 * @param filePath
	 *            源报表路径或报表模板路径
	 */
	public PoiExcelReport(final String filePath) {
		FileInputStream inp = null;

		try {
			inp = new FileInputStream(filePath);

			if (filePath.substring(filePath.lastIndexOf(".")).equals("xlsx")) {
				wb = new XSSFWorkbook(inp);
			} else {
				wb = WorkbookFactory.create(inp);
			}

			inp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} finally {
			if (null != inp) {
				try {
					inp.close();
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * 导出报表
	 */
	public void export(String outputFile) {
		FileOutputStream out = null;

		try {
			FileUtil.makeDirs(FileUtil.getFolderName(outputFile));
			out = new FileOutputStream(outputFile);
			wb.write(out);
			close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭Excel
	 */
	public void close() {
		if (wb != null) {
			try {
				wb.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 获取Workbook
	 * 
	 * @return
	 */
	public Workbook getWorkbook() {
		return this.wb;
	}

	// ==========================================================================
	// Sheet 获取、创建、删除
	// ==========================================================================

	public Sheet getSheet(int index) {
		if (wb != null) {
			return wb.getSheetAt(index);
		}

		return null;
	}

	public Sheet getSheet(String sheetName) {
		if (wb != null) {
			return wb.getSheet(sheetName);
		}

		return null;
	}

	public Sheet createSheet(String sheetName) {
		if (wb != null) {
			return wb.createSheet(sheetName);
		}

		return null;
	}

	public Sheet createSheet() {
		if (wb != null) {
			return wb.createSheet();
		}

		return null;
	}

	public void removeSheet(int idx) {
		if (wb != null) {
			if (wb.getSheetAt(idx) != null) {
				wb.removeSheetAt(idx);
			}
		}
	}

	public void removeSheet(String name) {
		if (wb != null) {
			int idx = wb.getSheetIndex(name);

			if (idx > -1) {
				wb.removeSheetAt(idx);
			}
		}
	}

	public void removeSheet(Sheet sheet) {
		if (wb != null) {
			int idx = wb.getSheetIndex(sheet);

			if (idx > -1) {
				wb.removeSheetAt(idx);
			}
		}
	}

	// ==========================================================================
	// Row 获取与创建
	// ==========================================================================

	public Row getRow(int sheetIndex, int rowIndex) {
		Sheet sheet = this.getSheet(sheetIndex);

		if (sheet != null) {
			return sheet.getRow(rowIndex);
		}

		return null;
	}

	public Row getRow(String sheetName, int rowIndex) {
		Sheet sheet = this.getSheet(sheetName);

		if (sheet != null) {
			return sheet.getRow(rowIndex);
		}

		return null;
	}

	public Row getRow(final Sheet sheet, final int rowIndex) {
		Row row = sheet.getRow(rowIndex);

		if (row == null) {
			row = sheet.createRow(rowIndex);
		}

		return row;
	}

	public Row createRow(final Sheet sheet, final int rowIndex) {
		if (sheet != null) {
			return sheet.createRow(rowIndex);
		}

		return null;
	}

	// ==========================================================================
	// Cell 获取与创建
	// ==========================================================================

	public Cell getCell(final Row row, final int cellIndex) {
		Cell cell = row.getCell(cellIndex);

		if (cell == null) {
			cell = row.createCell(cellIndex);
		}

		return cell;
	}

	public Cell getCell(final Row row, final int cellIndex, final CellStyle style) {
		Cell cell = row.getCell(cellIndex);

		if (cell == null) {
			cell = row.createCell(cellIndex);
		}

		cell.setCellStyle(style);
		return cell;
	}

	public Cell createCell(final Row row, final int cellIndex) {
		if (row != null) {
			return row.createCell(cellIndex);
		}

		return null;
	}

	public Cell createCell(final Row row, final int cellIndex, final CellStyle style) {
		if (row != null) {
			Cell cell = row.createCell(cellIndex);
			cell.setCellStyle(style);
			return cell;
		}

		return null;
	}

	// ==========================================================================
	// 设置单元格值
	// ==========================================================================

	/**
	 * 参数方式设置单元格值
	 * 
	 * @param sheet
	 * @param paramMap
	 */
	@SuppressWarnings("deprecation")
	public void setSheetParams(final Sheet sheet, final Map<Object, Object> paramMap) {
		int startRowIdx = 0;
		int endRowIdx = sheet.getLastRowNum();

		for (int i = startRowIdx; i <= endRowIdx; i++) {
			final Row row = getRow(sheet, i);

			if (row == null) {
				continue;
			}

			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = getCell(row, j);

				if (cell != null && Cell.CELL_TYPE_STRING == cell.getCellType()) {
					final String cellValue = cell.getStringCellValue();

					if (paramMap.containsKey(cellValue)) {
						setCellValue(cell, paramMap.get(cellValue));
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getCellValue(Cell cell) {
		if (cell != null) {

			int type = cell.getCellType();

			switch (type) {
			case Cell.CELL_TYPE_BLANK:
				return (T) "";

			case Cell.CELL_TYPE_STRING:
				return (T) cell.getStringCellValue();

			case Cell.CELL_TYPE_BOOLEAN:
				return (T) (Boolean) cell.getBooleanCellValue();

			case Cell.CELL_TYPE_NUMERIC:
				return (T) (Double) cell.getNumericCellValue();

			default:
				break;
			}
		}

		return null;
	}

	public String getCellValueStr(Cell cell) {
		if (cell != null) {

			int type = cell.getCellType();

			switch (type) {
			case Cell.CELL_TYPE_BLANK:
				return "";

			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue();

			case Cell.CELL_TYPE_BOOLEAN:
				return cell.getBooleanCellValue() + "";

			case Cell.CELL_TYPE_NUMERIC:
				String strVal = (Double) cell.getNumericCellValue() + "";
				return strVal;
			default:
				break;
			}
		}

		return null;
	}

	/**
	 * 根据数据类型，设置单元格值
	 * 
	 * @param cell
	 * @param value
	 */
	public void setCellValue(Cell cell, Object value) {
		if (cell != null) {
			if (value == null) {
				cell.setCellType(Cell.CELL_TYPE_BLANK);
				cell.setCellValue("");
			} else if (value instanceof String) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue((String) value);
			} else if (value instanceof Date) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue((Date) value);
			} else if (value instanceof Double) {
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue((Double) value);
			} else if (value instanceof Float) {
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue((Float) value);
			} else if (value instanceof BigDecimal) {
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue(((BigDecimal) value).doubleValue());
			} else if (value instanceof Integer) {
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue((Integer) value);
			} else {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue(value.toString());
			}
		}
	}
}
