package Function;
//
//import java.awt.Graphics;
//import java.util.Iterator;
//
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import Data.Node;
//import Data.Tree;
//
//public class ApplyMapFunction {
//	
//    public static void applyMapFunction(Tree t,Node now, JPanel mindmapPane) {
//    	Node root = t.root;
//    	
//    	if(now == t.root) {
//    		mindmapPane.setLayout(null);
//    		JLabel rootNode =new JLabel((String)t.root.info);
//    		mindmapPane.add(rootNode);
//    		rootNode.setLocation((int)(t.root.x*100 + (mindmapPane.getWidth()/2)), (int)(t.root.y*100 + (mindmapPane.getHeight()/2)));
//    		rootNode.setSize(200,100);
//    	}
//    	
//        Iterator<Node> it = now.children.iterator();
//
//        if (!it.hasNext())
//          return;
//
//        while(it.hasNext()) {
//            Node dataNode = it.next();
//    		JLabel showNode =new JLabel((String)(dataNode.info));
//    		mindmapPane.add(showNode);
//    		showNode.setLocation((int)(dataNode.x*100 + (mindmapPane.getWidth()/2)), (int)(dataNode.y*100 + (mindmapPane.getHeight()/2)));
//    		showNode.setSize(200, 100);
//
//    		 applyMapFunction(t, dataNode, mindmapPane);
//        }
//       }
//    }
//
//
//class mindMapPainter extends JPanel {
//	Tree mainTree;
//	mindMapPainter (Tree mainTree) {
//		this.mainTree = mainTree;
//	}
//	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.drawRect(20,20,80,80);
//		g.drawString("자바는 재밌다.~~", 30,30);
//		g.drawString("얼마나? 하늘만큼 땅만큼 !!!!", 60, 60);
//	}
//}
//	
