package cirsimu.entity;

import java.util.ArrayList;
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
	private String compName;
	private HashMap<Integer, ArrayList<Integer>> neighCompTable
			= new HashMap<Integer, ArrayList<Integer>>();	//邻接组件表
	private HashMap<Integer, ArrayList<Integer>> neighInterTable
			= new HashMap<Integer, ArrayList<Integer>>();	//邻接接口表
	private HashMap<Integer, Boolean> pointFlagTable
			= new HashMap<Integer, Boolean>();
	private HashMap<Integer, String> interLabelTable
			= new HashMap<Integer, String>();	//标志接口在cir文件中的标号
	private int attributeNum;
	private ArrayList<String> attributeList;
	private Double property = -1.0;
	
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
	
	//元件属性数量
	public static final int voltmeterAttriNum = 0;
	public static final int amperrmeterAttriNum = 0;
	public static final int resistenceAttriNum = 1;
	public static final int capicititanceAttriNum = 1;
	public static final int diodeAttriNum = 0;
	public static final int amplifierAttriNum = 0;
	public static final int currentSourceAttriNum = 2;
	public static final int groundConnAttriNum = 0;
	public static final int inductanceAttriNum = 0;
	public static final int switchCompAttriNum = 0;
	public static final int voltageSourceAttriNum = 2;
	
	//元件属性名
	public static final String[] voltmeterAttriName = {};
	public static final String[] amperrmeterAttriName = {};
	public static final String[] resistenceAttriName = {"电阻值"};
	public static final String[] capicititanceAttriName = {"电容容量"};
	public static final String[] diodeAttriName = {};
	public static final String[] amplifierAttriName = {};
	public static final String[] currentSourceAttriName = {"电流源类型", "电流源大小"};
	public static final String[] groundConnAttriName = {};
	public static final String[] inductanceAttriName = {};
	public static final String[] switchCompAttriName = {};
	public static final String[] voltageSourceAttriName = {"电压源类型", "电压源大小"};
	
	
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
	
	public void setNeighCompTable(HashMap<Integer,ArrayList<Integer>> neighCompTable){
		this.neighCompTable = neighCompTable;
	}
	
	public HashMap<Integer,ArrayList<Integer>> getNeighCompTable(){
		return neighCompTable;
	}
	
	public void setNeighInterTable(HashMap<Integer,ArrayList<Integer>> neighInterTable){
		this.neighInterTable = neighInterTable;
	}
	
	public HashMap<Integer,ArrayList<Integer>> getNeighInterTable(){
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
	
	public void setInterLabel(Integer localInterface, String label){
		interLabelTable.put(localInterface, label);
	}
	
	public String getInterLabel(Integer localInterface){
		return interLabelTable.get(localInterface);
	}
	
	public void setInterLabelTable(){
		this.interLabelTable = new HashMap<Integer, String>();
	}
	
	public void setInterLabelTable(HashMap<Integer, String> interLabelTable){
		this.interLabelTable = interLabelTable;
	}
	
	public HashMap<Integer, String> getInterLabelTable(){
		return interLabelTable;
	}
	
	public int getAttributeNum() {
		switch(this.type){
		case voltmeter:
			return voltmeterAttriNum;
		case amperemeter:
			return amperrmeterAttriNum;
		case resistance:
			return resistenceAttriNum;
		case capicititance:
			return capicititanceAttriNum;
		case diode:
			return diodeAttriNum;
		case amplifier:
			return amplifierAttriNum;
		case currentSource:
			return currentSourceAttriNum;
		case groundConn:
			return groundConnAttriNum;
		case inductance:
			return inductanceAttriNum;
		case switchComp:
			return switchCompAttriNum;
		case voltageSource:
			return voltageSourceAttriNum;
		default:
			return 0;
		}
	}
	
	public void setAttributeList(ArrayList<String> attributeList){
		this.attributeList = attributeList;
	}
	
	public String getAttributeList(){
		String list = "";
		if(attributeList == null || attributeList.size()==0){
			return "";
		}
		for(int i=0; i<attributeList.size()-1; i++){
			list += attributeList.get(i) + " ";
		}
		list += attributeList.get(attributeList.size()-1);
		return list;
	}
	
	public ArrayList<String> getAttriArraylist(){
		return this.attributeList;
	}
	
	public void setProperty(Double property){
		this.property = property;
	}
	
	public Double getProperty(){
		return property;
	}
	
	public void setCompName(String compName){
		this.compName = compName;
	}
	
	public String getCompName(){
		return this.compName;
	}
	
	public String getAttriLogNameLabelText(){
		switch(this.type){
		case CirComponent.voltmeter:
			return "电压表名称";
		case CirComponent.amperemeter:
			return "电流表名称";
		case CirComponent.resistance:
			return "电阻名称";
		case CirComponent.capicititance:
			return "电容名称";
		case CirComponent.diode:
			return "二极管名称";
		case CirComponent.amplifier:
			return "放大器名称";
		case CirComponent.currentSource:
			return "电流源名称";
		case CirComponent.groundConn:
			return "接地名称";
		case CirComponent.inductance:
			return "电感名称";
		case CirComponent.switchComp:
			return "开关名称";
		case CirComponent.voltageSource:
			return "电压源名称";
		default:
			return null;
		}
	}
	
	public String[] getAttriName(){
		switch(this.type){
		case CirComponent.voltmeter:
			return CirComponent.voltmeterAttriName;
		case CirComponent.amperemeter:
			return CirComponent.amperrmeterAttriName;
		case CirComponent.resistance:
			return CirComponent.resistenceAttriName;
		case CirComponent.capicititance:
			return CirComponent.capicititanceAttriName;
		case CirComponent.diode:
			return CirComponent.diodeAttriName;
		case CirComponent.amplifier:
			return CirComponent.amperrmeterAttriName;
		case CirComponent.currentSource:
			return CirComponent.currentSourceAttriName;
		case CirComponent.groundConn:
			return CirComponent.groundConnAttriName;
		case CirComponent.inductance:
			return CirComponent.inductanceAttriName;
		case CirComponent.switchComp:
			return CirComponent.switchCompAttriName;
		case CirComponent.voltageSource:
			return CirComponent.voltageSourceAttriName;
		default:
			return null;
		}
	}
	
	public void setlink(int localInterface, int remoteComp, int remoteInterface){
		if (neighCompTable.get(localInterface) == null) {
			neighCompTable.put(localInterface, new ArrayList<Integer>());
		}
		neighCompTable.get(localInterface).add(remoteComp);
		if (neighInterTable.get(localInterface) == null) {
			neighInterTable.put(localInterface, new ArrayList<Integer>());
		}
		neighInterTable.get(localInterface).add(remoteInterface);
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
