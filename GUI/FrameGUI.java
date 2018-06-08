package GUI;

import javax.swing.*;
import Data.Tree;
import EventListener.FileExplorerListener;
import EventListener.FrameResizedListener;
import EventListener.MindmapListener;
import EventListener.PanelResizedListener;
import EventListener.scrollEvent;

import java.awt.*;

public class FrameGUI extends JFrame {
	JFrame mainFrame;
	JTextArea textarea;
	Tree mainTree;
	public static MindmapArea mindmapArea;
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
		JMenu menu1 = new JMenu("File");
			JMenuItem menu1item1 = new JMenuItem("Make new");
			menu1item1.addActionListener(new FileExplorerListener(mainTree,1));
			menu1.add(menu1item1);

			JMenuItem menu1item2 = new JMenuItem("load");
			menu1item2.addActionListener(new FileExplorerListener(mainTree,2));
			menu1.add(menu1item2);

			JMenuItem menu1item3 = new JMenuItem("save");
			menu1item3.addActionListener(new FileExplorerListener(mainTree,3));
			menu1.add(menu1item3);

			JMenuItem menu1item4 = new JMenuItem("save as");
			menu1item4.addActionListener(new FileExplorerListener(mainTree,4));
			menu1.add(menu1item4);

		
			JMenuItem menu1item5 = new JMenuItem("exit");
			menu1item5.addActionListener(new FileExplorerListener(mainTree,5));
			menu1.add(menu1item5);
			
			JMenuItem menu1item6 = new JMenuItem("apply");
			menu1item5.addActionListener(new EventListener.ApplyMap(mindmapArea, mainTree, mindmapArea));
			menu1item5.addActionListener(new EventListener.ApplyListener(textArea.textarea, mainTree));
			menu1.add(menu1item5);
			
			JMenuItem menu1item7 = new JMenuItem("change");
			menu1item5.addActionListener(new FileExplorerListener(mainTree,5));
			menu1.add(menu1item5);
			
			menubar.add(menu1);
			

			
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
		// 속성 판넬
		AttributeArea attributeArea = new AttributeArea();

//....................................................................		
		// 마인드맵 판넬
		mindmapArea = new MindmapArea(mainTree, mainFrame, attributeArea);
		mindmapArea.addMouseListener(new MindmapListener(mainTree, mindmapArea));
		mindmapArea.addComponentListener(new PanelResizedListener(mindmapArea));
		JScrollPane scroll = new JScrollPane(mindmapArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mindmapArea.setScroll(scroll);
        attributeArea.setMindemapArea(mindmapArea);
        scroll.getViewport().addChangeListener(new scrollEvent(mindmapArea));


//....................................................................		
		
		// 데이터 부분
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); 
        splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); 
        
        splitPane1.setRightComponent(splitPane2); //우측 컴포넌트 장착
        
        System.out.println(WMF);
        splitPane1.setDividerLocation(WMF/4);
        splitPane2.setDividerLocation((WMF/2));
        
        splitPane1.setLeftComponent(textArea.textPane); //좌측 컴포넌트 장착
        splitPane2.setLeftComponent(scroll); //좌측 컴포넌트 장착
        splitPane2.setRightComponent(attributeArea.attributePane); //좌측 컴포넌트 장착
        
        
        
  //....................................................................		
		textArea.applyButton.addActionListener(new EventListener.ApplyMap(mindmapArea, mainTree, mindmapArea));
		textArea.applyButton.addActionListener(new EventListener.ApplyListener(textArea.textarea, mainTree));
		mainFrame.addComponentListener(new FrameResizedListener(mindmapArea));

        
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
