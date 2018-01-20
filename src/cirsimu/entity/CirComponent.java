package cirsimu.entity;

import java.util.HashMap;

import cirsimu.ui.DrawArea;

public class CirComponent {
	
	private String type;
	private Point compLoc;
//	private int x;
//	private int y;
	private Point[] interfaceLocs;
	private int interfaceNum;
	private HashMap<Integer,Integer> neighCompTable
		= new HashMap<Integer,Integer>();	//邻接组件表
	private HashMap<Integer,Integer> neighInterTable
		= new HashMap<Integer,Integer>();	//邻接接口表
	
	//TODO 下面的数据需要校正
	private static final Point[] ampereMeterInterLoc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] voltmeterInterLoc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] amplifierInterLoc = 
		{new Point(0, 14), new Point(0, 35), new Point(119, 24)};
	private static final Point[] capicititanceInterLoc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] currentSourceInterLoc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] diodeInterLoc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] inductanceInterLoc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] resistanceInterLoc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] switchMeterInterLoc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] voltageSourceInterLoc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] groundConnInterLoc = 
		{new Point(25, 0)};
	
	//元件名
	public static final String voltmeter = "voltmeter";
	public static final String amperemeter = "amperemeter";
	public static final String resistance = "resistance";
	public static final String capicititance = "capicititance";
	public static final String diode = "diode";
	public static final String amplifier = "amplifier";
	public static final String currentSource = "currentSource";
	public static final String groundConn = "groundConn";
	public static final String inductance = "inductance";
	public static final String switchComp = "switch";
	public static final String voltageSource = "voltageSource";
	
	
	public CirComponent(String type, int x, int y){
		//DEBUG
//		System.out.println("CirComponent(): type="+type+", "
//				+"x=" + x + ", " + "y=" + y);
		this.type = type;
		compLoc = new Point(x, y);
		if(type.equals(amplifier)){
			this.interfaceNum = 3;
		}else if (type.equals(groundConn)) {
			this.interfaceNum = 1;
		}else{
			this.interfaceNum = 2;
		}
		switch(type){
		case amperemeter:
			interfaceLocs=ampereMeterInterLoc;
			break;
		case voltmeter:
			interfaceLocs=voltmeterInterLoc;
			break;
		case resistance:
			interfaceLocs=resistanceInterLoc;
			break;
		case capicititance:
			interfaceLocs=capicititanceInterLoc;
			break;
		case diode:
			interfaceLocs=diodeInterLoc;
			break;
		case amplifier:
			interfaceLocs=amplifierInterLoc;
			break;
		case voltageSource:
			interfaceLocs=voltageSourceInterLoc;
			break;
		case  currentSource:
			interfaceLocs=currentSourceInterLoc;
			break;
		case groundConn:
			interfaceLocs=groundConnInterLoc;
			break;
		case switchComp:
			interfaceLocs=switchMeterInterLoc;
			break;
		case inductance:
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
		compLoc.setX(x);
	}
	
	public int getx(){
		return compLoc.getX();
	}
	
	public void sety(int y){
		compLoc.setY(y);
	}
	
	public int gety(){
		return compLoc.getY();
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
	
	public Point[] getInterfaceLocs(){
		Point[] interLocs = new Point[interfaceNum];
		for(int i=0; i<interfaceNum; i++){
			interLocs[i] = new Point(compLoc.getX()+interfaceLocs[i].getX()
					, compLoc.getY()+interfaceLocs[i].getY());
		}
		return interLocs;
	}
	
	public Point getInterfaceLoc(int inter){
		Point interLoc = new Point(compLoc.getX()+interfaceLocs[inter].getX()
				, compLoc.getY()+interfaceLocs[inter].getY());
		return interLoc;
	}
	
	public void setlink(int localInterface, int remoteComp, int remoteInterface){
		neighCompTable.put(localInterface, remoteComp);
		neighInterTable.put(localInterface, remoteInterface);
	}
	
	//判断点击发生在哪个接口
	public int pointInInterface(int x, int y) {
		int delta = DrawArea.delta;	//点击误差限
		Point interTmp;
		for(int i=0; i<interfaceNum; i++) {
			interTmp = new Point(compLoc.getX()+interfaceLocs[i].getX()
					, compLoc.getY()+interfaceLocs[i].getY());
			//DEBUG
//			System.out.println("interfaceNo."+i);
//			System.out.println("Math.abs(interTmp.getX() - x)="
//					+ Math.abs(interTmp.getX() - x));
//			System.out.println("Math.abs(interTmp.getY() - y)="
//					+ Math.abs(interTmp.getY() - y));
			if(Math.abs(interTmp.getX() - x) <= delta 
					&& Math.abs(interTmp.getY() - y) <= delta) {
				return i;
			}
		}
		return -1;
	}

}
