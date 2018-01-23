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
	
	public CirComponent get(int index) {
		return cirComponents.get(index);
	}
	
	public int size() {
		return cirComponents.size();
	}
	
	public void setlink(Integer comp1, Integer interface1
			, Integer comp2, Integer interface2){
		CirComponent cirComponent1 = cirComponents.get(comp1);
		CirComponent cirComponent2 = cirComponents.get(comp2);
		cirComponent1.setlink(interface1, comp2, interface2);
		cirComponent2.setlink(interface2, comp1, interface1);
	}
	
	public void reverseLink(Integer comp1, Integer interface1) {
		CirComponent cirComponent1 = cirComponents.get(comp1);
		Integer comp2 = cirComponent1.getNeighCompTable().get(interface1);
		Integer interface2 = cirComponent1.getNeighInterTable().get(interface1);
		CirComponent cirComponent2 = cirComponents.get(comp2);
		cirComponent1.reverseLink(interface1);
		cirComponent2.reverseLink(interface2);
	}
	
	public ArrayList<CirComponent> getArrayList(){
		return cirComponents;
	}
	
	//判断点击发生在哪个组件和接口
	public int[] pointInComp(int x, int y){
		int[] result = new int[2];
		for(int i=0; i<cirComponents.size(); i++){
			//DEBUG
//			System.out.println("compNo."+i);
			int inter = cirComponents.get(i).pointInInterface(x, y);
			if( inter > -1){
				result[0] = i;
				result[1] = inter;
				return result;
			}else if (inter == -1) {
				result[0] = i;
				result[1] = -1;
				return result;
			}
		}
		return null;
	}

}
