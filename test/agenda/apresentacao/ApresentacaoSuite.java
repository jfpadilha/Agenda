/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.apresentacao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author joao
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    agenda.apresentacao.CompromissosTelaPrincipalTest.class, agenda.apresentacao.AgendarUmCompromissoTelaTest.class, agenda.apresentacao.RemoverCompromissoTest.class, agenda.apresentacao.EditarCompromissoTest.class, agenda.apresentacao.ManipularListaTest.class, agenda.apresentacao.TestesTest.class
})
public class ApresentacaoSuite
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }
    
}