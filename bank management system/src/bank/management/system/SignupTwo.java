
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
       setTitle("NEW ACCOUNT APPLICATION FORM");
       
         JLabel additionalDetails = new JLabel("Additional Details - Page 2");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
         JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100, 140, 100, 30);
        add(rel);
        String valReligion[] = {"Hindu", "Muslim","Sikh","Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100, 190, 200, 30);
        add(cat);
         String valcategory[] = {"General", "OBC", "ST", "SC", "Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
         category.setBackground(Color.WHITE);
        add(category);
        
         JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100, 240, 200, 30);
        add(inc);
        String incomecategory[] = {"NULL", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
         income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel edu = new JLabel("Educational:");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);
        
         JLabel qual = new JLabel("Qualification:");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100, 315, 200, 30);
        add(qual);
         String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctrate", "Other"};
         education= new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
         education.setBackground(Color.WHITE);
        add(education);
        
         JLabel  occup= new JLabel("Occupation:");
        occup.setFont(new Font("Raleway", Font.BOLD, 20));
        occup.setBounds(100, 390, 200, 30);
        add(occup);
        String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Other"};
        occupation= new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
         occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
         JLabel pno = new JLabel("PAN Number:");
        pno.setFont(new Font("Raleway", Font.BOLD, 20));
        pno.setBounds(100, 440, 200, 30);
        add(pno);
        pan = new JTextField();
        pan.setFont(new Font("Raieway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
         JLabel ano = new JLabel("Aadhar Number:");
       ano.setFont(new Font("Raleway", Font.BOLD, 20));
       ano.setBounds(100, 490, 200, 30);
        add(ano);
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel sc = new JLabel("Senior Citizen:");
       sc.setFont(new Font("Raleway", Font.BOLD, 20));
       sc.setBounds(100, 540, 200, 30);
        add(sc);
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup seniorcitizen = new ButtonGroup();
        seniorcitizen.add(syes);
        seniorcitizen.add(sno);
        
        JLabel ea = new JLabel("Existing Account:");
       ea.setFont(new Font("Raleway", Font.BOLD, 20));
       ea.setBounds(100, 590, 200, 30);
        add(ea);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup existingaccount = new ButtonGroup();
        existingaccount.add(eyes);
        existingaccount.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
  setSize(850, 800);
  setLocation(350, 10);
  setVisible(true);
}
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String srcitizen = null;
        if(syes.isSelected()) {
            srcitizen = "Yes";
        } else if(sno.isSelected()) {
            srcitizen = "No";
        }
        

        String existingAcc =null;
        if(eyes.isSelected()) {
            existingAcc = "Yes";
        } else if(eno.isSelected()) {
            existingAcc = "No";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();
      
        try{
         
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+srcitizen+"', '"+existingAcc+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        } catch(Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
