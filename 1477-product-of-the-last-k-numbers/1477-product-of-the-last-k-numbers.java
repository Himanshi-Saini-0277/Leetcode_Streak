class ProductOfNumbers {
    List<Integer> prefixProduct;
    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }
    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1);
        } else {
            prefixProduct.add(num * prefixProduct.get(prefixProduct.size() - 1));
        }
    }
    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (size <= k) return 0;
        return prefixProduct.get(size - 1) / prefixProduct.get(size - k - 1);
    }
}