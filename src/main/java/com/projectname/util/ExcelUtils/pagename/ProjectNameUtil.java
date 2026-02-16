package com.projectname.util.ExcelUtils.pagename;

import java.io.IOException;
import java.util.ArrayList;

import com.projectname.util.DTO.ProjectNameDTO;
import com.projectname.util.ExcelUtils.Xls_Reader;

public class ProjectNameUtil {
	public static Xls_Reader reader;

	public static ArrayList<ProjectNameDTO> getDetailsFromExcel(String dataFilePath) throws IOException {

		ArrayList<ProjectNameDTO> payNameDatas = new ArrayList<ProjectNameDTO>();
		try {
			reader = new Xls_Reader(dataFilePath, "SheetName");
		} catch (Exception e) {
			e.printStackTrace();

		}
		for (int rowNum = 2; rowNum <= reader.getRowCount("SheetName"); rowNum++) {
			ProjectNameDTO pageNameDetail = new ProjectNameDTO();
			String Username = Xls_Reader.getCellData("SheetName", "Username", rowNum);
			String Password = Xls_Reader.getCellData("SheetName", "Password", rowNum);
			pageNameDetail = new ProjectNameDTO();
			pageNameDetail.setUsername(Username);
			pageNameDetail.setPassword(Password);
		}
		return payNameDatas;

	}

}
