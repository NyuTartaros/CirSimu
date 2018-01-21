package cirsimu.ui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import cirsimu.entity.CirComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RightMenu extends JPopupMenu{

	private JMenuItem mCut;
	private JMenuItem mCopy;
	private JMenuItem mPaste;
	private JMenuItem mRotate;
	private JMenuItem mArrti;
	
	private DrawArea drawArea;
	private CirComponent parentComp;
	
	public RightMenu(DrawArea drawArea, CirComponent parentComp) {
		this.drawArea = drawArea;
		this.parentComp = parentComp;
		drawArea.isDrawArea();
		mCut = new JMenuItem("剪切");
		mCut.setIcon(null);
		mCopy = new JMenuItem("复制");
		mCopy.setIcon(null);
		mPaste = new JMenuItem("复制");
		mPaste.setIcon(null);
		mRotate = new JMenuItem("旋转");
		mRotate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO DEBUG
				parentComp.rotate();
				drawArea.paint(drawArea.getGraphics());
			}
		});
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
