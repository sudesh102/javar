import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotepadApp extends JFrame implements ActionListener 
{
    private JTextArea textArea;
    private JFileChooser fileChooser;
    public NotepadApp() 
    {
        setTitle("Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        fileChooser = new JFileChooser();
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem exitApp = new JMenuItem("Exit");
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        exitApp.addActionListener(this);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        fileMenu.add(exitApp);
        menuBar.add(fileMenu);
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutText = new JMenuItem("Cut");
        JMenuItem copyText = new JMenuItem("Copy");
        JMenuItem pasteText = new JMenuItem("Paste");
        cutText.addActionListener(this);
        copyText.addActionListener(this);
        pasteText.addActionListener(this);
        editMenu.add(cutText);
        editMenu.add(copyText);
        editMenu.add(pasteText);
        menuBar.add(editMenu);
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutApp = new JMenuItem("About");

        aboutApp.addActionListener(this);

        helpMenu.add(aboutApp);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();

        switch (command) 
	{
            case "New":
                textArea.setText("");
                break;

            case "Open":
                int openChoice = fileChooser.showOpenDialog(this);
                if (openChoice == JFileChooser.APPROVE_OPTION) 
		{
                    File file = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
		    {
                        textArea.read(reader, null);
                    } 
		    catch (IOException ex) 
		    {
                        JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage());
                    }
                }
                break;

            case "Save":
                int saveChoice = fileChooser.showSaveDialog(this);
                if (saveChoice == JFileChooser.APPROVE_OPTION) 
		{
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
		    {
                        textArea.write(writer);
                    } 
		    catch (IOException ex) 
	            {
                        JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
                    }
                }
                break;

            case "Exit":
                int confirmExit = JOptionPane.showConfirmDialog
		(
                        this,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirmExit == JOptionPane.YES_OPTION) 
		{
                    System.exit(0);
                }
                break;

            case "Cut":
                textArea.cut();
                break;

            case "Copy":
                textArea.copy();
                break;

            case "Paste":
                textArea.paste();
                break;

            case "About":
                JOptionPane.showMessageDialog
		(
                        this,
                        "Notepad Application\nVersion 1.0\nDeveloped in Java Swing",
                        "About Notepad",
                        JOptionPane.INFORMATION_MESSAGE
                );
                break;

            default:
                break;
        }
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(NotepadApp::new);
    }
}
