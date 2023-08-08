package technifutur.be.technifutur.repositories;

import technifutur.be.technifutur.exception.EntityException;
import technifutur.be.technifutur.models.entities.Product;
import technifutur.be.technifutur.models.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository{

    public ProductRepositoryImpl() {
        super("PRODUCT", "PRODUCT_ID");
    }

    @Override
    protected Product buildEntity(ResultSet rs) {
        try {
            return Product.builder()
                            .id(rs.getInt("PRODUCT_ID"))
                    .libele(rs.getString("LIBELE"))
                    .description(rs.getString("DESCRIPTION"))
                    .price(rs.getBigDecimal("PRICE"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Product add(Product product, Connection conn) {

        try {
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO PRODUCT(LIBELE,DESCRIPTION,PRICE) VALUES(?,?,?) RETURNING *");
            psmt.setString(1, product.getLibele());
            psmt.setString(2, product.getDescription());
            psmt.setBigDecimal(3, product.getPrice());
            ResultSet rs = psmt.executeQuery();
            if(!rs.next())
                throw new EntityException("Failed");

            return buildEntity(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product add(Product product) {
        return add(product,openConnection());

    }

    @Override
    public boolean update(Integer id, Product product) {
        try {
            Connection conn = openConnection();
            PreparedStatement psmt = conn.prepareStatement("UPDATE PRODUCT SET LIBELE = ?, DESCRIPTION = ?, PRICE = ? WHERE PRODUCT_ID = ?");
            psmt.setString(1,product.getLibele());
            psmt.setString(2, product.getDescription());
            psmt.setBigDecimal(3, product.getPrice());
            psmt.setInt(4,id);

            int nbRows = psmt.executeUpdate();

            conn.close();

            return nbRows == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
