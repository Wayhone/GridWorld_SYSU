package solution;

import java.util.ArrayList;

import jigsaw.Jigsaw;
import jigsaw.JigsawNode;


/**
 * �ڴ���������㷨�������ƴͼ��Ϸ��N-�������⣩
 */
public class Solution extends Jigsaw {

    /**
     * ƴͼ���캯��
     */
    public Solution() {
    }

    /**
     * ƴͼ���캯��
     * @param bNode - ��ʼ״̬�ڵ�
     * @param eNode - Ŀ��״̬�ڵ�
     */
    public Solution(JigsawNode bNode, JigsawNode eNode) {
        super(bNode, eNode);
    }

    /**
     *��ʵ��һ��������������㷨����ָ��5*5ƴͼ��24-�������⣩�����Ž�
     * ���˺���������Solution���������������������
     * @param bNode - ��ʼ״̬�ڵ�
     * @param eNode - Ŀ��״̬�ڵ�
     * @return �����ɹ�ʱΪtrue,ʧ��Ϊfalse
     */
    public boolean BFSearch(JigsawNode bNode, JigsawNode eNode) {
        //this.visitedList = new HashSet<>(1000);
        //this.exploreList = new Queue<>(500);
        ArrayList<JigsawNode> openList = new ArrayList<JigsawNode>();
        ArrayList<JigsawNode> closeList = new ArrayList<JigsawNode>();

        this.beginJNode = new JigsawNode(bNode);
        this.endJNode = new JigsawNode(eNode);
        this.currentJNode = null;

        final int DIRS = 4;

        // ���������
        int mySearchedNodesNum = 0;

        // (1)����ʼ�ڵ����openList��
        openList.add(this.beginJNode);

        // (2) ���exploreListΪ�գ�������ʧ�ܣ������޽�;����ѭ��ֱ�����ɹ�
        while (!openList.isEmpty()) {
            mySearchedNodesNum++;

            // (2-1)ȡ��exploreList�ĵ�һ���ڵ�N����Ϊ��ǰ�ڵ�currentJNode
            //      ��currentJNodeΪĿ��ڵ㣬�������ɹ��������·�����˳�
            this.currentJNode = openList.get(0);
            if (this.currentJNode.equals(eNode)) {
                this.getPath();
                break;
            }

            JigsawNode[] nextNodes = new JigsawNode[]{
                new JigsawNode(this.currentJNode), new JigsawNode(this.currentJNode),
                new JigsawNode(this.currentJNode), new JigsawNode(this.currentJNode)
            };

            // (2-2)Ѱ��������currentJNode�ڽ���δ�������ֵĽڵ㣬�����ǲ���openList��
            for (int i = 0; i < DIRS; i++) {
                if (nextNodes[i].move(i) && !openList.contains(nextNodes[i]) && !closeList.contains(nextNodes[i])) {
                            openList.add(nextNodes[i]);
                }
            }
            
            // (2-3)��openList��ɾ����ǰ�ڵ㣬���뵽closeList��
            openList.remove(currentJNode);
            closeList.add(currentJNode);    
            
        }

        System.out.println("Jigsaw AStar Search Result:");
        System.out.println("Begin state:" + this.getBeginJNode().toString());
        System.out.println("End state:" + this.getEndJNode().toString());
        // System.out.println("Solution Path: ");
        // System.out.println(this.getSolutionPath());
        System.out.println("Total number of searched nodes:" + mySearchedNodesNum);
        System.out.println("Depth of the current node is:" + this.getCurrentJNode().getNodeDepth());
        return this.isCompleted();
    }


    /**
     *��Demo+ʵ��������㲢�޸�״̬�ڵ�jNode�Ĵ��۹���ֵ:f(n)
     * �� f(n) = s(n). s(n)��������ڵ㲻��ȷ���������
     * �˺�����ı�ýڵ��estimatedValue����ֵ
     * �޸Ĵ˺���������Solution���������������������
     * @param jNode - Ҫ������۹���ֵ�Ľڵ�
     */
    public void estimateValue(JigsawNode jNode) {
        int s = 0; // �����ڵ㲻��ȷ���������
        int mhDis = 0;
        int euDis = 0;
        int dimension = JigsawNode.getDimension();
        for (int i = 1; i < dimension * dimension; i++) {
        	if (jNode.getNodesState()[i] + 1 != jNode.getNodesState()[i + 1]) {
                s++;
            }
        	
        	for (int j = 1; j < dimension * dimension; j++) {
        		if (jNode.getNodesState()[i] != 0 
        				&& jNode.getNodesState()[i] == endJNode.getNodesState()[j]) {
        			int x1 = (i - 1)/dimension, y1 = (i - 1)%dimension,
        				x2 = (j - 1)/dimension, y2 = (j - 1)%dimension;
        			mhDis += Math.abs(x1 - x2) + Math.abs(y1 - y2);
        			euDis += Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        			break;
        		}
        	}        
        }
        
        int weight = s * 5 + mhDis * 4 + euDis * 1;
        jNode.setEstimatedValue(weight);
    }
}
