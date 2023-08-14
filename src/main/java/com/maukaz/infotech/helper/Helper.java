package com.maukaz.infotech.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.maukaz.infotech.entites.ElectionApp;

public class Helper {

	// check that file is of excel type or not
	public static boolean checkExcelFormat(MultipartFile file) {

		String contentType = file.getContentType();

		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}

	}

	// convert excel to list of products

	public static List<ElectionApp> convertExcelToListOfElectionApp(InputStream is) {
		List<ElectionApp> list = new ArrayList<ElectionApp>();

		try {

			XSSFWorkbook workbook = new XSSFWorkbook(is);

			XSSFSheet sheet = workbook.getSheet("sheet");

			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();

				if (rowNumber==0) {
					rowNumber++;
					continue;
				}

				 Iterator<Cell> cells = row.iterator();

				int cid = 0;

				ElectionApp e = new ElectionApp();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					switch (cid) {
					case 0:
						e.setSrNo((int) cell.getNumericCellValue());
						break;
					case 1:
						e.setWardNo((int) cell.getNumericCellValue());
						break;
					case 2:
						e.setACNo((int) cell.getNumericCellValue());
						break;
					case 3:
						e.setPartNo((int) cell.getNumericCellValue());
						break;
					case 4:
						e.setSlNoInPart((int) cell.getNumericCellValue());
						break;
					case 5:
						e.setEPICNo(cell.getStringCellValue());
						break;
					case 6:
						e.setName(cell.getStringCellValue());
						break;
					case 7:
						e.setAge((int) cell.getNumericCellValue());
						break;
					case 8:
						e.setGender(cell.getStringCellValue());
						break;
					case 9:
						e.setRLnName(cell.getStringCellValue());
						break;

					case 10:
						e.setRLnType(cell.getStringCellValue());
						break;
					default:
						break;
					}
					cid++;

				}

				list.add(e);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;

	}

}
