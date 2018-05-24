import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CodeTabs extends JTabbedPane {
  private JTextPane codearea;
  private JScrollPane scroll;
  private String s;

  public CodeTabs() {
      s = "";
    setTabPlacement(JTabbedPane.BOTTOM);

    codearea = new JTextPane();

    scroll = new JScrollPane(codearea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setPreferredSize(new Dimension(  300,300 ));

    JPanel panel = new JPanel( new BorderLayout() );
    panel.add( scroll, BorderLayout.CENTER );
    JButton comp = new JButton( "Print text" );
    comp.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent e ) {
          try {
              getCode();
          } catch (IOException ex) {
              Logger.getLogger(CodeTabs.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    } );
    panel.add( comp, BorderLayout.SOUTH );

    addTab( "Code", panel );
  }

  public String getCode() throws IOException {
     s = codearea.getText();

    System.out.println(s);
    
    File newFile = new File("hellofile.txt");
    PrintWriter out = new PrintWriter(newFile.toString());
    out.println(s);

    return s;
  }

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame( "TestFrame" );
        frame.getContentPane().add( new CodeTabs() );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
      }
    } );
  }
}