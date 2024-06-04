import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class AWTEmail{
    AWTEmail(){
        Frame f = new Frame();
        Label company = new Label("Yodaplus");
        Label first_name = new Label("First Name: ");
        Label last_name = new Label("Last Name: ");
        Label age = new Label("Age: ");
        Button b = new Button("Submit");
        Button copy = new Button("Copy");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();

        company.setBounds(200, 50, 80, 30);
        first_name.setBounds(20, 100, 80, 30);
        t1.setBounds(100, 100, 80, 30);
        last_name.setBounds(20, 140, 80, 30);
        t2.setBounds(100, 140, 80, 30);
        age.setBounds(20, 180, 80, 30);
        t3.setBounds(100, 180, 80, 30);
        t4.setBounds(130, 220, 80, 30);
        b.setBounds(30, 250, 80, 30);
        copy.setBounds(120, 340, 80, 30);

        f.add(company);
        f.add(first_name);
        f.add(t1);
        f.add(last_name);
        f.add(t2);
        f.add(age);
        f.add(t3);
        f.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().isEmpty() || t2.getText().isEmpty() | t3.getText().isEmpty()){
                    Label error = new Label("Error: Empty fields");
                    error.setBounds(120, 250, 150, 30);
                    f.add(error);
                } else {
                    String first = t1.getText();
                    String last = t2.getText();
                    Label emailFinal = new Label(first + "." + last + "@yodaplus.com");
                    emailFinal.setBounds(20, 290, 250, 30);
                    f.add(emailFinal);

                    String chars = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890"
                            + "!@#$%^&*()_-";
                    Random rand = new Random();
                    StringBuilder sb = new StringBuilder(10);
                    for (int i = 0; i < 10; i++) {
                        sb.append(chars.charAt(rand.nextInt(chars.length())));
                    }
                    t4.setText(sb.toString());
                    t4.setBounds(30, 340, 80, 30);
                    f.add(t4);
                    f.add(copy);
                }
            }
        });

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(t4.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });

        f.setSize(600,600);
        f.setTitle("Employee Info");
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void email_password_generator (String args[]){
        AWTEmail awt_obj = new AWTEmail();
    }
}