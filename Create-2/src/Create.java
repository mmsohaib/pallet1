
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hilton
 */
public class Create extends JFrame
{

    private String dataType;

    private JPanel dataBossPanel;
    private JPanel dataTypePanel;
    private JPanel centerPanel;
    private JPanel finishPanel;
    private JPanel westPanel;
    private JPanel examplePanel;
    private JPanel languagePanel;
    private JPanel dataCatPanel;
    private JComboBox languageComboBox;

    private JLabel layer;
    private JLabel toolTip;
    private JLabel textLabel;
    private String icon;

    private JTextField langField;
    private JComboBox dataCatComboBox;
    private JComboBox dataTypeComboBox;

    private JButton finishButton;
    private JButton cancelButton;
    private JButton exampleButton;
    private JTextArea codePad;
    private JTextArea toolTipText;

    private static final int Frame_Width = 700;
    private static final int Frame_Heigth = 600;

    public Create()
    {

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("Create");
        setMinimumSize(new Dimension(700, 400));
        setSize(Frame_Width, Frame_Heigth);

        dataType = "";

        //LABEL AND AGE---> Will set the method getText() to save input
//LABEL AND AGE---> Will set the method getText() to save input
        layer = new JLabel("Programming Language: ");
        languageComboBox = new JComboBox();
        languageComboBox.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXX");
        languageComboBox.addItem("C or C++");
        languageComboBox.addItem("Java");
        languageComboBox.addItem("Python");
        languageComboBox.addItem("Go");
        languageComboBox.addItem("PHP");
        languageComboBox.addItem("Perl");

        languagePanel = new JPanel();
        languagePanel.add(layer);
        languagePanel.add(languageComboBox);

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new EtchedBorder());
        topPanel.setLayout(new GridLayout(2, 0));
        topPanel.add(languagePanel);
        add(topPanel, BorderLayout.NORTH);

//Data Category
        dataCatComboBox = new JComboBox();
        dataCatComboBox.setEditable(true);
        dataCatComboBox.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXX");
        dataCatComboBox.addItem("Collection");
        dataCatComboBox.addItem("Comments");
        dataCatComboBox.addItem("Data Structure");
        dataCatComboBox.addItem("List");
        dataCatComboBox.addItem("Decisions");
        dataCatComboBox.addItem("Input/Output");
        dataCatComboBox.addItem("Loops");
        dataCatComboBox.addItem("Objects/Class/Method");
        dataCatComboBox.addItem("Variable");

        dataCatPanel = new JPanel();
        dataCatPanel.setBorder(new TitledBorder(new EtchedBorder(), "Data Category"));
        dataCatPanel.add(dataCatComboBox);

//Data TYPE
        dataTypeComboBox = new JComboBox();
        dataTypeComboBox.setEditable(true);
        dataTypeComboBox.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXX");
        dataTypeComboBox.addItem("ArrayList");
        dataTypeComboBox.addItem("Array");
        dataTypeComboBox.addItem("HashMap");
        dataTypeComboBox.addItem("HashSet");
        dataTypeComboBox.addItem("TreeMap");
        dataTypeComboBox.addItem("TreeSet");
        dataTypeComboBox.addItem("LinkedList");
        dataTypeComboBox.addItem("Queues");
        dataTypeComboBox.addItem("Stacks");
        dataTypeComboBox.addItem("2-D Arrays");

        dataTypePanel = new JPanel();
        dataTypePanel.setBorder(new TitledBorder(new EtchedBorder(), "Data Type"));
        dataTypePanel.add(dataTypeComboBox);

        dataBossPanel = new JPanel();
        dataBossPanel.setLayout(new GridLayout(2, 0));
        dataBossPanel.add(dataCatPanel);
        dataBossPanel.add(dataTypePanel);

        ActionListener comboListener = new ComboBoxListener();
        dataCatComboBox.addActionListener(comboListener);

//TextArea
        codePad = new JTextArea(20, 30);
        JScrollPane scroll = new JScrollPane(codePad, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        codePad.setEditable(true);

        JPanel codePadPanel = new JPanel();
        JPanel codeTextPanel = new JPanel();
        JPanel toolTipPanel = new JPanel();

        codePadPanel.add(codeTextPanel);
        topPanel.add(toolTipPanel);
        //codePadPanel.setBorder(new EtchedBorder()); //border of control padPanel
        //code.add(textLabel);
        codeTextPanel.add(scroll);
        codeTextPanel.setBorder(new TitledBorder(new EtchedBorder(), "Java Text Editor: "));

        add(codePadPanel, BorderLayout.CENTER);
        codePadPanel.setLayout(new GridLayout(1, 0));
        codeTextPanel.setLayout(new GridLayout(1, 0));

        // Tool Tip
        toolTip = new JLabel("          Tool Tip:       ");

        toolTipText = new JTextArea(1, 30);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        toolTipText.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        //tool.setBorder(new TitledBorder(new EtchedBorder(), "Java Text Editor: "));
        toolTipPanel.add(toolTip);
        toolTipPanel.add(toolTipText);
// EXAMPLE BUTTON

        exampleButton = new JButton("Show Example");
        ActionListener exampleListner = new ExampleButtonListner();
        exampleButton.addActionListener(exampleListner);

        examplePanel = new JPanel();
        examplePanel.add(exampleButton);
        add(examplePanel, BorderLayout.SOUTH);

// CANCEL BUTTON
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.cyan);
        ActionListener cancelListner = new CancelButtonListner();
        cancelButton.addActionListener(cancelListner);

//FINISH BUTTON
        finishButton = new JButton("Finish");
        finishButton.setBackground(Color.white);

        finishPanel = new JPanel();
        finishPanel.add(cancelButton);
        finishPanel.add(examplePanel);
        finishPanel.add(Box.createHorizontalStrut(330));
        finishPanel.add(finishButton);

        add(finishPanel, BorderLayout.PAGE_END);
        ActionListener finishListener = new FinishButtonListener();
        finishButton.addActionListener(finishListener);

//********************************************************//
        //West PANEL
        westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(1, 2));
        westPanel.add(dataBossPanel);
        add(westPanel, BorderLayout.WEST);

        // CENTER PANEL    
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 1));
        centerPanel.add(codePadPanel);
        add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * @return the language
     */
    public String languageName()
    {
        return (String) languageComboBox.getSelectedItem();
    }

    public String toolTipGetter()
    {
        return toolTipText.getText();
    }

    /**
     * @return
     */
    public String getChosenCourse()
    {
        return (String) dataTypeComboBox.getSelectedItem();
    }

//Example Button Listner
    class ExampleButtonListner implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JLabel label = new JLabel("Example");
            JTextArea exampleTextArea = new JTextArea(300, 400);
            exampleTextArea.setEditable(true);
            String text = "package org.netbeans.modules.multilangsourcefilepalette.java;\n"
                    + "\n"
                    + "import javax.swing.DefaultComboBoxModel;\n"
                    + "import javax.swing.text.BadLocationException;\n"
                    + "import javax.swing.text.JTextComponent;\n"
                    + "import org.netbeans.modules.multilangsourcefilepalette.CodeParser;\n"
                    + "import org.netbeans.modules.multilangsourcefilepalette.PaletteUtilities;\n"
                    + "import org.netbeans.modules.multilangsourcefilepalette.Customizer.*;\n"
                    + "import org.openide.text.ActiveEditorDrop;\n"
                    + "\n"
                    + "public class ArrayLists implements ActiveEditorDrop {\n"
                    + "\n"
                    + "    private Customizer c;\n"
                    + "    private ComboFieldFieldField cfffPanel;\n"
                    + "    private String comment = \"\";\n"
                    + "    private String name = \"\";\n"
                    + "    private String type = \"\";\n"
                    + "    private String size = \"\";\n"
                    + "\n"
                    + "    private String createBody() {\n"
                    + "        String body = \"\";\n"
                    + "        if (!comment.isEmpty()) {\n"
                    + "            body += String.format(\"// %s\\n\", comment);\n"
                    + "        }\n"
                    + "        if (name.isEmpty()) return \"\"; \n"
                    + "        body += String.format(\"ArrayList<%s> %s = new ArrayList<>(%s);\", type,\n"
                    + "                name, size);\n"
                    + "        return body;\n"
                    + "    }\n"
                    + "\n"
                    + "    @Override\n"
                    + "    public boolean handleTransfer(JTextComponent targetComponent) {\n"
                    + "        c = new Customizer(targetComponent);\n"
                    + "        cfffPanel = new ComboFieldFieldField(ComboFieldFieldField.TWO_FIELDS);\n"
                    + "        c.setDescriptionText(\"An ArrayList is a resizable array.\");\n"
                    + "        c.setExampleText(\"// Your comment\\nArrayList<Integer> foo = \"\n"
                    + "                + \"new ArrayList<>()\"\n"
                    + "                + \"\\nArrayList<String> foo = new ArrayList<>(10);\"\n"
                    + "                + \"\\nArrayList<Double> foo = new ArrayList<>()\");\n"
                    + "        cfffPanel.getjLabel1().setText(\"Type: \");\n"
                    + "        cfffPanel.getjLabel2().setText(\"Name: \");\n"
                    + "        cfffPanel.getjLabel3().setText(\"Size: \");\n"
                    + "        cfffPanel.getjComboBox1().setModel(new DefaultComboBoxModel<>(\n"
                    + "                new String[]{\"Integer\", \"String\", \"Character\", \"Double\", \n"
                    + "                \"Boolean\"}));\n"
                    + "        c.addPanel(cfffPanel);\n"
                    + "        boolean accept = c.showDialog();\n"
                    + "        if (accept) {\n"
                    + "            comment = c.getComment();\n"
                    + "            type = cfffPanel.getjComboBox1Text();\n"
                    + "            name = cfffPanel.getjTextField1Text();\n"
                    + "            size = cfffPanel.getjTextField2Text();      \n"
                    + "            String body = createBody();\n"
                    + "            try {\n"
                    + "                PaletteUtilities.insert(body, targetComponent);\n"
                    + "            } catch (BadLocationException ble) {\n"
                    + "                accept = false;\n"
                    + "            }\n"
                    + "            try {\n"
                    + "                CodeParser.checkImports(targetComponent, \"import java.util.ArrayList;\", \"java\");\n"
                    + "            } \n"
                    + "            catch (BadLocationException ble) \n"
                    + "            {\n"
                    + "            }\n"
                    + "        }\n"
                    + "        return accept;\n"
                    + "    }\n"
                    + "} ";
            exampleTextArea.setText(text);
            JScrollPane scroll = new JScrollPane(exampleTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 0));
            panel.add(exampleTextArea);
            //panel.add(scroll);

            add(panel, BorderLayout.CENTER);

            JFrame frame = new JFrame("Show Example");
            frame.add(panel);
            frame.setSize(600, 700);
            frame.setVisible(true);
        }
    }

    class ComboBoxListener implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            if (dataCatComboBox.getSelectedItem().toString().equals("Collection"))
            {
                dataType = "Collection";
                dataTypeComboBox.setModel(new DefaultComboBoxModel(new String[]
                {
                    "ArrayList", "Array", "HashMap",
                    "HashSet", "TreeMap", "TreeSet", "LinkedList", "List", "Queues", "Stacks", "2-D Arrays"
                }));
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Comments"))
            {
                dataType = "Comments";
                dataTypeComboBox.setModel(new DefaultComboBoxModel(new String[]
                {
                    "Inline Comment", "MultiLine Comment"
                }));
                dataTypeComboBox.getSelectedItem().toString();
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Data Structure"))
            {
                dataType = "DataStructure";
                dataTypeComboBox.setModel(new DefaultComboBoxModel(new String[]
                {
                    "ArrayList", "Array", "HashMap",
                    "HashSet", "TreeMap", "TreeSet", "LinkedList", "List", "Queues", "Stacks", "2-D Arrays"
                }));
            } else if (dataCatComboBox.getSelectedItem().toString().equals("List"))
            {
                dataType = "List";
                dataTypeComboBox.setModel(new DefaultComboBoxModel(new String[]
                {
                    "ArrayList", "LinkedLsit", "Queues"
                }));
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Decisions"))
            {
                dataType = "Decisions";
                dataTypeComboBox.setModel(new DefaultComboBoxModel(new String[]
                {
                    "Else", "Else If", "If", "Switch Block"
                }));
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Input/Output"))
            {
                dataType = "Input/Output";
                dataTypeComboBox.setModel(new DefaultComboBoxModel(new String[]
                {
                    "File", "PrintWriter", "Input Scanner", "Send Text To Console", "Try Catch"
                }));
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Loops"))
            {
                dataType = "Loops";
                dataTypeComboBox.setModel(new DefaultComboBoxModel(new String[]
                {
                    "Do While", "For Each", "For Loop", "While"
                }));
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Objects/Class/Method"))
            {
                dataType = "Objects/Class/Method";
                dataTypeComboBox.setModel(new DefaultComboBoxModel(new String[]
                {
                    "Main Method", "Method", "New Method", "New Object"
                }));
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Variable"))
            {
                dataType = "Variable";
                dataTypeComboBox.setModel(new DefaultComboBoxModel(new String[]
                {
                    "Variable"
                }));
            }
        }
    }

    class CancelButtonListner implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }

    class FinishButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            createDirectories(capFirstLetter(languageName()));
            createIndividualXML(capFirstLetter(languageName()), getChosenCourse(), toolTipGetter());

            if (dataCatComboBox.getSelectedItem().toString().equals("Collection"))
            {
                dataType = "Collection";
                icon = "array16";
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Comments"))
            {
                dataType = "Comments";
                icon = "comment16";
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Data Structure"))
            {
                dataType = "DataStructure";
                icon = "array16";
            } else if (dataCatComboBox.getSelectedItem().toString().equals("List"))
            {
                dataType = "List";
                icon = "array16";
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Decisions"))
            {
                dataType = "Decisions";
                icon = "component16";
            } else if (dataCatComboBox.getSelectedItem().toString().equals("InputOutput"))
            {
                dataType = "InputOutput";
                icon = "Item16";
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Loops"))
            {
                dataType = "Loops";
                icon = "loop16";
            } else if (dataCatComboBox.getSelectedItem().toString().equals("ObjectsClassesMethods"))
            {
                dataType = "ObjectsClassesMethods";
                icon = "Item16";
            } else if (dataCatComboBox.getSelectedItem().toString().equals("Variables"))
            {
                dataType = "Variables";
                icon = "object16";
            }

            String javaType = dataTypeComboBox.getSelectedItem().toString();
            System.out.println(dataType);
            System.out.println(javaType);
        }
    }

    public static void createIndividualXML(String language, String dataype, String toolTip)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element bossElement = document.createElement("editor_palette_item");
            document.appendChild(bossElement);

            Element classElement = document.createElement("class");
            Element icon16 = document.createElement("icon16");
            Element icon32 = document.createElement("icon32");
            Element inlineDescription = document.createElement("inline-description");

            Element displayName = document.createElement("display-name");
            Element toolTipElement = document.createElement("tooltip");

            inlineDescription.appendChild(displayName);
            inlineDescription.appendChild(toolTipElement);

            bossElement.appendChild(classElement);
            bossElement.appendChild(icon16);
            bossElement.appendChild(icon32);
            bossElement.appendChild(inlineDescription);

            Attr bossElementAttr = document.createAttribute("version");
            bossElementAttr.setValue("1.1");
            Attr classElementAttr = document.createAttribute("name");
            classElementAttr.setValue("org.netbeans.modules.multilangsourcefilepalette." + language + "." + dataype);
            Attr icon16Attr = document.createAttribute("url");
            icon16Attr.setValue("org/netbeans/modules/multilangsourcefilepalette/icons/array16.png");
            Attr icon32Attr = document.createAttribute("url");
            icon32Attr.setValue("org/netbeans/modules/multilangourcefilepalette/icons/BR32.png");

            bossElement.setAttributeNode(bossElementAttr);
            classElement.setAttributeNode(classElementAttr);
            icon16.setAttributeNode(icon16Attr);
            icon32.setAttributeNode(icon32Attr);

            Text displayNameText = document.createTextNode(dataype);
            displayName.appendChild(displayNameText);
            Text toolTipText = document.createTextNode(toolTip);
            toolTipElement.appendChild(toolTipText);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            DOMImplementation domImpl = document.getImplementation();
            DocumentType documentType = domImpl.createDocumentType("doctype",
                    "-//NetBeans//Editor Palette Item 1.1//EN",
                    "https://netbeans.org/dtds/editor-palette-item-1_1.dtd");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, documentType.getPublicId());
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, documentType.getSystemId());
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            StreamResult streamResult = new StreamResult(new File(language + "/XML/" + dataype + ".xml"));
            transformer.transform(source, streamResult);
        } catch (ParserConfigurationException | TransformerException ex)
        {
            ex.printStackTrace();
        }
    }

    private static void createDirectories(String language)
    {
        try
        {
            boolean langFolder;
            boolean XMLfolder;

            // Create multiple directories
            langFolder = (new File(language)).mkdirs();
            XMLfolder = (new File(language + File.separator + "XML")).mkdirs();

            if (langFolder && XMLfolder)
            {

            }else if (!(langFolder) || !(XMLfolder))
            {
                JFrame frame = new JFrame("Alert!!!");
                JOptionPane.showMessageDialog(frame, "The folder directory already exits");
            }
        } catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static String capFirstLetter(String word)
    {
        char capLetter = word.charAt(0);
        String wo = "" + capLetter;

        String renewedWord = wo.toUpperCase() + word.substring(1);
        String newWord = renewedWord.replaceAll("\\s+", "");
        return newWord;
    }

    public static void main(String[] args)
    {
        // TODO code application logic here
        JFrame frame = new Create();
        frame.setVisible(true);
    }
}
