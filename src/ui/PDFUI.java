package ui;

import javax.swing.*;

public class PDFUI {
    private JFrame frame = new JFrame("PDF工具");
    private JPanel JPanel1;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JRadioButton DSRadioButton;
    private JRadioButton IDRadioButton;
    private JRadioButton MDRadioButton;
    private JRadioButton OMRadioButton;
    private JRadioButton VDRadioButton;
    private JRadioButton CSRadioButton;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;

    public PDFUI() {

    }


    public void init() {
        JFrame frame = new JFrame("PDFUI");
        frame.setContentPane(new PDFUI().JPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 250);
        frame.setLocation(600, 200);
        frame.setVisible(true);
        ButtonGroup group = new ButtonGroup();
        group.add(this.DSRadioButton);
        group.add(this.IDRadioButton);
        group.add(this.MDRadioButton);
        group.add(this.OMRadioButton);
        group.add(this.VDRadioButton);
        group.add(this.CSRadioButton);
    }

    public static void main(String[] args) {
        PDFUI ui = new PDFUI();
        ui.init();

    }
}
