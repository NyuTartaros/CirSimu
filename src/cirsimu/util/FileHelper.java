package cirsimu.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import cirsimu.entity.CirComponent;
import cirsimu.entity.CirComponentList;

public class FileHelper {
	
	public static boolean saveComponentListToCsv(File file
			, CirComponentList componentList) throws IOException{
		FileWriter writer = new FileWriter(file, false);
		ArrayList<CirComponent> components = componentList.getArrayList();
		for(int i=0; i<components.size(); i++){
			CirComponent component = components.get(i);
			writer.write("<component>\n");
			writer.write(component.getType()+"\n");
			writer.write(component.getx()+"\n");
			writer.write(component.gety()+"\n");
			HashMap<Integer,Integer> neighCompTable = component.getNeighCompTable();
			HashMap<Integer,Integer> neighInterTable = component.getNeighInterTable();
			for(int j=0; j<component.getInterfaceNum(); j++){
				writer.write(j+" "+neighCompTable.get(j)+" "+neighInterTable.get(j)+" \n");
			}
			writer.write("\n");
			writer.flush();
		}
		writer.close();
		return false;
	}
	
	/**
	 * 将电路图数据结构转换为Cir格式并保存
	 * @param componentList 电路图数据结构
	 * @param filename 保存文件名
	 * @param savepath 保存路径
	 * @return Cir文件内容
	 */
	public static void convertToCir(CirComponentList componentList
			, String filename, File savepath){
		if(filename == null){	//如果文件名为空，则使用默认文件名new.cir
			filename="new.cir";
		}
		//将电路图的数据结构转换为HashMap
		HashMap<String, Object> result = new HashMap<String, Object>();
		for(int i=0; i<componentList.size(); i++){
			CirComponent comp = componentList.get(i);
			result.put("component", comp.getType());
			result.put("No", i);
			HashMap<Integer,Integer> neighCompTable = comp.getNeighCompTable();
			HashMap<Integer,Integer> neighInterTable = comp.getNeighInterTable();
			for(int j=0; j<comp.getInterfaceNum(); j++){
				result.put("connect", j);
				result.put("connect", neighCompTable.get(j));
				result.put("connect", neighInterTable.get(j));
			}
		}
		//使用freemaker框架结合预存的cir模板生成cir文件
		DocUtil docUtil = new DocUtil();
		docUtil.createDoc(result, filename, savepath);
	}

}
