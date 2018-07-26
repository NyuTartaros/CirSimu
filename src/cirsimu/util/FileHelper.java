package cirsimu.util;

import java.io.File;
import java.io.FileReader;
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
			HashMap<Integer,ArrayList<Integer>> neighCompTable = component.getNeighCompTable();
			HashMap<Integer,ArrayList<Integer>> neighInterTable = component.getNeighInterTable();
			for(int j=0; j<component.getInterfaceNum(); j++){
				for(int k=0; k<neighCompTable.get(j).size(); k++){
					writer.write(j+" "+neighCompTable.get(j).get(k)+" "+neighInterTable.get(j).get(k)+" \n");
				}
			}
			writer.write("\n");
			writer.flush();
		}
		writer.close();
		return false;
	}
	
	/**
	 * 将电路图数据结构转换为Cir格式并保存
	 * @param file 文件对象
	 * @param componentList 电路图数据结构
	 * @return 写入成功返回true, 不成功false
	 * @throws IOException 
	 */
	public static boolean saveComponentListToCir(File file
			, CirComponentList componentList) throws IOException{
		FileWriter writer = new FileWriter(file, false);
		componentList.reformNeighTable2LabelTable();
		ArrayList<CirComponent> components = componentList.getArrayList();
		for(int i=0; i<components.size(); i++){
			CirComponent component = components.get(i);
			writer.write(component.getType()+i+" ");
			for(int j=0; j<component.getInterfaceNum(); j++){
				writer.write(component.getInterLabel(j)+' ');
			}
			writer.write(String.valueOf(component.getProperty()));
			writer.write("\n");
			writer.flush();
		}
		writer.close();
		return true;
	}
	
	public static String readPspicePath() {
		try {
			FileReader reader = new FileReader(new File("pspice.dat"));
			char[] buffer = new char[100];
			reader.read(buffer);
			return new String(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean savePspicePath(String pspicePath) {
		try {
			FileWriter writer = new FileWriter(new File("pspice.dat"), false);
			writer.write(pspicePath);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
