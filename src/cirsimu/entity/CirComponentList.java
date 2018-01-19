package cirsimu.entity;

import java.util.ArrayList;

public class CirComponentList {
	
	private ArrayList<CirComponent> cirComponents
		= new ArrayList<CirComponent>();
	
	public CirComponentList(){
		
	}
	
	public void add(CirComponent cirComponent){
		cirComponents.add(cirComponent);
	}
	
	public void setlink(Integer comp1, Integer interface1
			, Integer comp2, Integer interface2){
		CirComponent cirComponent1 = cirComponents.get(comp1);
		CirComponent cirComponent2 = cirComponents.get(comp2);
		cirComponent1.setlink(interface1, comp2, interface2);
		cirComponent2.setlink(interface2, comp1, interface1);
	}
	
	public ArrayList<CirComponent> getArrayList(){
		return cirComponents;
	}
	
	//�жϵ���������ĸ�����ͽӿ�
	public int[] pointInComp(int x, int y){
		int[] result = new int[2];
		for(int i=0; i<cirComponents.size(); i++){
			int inter = cirComponents.get(i).pointInInterface(x, y);
			if( inter > 0){
				result[0] = i;
				result[1] = inter;
				return result;
			}
		}
		return null;
	}

}
