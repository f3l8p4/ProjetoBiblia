package br.com.empresa.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import br.com.empresa.service.Service;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivrosVO;
import javax.swing.SwingConstants;


public class TelaConsultaBiblia extends JFrame {

	private JPanel contentPane;
	private JTextField tfInicial;
	private JTextField tfFinal;
	private JTextField tfTexto;
	private TableModel tableModel;
	private JTable table;

	private Integer paginaAtual = 1;
	private Integer totalRegistros;
	private Integer tamanhoPaginacao = 5;

	private JComboBox cbQuantidade;
	private JComboBox cbLivro;
	private JComboBox cbCapitulo;

	private JLabel lblPaginacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaBiblia frame = new TelaConsultaBiblia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsultaBiblia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsultaBiblia.class.getResource("/br/com/empresa/view/img/logosenac.jpg")));
		setTitle("Consultar Biblia");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Livro");
		lblNewLabel.setBounds(36, 28, 46, 14);
		contentPane.add(lblNewLabel);

		cbLivro = new JComboBox();
		cbLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCapitulos();
			}
		});
		cbLivro.setBounds(85, 24, 106, 22);
		contentPane.add(cbLivro);

		JLabel lblCapitulo = new JLabel("capitulo");
		lblCapitulo.setBounds(36, 72, 46, 14);
		contentPane.add(lblCapitulo);

		cbCapitulo = new JComboBox();
		cbCapitulo.setBounds(85, 68, 106, 22);
		contentPane.add(cbCapitulo);

		JLabel lblVesiculoInicial = new JLabel("Versiculo Inicial");
		lblVesiculoInicial.setBounds(201, 28, 86, 14);
		contentPane.add(lblVesiculoInicial);

		tfInicial = new JTextField();
		tfInicial.setBounds(285, 26, 86, 20);
		contentPane.add(tfInicial);
		tfInicial.setColumns(10);

		JLabel lblVesiculoFinal = new JLabel("Versiculo Final");
		lblVesiculoFinal.setBounds(201, 72, 66, 14);
		contentPane.add(lblVesiculoFinal);

		tfFinal = new JTextField();
		tfFinal.setColumns(10);
		tfFinal.setBounds(285, 70, 86, 20);
		contentPane.add(tfFinal);

		JButton btnPesquisar = new JButton("Pesquisar\r\n");
		btnPesquisar.setIcon(new ImageIcon(TelaConsultaBiblia.class.getResource("/br/com/empresa/view/img/pesquisar.png")));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual = 1;
				pesquisar();
			}

		});
		btnPesquisar.setBounds(808, 68, 126, 23);
		contentPane.add(btnPesquisar);

		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setBounds(397, 28, 46, 14);
		contentPane.add(lblTexto);

		tfTexto = new JTextField();
		tfTexto.setColumns(10);
		tfTexto.setBounds(455, 26, 519, 20);
		contentPane.add(tfTexto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(41, 125, 978, 385);
		contentPane.add(scrollPane);

		tableModel = new TableModel();
		tableModel.addColumn("LIVRO");
		tableModel.addColumn("CAPITULO");
		tableModel.addColumn("VERSICULO");
		tableModel.addColumn("TEXTO");

		table = new JTable(tableModel);
		table.setAutoscrolls(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel tableColumnModel = table.getColumnModel();
		tableColumnModel.getColumn(0).setPreferredWidth(60);
		tableColumnModel.getColumn(1).setPreferredWidth(70);
		tableColumnModel.getColumn(2).setPreferredWidth(80);
		tableColumnModel.getColumn(3).setPreferredWidth(2000);

		scrollPane.setViewportView(table);

		JButton btnSair = new JButton("Sair\r\n");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					 int input = 
						JOptionPane.showConfirmDialog(null, 
							"Deseja sair do sistema?", 
							"Selecione uma opção...",
							JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE);
					 if(input == 0) {
						 System.exit(0);
					 }
					}
				});
				btnSair.setToolTipText("Clique aqui para sair da aplicação");
				btnSair.setMnemonic('S');
				btnSair.setBounds(740, 514, 108, 23);
				getContentPane().add(btnSair);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(192, 192, 192));
				panel.setBounds(0, 85, 284, 3);
				getContentPane().add(panel);
			
			
		btnSair.setIcon(new ImageIcon(TelaConsultaBiblia.class.getResource("/br/com/empresa/view/img/Fechar.png")));
		btnSair.setBounds(510, 68, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparPesquisa();
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaConsultaBiblia.class.getResource("/br/com/empresa/view/img/cancel.png")));
		btnNewButton.setBounds(640, 69, 126, 21);
		contentPane.add(btnNewButton);

		carregarLivros();

	}
	
	private void carregarCapitulos() {
		
		LivrosVO aux = (LivrosVO) cbLivro.getSelectedItem();
		
		int qtdCapitulos = aux.getQtdecaptulos();
		    
		  cbCapitulo.removeAllItems(); // Limpa o combo box de capítulos antes de carregar os novos valores
		    
		    for (int i = 1; i <= qtdCapitulos; i++) {
		    	cbCapitulo.addItem(i); // Adiciona cada número de capítulo ao combo box
		    }
		
		//Aqui você vai fazer um for de 1 até qtdCapitulos e adicionar ao comboBox de capitulos.
		
	}

	private void carregarLivros() {

		Service service = new Service();
		
		try {
			List<LivrosVO> livros = service.buscarLivros();
			
			cbLivro.removeAllItems();
			
			cbLivro.addItem(null);
			
			for (LivrosVO livrosVO : livros) {
				cbLivro.addItem(livrosVO);
			}
			
		} catch (BOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Ocorreu um erro ao executar a operação!",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	public void pesquisar() {
		
		Service service = new Service();
		TableModel tableModel = (TableModel) table.getModel();
		tableModel.clearTable();
		
		try {
			
			Map<String, Object> filters = new HashMap<>();
			
			if(this.tfTexto.getText() != null && 
					this.tfTexto.getText().trim().length() > 0) {
					try {
						
						String id = new String(this.tfTexto.getText().trim());
						filters.put("id", id);					
					}catch (Exception e) {
						throw new 
							BOValidationException("Código: Erro de validação: "
									+ "Valor incorreto.");
					}
				}
			
			if(tfTexto.getText() != null && 
					tfTexto.getText().trim().length() > 0) {				
				filters.put("texto", tfTexto.getText().trim());
			}
			
			if(cbCapitulo.getSelectedItem() != null) {				
				filters.put("capitulo", cbCapitulo.getSelectedItem());
			}
			if(cbLivro.getSelectedItem() != null) {				
				filters.put("livro", cbLivro.getSelectedItem());
			}
	
			
			List<BibliaVO> bibliasVOs = service.consultarBiblia(DadosConstantesVO.getLivrosVO(),paginaAtual, paginaAtual, paginaAtual, tfTexto.getText(), filters);
			
			if(bibliasVOs != null) {
				for (BibliaVO bibliaVO : bibliasVOs) {
					RowData rowData = new RowData();
					rowData.getValues().put(0, bibliaVO.getId());
					rowData.getValues().put(1, bibliaVO.getCapitulo());
					rowData.getValues().put(2, bibliaVO.getVersiculo());
					rowData.getValues().put(3, bibliaVO.getTexto());
					
					rowData.setElement(bibliaVO);
					tableModel.addRow(rowData);
				}
			}
			
		}catch (BOValidationException e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, e2.getMessage(),
					"Mensagem de aviso", JOptionPane.WARNING_MESSAGE);
		}catch (BOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(),
					"Ocorreu um erro ao executar a operação!", 
					JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	public void limparPesquisa() {
		paginaAtual = 1;
		this.tfTexto.setText(null);
		pesquisar();
	}
}
