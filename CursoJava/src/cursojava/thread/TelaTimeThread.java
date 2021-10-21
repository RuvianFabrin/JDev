package cursojava.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1132925817774903930L;

	private JPanel jpanel = new JPanel(new GridBagLayout());
	private JLabel descricaoHora = new JLabel("Nome");
	private JTextField mostraTempo = new JTextField();
	private JLabel descricaoHora2 = new JLabel("E-mail");
	private JTextField mostraTempo2 = new JTextField();
	private JButton jbutton = new JButton("Add Lista");
	private JButton jbutton2 = new JButton("Stop");
	
	private implementacaoFilaThread fila = new implementacaoFilaThread();
		
	public TelaTimeThread() {
		setTitle("Minha tela de time com Thread");
		setSize(new Dimension(236, 236));
		setLocationRelativeTo(null);
		setResizable(false);
		/* Primeira parte concluida*/
	
		//Controlador de posicionamento
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx=0;
		gridBagConstraints.gridy=0;
		gridBagConstraints.gridwidth=2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = gridBagConstraints.WEST;
		
		descricaoHora.setPreferredSize(new Dimension(200,25));
		jpanel.add(descricaoHora,gridBagConstraints);
		
		mostraTempo.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy++;
		jpanel.add(mostraTempo,gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy++;
		jpanel.add(descricaoHora2,gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy++;
		jpanel.add(mostraTempo2,gridBagConstraints);
		
		gridBagConstraints.gridwidth=1;
		
		jbutton.setPreferredSize(new Dimension(92,25));
		gridBagConstraints.gridy++;
		jpanel.add(jbutton,gridBagConstraints);
		
		jbutton2.setPreferredSize(new Dimension(92,25));
		gridBagConstraints.gridx++;
		jpanel.add(jbutton2,gridBagConstraints);
		
		jbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fila==null) {
					fila =new implementacaoFilaThread();
					fila.start();
				}
				for (int i = 0; i < 100; i++) {/*Simulando 100 envios em massa*/				
					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(mostraTempo.getText());
					filaThread.setEmail(mostraTempo2.getText()+" - " +i);
					fila.add(filaThread);
				
				}
			}
		});
		jbutton2.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
								
				fila.stop();
				fila = null;
				
			}
		});
		
		fila.start();
		add(jpanel, BorderLayout.WEST);
		setVisible(true);//Torna a tela visivel, sempre tem que ser o ultimo
		
	}
	
}
