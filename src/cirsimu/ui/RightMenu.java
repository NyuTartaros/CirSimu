package cirsimu.ui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import cirsimu.entity.CirComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RightMenu extends JPopupMenu{

	private JMenuItem mDrag;
	private JMenuItem mCopy;
//	private JMenuItem mPaste;
	private JMenuItem mRotate;
	private JMenuItem mArrti;
	
	private DrawArea drawArea;
	private CirComponent parentComp;
	
	public RightMenu(DrawArea drawArea, CirComponent parentComp) {
		//DEBUG
//		System.out.println("At RightMenu.init<>");
		this.drawArea = drawArea;
		this.parentComp = parentComp;
		drawArea.isDrawArea();
		mDrag = new JMenuItem("ÍÏ¶¯");
		mDrag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.deleteComp(parentComp);
				drawArea.startEditing(parentComp.getType());
			}
		});
		mDrag.setIcon(null);
		mCopy = new JMenuItem("¸´ÖÆ");
		mCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawArea.startEditing(parentComp.getType());
			}
		});
		mCopy.setIcon(null);
//		mPaste = new JMenuItem("Õ³Ìù");
//		mPaste.setIcon(null);
		mRotate = new JMenuItem("É¾³ý");
		mRotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawArea.deleteComp(parentComp);
			}
		});
		mRotate.setIcon(null);
		mArrti = new JMenuItem("ÊôÐÔ");
		mArrti.setIcon(null);
		
		add(mDrag);
		add(mCopy);
//		add(mPaste);
		add(mRotate);
		add(mArrti);
	}
	
}
