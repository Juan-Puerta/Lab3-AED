package collections;

public class NodeAVL<T extends Comparable<T>> {

	private T date;
	private int feNode;
	
	private NodeAVL<T> leftSon;
	private NodeAVL<T> rightSon;
	
	public NodeAVL(T date) {
		// TODO Auto-generated constructor stub
		this.date = date;
		this.feNode = 0;
		this.leftSon = null;
		this.rightSon = null;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

	public int getFeNode() {
		return feNode;
	}

	public void setFeNode(int feNode) {
		this.feNode = feNode;
	}

	public NodeAVL<T> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(NodeAVL<T> leftSon) {
		this.leftSon = leftSon;
	}

	public NodeAVL<T> getRightSon() {
		return rightSon;
	}

	public void setRightSon(NodeAVL<T> rightSon) {
		this.rightSon = rightSon;
	}
	
}
