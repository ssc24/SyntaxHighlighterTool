package samchen.io.util.SyntaxHighlighterTool;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SyntaxHighlighterTool extends JFrame{
	
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public SyntaxHighlighterTool() {
		setSize(1024,600);
		setType(Type.NORMAL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(ParseCodeToHtmlUI.class.getResource("/com/ssc24/Icon_SyntaxHighlighter.png")));
		setTitle("Parse Code To Html For SyntaxHighlighter_JAVA");
		getContentPane().setLayout(null);
		JTextArea textArea = new JTextArea();
		JTextArea textArea_1 = new JTextArea();
		
		textArea.setBounds(10, 10, 974, 156);
		getContentPane().add(textArea);
		
		
		textArea_1.setBounds(10, 208, 974, 162);
		getContentPane().add(textArea_1);
		
		String[] choices = { "","applescript","actionscript3","shell","coldfusion","cpp","csharp","css","java","javascript","perl","php","text","python","sql","xml","html"};
		JComboBox comboBox = new JComboBox(choices);
		comboBox.setBounds(107, 177, 87, 21);
		getContentPane().add(comboBox);
		
		
		JButton btnNewButton = new JButton("Parse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ParseCodeToHTML pct = new ParseCodeToHTML();
					String item = comboBox.getSelectedItem().toString();
					if ("".equals(item)) {
						item = "java";
					}
					pct.setCodeLanguage(item);
					pct.setParseSqlStr(textArea.getText());
					String rtnStr = pct.parse();
					textArea_1.setText(rtnStr);
					textArea.setText("");
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(10, 176, 87, 23);
		getContentPane().add(btnNewButton);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SyntaxHighlighterTool frame = new SyntaxHighlighterTool();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
