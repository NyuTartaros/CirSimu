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
		mCut = new JMenuItem("剪切");
		mCut.setIcon(null);
		mCopy = new JMenuItem("复制");
		mCopy.setIcon(null);
		mPaste = new JMenuItem("复制");
		mPaste.setIcon(null);
		mRotate = new JMenuItem("旋转");
		mRotate.setIcon(null);
		mArrti = new JMenuItem("属性");
		mArrti.setIcon(null);
		
		add(mCut);
		add(mCopy);
		add(mPaste);
		add(mRotate);
		add(mArrti);
	}
	
}
