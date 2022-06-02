interface Graph {
    public void add(int source, int destination, int weight);

    public int getWeight(int source, int destination);

    public int getSize();

    public boolean isDirected();

    public void print();
}