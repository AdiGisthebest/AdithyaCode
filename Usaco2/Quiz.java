package myapp;
import java.sql.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.json.simple.parser.*;
import org.json.simple.*;
import javax.sql.DataSource;
import java.util.ArrayList;
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
    public int getQuestionLimit(int quizId) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from quizzes where quizId = ?");
            statement.setInt(1,quizId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt("quizQuestionLimit");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public JSONArray getContent(int quizId) {
        Integer[] arr = this.getQuestions(quizId);
        JSONArray jArr = new JSONArray();
        for(int i = 0; i < arr.length;i++) {
            JSONParser parser = new JSONParser();
            JSONObject jObj = null;
            try {
                jObj =this.getQuestionDetails(arr[i]);
            } catch(Exception e) {
                e.printStackTrace();
            }
            jArr.add(jObj);
        }
        return jArr;
        //resp.getWriter().println(jArr.toString());
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
    public String doJSON(String Json) {
        try {
            JSONParser parse = new JSONParser();
            JSONObject jObj = (JSONObject)parse.parse(Json);
            JSONArray arr = (JSONArray)jObj.get("questions");
            String name = jObj.get("name").toString();
            this.addQuiz(name);
            int quizId = this.getQuizId(name);
            for(int i = 0; i < arr.size(); i ++) {
                System.out.println("inQuestion");
                JSONObject jsonObj = (JSONObject)arr.get(i);
                this.addQuestion(quizId,jsonObj.get("qText").toString(),jsonObj.get("option1").toString(),jsonObj.get("option2").toString(), jsonObj.get("option3").toString(),jsonObj.get("option4").toString(), Integer.valueOf(jsonObj.get("correctOption").toString()));
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public String doJSONUpdate(String Json, int quizId) {
        try {
            if(this.removeAllQuestions(quizId)) {
                JSONParser parse = new JSONParser();
                JSONObject jObj = (JSONObject)parse.parse(Json);
                JSONArray arr = (JSONArray)jObj.get("questions");
                String name = jObj.get("name").toString();
                System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
                this.changeQuizName(quizId,name);
                for(int i = 0; i < arr.size(); i ++) {
                    System.out.println("inside");
                    JSONObject jsonObj = (JSONObject)arr.get(i);
                    this.addQuestion(quizId,jsonObj.get("qText").toString(),jsonObj.get("option1").toString(),jsonObj.get("option2").toString(), jsonObj.get("option3").toString(),jsonObj.get("option4").toString(), Integer.valueOf(jsonObj.get("correctOption").toString()));
                }
                return "success";
            } else {
                return "update failed";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public boolean changeQuizName(int quizId, String name) {
        try {
            PreparedStatement statement = conn.prepareStatement("update quizzes set quizName = ? where quizId = ?");
            statement.setString(1,name);
            statement.setInt(2,quizId);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
            statement.setInt(6,correctOption);
            statement.executeUpdate();
            statement = conn.prepareStatement("select last_insert_id() as num");
            ResultSet rs = statement.executeQuery();
            rs.next();
            int id = rs.getInt("num");
            PreparedStatement statement2 = conn.prepareStatement("insert into quizzesToQuestions (qId,quizId) values (?,?)");
            statement2.setInt(1,id);
            statement2.setInt(2,quizId);
            statement2.executeUpdate();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed from questions");
            return e.getMessage();
        }
    }
    public int getQuestionId(String qText) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from questions where qText = ?");
            statement.setString(1,qText);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt("qId");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public boolean checkQuestion(int qId, int optionNum) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from questions where qId = ?");
            statement.setInt(1,qId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            int num = rs.getInt("correctOption");
            return num == optionNum;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
    public boolean removeAllQuestions(int quizId) {
        try {
            Integer[] qIdArr = this.getAllQuestions(quizId);
            for(int i = 0; i < qIdArr.length; i++) {
                this.removeQuestion(qIdArr[i]);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Integer[] getQuestions(int quizId) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from quizzesToQuestions where quizId = ? limit ?");
            statement.setInt(1,quizId);
            statement.setInt(2,this.getQuestionLimit(quizId));
            ResultSet rs = statement.executeQuery();
            ArrayList<Integer> arr = new ArrayList<>(); 
            while(!rs.isLast()) {
                rs.next();
                arr.add(rs.getInt("qId"));
            }
            Integer[] intArr = new Integer[arr.size()];
            arr.toArray(intArr);
            return intArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Integer[] getAllQuestions(int quizId) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from quizzesToQuestions where quizId = ?");
            statement.setInt(1,quizId);
            ResultSet rs = statement.executeQuery();
            ArrayList<Integer> arr = new ArrayList<>(); 
            while(!rs.isLast()) {
                rs.next();
                arr.add(rs.getInt("qId"));
            }
            Integer[] intArr = new Integer[arr.size()];
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
            jObj.put("qText",rs.getString("qText"));
            jObj.put("correctOption",rs.getString("correctOption"));
            return jObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    public String removeQuiz(int quizId) {
        try {
            if(this.removeAllQuestions(quizId)) {
                PreparedStatement statement = conn.prepareStatement("delete from quizzes where quizId = ?");
                statement.setInt(1,quizId);
                statement.executeUpdate();
                return "success";
            } else {
                return "removal failed";
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public String removeQuestion(int qId) {
        try {
            PreparedStatement statement = conn.prepareStatement("delete from questions where qId = ?");
            PreparedStatement statement2 = conn.prepareStatement("delete from quizzesToQuestions where qId = ?");
            statement.setInt(1,qId);
            statement2.setInt(1,qId);
            statement.executeUpdate();
            statement2.executeUpdate();
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