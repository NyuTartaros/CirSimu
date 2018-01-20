package cirsimu.ui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class RightMenu extends JPopupMenu{

	private JMenuItem mCut;
	private JMenuItem mCopy;
	private JMenuItem mPaste;
	private JMenuItem mRotate;
	private JMenuItem mArrti;
	
	public RightMenu() {
		mCut = new JMenuItem("����");
		mCut.setIcon(null);
		mCopy = new JMenuItem("����");
		mCopy.setIcon(null);
		mPaste = new JMenuItem("����");
		mPaste.setIcon(null);
		mRotate = new JMenuItem("��ת");
		mRotate.setIcon(null);
		mArrti = new JMenuItem("����");
		mArrti.setIcon(null);
		
		add(mCut);
		add(mCopy);
		add(mPaste);
		add(mRotate);
		add(mArrti);
	}
	
}
