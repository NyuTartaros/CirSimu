package cirsimu.entity;

import java.util.HashMap;

import cirsimu.ui.DrawArea;

public class CirComponent {
	
	private String type;
	private Point compLoc;
	private Point compSize;
//	private int x;
//	private int y;
	private Point[] interfaceLocs;
	private int interfaceNum;
	private int rotateCount = 0;
	private HashMap<Integer,Integer> neighCompTable
			= new HashMap<Integer, Integer>();	//邻接组件表
	private HashMap<Integer,Integer> neighInterTable
			= new HashMap<Integer, Integer>();	//邻接接口表
	private HashMap<Integer, Boolean> pointFlagTable
			= new HashMap<Integer, Boolean>();
	
	//元件尺寸
	private static final Point defaultSize = new Point(120, 30);
	private static final Point amplifierSize = new Point(120, 50);
	private static final Point groundConnSize = new Point(50, 50);
	
	//元件接口位置
	private static final Point[] defaultInterloc = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] amplifierInterLoc = 
		{new Point(0, 14), new Point(0, 35), new Point(119, 24)};
	private static final Point[] groundConnInterLoc = 
		{new Point(25, 0)};
	private static final Point[] defaultInterloc_1 = 
		{new Point(15, 0), new Point(15, 119)};
	private static final Point[] amplifierInterLoc_1 = 
		{new Point(14, 0), new Point(35, 0), new Point(24, 119)};
	private static final Point[] groundConnInterLoc_1 = 
		{new Point(50, 25)};
	private static final Point[] defaultInterloc_2 = 
		{new Point(0, 15), new Point(119, 15)};
	private static final Point[] amplifierInterLoc_2 = 
		{new Point(119, 49-14), new Point(119, 49-35), new Point(0, 24)};
	private static final Point[] groundConnInterLoc_2 = 
		{new Point(25, 50)};
	private static final Point[] defaultInterloc_3 = 
		{new Point(15, 0), new Point(15, 119)};
	private static final Point[] amplifierInterLoc_3 = 
		{new Point(49-14, 119), new Point(49-35, 119), new Point(24, 0)};
	private static final Point[] groundConnInterLoc_3 = 
		{new Point(0, 25)};
	
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
		case amplifier:
			interfaceLocs = amplifierInterLoc;
			compSize = amplifierSize;
			break;
		case groundConn:
			interfaceLocs = groundConnInterLoc;
			compSize = groundConnSize;
			break;
		default:
			interfaceLocs = defaultInterloc;
			compSize = defaultSize;
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
	
	public boolean getPointFlag(int inter) {
		return pointFlagTable.get(inter);
	}
	
	public void setlink(int localInterface, int remoteComp, int remoteInterface){
		neighCompTable.put(localInterface, remoteComp);
		neighInterTable.put(localInterface, remoteInterface);
		pointFlagTable.put(localInterface, false);
	}
	
	public void reverseLink(int localInterface) {
		boolean nowFlag = pointFlagTable.get(localInterface);
		pointFlagTable.put(localInterface, !nowFlag);
	}
	
	/**
	 * 判断点击发生在哪个接口
	 * @param x: x Point
	 * @param y: y Point
	 * @return >0为点击到的接口编号，-1为点击到元件，但未点击到接口，<-1为未点击到元件
	 */
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
		if(x>=compLoc.getX() && y>=compLoc.getY() 
				&& x-compLoc.getX()<=compSize.getX() 
				&& y-compLoc.getY()<=compSize.getY()) {
			return -1;
		}
		return -2;
	}
	
	public int getRotateCount() {
		return rotateCount;
	}
	
	//旋转元件
	//TODO 需要component的size来计算旋转后的interLoc
	public void rotate(){
		rotateCount++;
		rotateCount = rotateCount%4;
		//DEBUG
//		System.out.println("At CirComponent.rotate(): rotateCount=" + rotateCount);
		compSize = new Point(compSize.getY(), compSize.getX());
		switch(rotateCount) {
		case 0:
			switch (type) {
			case amplifier:
				interfaceLocs = amplifierInterLoc;
				break;
			case groundConn:
				interfaceLocs = groundConnInterLoc;
				break;
			default:
				interfaceLocs = defaultInterloc;
				break;
			}
			break;
		case 1:
			switch (type) {
			case amplifier:
				interfaceLocs = amplifierInterLoc_1;
				break;
			case groundConn:
				interfaceLocs = groundConnInterLoc_1;
				break;
			default:
				interfaceLocs = defaultInterloc_1;
				break;
			}
			break;
		case 2:
			switch (type) {
			case amplifier:
				interfaceLocs = amplifierInterLoc_2;
				break;
			case groundConn:
				interfaceLocs = groundConnInterLoc_2;
				break;
			default:
				interfaceLocs = defaultInterloc_2;
				break;
			}
			break;
		case 3:
			switch (type) {
			case amplifier:
				interfaceLocs = amplifierInterLoc_3;
				break;
			case groundConn:
				interfaceLocs = groundConnInterLoc_3;
				break;
			default:
				interfaceLocs = defaultInterloc_3;
				break;
			}
			break;
		}
		
	}

}
