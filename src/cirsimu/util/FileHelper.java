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
				writer.write(j+" "+neighCompTable.get(j)+" "+neighInterTable.get(j)+" ");
			}
			writer.write("\n");
			writer.flush();
		}
		writer.close();
		return false;
	}
	
	public static String convertToCir(CirComponentList componentList){
		
		
		return null;
	}

}
