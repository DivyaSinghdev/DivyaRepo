package com.labmanagement.util;

/*
 * This code uses singleton pattern to ensure only one instance of the excel file is used and always that instance is only referred!
 * 
 */

import com.labmanagement.model.Equipment;
import com.labmanagement.model.Inventory;
import com.labmanagement.model.Research;
import com.labmanagement.model.Scientist;
import com.labmanagement.model.Laboratory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileHandlingUtility {

	private static FileHandlingUtility instance;
	private static final String filePath = "C:\\Users\\Divya03.S\\OneDrive - Zifo RnD Solutions\\JAVA\\eclipse made project"
			+ "\\researchlabmanagement\\Laboratory Details.xlsx";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("M/d/yy");

	private FileHandlingUtility() {
		// Private constructor to prevent instantiation
		//singleton design pattern!
	}

	public static FileHandlingUtility getInstance() {
		if (instance == null) {
			instance = new FileHandlingUtility();
		}
		return instance;
	}

	public List<Equipment> readEquipmentDetails() {
		List<Equipment> equipmentList = new ArrayList<>();
		DataFormatter dataFormatter = new DataFormatter();
		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet("Equipment details");
			for (Row row : sheet) {
				if (row.getRowNum() == 0) continue;
				String equipmentId = dataFormatter.formatCellValue(row.getCell(0));
				String equipmentName = dataFormatter.formatCellValue(row.getCell(1));
				Equipment equipment = new Equipment(equipmentId, equipmentName);
				equipment.setManufacturerName(dataFormatter.formatCellValue(row.getCell(2)));
				equipment.setManufacturingDate(dataFormatter.formatCellValue(row.getCell(3)));
				equipment.setStatus(dataFormatter.formatCellValue(row.getCell(4)));
				equipmentList.add(equipment);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return equipmentList;
	}

	public void writeEquipmentDetails(List<Equipment> equipmentList) {
		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet("Equipment details");
			int rowIndex = 1; // Start after header row
			for (Equipment equipment : equipmentList) {
				Row row = sheet.getRow(rowIndex++);
				if (row == null) row = sheet.createRow(rowIndex - 1);
				row.createCell(0).setCellValue(equipment.getEquipmentId());
				row.createCell(1).setCellValue(equipment.getEquipmentName());
				row.createCell(2).setCellValue(equipment.getManufacturerName());
				row.createCell(3).setCellValue(equipment.getManufacturingDate());
				row.createCell(4).setCellValue(equipment.getStatus());
			}
			// Clear remaining rows
			for (int i = rowIndex; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					sheet.removeRow(row);
				}
			}
			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Inventory> readInventoryDetails() {
		List<Inventory> inventoryList = new ArrayList<>();
		DataFormatter dataFormatter = new DataFormatter();
		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet("Inventory details");
			for (Row row : sheet) {
				if (row.getRowNum() == 0) continue;
				String equipmentId = dataFormatter.formatCellValue(row.getCell(0));
				String equipmentName = dataFormatter.formatCellValue(row.getCell(1));
				Inventory inventory = new Inventory(equipmentId, equipmentName);
				inventory.setManufacturerName(dataFormatter.formatCellValue(row.getCell(2)));
				inventory.setManufacturingDate(dataFormatter.formatCellValue(row.getCell(3)));
				inventory.setStatus(dataFormatter.formatCellValue(row.getCell(4)));
				String discardDateStr = dataFormatter.formatCellValue(row.getCell(5));
				if (!discardDateStr.isEmpty()) {
					inventory.setDiscardDate(LocalDate.parse(discardDateStr, DATE_FORMATTER));
				}
				inventoryList.add(inventory);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inventoryList;
	}

	public void writeInventoryDetails(List<Inventory> inventoryList) {
		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet("Inventory details");
			int rowIndex = 1; // Start after header row
			for (Inventory inventory : inventoryList) {
				Row row = sheet.getRow(rowIndex++);
				if (row == null) row = sheet.createRow(rowIndex - 1);
				row.createCell(0).setCellValue(inventory.getEquipmentId());
				row.createCell(1).setCellValue(inventory.getEquipmentName());
				row.createCell(2).setCellValue(inventory.getManufacturerName());
				row.createCell(3).setCellValue(inventory.getManufacturingDate());
				row.createCell(4).setCellValue(inventory.getStatus());
				if (inventory.getDiscardDate() != null) {
					row.createCell(5).setCellValue(inventory.getDiscardDate().format(DATE_FORMATTER));
				}
			}
			// Clear remaining rows
			for (int i = rowIndex; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					sheet.removeRow(row);
				}
			}
			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public List<Research> readResearchDetails() {
	    List<Research> researchList = new ArrayList<>();
	    DataFormatter dataFormatter = new DataFormatter();
	    try (FileInputStream fis = new FileInputStream(filePath);
	            Workbook workbook = new XSSFWorkbook(fis)) {
	        Sheet sheet = workbook.getSheet("Research details");
	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) continue; // Skip header row
	            String researchId = dataFormatter.formatCellValue(row.getCell(0));
	            String researchName = dataFormatter.formatCellValue(row.getCell(1));
	            Research research = new Research(researchId, researchName);
	            research.setStartDate(dataFormatter.formatCellValue(row.getCell(2)));
	            research.setEndDate(dataFormatter.formatCellValue(row.getCell(3)));
	            research.setLeadScientistId(dataFormatter.formatCellValue(row.getCell(4)));
	            research.setLeadScientistName(dataFormatter.formatCellValue(row.getCell(5)));
	            research.setEquipmentId(dataFormatter.formatCellValue(row.getCell(6)));
	            research.setEquipmentName(dataFormatter.formatCellValue(row.getCell(7)));
	            researchList.add(research);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return researchList;
	}

	public void writeResearchDetails(List<Research> researchList) {
	    try (FileInputStream fis = new FileInputStream(filePath);
	            Workbook workbook = new XSSFWorkbook(fis)) {
	        Sheet sheet = workbook.getSheet("Research details");
	        int rowIndex = 1; // Start after header row
	        for (Research research : researchList) {
	            Row row = sheet.getRow(rowIndex++);
	            if (row == null) row = sheet.createRow(rowIndex - 1);
	            row.createCell(0).setCellValue(research.getResearchId());
	            row.createCell(1).setCellValue(research.getResearchName());
	            row.createCell(2).setCellValue(research.getStartDate());
	            row.createCell(3).setCellValue(research.getEndDate());
	            row.createCell(4).setCellValue(research.getLeadScientistId());
	            row.createCell(5).setCellValue(research.getLeadScientistName());
	            row.createCell(6).setCellValue(research.getEquipmentId());
	            row.createCell(7).setCellValue(research.getEquipmentName());
	        }

	        // Clear remaining rows
	        for (int i = rowIndex; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row != null) {
	                sheet.removeRow(row);
	            }
	        }

	        try (FileOutputStream fos = new FileOutputStream(filePath)) {
	            workbook.write(fos);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public List<Scientist> readScientistDetails() {
		List<Scientist> scientistList = new ArrayList<>();
		DataFormatter dataFormatter = new DataFormatter();
		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet("Scientist details");
			for (Row row : sheet) {
				if (row.getRowNum() == 0) continue; // Skip header row
				String scientistId = dataFormatter.formatCellValue(row.getCell(0));
				String scientistName = dataFormatter.formatCellValue(row.getCell(1));
				Scientist scientist = new Scientist(scientistId, scientistName);
				scientist.setAge((int) row.getCell(2).getNumericCellValue());
				scientist.setGender(dataFormatter.formatCellValue(row.getCell(3)));
				scientist.setResearchId(dataFormatter.formatCellValue(row.getCell(4)));
				scientist.setReportingScientistId(dataFormatter.formatCellValue(row.getCell(5)));
				scientistList.add(scientist);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scientistList;
	}

	public void writeScientistDetails(List<Scientist> scientistList) {
		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet("Scientist details");
			int rowIndex = 1; // Start after header row
			for (Scientist scientist : scientistList) {
				Row row = sheet.getRow(rowIndex++);
				if (row == null) row = sheet.createRow(rowIndex - 1);
				row.createCell(0).setCellValue(scientist.getScientistId());
				row.createCell(1).setCellValue(scientist.getScientistName());
				row.createCell(2).setCellValue(scientist.getAge());
				row.createCell(3).setCellValue(scientist.getGender());
				row.createCell(4).setCellValue(scientist.getResearchId());
				row.createCell(5).setCellValue(scientist.getReportingScientistId());
			}

			// Clear remaining rows
			for (int i = rowIndex; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					sheet.removeRow(row);
				}
			}

			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Laboratory> readLaboratoryDetails() {
		List<Laboratory> laboratoryList = new ArrayList<>();
		DataFormatter dataFormatter = new DataFormatter();
		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet("Laboratory details");
			for (Row row : sheet) {
				if (row.getRowNum() == 0) continue; // Skip header row
				String labId = dataFormatter.formatCellValue(row.getCell(0));
				String laboratoryName = dataFormatter.formatCellValue(row.getCell(1));
				Laboratory laboratory = new Laboratory(labId, laboratoryName);
				laboratory.setResearchId(dataFormatter.formatCellValue(row.getCell(2)));
				laboratory.setResearchName(dataFormatter.formatCellValue(row.getCell(3)));
				laboratory.setScientistId(dataFormatter.formatCellValue(row.getCell(4)));
				laboratory.setLeadScientistName(dataFormatter.formatCellValue(row.getCell(5)));
				laboratory.setEquipmentId(dataFormatter.formatCellValue(row.getCell(6)));
				laboratory.setEquipmentName(dataFormatter.formatCellValue(row.getCell(7)));
				laboratoryList.add(laboratory);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return laboratoryList;
	}

	public void writeLaboratoryDetails(List<Laboratory> laboratoryList) {
		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet("Laboratory details");
			int rowIndex = 1; // Start after header row
			for (Laboratory laboratory : laboratoryList) {
				Row row = sheet.getRow(rowIndex++);
				if (row == null) row = sheet.createRow(rowIndex - 1);
				row.createCell(0).setCellValue(laboratory.getLabId());
				row.createCell(1).setCellValue(laboratory.getLaboratoryName());
				row.createCell(2).setCellValue(laboratory.getResearchId());
				row.createCell(3).setCellValue(laboratory.getResearchName());
				row.createCell(4).setCellValue(laboratory.getScientistId());
				row.createCell(5).setCellValue(laboratory.getLeadScientistName());
				row.createCell(6).setCellValue(laboratory.getEquipmentId());
				row.createCell(7).setCellValue(laboratory.getEquipmentName());
			}

			// Clear remaining rows
			for (int i = rowIndex; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					sheet.removeRow(row);
				}
			}

			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}