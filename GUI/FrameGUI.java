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
		// ������ ����
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
		//�޴��� ����
		JMenuBar menubar = new JMenuBar();
		
		// �޴��� ��� ����
		JMenu menu1 = new JMenu("1");
			JMenuItem menu1item1 = new JMenuItem("m1 i1");
			menu1.add(menu1item1);
			menubar.add(menu1);
//		JMenu menu2 = new JMenu("2");
//		JMenu menu3 = new JMenu("3");
//		JMenu menu4 = new JMenu("4");
			
		//�޴��� ����
		mainFrame.setJMenuBar(menubar);
//....................................................................		
		//���� ����
		JToolBar toolbar = new JToolBar("ToolBar");
		toolbar.setBackground(Color.black);
		toolbar.add(new JButton("ti1"));
		toolbar.setVisible(true);
		mainFrame.add(toolbar);
		

//....................................................................						
		// �ؽ�Ʈ ������ ����
		
		TextArea textArea = new TextArea(mainFrame);


//....................................................................		
		// ���ε�� �ǳ�

		mindmapArea = new MindmapArea(mainTree, mainFrame);
//		mindmapArea.mindmapPane.setLayout(null);
//		
				
//....................................................................		
		// �Ӽ� �ǳ�
		AttributeArea attributeArea = new AttributeArea();


//....................................................................		
		
		// ������ �κ�
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); 
        splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); 
        
        splitPane1.setRightComponent(splitPane2); //���� ������Ʈ ����
        
        System.out.println(WMF);
        splitPane1.setDividerLocation(WMF/4);
        splitPane2.setDividerLocation((WMF/2));
        
        splitPane1.setLeftComponent(textArea.textPane); //���� ������Ʈ ����
        splitPane2.setLeftComponent(mindmapArea); //���� ������Ʈ ����
        splitPane2.setRightComponent(attributeArea.attributePane); //���� ������Ʈ ����
        
        
        
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
