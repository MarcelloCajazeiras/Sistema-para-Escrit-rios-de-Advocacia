import Entidades.Advogado;
import Entidades.Cliente;
import Entidades.Peticao;
import Entidades.Processo;

import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Main {
    private static List<Cliente> clientes;
    private static List<Advogado> advogados;
    private static List<Processo> processos;
    private static List<String> peticoes;
    private static JFrame janela;
    private static JTable tabelaClientes;
    private static JTable tabelaAdvogados;
    private static JTable tabelaProcessos;
    private static JTable tabelaPeticoes;
    private static DefaultTableModel modeloTabelaClientes;
    private static DefaultTableModel modeloTabelaAdvogados;
    private static DefaultTableModel modeloTabelaProcessos;
    private static DefaultTableModel modeloTabelaPeticoes;
    public static void main(String[] args) {

        JFrame frame = new JFrame("Sistema de escritório de Advocácia");


        JButton clientButton = new JButton("Cliente"); // botão Cliente
        clientButton.setBounds(150, 70, 100, 25); // configura a posição e o tamanho do botão

        JButton advogadoButton = new JButton("Advogado"); // botão Advogado
        advogadoButton.setBounds(150, 100, 100, 25); // configura a posição e o tamanho do botão

        JButton processButton = new JButton("Processo"); // botão Processo
        processButton.setBounds(150, 130, 100, 25); // configura a posição e o tamanho do botão

        JButton petitionButton = new JButton("Petição"); // botão Petição
        petitionButton.setBounds(150, 160, 100, 25); // configura a posição e o tamanho do botão

        JButton creditsButton = new JButton("Créditos"); // botão Petição
        creditsButton.setBounds(150, 190, 100, 25); // configura a posição e o tamanho do botão

        frame.add(creditsButton);
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela = new JFrame("Créditos");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600,400);
                janela.setLocationRelativeTo(null);

                janela.setVisible(false);
                janela.dispose();
                janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                JPanel painelFormulario = new JPanel(new GridLayout(6, 2));
                JLabel creditos = new JLabel("Quem produziu o sistema?");
                JLabel carlos = new JLabel("1 - Carlos César");
                JLabel francisco = new JLabel("2 - Francisco das Chagas");
                JLabel marcello = new JLabel("3 - Marcello Cajazeiras");
                JLabel rafael = new JLabel("4 - Rafael Seixas");


                painelFormulario.add(creditos);
                painelFormulario.add(carlos);
                painelFormulario.add(francisco);
                painelFormulario.add(marcello);
                painelFormulario.add(rafael);


                janela.setContentPane(painelFormulario);

                // Exibe a janela principal
                janela.setVisible(true);

            }
        });

        frame.add(clientButton); // adiciona o botão Cliente à janela
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clientes = new ArrayList<>();

                janela = new JFrame("Sistema de cadastro de cliente");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLocationRelativeTo(null);

                janela.setVisible(false);
                janela.dispose();
                janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                JPanel painelFormulario = new JPanel(new GridLayout(6, 2));
                JLabel labelNome = new JLabel("Nome:");
                JTextField campoNome = new JTextField();
                JLabel labelCpf = new JLabel("CPF:");
                JTextField campoCpf = new JTextField();
                JLabel labelEmail = new JLabel("E-mail:");
                JTextField campoEmail = new JTextField();
                JLabel labelTelefone = new JLabel("Telefone:");
                JTextField campoTelefone = new JTextField();
                JLabel labelEndereco = new JLabel("Rua:");
                JTextField campoEndereco = new JTextField();
                JButton botaoAdicionar = new JButton("Adicionar");
                JButton botaoRemover = new JButton("Remover");

                botaoAdicionar.addActionListener(e12 -> {
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
                });
                botaoRemover.addActionListener(e1 -> {
                    int linhaSelecionada = tabelaClientes.getSelectedRow();
                    if (linhaSelecionada >= 0) { // Verifica se alguma linha está selecionada
                        Cliente clienteSelecionado = clientes.get(linhaSelecionada);
                        clientes.remove(clienteSelecionado); // Remove o cliente da lista
                        modeloTabelaClientes.removeRow(linhaSelecionada); // Remove a linha da tabela
                        JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente!");
                    }
                });


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

                modeloTabelaClientes = new DefaultTableModel(new Object[] {"Nome", "CPF", "E-mail", "Telefone", "Rua"}, 0);
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
        });
        frame.add(advogadoButton); // adiciona o botão Advogado à janela

        advogadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                advogados = new ArrayList<>();

                janela = new JFrame("Sistema de cadastro de advogado");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLocationRelativeTo(null);

                janela.setVisible(false);
                janela.dispose();
                janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                JPanel painelFormulario = new JPanel(new GridLayout(6, 2));
                JLabel labelNome = new JLabel("Nome:");
                JTextField campoNome = new JTextField();
                JLabel labelCpf = new JLabel("CNPJ:");
                JTextField campoCnpj = new JTextField();
                JLabel labelEmail = new JLabel("E-mail:");
                JTextField campoEmail = new JTextField();
                JLabel labelTelefone = new JLabel("Telefone:");
                JTextField campoTelefone = new JTextField();
                JLabel labelrua = new JLabel("Rua:");
                JTextField campoRua = new JTextField();
                JButton botaoAdicionar = new JButton("Adicionar");
                JButton botaoRemover = new JButton("Remover");

                botaoAdicionar.addActionListener(e12 -> {
                    String nome = campoNome.getText();
                    String cnpj = campoCnpj.getText();
                    String email = campoEmail.getText();
                    String telefone = campoTelefone.getText();
                    String endereco = campoRua.getText();
                    if (!nome.isEmpty() && !cnpj.isEmpty() && !email.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty()) {
                        Advogado advogado = new Advogado(nome, cnpj, email, telefone, endereco);
                        advogados.add(advogado);
                        modeloTabelaAdvogados.addRow(new Object[]{advogado.getNome(), advogado.getCpf(), advogado.getEmail(), advogado.getTelefone(), advogado.getEndereco()});
                        JOptionPane.showMessageDialog(null, "Advogado adicionado com sucesso!");
                        campoNome.setText("");
                        campoCnpj.setText("");
                        campoEmail.setText("");
                        campoTelefone.setText("");
                        campoRua.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
                    }
                });
                botaoRemover.addActionListener(e1 -> {
                    int linhaSelecionada = tabelaAdvogados.getSelectedRow();
                    if (linhaSelecionada >= 0) { // Verifica se alguma linha está selecionada
                        Advogado advogadoSelecionado = advogados.get(linhaSelecionada);
                        advogados.remove(advogadoSelecionado); // Remove o cliente da lista
                        modeloTabelaAdvogados.removeRow(linhaSelecionada); // Remove a linha da tabela
                        JOptionPane.showMessageDialog(null, "Advogado removido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecione um advogado!");
                    }
                });

                painelFormulario.add(labelNome);
                painelFormulario.add(campoNome);
                painelFormulario.add(labelCpf);
                painelFormulario.add(campoCnpj);
                painelFormulario.add(labelEmail);
                painelFormulario.add(campoEmail);
                painelFormulario.add(labelTelefone);
                painelFormulario.add(campoTelefone);
                painelFormulario.add(labelrua);
                painelFormulario.add(campoRua);
                painelFormulario.add(botaoAdicionar);
                painelFormulario.add(botaoRemover);

                modeloTabelaAdvogados = new DefaultTableModel(new Object[] {"Nome", "CNPJ", "E-mail", "Telefone", "Rua"}, 0);
                tabelaAdvogados = new JTable(modeloTabelaAdvogados);
                JScrollPane painelTabela = new JScrollPane(tabelaAdvogados);

                // Adiciona os painéis à janela principal
                JPanel painelPrincipal = new JPanel(new BorderLayout());
                painelPrincipal.add(painelFormulario, BorderLayout.NORTH);
                painelPrincipal.add(painelTabela, BorderLayout.CENTER);
                janela.setContentPane(painelPrincipal);

                // Exibe a janela principal
                janela.setVisible(true);

            }

        });
        frame.add(processButton); // adiciona o botão Processo à janela
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        processos = new ArrayList<>();

                        janela = new JFrame("Sistema de cadastro de Processos");
                        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        janela.setSize(600, 400);
                        janela.setLocationRelativeTo(null);

                        janela.dispose();
                        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                        Random gerador = new Random();

                        int a = 0;
                        for (int i = 1; i < 9; i++) {
                            a = gerador.nextInt();
                        }

                        JPanel painelFormulario = new JPanel(new GridLayout(6, 2));
                        JLabel labelProcesso = new JLabel("Numero do Processo");
                        JTextField campoProcesso = new JTextField(String.valueOf(a));
                        campoProcesso.setEditable(false);
                        JLabel labelAdvogado = new JLabel("Advogado:");
                        JTextField campoAdvogado = new JTextField();
                        JLabel labelClient = new JLabel("Client:");
                        JTextField campoClient = new JTextField();
                        JLabel labelDescricao = new JLabel("Descrição:");
                        JTextField campoDescricao = new JTextField();
                        JButton botaoAdicionar = new JButton("Adicionar");
                        JButton botaoRemover = new JButton("Remover");

                        botaoAdicionar.addActionListener(e12 -> {
                            String processo = campoProcesso.getText();
                            String advogado = campoAdvogado.getText();
                            String client = campoClient.getText();
                            String descricao = campoDescricao.getText();
                            if (!advogado.isEmpty() && !client.isEmpty() && !descricao.isEmpty()) {
                                Processo processoo = new Processo(processo,advogado, client, descricao);
                                processos.add(processoo);
                                modeloTabelaProcessos.addRow(new Object[]{processoo.getProcesso(), processoo.getAdvogado(), processoo.getClient(), processoo.getDescricao()});
                                JOptionPane.showMessageDialog(null, "Processo adicionado com sucesso!");
                                campoClient.setText("");
                                campoAdvogado.setText("");
                                campoDescricao.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
                            }

                        });
                        botaoRemover.addActionListener(e1 -> {
                            int linhaSelecionada = tabelaProcessos.getSelectedRow();
                            if (linhaSelecionada >= 0) { // Verifica se alguma linha está selecionada
                                Processo processoSelecionado = processos.get(linhaSelecionada);
                                processos.remove(processoSelecionado); // Remove o cliente da lista
                                modeloTabelaProcessos.removeRow(linhaSelecionada); // Remove a linha da tabela
                                JOptionPane.showMessageDialog(null, "Processo removido com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Por favor, selecione um advogado!");
                            }
                        });

                        painelFormulario.add(labelProcesso);
                        painelFormulario.add(campoProcesso);
                        painelFormulario.add(labelAdvogado);
                        painelFormulario.add(campoAdvogado);
                        painelFormulario.add(labelClient);
                        painelFormulario.add(campoClient);
                        painelFormulario.add(labelDescricao);
                        painelFormulario.add(campoDescricao);
                        painelFormulario.add(botaoAdicionar);
                        painelFormulario.add(botaoRemover);

                        modeloTabelaProcessos = new DefaultTableModel(new Object[]{"Processo", "Advogado", "Cliente", "Descrição"}, 0);
                        tabelaProcessos = new JTable(modeloTabelaProcessos);
                        JScrollPane painelTabela = new JScrollPane(tabelaProcessos);

                        // Adiciona os painéis à janela principal
                        JPanel painelPrincipal = new JPanel(new BorderLayout());
                        painelPrincipal.add(painelFormulario, BorderLayout.NORTH);
                        painelPrincipal.add(painelTabela, BorderLayout.CENTER);
                        janela.setContentPane(painelPrincipal);

                        // Exibe a janela principal
                        janela.setVisible(true);

                    }

                });

            }
        });

        frame.add(petitionButton); // adiciona o botão Petição à janela
        petitionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petitionButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        peticoes = new ArrayList<>();

                        janela = new JFrame("Sistema de cadastro de petição");
                        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        janela.setSize(600, 400);
                        janela.setLocationRelativeTo(null);

                        janela.dispose();
                        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


                        JPanel painelFormulario = new JPanel(new GridLayout(6, 2));
                        JLabel labelCausa = new JLabel("Causa:");
                        JTextField campoCausa = new JTextField();
                        JLabel labelvalorCausa = new JLabel("Valor da Causa:");
                        JTextField campovalorCausa = new JTextField();
                        JLabel labelClient = new JLabel("Cliente:");
                        JTextField campoClient = new JTextField();
                        JLabel labelDescricao = new JLabel("Descrição:");
                        JTextField campoDescricao = new JTextField();
                        JButton botaoAdicionar = new JButton("Adicionar");
                        JButton botaoRemover = new JButton("Remover");

                        botaoAdicionar.addActionListener(e12 -> {
                            String causa = campoCausa.getText();
                            Double valorCausa = Double.valueOf(campovalorCausa.getText());
                            String client = campoClient.getText();
                            String descricao = campoDescricao.getText();
                            if (!causa.isEmpty() && !client.isEmpty() && !descricao.isEmpty()) {
                                    Peticao peticao = new Peticao(causa, valorCausa, client, descricao);
                                peticoes.add(causa);
                                modeloTabelaPeticoes.addRow(new Object[]{peticao.getCausa(), peticao.getvalorCausa(), peticao.getClient(), peticao.getDescricao()});
                                JOptionPane.showMessageDialog(null, "Petição adicionado com sucesso!");
                                campoClient.setText("");
                                campovalorCausa.setText("");
                                campoDescricao.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
                            }

                        });
                        botaoRemover.addActionListener(e1 -> {
                            int linhaSelecionada = tabelaPeticoes.getSelectedRow();
                            if (linhaSelecionada >= 0) { // Verifica se alguma linha está selecionada
                                String peticaoSelecionado = peticoes.get(linhaSelecionada);
                                peticoes.remove(peticaoSelecionado); // Remove o cliente da lista
                                modeloTabelaPeticoes.removeRow(linhaSelecionada); // Remove a linha da tabela
                                JOptionPane.showMessageDialog(null, "Petição removido com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Por favor, selecione um Causa!");
                            }
                        });

                        painelFormulario.add(labelCausa);
                        painelFormulario.add(campoCausa);
                        painelFormulario.add(labelvalorCausa);
                        painelFormulario.add(campovalorCausa);
                        painelFormulario.add(labelClient);
                        painelFormulario.add(campoClient);
                        painelFormulario.add(labelDescricao);
                        painelFormulario.add(campoDescricao);
                        painelFormulario.add(botaoAdicionar);
                        painelFormulario.add(botaoRemover);

                        modeloTabelaPeticoes = new DefaultTableModel(new Object[]{"Causa", "Valor da Causa", "Cliente", "Descrição"}, 0);
                        tabelaPeticoes = new JTable(modeloTabelaPeticoes);
                        JScrollPane painelTabela = new JScrollPane(tabelaPeticoes);

                        // Adiciona os painéis à janela principal
                        JPanel painelPrincipal = new JPanel(new BorderLayout());
                        painelPrincipal.add(painelFormulario, BorderLayout.NORTH);
                        painelPrincipal.add(painelTabela, BorderLayout.CENTER);
                        janela.setContentPane(painelPrincipal);

                        // Exibe a janela principal
                        janela.setVisible(true);


                    }
                });
            }
        });
        frame.setLayout(null); // desabilita o layout automático
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}