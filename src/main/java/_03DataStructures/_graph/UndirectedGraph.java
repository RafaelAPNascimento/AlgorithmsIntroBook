package _03DataStructures._graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class UndirectedGraph<E> {

    private Map<E, LinkedList<Data<E>>> buckets;

    public class Data<E> {
        private E data;
        private Integer weight;

        private Data(E data, Integer weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data<?> data1 = (Data<?>) o;

            return data.equals(data1.data);
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }

        @Override
        public String toString() {
            return "{"
                    + "\"data\":" + data
                    + ", \"weight\":\"" + weight + "\""
                    + "}";
        }
    }

    public UndirectedGraph() {
        buckets = new HashMap<>();
    }

    public boolean addVertex(E vertex) {

        Data<E> neW = new Data<>(vertex, null);

        LinkedList<Data<E>> bucket = buckets.get(vertex);
        if (bucket != null)
            return false;    // ja tem

        bucket = new LinkedList<>();
        buckets.put(vertex, bucket);
        return true;
    }

    public void addEdge(E v1, E v2, Integer weight) {

        if (!(buckets.containsKey(v1) || buckets.containsKey(v2)))
            throw new RuntimeException("Some vertex are not present in the graph");

        LinkedList<Data<E>> bucket1 = buckets.get(v1);
        LinkedList<Data<E>> bucket2 = buckets.get(v2);

        Data<E> d1 = new Data<>(v2, weight);
        if (!bucket1.contains(d1))
            bucket1.add(d1);

        Data<E> d2 = new Data<>(v1, weight);
        if (!bucket2.contains(d2))
            bucket2.add(d2);
    }

    public Set<Data<E>> bfs() {

        Queue<Data<E>> queue = new LinkedList<>();
        E firstKey = getFirstKey();

        LinkedList<Data<E>> bucket = buckets.get(firstKey);

        Data<E> first = bucket.getFirst();
        queue.add(first);

        Set<Data<E>> visited = new HashSet<>();

        while (!queue.isEmpty()) {

            Data<E> d = queue.poll();
            visited.add(d);

            for (Data<E> adj : bucket) {

                if (!(queue.contains(adj) && visited.contains(adj)))
                    queue.add(adj);
            }
        }
        return visited;
    }

    private E getFirstKey() {

        Set<E> keys = buckets.keySet();
        Iterator<E> it = keys.iterator();
        if (it.hasNext())
            return it.next();
        throw new RuntimeException("Graph is empty");
    }

    public Set<Data<E>> _bsf() {

        Queue<Data<E>> queue = new LinkedList<>();

        E key = buckets.entrySet().iterator().next().getKey();
        LinkedList<Data<E>> b1 = buckets.get(key);

        Data<E> first = b1.getFirst();
        queue.offer(first);

        Set<Data<E>> visisted = new HashSet<>();

        while (!queue.isEmpty()) {

            Data<E> current = queue.poll();
            visisted.add(current);
            for (Data<E> adj : buckets.get(current)) {

                if (!queue.contains(adj) && !visisted.contains(adj)) {
                    queue.add(adj);
                }
            }
        }
        return visisted;
    }
}
