
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
import javax.swing.JTextField;

import dao.PeritoDAO;
import model.Perito;

public class PeritoView extends JFrame{
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblEndereco;
	private JLabel lblTelefone;
	
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnLimpar;
	private JButton btnExcluir;
	private JButton btnLocalizar;
	private JButton btnVoltar;
	
	private JPanel pnlBotoes;
	private JPanel pnlFormulario;
	
	public PeritoView() {
		super("Cadastro de Peritos");
		this.setSize(600,500);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
			
		pnlFormulario = new JPanel();
		pnlFormulario.setLayout(new GridBagLayout());
		
		GridBagConstraints posicoes = new GridBagConstraints();
		posicoes.insets = new Insets(3,0,3,0);
		posicoes.anchor = posicoes.LINE_START;
		posicoes.gridx = 0;
		posicoes.gridy = 0;		
		
		lblId = new JLabel("Cód do Perito: ");
		pnlFormulario.add(lblId, posicoes);
		
		posicoes.gridy = 1;
		lblNome = new JLabel("Nome do Perito: ");
		pnlFormulario.add(lblNome, posicoes);
		
		posicoes.gridy = 2;
		lblEmail = new JLabel("Email do Perito:");
		pnlFormulario.add(lblEmail, posicoes);
		
		posicoes.gridy = 3;
		lblEndereco = new JLabel("Endereço do Perito: ");
		pnlFormulario.add(lblEndereco, posicoes);
		
		posicoes.gridy = 4;
		lblTelefone = new JLabel("Telefone do Perito: ");
		pnlFormulario.add(lblTelefone, posicoes);
		
		
		posicoes.gridx = 1;
		posicoes.gridy = 0;
		txtId = new JTextField(10);
		pnlFormulario.add(txtId, posicoes);
		
		posicoes.gridy = 1;
		txtNome = new JTextField(10);
		pnlFormulario.add(txtNome, posicoes);	
		
		posicoes.gridy = 2;
		txtEmail = new JTextField(10);
		pnlFormulario.add(txtEmail, posicoes);
		
		posicoes.gridy = 3;
		txtEndereco = new JTextField(10);
		pnlFormulario.add(txtEndereco, posicoes);
		
		posicoes.gridy = 4;
		txtTelefone = new JTextField(10);
		pnlFormulario.add(txtTelefone, posicoes);
		
		
		pnlBotoes = new JPanel();
		pnlBotoes.setLayout(new FlowLayout());
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Perito perito = new Perito();
				perito.setNome(txtNome.getText());
				perito.setEmail(txtEmail.getText());
				perito.setEndereco(txtEndereco.getText());
				perito.setTelefone(txtTelefone.getText());

				
				PeritoDAO dao = new PeritoDAO();
				dao.inserir(perito);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			}
		});
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Perito perito = new Perito();
				perito.setId(Integer.parseInt(txtId.getText()));
				perito.setNome(txtNome.getText());
				perito.setEmail(txtEmail.getText());
				perito.setEndereco(txtEndereco.getText());
				perito.setTelefone(txtTelefone.getText());
				
				PeritoDAO dao = new PeritoDAO();
				dao.atualizar(perito);			
				JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
			}
		});
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				txtId.setText("");
				txtNome.setText("");
				txtEmail.setText("");
				txtEndereco.setText("");
				txtTelefone.setText("");

			}
		});
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Perito perito = new Perito();
				perito.setId(Integer.parseInt(txtId.getText()));
							
				PeritoDAO dao = new PeritoDAO();
				dao.excluir(perito);			
				JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			}
		});
		btnLocalizar = new JButton("Localizar");
		btnLocalizar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Perito perito = new Perito();
			perito.setId(Integer.parseInt(txtId.getText()));
						
			PeritoDAO dao = new PeritoDAO();
			perito = dao.localizar(perito);			
			JOptionPane.showMessageDialog(null,"Perito Localizado" + "\n" + perito.getId() + "\n" + perito.getNome() + "\n" + perito.getEmail() + "\n" + perito.getEndereco() + "\n" + perito.getTelefone());
			
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
		pnlBotoes.add(btnAtualizar);
		pnlBotoes.add(btnLimpar);
		pnlBotoes.add(btnExcluir);
		pnlBotoes.add(btnLocalizar);
		pnlBotoes.add(btnVoltar);
		
		this.add(pnlFormulario, BorderLayout.CENTER);
		this.add(pnlBotoes, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		PeritoView janela = new PeritoView();
		janela.setVisible(true);

	}

}
