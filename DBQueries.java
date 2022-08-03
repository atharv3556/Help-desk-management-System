
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athar
 */
public class DBQueries {
    private static final String INSERT_SQL = "INSERT INTO query_field(Date, Name, Mobile, Email, Gender, Complaint) values(?, ?, ?, ?, ?, ?) ";

    	public ArrayList<Helpdesk> checkQueryStatus(String Q_No) throws SQLException {
		ArrayList<Helpdesk> helpdeskList=new ArrayList<Helpdesk>();
		try {
			Connection cn=DBConnection.createConnection();
			PreparedStatement ps=cn.prepareStatement("select Date,Name,Mobile,Email,Gender,Complaint,Solution FROM query_field where Q_No=?");
			ps.setString(1, Q_No);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Helpdesk h=new Helpdesk();
				h.setDate(rs.getDate("DATE").toString());
				h.setName(rs.getString("NAME"));
				h.setMobile(rs.getLong("MOBILE"));
				h.setEmail(rs.getString("EMAIL"));
				h.setGender(rs.getString("GENDER"));
				h.setComplaint(rs.getString("COMPLAINT"));
				h.setSolution(rs.getString("SOLUTION"));
			
				helpdeskList.add(h);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection();
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return helpdeskList;
	}
        public void selectAll() throws HelpdeskNotExist{
            try {
                Connection cn=DBConnection.createConnection();
                PreparedStatement ps=cn.prepareStatement("select * FROM query_field");
                ResultSet rs=ps.executeQuery();
                while(rs.next()) {
				String Q_No = String.valueOf(rs.getLong("Q_NO"));
                                String Date = rs.getDate("DATE").toString();
				String Name= rs.getString("NAME");
				String Mobile = String.valueOf(rs.getLong("MOBILE"));
				String Email = rs.getString("EMAIL");
				String Gender = rs.getString("GENDER");
				String Complaint = rs.getString("COMPLAINT");
				String Solution = rs.getString("SOLUTION");
			
				String datatable[] = {Q_No,Date,Name,Mobile,Email,Gender,Complaint,Solution};
                                DefaultTableModel model = (DefaultTableModel)A1.jTable1.getModel();
                                model.addRow(datatable);
			}   
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection();
            } catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
            }
        }
        
        	public void updateQuerySolution(String Q_No, String Solution) throws HelpdeskNotExist{
		try {
			Connection cn=DBConnection.createConnection();
			PreparedStatement ps1=cn.prepareStatement("UPDATE query_field SET Solution=? WHERE Q_No=?");
			ps1.setString(1, Solution);
			ps1.setString(2, Q_No);
			int t=ps1.executeUpdate();
			if(t==0) {
				throw new HelpdeskNotExist("Helpdesk with id="+Q_No+" not exists!!!");
			}

			DBConnection.closePreparedStatement(ps1);
			DBConnection.closeConnection();
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}
                
                public long insertQueryDetails(String date, String name, String mobile, String email, String gender, String complaint) throws HelpdeskNotExist{
		long query_id = 0;
                Helpdesk helpdesk=new Helpdesk();
		try {
                        Connection cn=DBConnection.createConnection();
			PreparedStatement ps=cn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, date);
                        ps.setString(2, name);
                        ps.setString(3, mobile);
                        ps.setString(4, email);
                        ps.setString(5, gender);
                        ps.setString(6, complaint);
			int t=ps.executeUpdate();
			if(t==0) {
				throw new HelpdeskNotExist("Couldn't add new complaint entry");
			}
                        try (ResultSet rs = ps.getGeneratedKeys()) {
                            if (rs.next()) {
                                //helpdesk.setQ_No(rs.getLong(1));
                                query_id=rs.getLong(1);
                                
                            }
                        } catch (SQLException s) {
                            s.printStackTrace();
                        }
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection();
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return query_id;
	}
    
}
