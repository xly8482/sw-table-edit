package com.example.demo.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	public static String getFolderName(String fullFilePath) {
		fullFilePath = fullFilePath.replaceAll("\\\\", "\\/");
		return fullFilePath.substring(0, fullFilePath.lastIndexOf("/"));
	}

	public static boolean makeDirs(String dirs) {
		if (dirs == null || dirs.isEmpty()) {
			return false;
		}

		File folder = new File(dirs);
		return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
	}

	public static boolean save(String fullFilePath, byte[] fileBytes) {
		File file = create(fullFilePath, true);

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(fileBytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}

		return true;
	}

	public static File create(String fullFilePath, boolean existsDel) {
		File file = new File(fullFilePath);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}

	public static File get(String fullFilePath) {
		File file = new File(fullFilePath);

		if (file.exists()) {
			return file;
		}

		return null;
	}

	public static void delete(String fullFilePath) {
		File file = new File(fullFilePath);

		if (file.exists() && !file.delete()) {
		}
	}
}
