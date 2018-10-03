package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {

    /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
	//LoginServletで使用
    public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            //ハッシュを生成したい元の文字列
            String source = "password";
            //ハッシュ生成前にバイト配列に置き換える際のCharset
            Charset charset = StandardCharsets.UTF_8;
            //ハッシュアルゴリズム
            String algorithm = "MD5";

            //ハッシュ生成処理
            byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
            String passresult = DatatypeConverter.printHexBinary(bytes);

            // SELECT文を準備
            String sql = "SELECT * FROM userdate WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, passresult);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
             //レコードがない場合はnullを返す
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);
            //Userクラスのインスタンスを生成し、生成したインスタンスを返す

        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }


    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    //userListServletで使用
    // ユーザ一覧情報を取得
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM userdate WHERE id != 1";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

    //	ユーザーの詳細情報を出力する
    public User UserDetail(String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT login_id,name,birth_date,create_date,update_date FROM userdate WHERE id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
             //レコードがない場合はnullを返す
            if (!rs.next()) {
                return null;
            }

            String loginIdDate = rs.getString("login_id");
            String nameDate = rs.getString("name");
            Date birthDate = rs.getDate("birth_date");
            String createDate = rs.getString("create_date");
            String updateDate = rs.getString("update_date");
            return new User(loginIdDate, nameDate, birthDate, createDate, updateDate);
            //Userクラスのインスタンスを生成し、生成したインスタンスを返す

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
    //	ユーザーの新規登録を行う
    public boolean SignUpUser(String loginId, String username, String birthday, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            //ハッシュを生成したい元の文字列
            String source = "password";
            //ハッシュ生成前にバイト配列に置き換える際のCharset
            Charset charset = StandardCharsets.UTF_8;
            //ハッシュアルゴリズム
            String algorithm = "MD5";

            //ハッシュ生成処理
            byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
            String passresult = DatatypeConverter.printHexBinary(bytes);

            // INSERT文を準備
            String sql = "INSERT INTO userdate (login_id, name, birth_date, password, create_date, update_date) VALUES (?,N?,?,?,now(),now())";

             // INSERT文を実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, username);
            pStmt.setString(3, birthday);
            pStmt.setString(4, passresult);

            int result = pStmt.executeUpdate();

            //PreparedStatementでは後から?に割り当てるので、（）の中にSQLはいらない！→SQL文がそのまま実行されてしまう、
            pStmt.close();
            return true;


        } catch (SQLException | NoSuchAlgorithmException e) {
        	e.printStackTrace();
        	return false;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }

    }
    //	ユーザー情報の更新を行う
    public boolean UserUpdate(String loginId, String username, String birthday, String password,String passwordConf) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            if((!password.equals("")) && (!passwordConf.equals(""))) {
            	String sql = "UPDATE userdate SET name=?, birth_date=?, update_date=now() WHERE login_id=?";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, username);
                pStmt.setString(2, birthday);
                pStmt.setString(3, loginId);

                int result = pStmt.executeUpdate();
                pStmt.close();

            } else {

            //ハッシュを生成したい元の文字列
            String source = "password";
            //ハッシュ生成前にバイト配列に置き換える際のCharset
            Charset charset = StandardCharsets.UTF_8;
            //ハッシュアルゴリズム
            String algorithm = "MD5";

            //ハッシュ生成処理
            byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
            String passresult = DatatypeConverter.printHexBinary(bytes);


            // INSERT文を準備
            String sql = "UPDATE userdate SET name=?, birth_date=?, password=?, update_date=now() WHERE login_id=?";

             // INSERT文を実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, username);
            pStmt.setString(2, birthday);
            pStmt.setString(3, passresult);
            pStmt.setString(4, loginId);

            int result = pStmt.executeUpdate();



            //PreparedStatementでは後から?に割り当てるので、（）の中にSQLはいらない！→元のSQL文がそのまま実行されてしまう、

            pStmt.close();
            }
            return true;




        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
    }
    //	ユーザー情報の削除を行う
    public void UserDelete(String loginId) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // INSERT文を準備
            String sql = "DELETE FROM userdate WHERE login_id=?";

             // INSERT文を実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);


            int result = pStmt.executeUpdate();

            //PreparedStatementでは後から?に割り当てるので、（）の中にSQLはいらない！→元のSQL文がそのまま実行されてしまう、

            pStmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //	ユーザー一覧でユーザー情報の検索を行う

    public List<User> SearchUser(String loginid, String username, String birthfrom, String birthto) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();
        try {
            // データベースへ接続

            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM userdate WHERE login_id not in ('admin')";

            if(!loginid.equals("")) {
            	sql += " AND login_id = " + "'" + loginid + "'";
            }

            if(!username.equals("")) {
            	sql += " AND name LIKE " + "'" + '%' + username + '%' + "'";
            }
            if(!birthfrom.equals("")) {
            	sql += " AND birth_date >= " + "'" + birthfrom + "'";
            }
            if(!birthto.equals("")) {
            	sql += " AND birth_date < " + "'" + birthto + "'";
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }


        } catch (SQLException e) {
        	e.printStackTrace();
        return null;
        } finally {
        	// データベース切断
        	if (conn != null) {
        		try {
        			conn.close();
        		} catch (SQLException e) {
        			e.printStackTrace();
        			return null;
        		}
        	}
        }
        return userList;
    }
}
