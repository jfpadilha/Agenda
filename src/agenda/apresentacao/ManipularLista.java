/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.apresentacao;

import agenda.controle.AgendaControladorV2;
import agenda.controle.AgendaTableModel;
import agenda.negocio.Compromisso;
import core.Data;
import core.SomenteNumeros;
import javax.swing.JOptionPane;

/**
 *
 * @author joao
 */
public class ManipularLista extends javax.swing.JFrame
{

    private final AgendaControladorV2 controle;

    /**
     * Creates new form ManipularLista
     */
    public ManipularLista(AgendaControladorV2 controle)
    {
        this.controle = controle;
        initComponents();
        setLocationRelativeTo(null);
        setsIniciais();

    }

    private void carregar()
    {
        AgendaTableModel m = new AgendaTableModel(controle);
        jtTabela.setModel(m);
    }

    private void setsIniciais()
    {
        carregar();

        tfCodigo.setText(Integer.toString(controle.getMaiorCodigo() - 1));
        tfCodigo.requestFocus();
        tfCodigo.selectAll();
        tfCodigo.setEditable(true);
        tfDescricao.setEditable(false);
        tffData.setEditable(false);
        tffHorario.setEditable(false);
        btnSalvar.setEnabled(false);
        btnExcluir1.setEnabled(false);

    }

    private void limparCampos()
    {
        String codigo = Integer.toString(controle.getMaiorCodigo() - 1);
        tfDescricao.setText("");
        tffData.setText("");
        tffHorario.setText("");
        btnLocalizar.setEnabled(true);
        setsIniciais();
    }

    private void localizar()
    {
        if ( !tfCodigo.getText().isEmpty() )
        {
            tfCodigo.setEditable(false);
            int codigo = Integer.parseInt(tfCodigo.getText());
            Compromisso c = controle.procurarCompromissoCodigo(codigo);
            try
            {
                tfDescricao.setText(c.getCompromisso());
                tffData.setText(c.getDataCompromisso().toString());
                tffHorario.setText(c.getHorario());

                tfDescricao.requestFocus();
                tfDescricao.selectAll();
                tffData.selectAll();
                tffHorario.selectAll();

                tfDescricao.setEditable(true);
                tffData.setEditable(true);
                tffHorario.setEditable(true);
                btnSalvar.setEnabled(true);
                btnExcluir1.setEnabled(true);
                btnLocalizar.setEnabled(false);

            }
            catch ( Exception e )
            {
                JOptionPane.showMessageDialog(null, "Não foi encontrado compromisso nesse código!", "Não Encontrado!", JOptionPane.ERROR_MESSAGE);
                limparCampos();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Deve ter um compromisso selecionado ou informado!", "Erro!", JOptionPane.ERROR_MESSAGE);
            limparCampos();

        }
    }

    private void selectMouse()
    {
        int selectedLine = jtTabela.getSelectedRow();
        int selectedColumn = jtTabela.getSelectedColumn();

        tfCodigo.setText(jtTabela.getValueAt(selectedLine, 0).toString());
    }

    private void exclusao()
    {
        int codigo = Integer.parseInt(tfCodigo.getText());
        String descricao = tfDescricao.getText();
        String data = tffData.getText();
        String horario = tffHorario.getText();

        Data dt = new Data(data);
        Compromisso comp = new Compromisso(codigo, descricao, dt, horario);

        controle.removerCompromissoCodigo(codigo);

        limparCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        tffHorario = new javax.swing.JFormattedTextField();
        lbCodigo = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbHorario = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        tffData = new javax.swing.JFormattedTextField();
        btnLocalizar = new javax.swing.JButton();
        btnExcluir1 = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lbTitulo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Agenda de Compromissos");

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtTabela.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jtTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabela);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnVoltarActionPerformed(evt);
            }
        });

        try
        {
            tffHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        lbCodigo.setText("Código:");

        lbDescricao.setText("Descrição:");

        lbData.setText("Data:");

        lbHorario.setText("Horário:");

        tfCodigo.setDocument(new SomenteNumeros());
        tfCodigo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tfCodigoActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLimparActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSalvarActionPerformed(evt);
            }
        });

        try
        {
            tffData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLocalizarActionPerformed(evt);
            }
        });

        btnExcluir1.setText("Excluir");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExcluir1ActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbCodigo)
                .addGap(29, 29, 29)
                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbDescricao)
                .addGap(12, 12, 12)
                .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbData)
                .addGap(42, 42, 42)
                .addComponent(tffData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbHorario)
                .addGap(26, 26, 26)
                .addComponent(tffHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescricao)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbData)
                    .addComponent(tffData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHorario)
                    .addComponent(tffHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpar)
                    .addComponent(btnLocalizar)
                    .addComponent(btnExcluir1)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnVoltarActionPerformed
    {//GEN-HEADEREND:event_btnVoltarActionPerformed
        CompromissosTelaPrincipal tela = new CompromissosTelaPrincipal(controle);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLimparActionPerformed
    {//GEN-HEADEREND:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSalvarActionPerformed
    {//GEN-HEADEREND:event_btnSalvarActionPerformed

        int code = controle.getMaiorCodigo();
        int codigo = Integer.parseInt(tfCodigo.getText());
        String descricao = tfDescricao.getText();
        String data = tffData.getText();
        String horario = tffHorario.getText();

        if ( codigo < code )
        {
            try
            {
                Data dt = new Data(data);
                Compromisso comp = new Compromisso(codigo, descricao, dt, horario);
                controle.editarCompromisso(codigo, comp);
                JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();

            }
            catch ( Exception e )
            {
                JOptionPane.showMessageDialog(null, "Verifique os dados informados, todos os campos devem ser informados!", "Erro!", JOptionPane.ERROR_MESSAGE);
                tfDescricao.requestFocus();
            }
        }
        else
        {
            try
            {
                Data dt = new Data(data);
                Compromisso comp = new Compromisso(codigo, descricao, dt, horario);
                controle.inserirCompromisso(comp);
                JOptionPane.showMessageDialog(null, "Cadastro adicionado com sucesso!", "OK!", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();

            }
            catch ( Exception e )
            {
                JOptionPane.showMessageDialog(null, "Verifique os dados informados, todos os campos devem ser informados!", "Erro!", JOptionPane.ERROR_MESSAGE);
                tfDescricao.requestFocus();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLocalizarActionPerformed
    {//GEN-HEADEREND:event_btnLocalizarActionPerformed
        localizar();
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExcluir1ActionPerformed
    {//GEN-HEADEREND:event_btnExcluir1ActionPerformed
        int conf = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Confirm!", JOptionPane.INFORMATION_MESSAGE);

        if ( conf == 0 )
        {
            exclusao();
        }
        else
        {
            limparCampos();
        }
    }//GEN-LAST:event_btnExcluir1ActionPerformed

    private void tfCodigoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tfCodigoActionPerformed
    {//GEN-HEADEREND:event_tfCodigoActionPerformed
        localizar();
    }//GEN-LAST:event_tfCodigoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnNovoActionPerformed
    {//GEN-HEADEREND:event_btnNovoActionPerformed
        limparCampos();
        int code = controle.getMaiorCodigo();
        String co = Integer.toString(code);
        tfCodigo.setText(co);
        tfCodigo.setEditable(false);
        tfDescricao.setEditable(true);
        tfDescricao.requestFocus();
        tffData.setEditable(true);
        tffHorario.setEditable(true);

        btnSalvar.setEnabled(true);
        btnExcluir1.setEnabled(false);
        btnLocalizar.setEnabled(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void jtTabelaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jtTabelaMouseClicked
    {//GEN-HEADEREND:event_jtTabelaMouseClicked
        if ( !tfDescricao.isEditable() )
        {
            selectMouse();
        }

    }//GEN-LAST:event_jtTabelaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabela;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbHorario;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JFormattedTextField tffData;
    private javax.swing.JFormattedTextField tffHorario;
    // End of variables declaration//GEN-END:variables
}