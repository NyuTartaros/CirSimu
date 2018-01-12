package cirsimu.entity;

import java.util.HashMap;

public class CirComponent {
	
	private String type;
	private int x;
	private int y;
	private int interfaceNum;
	private HashMap<Integer,Integer> neighCompTable
		= new HashMap<Integer,Integer>();	//邻接组件表
	private HashMap<Integer,Integer> neighInterTable
		= new HashMap<Integer,Integer>();	//邻接接口表
	
	public CirComponent(String type, int x, int y){
		this.type = type;
		this.x = x;
		this.y = y;
		if(type.equals("amplifier")){
			this.interfaceNum = 3;
		}else{
			this.interfaceNum = 2;
		}
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public void setx(int x){
		this.x = x;
	}
	
	public int getx(){
		return x;
	}
	
	public void sety(int y){
		this.y = y;
	}
	
	public int gety(){
		return y;
	}
	
	public void setInterfaceNum(int interfaceNum){
		this.interfaceNum = interfaceNum;
	}
	
	public int getInterfaceNum(){
		return interfaceNum;
	}
	
	public void setNeighCompTable(HashMap<Integer,Integer> neighCompTable){
		this.neighCompTable = neighCompTable;
	}
	
	public HashMap<Integer,Integer> getNeighCompTable(){
		return neighCompTable;
	}
	
	public void setNeighInterTable(HashMap<Integer,Integer> neighInterTable){
		this.neighInterTable = neighInterTable;
	}
	
	public HashMap<Integer,Integer> getNeighInterTable(){
		return neighInterTable;
	}
	
	public void setlink(int localInterface, int remoteComp, int remoteInterface){
		neighCompTable.put(localInterface, remoteComp);
		neighInterTable.put(localInterface, remoteInterface);
	}

}
