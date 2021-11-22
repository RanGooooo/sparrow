package com.xin.sparrow.control.code.service.sdk;

import com.xin.sparrow.control.code.service.sdk.constant.DataTypeEnum;

public class Field {
	
	private StringBuilder result = new StringBuilder();
	
	public final static String LN = "\n";
	
	private String columns;
	
	private String comments;
	
	private String datatypes;

	public Field setColumns(String columns) {
		this.columns = columns;
		return this;
	}

	public Field setComments(String comments) {
		this.comments = comments;
		return this;
	}
	
	public Field setDatatypes(String datatypes) {
		this.datatypes = datatypes;
		return this;
	}

	public StringBuilder append(String obj) {
		 return result.append(obj + LN);
	}

	public String getDataType(String datatype) {
		DataTypeEnum enumByKey = DataTypeEnum.getEnumByKey(datatype);
		if(enumByKey != null) {
			return enumByKey.getValue();
		}
		return "String"; 
	}

	public void assemble() throws Exception {
		String[] columnArr = columns.split(",");
		String[] commentArr = comments.split(",");
		String[] datatypeArr = datatypes.split(",");
		if(columnArr.length != commentArr.length){
		    throw new Exception("请检查表字段注释");
        }
		int k = 0;
		for (String column : columnArr) {
			String dataType = getDataType(datatypeArr[k]);
			field(column, commentArr[k], dataType);
			k++;
		}
		k = 0;
		for (String column : columnArr) {
			String dataType = getDataType(datatypeArr[k]);
			setGet(column, dataType);
			k++;
		}
	}
	public void field(String column,String comment,String datatype) {
		String[] split = column.split("_");
		String t = "";
		int i = 0;
		for (String string : split) {
			if(i != 0){
				t += string.substring(0, 1).toUpperCase() + string.substring(1);
			}else{
				t += string;
			}
			i++;
		}
		this.append("/**" + comment + "*/");
		this.append("private "+datatype+" " + t + ";");
	}
	
	public void setGet(String column,String datatype) {
		String[] split = column.split("_");
		String t = "";
		String T = "";
		int i = 0;
		for (String string : split) {
			T += string.substring(0, 1).toUpperCase() + string.substring(1);
			if(i != 0){
				t += string.substring(0, 1).toUpperCase() + string.substring(1);
			}else{
				t +=string;
			}
			i++;
		}
		if("id".equals(column)) {
			this.append("@Id");
			this.append("@GeneratedValue(generator = \"paymentableGenerator\")");
			this.append("@GenericGenerator(name = \"paymentableGenerator\", strategy = \"uuid\")");
			this.append("@Column(name =\"ID\",nullable=false,length=36)");
		}else {
			this.append("@Column(name =\""+column+"\")");
		}
		this.append("public "+datatype+" get"+T +"() {");
		this.append("return "+t+";");
		this.append("}");

		this.append("public void set"+T +"("+datatype+" "+t+") {");
		this.append("this."+t+" = "+t+";");
		this.append("}");
	}
	
	public String build() throws Exception {
		this.assemble();
		return LN + result.toString();
    }
	
	
	public static void StrSQL(String str) {
		String[] split = str.split(",");
		for (String string : split) {
			String[] split2 = string.split("_");
			String t = "";
			int i = 0;
			for (String string2 : split2) {
				if(i != 0){
					t += string2.substring(0, 1).toUpperCase() + string2.substring(1);
				}else{
					t +=string2;
				}
				i++;
			}
			System.out.println("b." + string + " AS " + t + ",");
		}
	}
	
	

	public static void main(String[] args) throws Exception {
		String columns = "id,purchase_apply_no,purchase_apply_name,total_budget,tender_mode_desc,sub_package_desc,main_qualification,evaluation_mode_desc,confirm_rule,evaluate_committee,agency_desc,agency_desc_id,sign_and_payment,audit_status,use_status,create_time,create_user_id,create_role_code,create_depart_id,formal_use,purchase_method,create_depart_name";
		String comments = "主键,采购方案编号,采购方案名称,采购总预算(元),采购方式描述,分包方案,包组主要资格条件描述,评审方式描述,中标及成交原则,评审委员会组成,采购代理,采购代理ID,签约及付款,审核状态（00暂存 03待审核）,使用状态（00暂存 01提交）,创建时间,创建人,角色,机构,是否正式使用 00 未正式使用，01正式使用（提交或保存为正式使用）,没有注释,创建方案的机构名称";
		String datatypes = "varchar,varchar,text,decimal,longtext,varchar,varchar,varchar,varchar,varchar,varchar,varchar,varchar,varchar,varchar,datetime,varchar,varchar,varchar,varchar,text,varchar";
//		Main.StrSQL(a);
		String build = new Field()
		.setColumns(columns)
		.setComments(comments)
		.setDatatypes(datatypes)
		.build();
		System.out.println(build);
	}
	
}
