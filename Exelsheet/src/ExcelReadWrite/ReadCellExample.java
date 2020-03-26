package ExcelReadWrite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadCellExample {
	public static void main(String[] args) {
		ReadCellExample rc = new ReadCellExample();

		String vOutput = rc.ReadCellData(1, 0);
		System.out.println(vOutput);
	}

	public String ReadCellData(int vRow, int vColumn) {
		String value = null;
		Workbook wb = null;
		try {

			FileInputStream fis = new FileInputStream("C:\\Users\\91975\\Documents\\student.xls");

			wb = new HSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(vRow);
		Cell cell = row.getCell(vColumn);
		value = cell.getStringCellValue();
		return value;
	}
}