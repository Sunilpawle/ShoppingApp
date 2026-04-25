package ShopingPackage;

import java.sql.*;

public class ProductOptn {

    String url = "jdbc:mysql://localhost:3306/collagedb";
    String user = "root";
    String password = "Sunil2304@$";

    //INSERT
    public void addProduct(Product p) {
        String query = "INSERT INTO product (pid, pname, qty, price) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, p.pid);
            ps.setString(2, p.pname);
            ps.setInt(3, p.qty);
            ps.setDouble(4, p.price);

            int rows = ps.executeUpdate();
            System.out.println("Inserted rows: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SELECT BY ID
    public void getProductById(int pid) {
        String query = "SELECT * FROM product WHERE pid = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Product p = new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getInt("qty"),
                        rs.getDouble("price")
                );
                System.out.println(p);
            } else {
                System.out.println("Product not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE
    public void updateProduct(Product p) {
        String query = "UPDATE product SET pname=?, qty=?, price=? WHERE pid=?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, p.pname);
            ps.setInt(2, p.qty);
            ps.setDouble(3, p.price);
            ps.setInt(4, p.pid);

            int rows = ps.executeUpdate();
            System.out.println("Updated rows: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //DELETE
    public void deleteProduct(int pid) {
        String query = "DELETE FROM product WHERE pid = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, pid);

            int rows = ps.executeUpdate();
            System.out.println("Deleted rows: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SELECT ALL
    public void getAllProducts() {
        String query = "SELECT * FROM product";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getInt("qty"),
                        rs.getDouble("price")
                );
                System.out.println(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}