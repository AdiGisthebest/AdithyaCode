import java.util.*;
import java.text.*;
import javax.mail.internet.*;
import javax.mail.*;
import javax.activation.*;
import org.apache.commons.mail.*;
class Manager {
  LL tasks = new LL();
  public void add(String due, String task) {
    SimpleDateFormat hi = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
    Date duedate = new Date();
    try {
      duedate = hi.parse(due.trim());
    } catch(Exception e) {
      System.out.println("Enter date in yyyy-MM-dd-hh-mm format");
      System.exit(-1);
    }
    Task todo = new Task(duedate,task);
    Node find = tasks.head;
    int index = 0;
    if (tasks.length != 0) {
      while (find.next != null && duedate.compareTo(find.next.val.due) > 0) {
        find = find.next;
      }
      if(index == 0) {
        Node add = new Node(todo);
        add.next = tasks.head;
        tasks.head = add;
      } else {
        tasks.add(todo,index-1);
      }
    } else {
      tasks.add(todo);
    }
  }
  public void del(String Task) {
    Node find = tasks.head;
    tasks.length--;
    for (int i = 0; i < tasks.length; i++) {
      if (find.val.task.equals(Task) && find.next != tasks.tail) {
        find.val = find.next.val;
        find.next = find.next.next;
      } else if (find.next == tasks.tail) {
        find.next = null;
        tasks.tail = find;
        break;
      } else {
        find = find.next;
      }
    }
  }
  public void store() {
    Node find = tasks.head;
    Datatofile file = new Datatofile();
    SimpleDateFormat hi = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
    for (int i = 0; i < tasks.length; i++) {
      file.fileWrite(find.val.task, hi.format(find.val.due));
      find = find.next;
    }
  }
  public void check() {
    Date current = new Date();
    Node find = tasks.head;
    //for (int i = 0; i < tasks.length; i++) {
      //if (find.val.due.getTime() + 86400 >= current.getTime()) {
        /*String sender = "incredibleatha2@gmail.com";
        String me = "incredibleatha2@gmail.com";
        String host = "Smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(prop);
        try {
          MimeMessage mime = new MimeMessage(session);
          mime.setFrom(new InternetAddress(sender));
          mime.addRecipient(Message.RecipientType.TO, new InternetAddress(me));
          mime.setSubject("Alert");
          mime.setText("task is due soon");
          Transport.send(mime);
          System.out.println("Message sent");
        } catch (Exception e) {
          e.printStackTrace();
        }*/
        try{
          Email email = new SimpleEmail();
          email.setHostName("smtp.googlemail.com");
          email.setSmtpPort(465);
          email.setAuthenticator(new DefaultAuthenticator("367099@cusdk8.org".trim(),"Nine97rose".trim()));
          email.setSSLOnConnect(true);
          email.setFrom("367099@cusdk8.org");
          email.setSubject("Computer");
          email.setMsg("This is me");
          email.addTo("incredibleatha2@gmail.com");
          email.send();
        } catch (Exception e) {
          e.printStackTrace();
        }
        //find = find.next;
    //  } else {
    //    break;
    //  }
    //}
  }
  public static void main(String[] args) {
    Manager hi2 = new Manager();
    hi2.check();
    Scanner n = new Scanner(System.in);
    System.out.println("Add or delete task");
    String hi = n.next();
    String task;
    String due;
    if (hi.trim().equals("add")) {
      System.out.println("Task to add");
      task = n.next();
      System.out.println("Due date in yyyy-MM-dd-hh-mm format");
      due = n.next();
      hi2.add(due, task);
    } else if (hi.trim() == "delete") {
      System.out.println("Task to delete");
      task = n.next();
      hi2.del(task);
    }
  }
}
