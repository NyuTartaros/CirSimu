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
		Integer comp2 = cirComponent1.getNeighCompTable().get(interface1).get(0);
		Integer interface2 = cirComponent1.getNeighInterTable().get(interface1).get(0);
		CirComponent cirComponent2 = cirComponents.get(comp2);
		cirComponent1.reverseLink(interface1);
		cirComponent2.reverseLink(interface2);
	}
	
	public ArrayList<CirComponent> getArrayList(){
		return cirComponents;
	}
	
	public int indexOf(CirComponent component){
		return cirComponents.indexOf(component);
	}
	
	public void remove(int index){
		cirComponents.remove(index);
	}
	
	public void remove(CirComponent component){
		cirComponents.remove(component);
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
	
	//将组件邻接表重整为cir文件使用的标签表，等价的接口用同一个label表示
	public void reformNeighTable2LabelTable(){
		//init interLabelTable
		for(int i=0; i<cirComponents.size(); i++){
			cirComponents.get(i).setInterLabelTable();
		}
		char labeliter = 'a';
		for(int i=0; i<cirComponents.size(); i++){
			CirComponent component = cirComponents.get(i);
			for(int j=0; j<component.getInterfaceNum(); j++){
				if (component.getInterLabel(j) != null) {
					String label = component.getInterLabel(j);
					for(int k=0; k<component.getNeighCompTable().get(j).size(); k++){
						int comp = component.getNeighCompTable().get(j).get(k);
						int inter = component.getNeighInterTable().get(j).get(k);
						cirComponents.get(comp).setInterLabel(inter, label);
					}
				}else{
					for(int k=0; k<component.getNeighCompTable().get(j).size(); k++){
						int comp = component.getNeighCompTable().get(j).get(k);
						int inter = component.getNeighInterTable().get(j).get(k);
						if (cirComponents.get(comp).getInterLabel(inter) != null) {
							String label = cirComponents.get(comp).getInterLabel(inter);
							component.setInterLabel(j, label);
							break;
						}
					}
				}
				//如果label依然为null，说明自身和邻接inter都为null，则赋一个新的label
				if(component.getInterLabel(j) == null){
					component.setInterLabel(j, String.valueOf(labeliter));
					labeliter++;
				}
			}
		}
		//如果有接地，label重置为0
		String groundlabel = null;
		for(int i=0; i<cirComponents.size(); i++){
			CirComponent component = cirComponents.get(i);
			if (component.getType() != CirComponent.groundConn) {
				continue;
			}
			groundlabel = component.getInterLabel(0);
		}
		//没有接地就直接返回
		if (groundlabel == null) {
			return;
		}
		//有接地则开始重置
		for(int i=0; i<cirComponents.size(); i++){
			CirComponent component = cirComponents.get(i);
			for(int j=0; j<component.getInterfaceNum(); j++){
				if (component.getInterLabel(j).equals(groundlabel)) {
					component.setInterLabel(j, "0");
				}
			}
		}
	}

}
