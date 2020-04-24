package com.takeout.tool;

import java.io.File;
import java.util.UUID;


public class PicTool {
	//重命名图片方法
	//传入sumartupload对象
	/*public static String renamePic(SmartUpload su, String abspath, String dir) {
		String path = abspath + dir;
		if (su==null) {
			return null;
		}
		try {
			File f = new File(path);
			if (!f.exists())
				f.mkdir();
			String ext = su.getFiles().getFile(0).getFileExt();
			if (ext == null || ext.equals("")) {
				System.out.println("用户未上传图片！");
				return null;
			}
			//使用uuid对文件进行重命名，以防止遇见不同用户上传同名文件
			String fileName = UUID.randomUUID() + "." + ext;
			System.out.println(path + java.io.File.separator + fileName);
			su.getFiles().getFile(0).saveAs(path + java.io.File.separator + fileName);
			return "/img/" + dir + "/" + fileName;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}*/

	//删除图片方法
	//传入图片路径
	public static boolean delPic(String path) {
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("文件" + path + "删除成功！");
				return true;
			}
			System.out.println("文件" + path + "删除失败！");
		}
		return false;
	}
}
