package cirsimu.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class CirComponent {
	
	private String type;
	private int x;
	private int y;
	private Point[] interfaceLocs;
	private int interfaceNum;
	private HashMap<Integer,Integer> neighCompTable
		= new HashMap<Integer,Integer>();	//邻接组件表
	private HashMap<Integer,Integer> neighInterTable
		= new HashMap<Integer,Integer>();	//邻接接口表
	
	//TODO 下面的数据需要校正
	private static final Point[] ampereMeterInterLoc = 
		{new Point(0, 15), new Point(29, 15)};
	private static final Point[] voltmeterInterLoc = 
		{new Point(0, 15), new Point(29, 15)};
	private static final Point[] amplifierMeterInterLoc = 
		{new Point(0, 10), new Point(0, 20), new Point(29, 15)};
	private static final Point[] capicititanceInterLoc = 
		{new Point(0, 15), new Point(29, 15)};
	private static final Point[] currentSourceInterLoc = 
		{new Point(0, 15), new Point(29, 15)};
	private static final Point[] diodeInterLoc = 
		{new Point(0, 15), new Point(29, 15)};
	private static final Point[] inductanceInterLoc = 
		{new Point(0, 15), new Point(29, 15)};
	private static final Point[] resistanceInterLoc = 
		{new Point(0, 15), new Point(29, 15)};
	private static final Point[] switchMeterInterLoc = 
		{new Point(0, 15), new Point(29, 15)};
	private static final Point[] voltageSourceInterLoc = 
		{new Point(0, 15), new Point(29, 15)};
	
	//元件名
	public static final String voltmeter = "voltmeter";
	public static final String amperemeter = "amperemeter";
	public static final String resistance = "resistance";
	public static final String capicititance = "capicititance";
	public static final String diode = "diode";
	public static final String amplifier = "amplifier";
	
	
	public CirComponent(String type, int x, int y){
		this.type = type;
		this.x = x;
		this.y = y;
		if(type.equals("amplifier")){
			this.interfaceNum = 3;
		}else{
			this.interfaceNum = 2;
		}
		switch(type){
		case "amperemeter":
			interfaceLocs=ampereMeterInterLoc;
			break;
		case "voltmeter":
			interfaceLocs=voltmeterInterLoc;
			break;
		case "resistance":
			interfaceLocs=resistanceInterLoc;
			break;
		case "capicititance":
			interfaceLocs=capicititanceInterLoc;
			break;
		case "diode":
			interfaceLocs=diodeInterLoc;
			break;
		case "amplifier":
			interfaceLocs=amplifierMeterInterLoc;
			break;
		case "voltageSource":
			interfaceLocs=voltageSourceInterLoc;
			break;
		case "currentSource":
			interfaceLocs=currentSourceInterLoc;
			break;
		case "":	//TODO 接地
			break;
		case "switch":
			interfaceLocs=switchMeterInterLoc;
			break;
		case "inductance":
			interfaceLocs=inductanceInterLoc;
			break;
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

class Point{
	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
