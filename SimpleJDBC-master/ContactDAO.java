import java.sql.*;

public class ContactDAO {

    public void addContact(String name, String email, String phone) {

        String sql = "INSERT INTO contacts(name, email, phone) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.executeUpdate();

            System.out.println("Contact added successfully");

        } catch (Exception e) {
            System.out.println("Insert failed");
            e.printStackTrace();
        }
    }

    public void viewContacts() {

        String sql = "SELECT * FROM contacts";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nID | Name | Email | Phone");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("phone")
                );
            }

        } catch (Exception e) {
            System.out.println("Select failed");
            e.printStackTrace();
        }
    }

    public void searchByName(String name) {

        String sql = "SELECT * FROM contacts WHERE name LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("phone")
                );
            }

        } catch (Exception e) {
            System.out.println("Search failed");
            e.printStackTrace();
        }
    }

    public void updateContact(int id, String phone) {

        String sql = "UPDATE contacts SET phone=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, phone);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Contact updated");

        } catch (Exception e) {
            System.out.println("Update failed");
            e.printStackTrace();
        }
    }

    public void deleteContact(int id) {

        String sql = "DELETE FROM contacts WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Contact deleted");

        } catch (Exception e) {
            System.out.println("Delete failed");
            e.printStackTrace();
        }
    }
}

