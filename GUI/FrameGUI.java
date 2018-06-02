package GUI;

import javax.swing.*;
import Data.Tree;
import EventListener.FrameResizedListener;
import EventListener.NodeListener;

import java.awt.*;

public class FrameGUI extends JFrame {
	JFrame mainFrame;
	JTextArea textarea;
	Tree mainTree;
	MindmapArea mindmapArea;
	JSplitPane splitPane2;
	
	public FrameGUI (JFrame mainFrame, Tree mainTree) {
		this.mainFrame = mainFrame;
		this.mainTree = mainTree;

//....................................................................		
		// 프레임 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container conPane = mainFrame.getContentPane();
		conPane.setLayout(new BorderLayout(0,0));
		mainFrame.setSize(1600, 800);

//....................................................................		
		Rectangle r = mainFrame.getBounds();
		int HMF = r.height;
		int WMF = r.width;
        Dimension eachDimension = new Dimension ((HMF-200) , WMF/3);

//....................................................................		
		//메뉴바 생성
		JMenuBar menubar = new JMenuBar();
		
		// 메뉴바 목록 생성
		JMenu menu1 = new JMenu("1");
			JMenuItem menu1item1 = new JMenuItem("m1 i1");
			menu1.add(menu1item1);
			menubar.add(menu1);
//		JMenu menu2 = new JMenu("2");
//		JMenu menu3 = new JMenu("3");
//		JMenu menu4 = new JMenu("4");
			
		//메뉴바 세팅
		mainFrame.setJMenuBar(menubar);
//....................................................................		
		//툴바 생성
		JToolBar toolbar = new JToolBar("ToolBar");
		toolbar.setBackground(Color.black);
		toolbar.add(new JButton("ti1"));
		toolbar.setVisible(true);
		mainFrame.add(toolbar);
		

//....................................................................						
		// 텍스트 에디터 페인
		
		TextArea textArea = new TextArea(mainFrame);


//....................................................................		
		// 마인드맵 판넬

		mindmapArea = new MindmapArea(mainTree, mainFrame);
//		mindmapArea.mindmapPane.setLayout(null);
//		
				
//....................................................................		
		// 속성 판넬
		AttributeArea attributeArea = new AttributeArea();


//....................................................................		
		
		// 데이터 부분
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); 
        splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); 
        
        splitPane1.setRightComponent(splitPane2); //우측 컴포넌트 장착
        
        System.out.println(WMF);
        splitPane1.setDividerLocation(WMF/4);
        splitPane2.setDividerLocation((WMF/2));
        
        splitPane1.setLeftComponent(textArea.textPane); //좌측 컴포넌트 장착
        splitPane2.setLeftComponent(mindmapArea); //좌측 컴포넌트 장착
        splitPane2.setRightComponent(attributeArea.attributePane); //좌측 컴포넌트 장착
        
        
        
  //....................................................................		
		textArea.applyButton.addActionListener(new EventListener.ApplyMap(mindmapArea, mainTree));
		textArea.applyButton.addActionListener(new EventListener.ApplyListener(textArea.textarea, mainTree));
		mainFrame.addComponentListener(new FrameResizedListener(mindmapArea));
//		mindmapArea.addMouseListener(new NodeListener(mainTree, mindmapArea));

        
        conPane.add(splitPane1);
        mainFrame.setVisible(true);


	}
	
	

	
	public JTextArea getJTextArea() {
		return textarea;
	}
	public MindmapArea getmindmapArea() {
		return mindmapArea;
	}

}
