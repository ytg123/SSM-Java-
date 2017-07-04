package com.gg.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;




/**
 * 
 * 用于文件上传的控制层
 * UploadController
 * 创建人:Tengguang Yang
 * 手机：18734153794
 * 时间：2017年7月2日-下午5:33:32 
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/sysmanager/upload")
public class UploadController {
	//跳往上传页面
	@RequestMapping("/goUpload")
	public String goUpload(){
		return "sysmanger/test/uplaod";
	}
	/**
	 * 
	 * 单文件上传
	 * com.gg.ssm.controller 
	 * 方法名：uploadFile
	 * 创建人:Tengguang Yang
	 * 手机：18734153794
	 * 时间：2017年7月2日-下午8:06:25 
	 * @param uploadFile
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/uploadFile")
	public String uploadFile(MultipartFile  uploadFile,HttpServletRequest request){
		//将我们的文件保存到项目中某个指定的文件夹下
		//得到项目的绝对路径
		String rootPath = request.getServletContext().getRealPath("upload");
		//将上传的图片放入指定文件夹中
		if(uploadFile != null){
			//上传文件的名字
			String fileName = uploadFile.getOriginalFilename();
			//文件后缀名
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			//避免文件重复,重新指定一个名字
			String newFileName = UUID.randomUUID().toString() + suffix;
			System.out.println(suffix);
			//如果不存在就创建
			File file = new File(rootPath);
			if(!file.exists()){
				file.mkdirs();
			}
			//存在的话
			File files = new File(rootPath+"\\"+newFileName);
			//将上传的文件放入指定的地点
			try {
				uploadFile.transferTo(files);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			request.setAttribute("uploadPath", "upload/"+newFileName);
		}
		return "sysmanger/test/uplaod";
	}
	/**
	 * 
	 * 多文件上传
	 * com.gg.ssm.controller 
	 * 方法名：uploadFile
	 * 创建人:Tengguang Yang
	 * 手机：18734153794
	 * 时间：2017年7月2日-下午7:50:28 
	 * @param uploadFiles
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/uploadFiles")
	public String uploadFile(@RequestParam MultipartFile[]  uploadFiles,HttpServletRequest request){
		//将我们的文件保存到项目中某个指定的文件夹下
		//得到项目的绝对路径
		String rootPath = request.getServletContext().getRealPath("upload");
		Map<String, Object>  maps = new HashMap<String, Object>();
		//将上传的图片放入指定文件夹中
		if(uploadFiles != null && uploadFiles.length > 0){
			for(MultipartFile uploadFile : uploadFiles){
				//上传文件的名字
				String fileName = uploadFile.getOriginalFilename();
				//文件后缀名
				String suffix = fileName.substring(fileName.lastIndexOf("."));
				//避免文件重复,重新指定一个名字
				String newFileName = UUID.randomUUID().toString() + suffix;
				//如果不存在就创建
				File file = new File(rootPath);
				if(!file.exists()){
					file.mkdirs();
				}
				//存在的话
				File files = new File(rootPath+"\\"+newFileName);
				//将上传的文件放入指定的地点
				try {
					uploadFile.transferTo(files);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				maps.put(fileName, newFileName);
			}
			request.setAttribute("Maps", maps);
		}
		return "sysmanger/test/uplaod";
	}
	/**
	 * 
	 * 文件下载
	 * com.gg.ssm.controller 
	 * 方法名：downLoad
	 * 创建人:Tengguang Yang
	 * 手机：18734153794
	 * 时间：2017年7月2日-下午8:30:31 
	 * @param fileName
	 * @param request
	 * @param response void
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/downLoad")
	public void downLoad(String fileName,HttpServletRequest request,HttpServletResponse response){
		if(fileName != null){
			String realPath = request.getServletContext().getRealPath("upload/");
			File file = new File(realPath,fileName);
			//输出流
			OutputStream out = null;
			if(file.exists()){
				//设置强制下载不打开
				response.setContentType("application/force-download");
				//设置请求头
				response.setHeader("Content-Disposition", "attachment;filename="+fileName);
				try {
					//获取输出流
					out = response.getOutputStream();
					//输出到页面
					out.write(FileUtils.readFileToByteArray(file));
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					if(out != null){
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
