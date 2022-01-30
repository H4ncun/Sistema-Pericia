//NOME: Luiz Felipe Cardoso Gonçalves



package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.ConnectionFactory;


public class MainView extends JFrame{
	private JLabel lblId;

	private JButton btnCadastrarPerito;
	private JButton btnCadastrarProvas;	
	
	
	private JPanel pnlFormulario;
	private JPanel pnlBotoes;
	
	public MainView() {
		super("Tela de Cadastro");
		this.setLayout(new BorderLayout());
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);		
		
		
		pnlFormulario = new JPanel();
		pnlFormulario.setLayout(new GridBagLayout());
		GridBagConstraints posicoes = new GridBagConstraints();
		posicoes.insets = new Insets(3,10,3,10);
		posicoes.anchor = posicoes.FIRST_LINE_START;
		posicoes.gridx = 0;
		posicoes.gridy = 0;

		lblId = new JLabel("Escolha quem quer cadastrar");
		pnlFormulario.add(lblId, posicoes);
		posicoes.gridx = 2;
		posicoes.gridy = 1;
	

		
		pnlBotoes = new JPanel();
		pnlBotoes.setLayout(new FlowLayout());
		
		btnCadastrarPerito = new JButton("Cadastrar Perito");
		btnCadastrarPerito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				PeritoView perito = new PeritoView(); 
				perito.setVisible(true);
				dispose();
				
			}					
		});		
		pnlBotoes.add(btnCadastrarPerito);
		
		btnCadastrarProvas = new JButton("Cadastrar Provas");
		btnCadastrarProvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				CadastroProvasView CadastroProvas = new CadastroProvasView(); 
				CadastroProvas.setVisible(true);
				dispose();
			}
		});
		pnlBotoes.add(btnCadastrarProvas);

		
		this.add(pnlFormulario, BorderLayout.CENTER);
		this.add(pnlBotoes, BorderLayout.SOUTH);
	
	}
	public static void main(String[] args) {
		MainView janela = new MainView();
		janela.setVisible(true);

	}

}
