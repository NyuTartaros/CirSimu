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
	 * ����·ͼ���ݽṹת��ΪCir��ʽ������
	 * @param file �ļ�����
	 * @param componentList ��·ͼ���ݽṹ
	 * @return д��ɹ�����true, ���ɹ�false
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

}
