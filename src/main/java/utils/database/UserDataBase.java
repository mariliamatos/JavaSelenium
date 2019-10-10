
package utils.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class UserDataBase {

	public User insertUser() throws SQLException, ClassNotFoundException {

		User user = new User();
		user.setId(getMaximuIdUser() + 1);
		user.setUsername("USER.TESTE" + user.getId());
		String sql = "INSERT INTO SPCJAVA.operador (ID, NOM_OPERADOR, COD_OPERADOR, ID_PROCESSADOR, IDC_CONOTACAO_SRF, TIP_OPERADOR, ID_PERFIL, IDC_ACESSO_BOE, IDC_ADMINISTRATIVO, IDC_CALLCENTER, IDC_EXIBIR_CONSULTA, IDC_ACESSO_VPN_CONNECT, IDC_STATUS, DAT_INCLUSAO, ID_DISPOSITIVO_INCLUSAO, ID_DISPOSITIVO_ALTERACAO, ID_FRASE_SECRETA, IDC_NOTIFICACAO, ID_MOTIVO_BLOQUEIO_OPERADOR, EMAIL_CORPORATIVO, IDC_ADM_LOJA_ONLINE, IDC_SAC_CAD_POSITIVO, IDC_BACKOFFICE_CAD_POSITIVO, IDC_OUVIDORIA_CAD_POSITIVO)"
				+ "VALUES (?,?,?,?, ?,?,?,?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?)";

		PreparedStatement stmt = ConnectionDataBase.getConnection().prepareStatement(sql);
		// Preenche os valores
		stmt.setInt(1, user.getId());
		stmt.setString(2, "USER TESTE");
		stmt.setString(3, "USER.TESTE" + user.getId());

		stmt.setInt(4, 1);
		stmt.setString(5, "S");
		stmt.setString(6, "P");
		stmt.setInt(7, 1);
		stmt.setString(8, "N");
		stmt.setString(9, "S");
		stmt.setString(10, "N");
		stmt.setString(11, "S");
		stmt.setString(12, "S");
		stmt.setString(13, "A");
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		stmt.setDate(14, date);
		stmt.setInt(15, 1);
		stmt.setInt(16, 1);
		stmt.setInt(17, 4721);
		stmt.setString(18, "N");
		stmt.setInt(19, 1);
		stmt.setString(20, "testemail@hotmail.com");
		stmt.setString(21, "S");
		stmt.setString(22, "S");
		stmt.setString(23, "S");
		stmt.setString(24, "S");

		// Executa e fecha
		stmt.execute();
		stmt.close();
		ConnectionDataBase.closeConnection();

		return user;
	}

	public void insertPassWord(int userId) throws SQLException, ClassNotFoundException {

		String sql = " INSERT INTO SPCJAVA.senha_operador (ID, ID_OPERADOR, ID_MEIO_ACESSO, DES_SENHA, NUM_TENTATIVA, DAT_ULTIMA_ALTERACAO)"
				+ "VALUES   (?,?,?,?,?,?)";
		PreparedStatement stmt = ConnectionDataBase.getConnection().prepareStatement(sql);
		stmt.setInt(1, getMaximuIdPassoword() + 1);
		stmt.setInt(2, userId);
		stmt.setInt(3, 1);
		stmt.setString(4, "d00382bb6ce5b77c6886d5b54cdd764c1cbfd31922f4365200022b7330dab2ab");
		stmt.setInt(5, 0);
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		stmt.setDate(6, date);
		// Executa e fecha
		stmt.execute();
		stmt.close();
		ConnectionDataBase.closeConnection();
	}

	public int getMaximuIdPassoword() throws SQLException, ClassNotFoundException {
		Statement statement = ConnectionDataBase.getConnection().createStatement();
		String query = "SELECT MAX(id) from SPCJAVA.senha_operador ";
		ResultSet resultSet = statement.executeQuery(query);
		if (resultSet.next()) {
			System.out.println("resultato =" + resultSet.getInt(1));
			return resultSet.getInt(1);
		}
		return 0;
	}

	public int getMaximuIdUser() throws SQLException, ClassNotFoundException {

		Statement statement = ConnectionDataBase.getConnection().createStatement();
		String query = "SELECT MAX(id) from SPCJAVA.operador ";
		ResultSet resultSet = statement.executeQuery(query);

		if (resultSet.next()) {
			System.out.println("resultato =" + resultSet.getInt(1));
			return resultSet.getInt(1);
		}
		return 0;
	}

	public void updateUserStatus() throws SQLException, ClassNotFoundException {

		String sql = "UPDATE SPCJAVA.SENHA_OPERADOR  SET NUM_TENTATIVA = '0'";
		Statement statement = ConnectionDataBase.getConnection().createStatement();
		statement.executeQuery(sql);
		ConnectionDataBase.closeConnection();

	}

	public void updatePasswordTentative() throws SQLException, ClassNotFoundException {

		String sql = "UPDATE SPCJAVA.OPERADOR SET IDC_STATUS = 'A'";
		Statement statement = ConnectionDataBase.getConnection().createStatement();
		statement.executeQuery(sql);
		ConnectionDataBase.closeConnection();

	}

	public void deleteEmail(String email) throws SQLException , ClassNotFoundException{
		String sql = "DELETE FROM SPCAUT.CAD_LGN where COD_LGN=:LOGIN  ";
		PreparedStatement stmt = ConnectionDataBase.getConnection().prepareStatement(sql);
		stmt.setString(1, email);
		// Executa e fecha
		stmt.execute();
		stmt.close();
		ConnectionDataBase.closeConnection();
	}

}
