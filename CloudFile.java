package myapp;
import java.sql.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.json.simple.parser.*;
import org.json.simple.*;
import javax.sql.DataSource;
class Quiz {
    Connection conn;
    String url;
    public Quiz() {
        try {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(String.format("jdbc:mysql:///%s", "courseSchema"));
            config.setUsername("root");
            config.setPassword("Adithya");
            config.addDataSourceProperty("socketFactory", "com.google.cloud.sql.mysql.SocketFactory");
            config.addDataSourceProperty("cloudSqlInstance", "psyched-bonfire-317319:us-central1:curso");
            config.addDataSourceProperty("ipTypes", "PUBLIC");
            DataSource pool = new HikariDataSource(config);
            conn = pool.getConnection();
            /*Class.forName("com.mysql.jdbc.GoogleDriver");
            url = "jdbc:mysql:///courseSchema?cloudSqlInstance=psyched-bonfire-317319:us-central1:curso&user=root&password=Adithya";
            conn = DriverManager.getConnection(url);*/
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
    public String addQuiz(String quizName) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into quizzes (quizName) values (?)");
            statement.setString(1,quizName);
            statement.executeUpdate();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public String addQuestion(int quizId, String questionText, String option1, String option2,String option3, String option4, int correctOption) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into questions(qText,option1,option2,option3,option4,correctOption) values (?,?,?,?,?,?)");
            statement.setString(1,questionText);
            statement.setString(2,option1);
            statement.setString(3,option2);
            statement.setString(4,option3);
            statement.setString(5,option4);
            statement.executeUpdate();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public int getQuizId(String quizName) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from quizzes where quizName = ?");
            statement.setString(1,quizName);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt("quizId");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int[] getQuestions(int quizId) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from quizzesToQuestions where quizId = ? limit 5");
            statement.setInt(1,quizId);
            ResultSet rs = statement.executeQuery();
            ArrayList<Integer> arr = new ArrayList<>();
            while(!rs.isLast()) {
                rs.next();
                arr.add(rs.getInt("qId"));
            }
            int[] intArr = new int[arr.size()];
            arr.toArray(intArr);
            return intArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int[] getAllQuestions(int quizId) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from quizzesToQuestions where quizId = ?");
            statement.setInt(1,quizId);
            ResultSet rs = statement.executeQuery();
            ArrayList<Integer> arr = new ArrayList<>();
            while(!rs.isLast()) {
                rs.next();
                arr.add(rs.getInt("qId"));
            }
            int[] intArr = new int[arr.size()];
            arr.toArray(intArr);
            return intArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public JSONObject getQuestionDetails(int qId) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from questions where qId = ?");
            statement.setInt(1,qId);
            JSONObject jObj = new JSONObject();
            ResultSet rs = statement.executeQuery();
            rs.next();
            jObj.put("qId",qId);
            jObj.put("option1",rs.getString("option1"));
            jObj.put("option2",rs.getString("option2"));
            jObj.put("option3",rs.getString("option3"));
            jObj.put("option4",rs.getString("option4"));
            jObj.put("correctOption",rs.getString("correctOption"));
            int[] intArr = new int[arr.size()];
            return jObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String removeQuiz(int quizId) {
        try {
            int[] qIdArr = this.getAllQuestions(quizId);
            for(int i = 0; i < qIdArr.length; i++) {
                this.removeQuestion(qIdArr[i]);
            }
            PreparedStatement statement = conn.prepareStatement("delete from questions where qId = ?");
            statement.setInt(1,qId);
            statement.executeUpdate();
            return "success";
        } catch(Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public String removeQuestion(int qId) {
        try {
            PreparedStatement statement = conn.prepareStatement("delete from questions where qId = ?");
            statement.setInt(1,qId);
            statement.executeUpdate();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public String close() {
        try {
            conn.close();
            return "success";
        } catch (Exception e) {
            return "-1" + e.getMessage();
        }
    }
}
