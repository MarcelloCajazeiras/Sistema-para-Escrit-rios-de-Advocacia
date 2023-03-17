import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SistemaAdvocacia implements ActionListener {

    private List<Cliente> clientes;
    private JFrame janela;
    private JTable tabelaClientes;
    private DefaultTableModel modeloTabelaClientes;

    public static void main(String[] args) {
        new SistemaAdvocacia().iniciar();
    }

    public void iniciar() {
        // Inicializa a lista de clientes
        clientes = new ArrayList<>();

        // Cria a janela principal
        janela = new JFrame("Sistema de Gerenciamento de Clientes");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 400);
        janela.setLocationRelativeTo(null);

        // Cria o painel com o formulário para adicionar clientes
        JPanel painelFormulario = new JPanel(new GridLayout(6, 2));
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();
        JLabel labelCpf = new JLabel("CPF:");
        JTextField campoCpf = new JTextField();
        JLabel labelEmail = new JLabel("E-mail:");
        JTextField campoEmail = new JTextField();
        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField campoTelefone = new JTextField();
        JLabel labelEndereco = new JLabel("Endereço:");
        JTextField campoEndereco = new JTextField();
        JButton botaoAdicionar = new JButton("Adicionar");
        JButton botaoRemover = new JButton("Remover");
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String cpf = campoCpf.getText();
                String email = campoEmail.getText();
                String telefone = campoTelefone.getText();
                String endereco = campoEndereco.getText();
                if (!nome.isEmpty() && !cpf.isEmpty() && !email.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty()) {
                    Cliente cliente = new Cliente(nome, cpf, email, telefone, endereco);
                    clientes.add(cliente);
                    modeloTabelaClientes.addRow(new Object[] {cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco()});
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
                    campoNome.setText("");
                    campoCpf.setText("");
                    campoEmail.setText("");
                    campoTelefone.setText("");
                    campoEndereco.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
                }
            }

        });
        botaoRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaClientes.getSelectedRow();
                if (linhaSelecionada >= 0) { // Verifica se alguma linha está selecionada
                    Cliente clienteSelecionado = clientes.get(linhaSelecionada);
                    clientes.remove(clienteSelecionado); // Remove o cliente da lista
                    modeloTabelaClientes.removeRow(linhaSelecionada); // Remove a linha da tabela
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente!");
                }
            }
        });

        // Adiciona o botão de remover ao painel de formulário

        painelFormulario.add(labelNome);
        painelFormulario.add(campoNome);
        painelFormulario.add(labelCpf);
        painelFormulario.add(campoCpf);
        painelFormulario.add(labelEmail);
        painelFormulario.add(campoEmail);
        painelFormulario.add(labelTelefone);
        painelFormulario.add(campoTelefone);
        painelFormulario.add(labelEndereco);
        painelFormulario.add(campoEndereco);
        painelFormulario.add(botaoAdicionar);
        painelFormulario.add(botaoRemover);

        modeloTabelaClientes = new DefaultTableModel(new Object[] {"Nome", "CPF", "E-mail", "Telefone", "Endereço"}, 0);
        tabelaClientes = new JTable(modeloTabelaClientes);
        JScrollPane painelTabela = new JScrollPane(tabelaClientes);

        // Adiciona os painéis à janela principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.add(painelFormulario, BorderLayout.NORTH);
        painelPrincipal.add(painelTabela, BorderLayout.CENTER);
        janela.setContentPane(painelPrincipal);

        // Exibe a janela principal
        janela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: implementar o código para as outras funcionalidades do sistema
    }

    public class Cliente {

        private String nome;
        private String cpf;
        private String email;
        private String telefone;
        private String endereco;

        public Cliente(String nome, String cpf, String email, String telefone, String endereco) {
            this.nome = nome;
            this.cpf = cpf;
            this.email = email;
            this.telefone = telefone;
            this.endereco = endereco;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
    }
}
