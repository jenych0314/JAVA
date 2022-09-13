public class SpanningTree extends GraphMatrix {
    SpanningTree(int size) {
        super(size, true);
    }

    public void add(int src, int dest, int weight) {
        // check range src and dest: 0 <= src, dest < size
        // check weight: weight >= 0
        // check cycle
        this.edges[src][dest] = weight;
    }

    public int getTotalWeight() {
        int result = 0;
        for (int row = 0; row < this.size; row++) {
            for (int col = row; col < this.size; col++) { // int col = 0 일 때보다 탐색량 1/2배로 감소
                result += this.edges[row][col];
            }
        }
        return result;
    }
}
