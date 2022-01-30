package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CadastroProvas;
import model.Perito;
import dao.PeritoDAO;
import dao.ProvasDAO;

public class CadastroProvasView extends JFrame{
	
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblProcesso;
	private JLabel lblPerito;
	private JLabel lblComentario;
	
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtProcesso;
	private JComboBox<Perito> cmbPerito;
	private JTextField txtComentario;
	
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnExcluir;
	private JButton btnLocalizar;
	private JButton btnVoltar;
	
	private JPanel pnlBotoes;
	private JPanel pnlFormulario;
	
	public CadastroProvasView() {
		super("Cadastro de produtos");
		this.setSize(500,500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null); 
			
		pnlFormulario = new JPanel();
		pnlFormulario.setLayout(new GridBagLayout());
		
		GridBagConstraints posicoes = new GridBagConstraints();
		posicoes.insets = new Insets(3,0,3,0);
		posicoes.anchor = posicoes.LINE_START;
		posicoes.gridx = 0;
		posicoes.gridy = 0;		
		
		lblId = new JLabel("Cód do Objeto: ");
		pnlFormulario.add(lblId, posicoes);
		
		posicoes.gridy = 1;
		lblNome = new JLabel("Nome do Objeto: ");
		pnlFormulario.add(lblNome, posicoes);
		
		posicoes.gridy = 2;
		lblProcesso = new JLabel("Número do Processo:");
		pnlFormulario.add(lblProcesso, posicoes);
		
		posicoes.gridy = 3;
		lblPerito = new JLabel("Perito do caso:");
		pnlFormulario.add(lblPerito, posicoes);
		
		posicoes.gridy = 4;
		lblComentario = new JLabel("Laudo do caso: ");
		pnlFormulario.add(lblComentario, posicoes);
		
		posicoes.gridx = 1;
		posicoes.gridy = 0;
		txtId = new JTextField(10);
		pnlFormulario.add(txtId, posicoes);
		
		posicoes.gridy = 1;
		txtNome = new JTextField(10);
		pnlFormulario.add(txtNome, posicoes);	
		
		posicoes.gridy = 2;
		txtProcesso = new JTextField(10);
		pnlFormulario.add(txtProcesso, posicoes);
		
		posicoes.gridy = 3;
		cmbPerito = new JComboBox<Perito>();
		pnlFormulario.add(cmbPerito, posicoes);
	
		posicoes.gridy = 4;
		txtComentario = new JTextField(10);
		pnlFormulario.add(txtComentario, posicoes);
		
		
		ArrayList<Perito> lista = new ArrayList<Perito>();
		PeritoDAO dao = new PeritoDAO();
		lista = dao.Todos();
		
		for(Perito forn:lista) {
			cmbPerito.addItem(forn);
		}
		
		
		pnlBotoes = new JPanel();
		pnlBotoes.setLayout(new FlowLayout());
		
		btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadastroProvas provas = new CadastroProvas();
				provas.setNome(txtNome.getText());
				provas.setNumero_processo(txtProcesso.getText());
				provas.setComentario(txtComentario.getText());
				provas.setPerito((Perito)cmbPerito.getModel().getSelectedItem()); 
				
				
				ProvasDAO dao = new ProvasDAO();
				dao.inserir(provas);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			}
		});
        
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				txtId.setText("");
				txtNome.setText("");
				txtComentario.setText("");
				txtProcesso.setText("");
				

			}
		});
		
		btnExcluir = new JButton("Excluir");
	    btnExcluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadastroProvas provas = new CadastroProvas();
				provas.setId(Integer.parseInt(txtId.getText()));
							
				ProvasDAO dao = new ProvasDAO();
				dao.excluir(provas);			
				JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			}
		});
		
		btnLocalizar = new JButton("Localizar");
		btnLocalizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ProvasDAO dao = new ProvasDAO();
				CadastroProvas provas = new CadastroProvas();
				provas.setId(Integer.parseInt(txtId.getText()));
				provas = dao.localizar(provas);
				
				txtNome.setText(provas.getNome());
				txtProcesso.setText(provas.getNumero_processo());
				txtComentario.setText(provas.getComentario());				
				cmbPerito.getModel().setSelectedItem(provas.getPerito());
				
			}
		});
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				MainView main = new MainView(); 
				main.setVisible(true);
				dispose();							
			}
			});
		
		pnlBotoes.add(btnCadastrar);
		pnlBotoes.add(btnLimpar);
		pnlBotoes.add(btnExcluir);
		pnlBotoes.add(btnLocalizar);
		pnlBotoes.add(btnVoltar);
		
		this.add(pnlFormulario, BorderLayout.CENTER);
		this.add(pnlBotoes, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		CadastroProvasView janela = new CadastroProvasView();
		janela.setVisible(true);
	}

}
