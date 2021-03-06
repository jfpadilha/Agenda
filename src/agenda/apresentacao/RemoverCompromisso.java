/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.apresentacao;

import agenda.controle.AgendaControladorV2;
import agenda.negocio.Compromisso;
import core.Data;
import core.SomenteLetras;
import core.SomenteNumeros;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author joao
 */
public class RemoverCompromisso extends javax.swing.JFrame
{

    private final AgendaControladorV2 controle;

    /**
     * Creates new form RemoverCompromisso
     */
    public RemoverCompromisso(AgendaControladorV2 controle)
    {
        initComponents();
        setLocationRelativeTo(null);
        this.controle = controle;
        setsIniciais();
    }

    private void setsIniciais()
    {
        tfCodigo.setText(Integer.toString(controle.getMaiorCodigo() - 1));
        tfCodigo.requestFocus();
        tfCodigo.selectAll();
        tfCodigo.setEditable(true);
        tfDescricao.setEditable(false);
        tffData.setEditable(false);
        tffHorario.setEditable(false);
        btnExcluir.setEnabled(false);
        btnLocalizar.setEnabled(true);

    }

    private void limparCampos()
    {
        String codigo = Integer.toString(controle.getMaiorCodigo() - 1);
        tfDescricao.setText("");
        tffData.setText("");
        tffHorario.setText("");
        setsIniciais();
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

    private void localizar()
    {
        int codigo = Integer.parseInt(tfCodigo.getText());

        Compromisso c = controle.procurarCompromissoCodigo(codigo);

        try
        {
//            String code = Integer.toString(c.getCodigo());
//            tfCodigo.setText(code);
            tfCodigo.setEditable(false);
            tfDescricao.setText(c.getCompromisso());
            tffData.setText(c.getDataCompromisso().toString());
            tffHorario.setText(c.getHorario());
System.out.println("aqi");
//            tfCodigo.selectAll();
//            tfDescricao.selectAll();
//            tffData.selectAll();
//            tffHorario.selectAll();
            btnExcluir.setEnabled(true);
            btnLocalizar.setEnabled(false);
        }
        catch ( Exception e )
        {
            JOptionPane.showMessageDialog(null, "Não foi encontrado compromisso nesse código!", "Não Encontrado!", JOptionPane.ERROR_MESSAGE);
            limparCampos();
        }
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

        lbDescricao = new javax.swing.JLabel();
        tffData = new javax.swing.JFormattedTextField();
        btnLocalizar = new javax.swing.JButton();
        lbHorario = new javax.swing.JLabel();
        tffHorario = new javax.swing.JFormattedTextField();
        tfDescricao = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbDescricao.setText("Descrição:");

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

        lbHorario.setText("Horário:");

        try
        {
            tffHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel5.setText("Remover Compromisso");

        lbCodigo.setText("Código:");

        lbData.setText("Data:");

        tfCodigo.setDocument(new SomenteNumeros());
        tfCodigo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tfCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbHorario)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbDescricao)
                                .addGap(27, 27, 27))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(tffHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluir)
                                .addGap(34, 34, 34)
                                .addComponent(btnLocalizar)
                                .addGap(36, 36, 36)
                                .addComponent(btnVoltar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbData)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbCodigo)
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tffData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(27, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescricao)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbData)
                    .addComponent(tffData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHorario)
                    .addComponent(tffHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLocalizar)
                    .addComponent(btnVoltar))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLocalizarActionPerformed
    {//GEN-HEADEREND:event_btnLocalizarActionPerformed
        localizar();
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLimparActionPerformed
    {//GEN-HEADEREND:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExcluirActionPerformed
    {//GEN-HEADEREND:event_btnExcluirActionPerformed
        int conf = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Confirm!", JOptionPane.INFORMATION_MESSAGE);

        if ( conf == 0 )
        {
            exclusao();
        }
        else
        {
            limparCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnVoltarActionPerformed
    {//GEN-HEADEREND:event_btnVoltarActionPerformed
        CompromissosTelaPrincipal tela = new CompromissosTelaPrincipal(controle);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tfCodigoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tfCodigoActionPerformed
    {//GEN-HEADEREND:event_tfCodigoActionPerformed
        localizar();
    }//GEN-LAST:event_tfCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbHorario;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JFormattedTextField tffData;
    private javax.swing.JFormattedTextField tffHorario;
    // End of variables declaration//GEN-END:variables
}
