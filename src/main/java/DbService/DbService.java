package DbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Patients;
import model.User;
import model.Vaccines;

public class DbService {

	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu93";
	private String username = "cs3220stu93";
	private String password = "fWyodIhiq7Pq";

	private static Connection connection;

	public DbService() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Vaccines> getVaccines() {
		List<Vaccines> vaccines = new ArrayList<Vaccines>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vaccines;");
			while (rs.next()) {
				Vaccines vaccine = new Vaccines();
				vaccine.setId(rs.getInt("id"));
				vaccine.setName(rs.getString("name"));
				vaccine.setDosesRequired(rs.getInt("dosesRequired"));
				vaccine.setDaysBetweenDoses(rs.getInt("daysBetweenDoses"));
				vaccine.setTotalDosesReceived(rs.getInt("totalDosesReceived"));
				vaccine.setTotalDosesLeft(rs.getInt("totalDosesLeft"));
				vaccines.add(vaccine);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vaccines;
	}

	public List<Patients> getPatients() {
		List<Patients> patients = new ArrayList<Patients>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from patients;");
			while (rs.next()) {
				Patients patient = new Patients();
				patient.setId(rs.getInt("id"));
				patient.setPeopleName(rs.getString("name"));
				patient.setFirstDate(rs.getDate("firstDate"));
				patient.setSecondDate(rs.getDate("secondDate"));
				patient.setVaccineId(rs.getInt("vaccineId"));
				patients.add(patient);

			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patients;

	}

	public void addVacine(String name, int dosesRequired, String daysBetween) {
		try {
			String sql = "insert into vaccines(name, dosesRequired, daysBetweenDoses) values (?,?,?);";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, name);
			pstmt.setInt(2, dosesRequired);
			pstmt.setString(3, daysBetween);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				pstmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return;

	}

	public void NewDose(int id, int totalLeft, int totalReceived) {
		try {
			String sql = "update vaccines set totalDosesReceived = ?, totalDosesLeft = ? where id = ?;";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, totalReceived);
			pstmt.setInt(2, totalLeft);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void editVaccine(int id, String name, int doses, String daysbetween) {
		try {
			String sql = "update vaccines set name = ?, dosesRequired = ?, daysBetweenDoses = ? where id = ?;";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, doses);
			pstmt.setString(3, daysbetween);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void newPatient(String name, int id) {
		try {
			String sql = "insert into patients(name, firstDate, vaccineId) values (?,?,?);";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			pstmt.setString(1, name);
			pstmt.setString(2, formatter.format(date));
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next())
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	public void decrement(int id, int totalDosesLeft) {
		try {
			String sql = "update vaccines set totalDosesLeft = ? where id = ?;";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, totalDosesLeft - 1);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Received(int id) {
		try {
			String sql = "update patients set secondDate = ? where id = ?;";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			pstmt.setString(1, formatter.format(date));
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users;");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("displayName"));
				user.setPassword(rs.getString("password"));
				user.setAdmin(rs.getBoolean("isAdmin"));
				users.add(user);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	
	}

	public void editUser(int id, String name, String password) {
		try {
			String sql = "update users set displayName = ?, password = ? where id = ?;";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

}
