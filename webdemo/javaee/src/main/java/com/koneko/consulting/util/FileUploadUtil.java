package com.koneko.consulting.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtil {
	// 需要用到的常量
	public static final long MAX_SIZE = 3141592L;
	public static final long FILE_MAX_SIZE = 1010101L;
	public static final String TEMP_DIR = "/temp/";
	public static final String UPLOAD_DIR = "/upload/";
	public static final String ENCODING = "utf-8";

	private HttpServletRequest request;
	private String uploadFile;// 上传路径
	private String tempFile;// 临时路径
	private String encoding;// 编码设定
	private long maxSize;// 提交表单大小
	private long fileMaxSize;// 文件大小
	private ServletFileUpload fileUpload;// 上传处理

	private boolean uploadFlag = false;
	private List<String> tempFileNames = new ArrayList<>();
	private Map<String, String[]> paramMap = new HashMap<>();

	public FileUploadUtil(HttpServletRequest request) throws Exception {
		this(request, UPLOAD_DIR, TEMP_DIR, ENCODING, MAX_SIZE, FILE_MAX_SIZE);
	}

	public FileUploadUtil(HttpServletRequest request, String uploadFile) throws Exception {
		this(request, uploadFile, TEMP_DIR, ENCODING, MAX_SIZE, FILE_MAX_SIZE);
	}

	public FileUploadUtil(HttpServletRequest request, String uploadFile, String tempFile, String encoding, long maxSize,
			long fileMaxSize) throws Exception {
		this.request = request;
		if (uploadFile.endsWith("/")) {
			this.uploadFile = uploadFile;
		} else {
			this.uploadFile = uploadFile + "/";
		}
		if (tempFile.endsWith("/")) {
			this.tempFile = tempFile;
		} else {
			this.tempFile = tempFile + "/";
		}
		this.encoding = encoding;
		this.maxSize = maxSize;
		this.fileMaxSize = fileMaxSize;
		// 实例化的时候就应该开始准备数据
		this.fileUploadHandler();
	}

	// 处理机制
	private void fileUploadHandler() throws Exception {
		// 判断表单是否封装 multipart/form-data
		if (uploadFlag = this.request.getContentType() != null
				&& this.request.getContentType().startsWith("multipart/form-data")) {
			DiskFileItemFactory factory = new DiskFileItemFactory();// 打开文件管理工厂
			factory.setRepository(new File(TEMP_DIR));// 设定工厂工作的临时仓库
			this.fileUpload = new ServletFileUpload(factory);// HttpServletRequest接口的子类实现
			fileUpload.setSizeMax(MAX_SIZE);// 设定最大的表单字节两
			fileUpload.setFileSizeMax(FILE_MAX_SIZE);// 设定文件最大字节两
			// 判断有文件上传
			if (fileUpload.isMultipartContent(request)) {// request是内置对象 HttpServletRequest
				// 此时得到的全部的数据内容实际上保存在FileItem
				try {
					Map<String, List<FileItem>> maps = this.fileUpload.parseParameterMap(request);
					Set<Map.Entry<String, List<FileItem>>> entrys = maps.entrySet();
					Iterator<Map.Entry<String, List<FileItem>>> it = entrys.iterator();
					while (it.hasNext()) {
						Map.Entry<String, List<FileItem>> entry = it.next();
						String paramName = entry.getKey();
						List<FileItem> items = entry.getValue();
						// 如果得到的内容是文本数据，直接保存在paramMap集合中，，如果是上传文件话，生成一个新的文件
						String[] values = new String[items.size()];
						int foot = 0;
						for (FileItem item : items) {
							if (item.isFormField()) {
								String value = item.getString(this.encoding);
								values[foot++] = value;
							} else {// 如果说二进制内容
								String fileName = this.saveTempFile(item);
								this.tempFileNames.add(fileName);
								values[foot++] = fileName;
							}
						}
						// 最终能够实现信息查询的就是parammap
						this.paramMap.put(paramName, values);
					}
				} catch (FileUploadException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

	// 通过FileItem可以获取原始文件名称以及MIME类型，咱们的最终文件名需要用到原始文件的后缀
	private String saveTempFile(FileItem item) throws Exception {
		if (item.getSize() > 0) {
			String fileName = "temp." + this.getUUIDName(item);
			String filePath = this.request.getServletContext().getRealPath(this.tempFile) + fileName;
			item.write(new File(filePath));
			item.delete();
			return fileName;
		}
		return null;
	}

	// 获取UUID名称
	private String getUUIDName(FileItem item) {
		return UUID.randomUUID() + "." + item.getContentType().substring(item.getContentType().lastIndexOf("/") + 1);
	}

	// 通过参数名称获取参数内容
	public String getParameter(String paramName) {
		if (this.uploadFlag) {
			if (this.paramMap.containsKey(paramName)) {
				return this.paramMap.get(paramName)[0];
			}
			return null;
		}
		return this.request.getParameter(paramName);
	}

	// 根据参数名获取一组参数内容
	public String[] getParameterValues(String paramName) {
		if (this.uploadFlag) {// 获取文件
			if (this.paramMap.containsKey(paramName)) {
				return this.paramMap.get(paramName);
			}
			return null;
		}
		return this.request.getParameterValues(paramName);// 普通文本
	}

	// 获取全部参数名称
	public Set<String> getParameterKeys() {
		if (this.uploadFlag) {
			return this.paramMap.keySet();
		}
		return this.request.getParameterMap().keySet();
	}

	public Map<String, String[]> getParamMap() {
		if (this.uploadFlag) {
			return this.paramMap;
		}
		return this.request.getParameterMap();
	}

	// 获取指定参数的临时文件保存名称，同时生成新的目标文件保存名称 获得一个新文件名集合
	public List<String> getUUIDName(String paramName) {
		List<String> uuidNames = new ArrayList<>();
		String[] fileNames = this.paramMap.get(paramName);// 获取到了所有的临时文件名
		for (String fileName : fileNames) {
			uuidNames.add("upload." + UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf("/") + 1));
		}
		return uuidNames;
	}

	// 上传
	public void saveUploadFile(String paramName, List<String> uploadFileNames) throws Exception {
		String[] fileNames = this.paramMap.get(paramName);
		for (int i = 0; i < fileNames.length; i++) {
			File srcFile = new File(this.request.getServletContext().getRealPath(this.tempFile) + fileNames[i]);
			File descFile = new File(
					this.request.getServletContext().getRealPath(this.uploadFile) + uploadFileNames.get(i));
			InputStream in = new FileInputStream(srcFile);
			OutputStream out = new FileOutputStream(descFile);
			in.transferTo(out);
			in.close();
			out.close();
		}
	}

	// 清除
	public void clear() {
		if (this.tempFileNames != null && this.tempFileNames.size() > 0) {
			for (String fileName : this.tempFileNames) {
				String filePath = this.request.getServletContext().getRealPath(this.tempFile) + fileName;
				File file = new File(filePath);
				if (file.exists()) {
					file.delete();
				}
			}
		}
	}

	// 获取临时目录下的所有内容
	public List<String> getTempFileNames() {
		return tempFileNames;
	}
}
