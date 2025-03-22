package services;

import beans.Etudiant;
import connexion.Connexion;
import dao.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantService implements IDao<Etudiant> {

    private Connection cn = Connexion.getInstance().getCn();
    public EtudiantService() {
    cn = Connexion.getInstance().getCn();
    System.out.println("✅ Connexion réussie (EtudiantService) : " + (cn != null));
}


    @Override
    public boolean create(Etudiant o) {
        if (emailExists(o.getEmail())) {
            System.out.println("Erreur : L'email '" + o.getEmail() + "' existe déjà !");
            return false;
        }

        String query = "INSERT INTO Etudiant (nom, prenom, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                o.setId(rs.getInt(1));
            }
            System.out.println("Étudiant ajouté avec succès !");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout de l'étudiant : " + ex.getMessage());
        }
        return false;
    }
    // ✅ EtudiantService.java
 public List<Etudiant> getAllEtudiants() {
        List<Etudiant> list = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";
        try (Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println("Erreur getAllEtudiants : " + e.getMessage());
        }
        return list;
    }


    @Override
    public boolean delete(Etudiant o) {
        String query = "DELETE FROM Etudiant WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, o.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Étudiant supprimé avec succès !");
                return true;
            } else {
                System.out.println("Aucun étudiant trouvé avec l'ID : " + o.getId());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de l'étudiant : " + ex.getMessage());
        }
        return false;
    }
    

    @Override
    public boolean update(Etudiant o) {
        if (emailExistsForOther(o.getEmail(), o.getId())) {
            System.out.println("Erreur : L'email '" + o.getEmail() + "' est déjà utilisé par un autre étudiant !");
            return false;
        }

        String query = "UPDATE Etudiant SET nom = ?, prenom = ?, email = ? WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Étudiant mis à jour avec succès !");
                return true;
            } else {
                System.out.println("Aucun étudiant trouvé avec l'ID : " + o.getId());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour de l'étudiant : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Etudiant findById(int id) {
        String query = "SELECT * FROM Etudiant WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération de l'étudiant : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM Etudiant";
        try (PreparedStatement ps = cn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                etudiants.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des étudiants : " + ex.getMessage());
        }
        return etudiants;
    }

    private boolean emailExists(String email) {
        String query = "SELECT COUNT(*) FROM Etudiant WHERE email = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la vérification de l'email : " + ex.getMessage());
        }
        return false;
    }

    private boolean emailExistsForOther(String email, int id) {
        String query = "SELECT COUNT(*) FROM Etudiant WHERE email = ? AND id <> ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la vérification de l'email (pour mise à jour) : " + ex.getMessage());
        }
        return false;
    }
    public boolean delete(int id) {
        String query = "DELETE FROM Etudiant WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Étudiant supprimé par ID !");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur suppression par ID : " + ex.getMessage());
        }
        return false;
    }
}