package collections;

public class NodeAVL<T extends Comparable<T>> {

    public int bf;
    public T value;
    public int height;
    public NodeAVL<T> left, right;

    public NodeAVL(T value) {
      this.value = value;
    }

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public NodeAVL<T> getLeft() {
		return left;
	}

	public void setLeft(NodeAVL<T> left) {
		this.left = left;
	}

	public NodeAVL<T> getRight() {
		return right;
	}

	public void setRight(NodeAVL<T> right) {
		this.right = right;
	}
	
}
