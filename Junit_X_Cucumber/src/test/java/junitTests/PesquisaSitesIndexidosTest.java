package junitTests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import paginas.PaginaPesquisa;
import paginas.PaginaResultadoPesquisa;

public class PesquisaSitesIndexidosTest {
    
    private PaginaPesquisa pagina;
    private PaginaResultadoPesquisa resultado;

    @Before
    public void antesDoTeste() {
        pagina = new PaginaPesquisa();
    }
    
    @After
    public void depoisDoTeste() {
        pagina.fechar();
    }

    @Test
    public void PesquisarUmTermoQueEstejaPresenteEmSitesIndexados() {
        String termoPesquisado = "Cucumber";
        pagina.preencherPesquisa(termoPesquisado);
        resultado = pagina.clicarPesquisar();
        assertTrue(resultado.todosOsSitesPossuemOTermo(termoPesquisado));
    }

    @Test
    public void PesquisarPorUmTermoQueNãoEstejaPresenteEmNenhumSiteIndexado() {
        String termoPesquisado = "Cucumber";
        pagina.preencherPesquisa(termoPesquisado);
        resultado = pagina.clicarPesquisar();
        assertTrue(resultado.todosOsSitesPossuemOTermo(termoPesquisado));
    }
}