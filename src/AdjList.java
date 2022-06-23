
public class AdjList {

	static class Node {
		int vertex;
		Node Node;

		public Node(int vertex, Node node) {
			this.vertex = vertex;
			Node = node;
		}
	}

	public static void main(String[] args) {
		Node[] adjList = new Node[10];
		int N = 100;
		for (int i = 0; i < N; i++) {
			int from = 0;
			int to = 0;
			adjList[from] = new Node(to, adjList[from]);
		}
	}
}
