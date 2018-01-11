package cirsimu.entity;

import java.util.ArrayList;
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
	
	public void setlink(int localInterface, int remoteComp, int remoteInterface){
		neighCompTable.put(localInterface, remoteComp);
		neighInterTable.put(localInterface, remoteInterface);
	}

}
