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
	private JMenuItem mDelete;
	private JMenuItem mAttri;
	
	private DrawArea drawArea;
	private CirComponent parentComp;
	private JMenuItem mPaste;
	private JMenuItem mRotate;
	
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
		mDelete = new JMenuItem("É¾³ý");
		mDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawArea.deleteComp(parentComp);
			}
		});
		mDelete.setIcon(null);
		mAttri = new JMenuItem("ÊôÐÔ");
		mAttri.setIcon(null);
		
		add(mDrag);
		add(mCopy);
		
		mPaste = new JMenuItem("\u7C98\u8D34");
		add(mPaste);
//		add(mPaste);
		add(mDelete);
		
		mRotate = new JMenuItem("\u65CB\u8F6C");
		add(mRotate);
		add(mAttri);
	}
	
}
