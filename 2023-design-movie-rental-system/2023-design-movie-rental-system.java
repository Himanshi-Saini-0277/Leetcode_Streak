class MovieRentingSystem {
    private static class Node {
        final int shop;
        final int movie;
        final int price;
        Node(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    private static final Comparator<Node> CMP =
        (a, b) -> {
            int c = Integer.compare(a.price, b.price);
            if (c != 0) return c;
            c = Integer.compare(a.shop, b.shop);
            if (c != 0) return c;
            return Integer.compare(a.movie, b.movie);
        };

    private final Map<Integer, TreeSet<Node>> availableByMovie = new HashMap<>();
    private final TreeSet<Node> rentedSet = new TreeSet<>(CMP);
    private final Map<Long, Node> byPair = new HashMap<>();

    private static long key(int shop, int movie) {
        return (((long) shop) << 32) ^ (movie & 0xffffffffL);
    }

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Node node = new Node(shop, movie, price);
            byPair.put(key(shop, movie), node);
            availableByMovie
                .computeIfAbsent(movie, k -> new TreeSet<>(CMP))
                .add(node);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>(5);
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set == null || set.isEmpty()) return ans;
        Iterator<Node> it = set.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            ans.add(it.next().shop);
        }
        return ans;
    }

    public void rent(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return;
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set != null) set.remove(node);
        rentedSet.add(node);
    }

    public void drop(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return;
        rentedSet.remove(node);
        availableByMovie
            .computeIfAbsent(movie, x -> new TreeSet<>(CMP))
            .add(node);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>(5);
        Iterator<Node> it = rentedSet.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            Node n = it.next();
            ans.add(Arrays.asList(n.shop, n.movie));
        }
        return ans;
    }
}