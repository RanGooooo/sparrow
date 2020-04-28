package com.rain.sparrow.control.code.service.sdk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
111111111111111111111111▄11
111111111▐█11111111111▄▀0▌1
11111111▐▀0█11111111▄▀000▐
1111111▐▄▀00▀▀▀▀▄▄▄▀00000▐
11111▄▄▀01000000000█00▄█0▐
111▄▀000111000111000▀██▀0▌
11▐000▄▄00001110000000▀▄00
11▌11▌█▀00000▄▀█▄0000000█0▐
1▐11100000000▌██▀00111000▀▄
1▌10▄██▄0000000001111110000
▀0▀▐▄█▄█▌▄1▀001111111111000
 * @author 赵宏宇
 */
public class LiberateHand {

	private List<String> sourceFiles = new ArrayList<String>();

	private List<String> sourceFolders = new ArrayList<String>();

	private List<String> modelFiles = new ArrayList<String>();

	private List<String> modelFolders = new ArrayList<String>();
	
	private final static String SOURCE_MODEL = "xxxxxxxxx";

	private final static String SOURCE_ENTITY = "Xxxxxxxxx";
	
	private final static String SOURCE_TABLE = "xxxxdbxxxx";
	
	private final static String SOURCE_FOLDERS_PATH = "D:\\code\\xxxxxxxxx";
	
	private final static String SOURCE_PACKAGE_PATH = "model.temp.";

	private String model;

	private String entity;
	
	private String table;
	
	private String packagePath;
	
	private Field field;

	public LiberateHand setModel(String model) {
		this.model = model;
		return this;
	}

	public LiberateHand setEntity(String entity) {
		this.entity = entity;
		return this;
	}

	public LiberateHand setTable(String table) {
		this.table = table;
		return this;
	}

	public LiberateHand setPackagePath(String packagePath) {
		this.packagePath = packagePath;
		return this;
	}

	public LiberateHand setField(Field field) {
		this.field = field;
		return this;
	}

	/**
	 * 获取指定目录下 文件 和 文件夹
	 * 
	 * @param files
	 * @param folders
	 * @param dir
	 * @return
	 *
	 * @version:v1.0
	 * @author:zhaohongyu
	 * @date:2019年12月24日 下午6:07:38
	 */
	public static boolean getAllFile(List<String> files, List<String> folders, File dir) {
		String absolutePath = dir.getAbsolutePath();
		if (dir.isDirectory()) {
			folders.add(absolutePath);
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				getAllFile(files, folders, new File(dir, children[i]));
			}
		} else {
			files.add(absolutePath);
		}
		return false;
	}

	public String replace(String str) {
		return str.replace(SOURCE_MODEL, model)
							.replace(SOURCE_ENTITY, entity)
							.replace(SOURCE_TABLE, table)
							.replace(SOURCE_PACKAGE_PATH, packagePath);
	}

	public void newFile() throws IOException {
		File file = new File(SOURCE_FOLDERS_PATH);
		getAllFile(sourceFiles, sourceFolders, file);
		for (String string : sourceFolders) {
			String replace = this.replace(string);
			modelFolders.add(replace);
			File newFolder = new File(replace);
			newFolder.mkdirs();
		}
		for (String string : sourceFiles) {
			String replace = this.replace(string);
			System.out.println("新增文件全限定名：" + replace);
			modelFiles.add(replace);
			File newFile = new File(replace);
			newFile.createNewFile();
		}
	}
	
	public void copyFileContextImpl(String source, String target) throws Exception {
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader(new File(source));
			br = new BufferedReader(fr);
			fw = new FileWriter(new File(target));
			bw = new BufferedWriter(fw);
			String line = "";
			while ((line = br.readLine()) != null) {
				line = this.replace(line);
				bw.write(line);
				//实体类代码组装处理
				if(target.lastIndexOf(entity + ".java")!=-1&&("public class "+entity+" {").equals(line)) {
					bw.write(field.build());
				}
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void copyFileContext() throws Exception {
		int i = 0;
		for (String string : modelFiles) {
			copyFileContextImpl(sourceFiles.get(i), string);
			i++;
		}
	}
	
	public LiberateHand build() throws Exception {
		this.newFile();
		this.copyFileContext();
		return this;
    }

	public static void main(String[] args) throws Exception {
		String columns = "id,purchase_apply_no,purchase_apply_name,total_budget,tender_mode_desc,sub_package_desc,main_qualification,evaluation_mode_desc,confirm_rule,evaluate_committee,agency_desc,agency_desc_id,sign_and_payment,audit_status,use_status,create_time,create_user_id,create_role_code,create_depart_id,formal_use,purchase_method,create_depart_name";
		String comments = "主键,采购方案编号,采购方案名称,采购总预算(元),采购方式描述,分包方案,包组主要资格条件描述,评审方式描述,中标及成交原则,评审委员会组成,采购代理,采购代理ID,签约及付款,审核状态（00暂存 03待审核）,使用状态（00暂存 01提交）,创建时间,创建人,角色,机构,是否正式使用 00 未正式使用，01正式使用（提交或保存为正式使用）,没有注释,创建方案的机构名称";
		String datatypes = "varchar,varchar,text,decimal,longtext,varchar,varchar,varchar,varchar,varchar,varchar,varchar,varchar,varchar,varchar,datetime,varchar,varchar,varchar,varchar,text,varchar";
		Field field = new Field()
		.setColumns(columns)
		.setComments(comments)
		.setDatatypes(datatypes);
		new LiberateHand()
		.setModel("purchase")
		.setEntity("TBPrePurchaseApply")
		.setTable("t_b_pre_purchase_apply")
		.setPackagePath("com.gxcx.")
		.setField(field)
		.build();
	}

}
