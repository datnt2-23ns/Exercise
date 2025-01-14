package View;

import java.awt.*;
import javax.swing.*;
import Controller.Controller;
import java.io.File;

public class View extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private JButton openButton;
    private JButton saveButton;
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Text Editor");
        setSize(600, 400);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        openButton = new JButton("Open");
        saveButton = new JButton("Save");
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        openButton.addActionListener(e -> controller.openButtonClicked());
        saveButton.addActionListener(e -> controller.saveButtonClicked());
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public File showOpenDialog() {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public File showSaveDialog() {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}