import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResumeGenerator extends JFrame {
    private JTextField nameField, emailField, experienceField, skillsField, genderField, phoneNumberField;

    public ResumeGenerator() {
        // Set up the JFrame
        setTitle("Resume Generator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel experienceLabel = new JLabel("Experience:");
        JLabel skillsLabel = new JLabel("Skills:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        experienceField = new JTextField(20);
        skillsField = new JTextField(20);
        genderField = new JTextField(20);
        phoneNumberField = new JTextField(20);

        JButton saveButton = new JButton("Save");
        JButton resetButton = new JButton("Reset");
        JButton downloadButton = new JButton("Download Resume");

        // Set up layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridy = 1;
        panel.add(emailLabel, gbc);

        gbc.gridy = 2;
        panel.add(experienceLabel, gbc);

        gbc.gridy = 3;
        panel.add(skillsLabel, gbc);

        gbc.gridy = 4;
        panel.add(genderLabel, gbc);

        gbc.gridy = 5;
        panel.add(phoneNumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);

        gbc.gridy = 1;
        panel.add(emailField, gbc);

        gbc.gridy = 2;
        panel.add(experienceField, gbc);

        gbc.gridy = 3;
        panel.add(skillsField, gbc);

        gbc.gridy = 4;
        panel.add(genderField, gbc);

        gbc.gridy = 5;
        panel.add(phoneNumberField, gbc);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(downloadButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners for the buttons
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveResume();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadResume();
            }
        });
    }

    private void saveResume() {
        // Perform actions when Save button is clicked
        JOptionPane.showMessageDialog(this, "Resume saved successfully!", "Save", JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetFields() {
        // Perform actions when Reset button is clicked
        nameField.setText("");
        emailField.setText("");
        experienceField.setText("");
        skillsField.setText("");
        genderField.setText("");
        phoneNumberField.setText("");
    }

    private void downloadResume() {
        // Get user input
        String name = nameField.getText();
        String email = emailField.getText();
        String experience = experienceField.getText();
        String skills = skillsField.getText();
        String gender = genderField.getText();
        String phoneNumber = phoneNumberField.getText();

        // Generate resume text
        String resumeText = "Resume\n\n";
        resumeText += "Name: " + name + "\n";
        resumeText += "Email: " + email + "\n";
        resumeText += "Experience: " + experience + "\n";
        resumeText += "Skills: " + skills + "\n";
        resumeText += "Gender: " + gender + "\n";
        resumeText += "Phone Number: " + phoneNumber + "\n";

        // Save resume text to a file
        saveToFile(resumeText, "resume.txt");

        // Inform the user about the download
        JOptionPane.showMessageDialog(this, "Resume downloaded successfully!", "Download",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveToFile(String resumeText, String fileName) {
        try {
            // Get the user's home directory
            String userHome = System.getProperty("user.home");

            // Specify the path where the file will be saved (on the desktop)
            String filePath = userHome + "\\Desktop\\" + fileName;

            // Create a BufferedWriter
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            // Write the resume text to the file
            writer.write(resumeText);

            // Close the writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving resume to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResumeGenerator().setVisible(true);
            }
        });
    }
}
