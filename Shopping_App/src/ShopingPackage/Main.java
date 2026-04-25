package ShopingPackage;

public class Main {
    public static void main(String[] args) {

        ProductOptn po = new ProductOptn();

        //INSERT
        Product p1 = new Product(12, "TV", 2, 5000.0);
        po.addProduct(p1);

        //GET BY ID
        po.getProductById(12);

        //UPDATE
        Product updated = new Product(12, "Smart TV", 5, 8000.0);
        po.updateProduct(updated);

        //GET ALL
        System.out.println("\nAll Products:");
        po.getAllProducts();

        //DELETE
        po.deleteProduct(12);

        //FINAL CHECK
        System.out.println("\nAfter Delete:");
        po.getAllProducts();
    }
}