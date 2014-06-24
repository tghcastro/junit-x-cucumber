package cucumberSteps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import paginas.PaginaPesquisa;
import paginas.PaginaResultadoPesquisa;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisarSitesIndexadosSteps {
    private String termoPesquisado;
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
    
    @Dado("^que exista pelo menos um site indexado contendo o termo \"([^\"]*)\"$")
    public void que_exista_pelo_menos_um_site_indexado_contendo_o_termo(String termo) throws Throwable {
        termoPesquisado = termo;
    }

    @Dado("^que o termo \"([^\"]*)\" não esteja presente em nenhum site indexado$")
    public void que_o_termo_não_esteja_presente_em_nenhum_site_indexado(String termo) throws Throwable {
        termoPesquisado = termo;
    }

    @Quando("^faço uma pesquisa por esse termo$")
    public void faço_uma_pesquisa_por_esse_termo() throws Throwable {
        pagina.preencherPesquisa(termoPesquisado);
        resultado = pagina.clicarPesquisar();
    }

    @Então("^resultado de busca exibe todos os sites com o termo pesquisado$")
    public void resultado_de_busca_exibe_todos_os_sites_com_o_termo_pesquisado() throws Throwable {
        assertTrue(resultado.todosOsSitesPossuemOTermo(termoPesquisado));
    }

    @Então("^o resultado de busca exibe uma mensagem informando que o termo não nenhum site correspondente$")
    public void o_resultado_de_busca_exibe_uma_mensagem_informando_que_o_termo_não_nenhum_site_correspondente() throws Throwable {
        assertFalse(resultado.encontrouSitesComTermo(termoPesquisado));
    }
}
