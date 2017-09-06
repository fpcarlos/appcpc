/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.visao;

import br.edu.uerr.appcpc.controle.CertameControle;
import br.edu.uerr.appcpc.controle.PessoaControle;
import br.edu.uerr.appcpc.controle.TipoVagaControle;
import br.edu.uerr.appcpc.modelo.Cargo;
import br.edu.uerr.appcpc.modelo.Certame;
import br.edu.uerr.appcpc.modelo.Inscricao;
import br.edu.uerr.appcpc.modelo.Pessoa;
import br.edu.uerr.appcpc.modelo.TipoVaga;
import br.edu.uerr.appcpc.util.UtilSession;
import static br.edu.uerr.appcpc.visao.AbstractVisao.showFacesMessage;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class CertameVisao extends AbstractVisao implements Serializable {

    @EJB
    private CertameControle certameControle;
    @EJB
    private PessoaControle pessoaControle;
    @EJB
    private TipoVagaControle tipoVagaControle;

    private Certame certame;

    private Pessoa pessoa;

    private Inscricao inscricao;

    private List<Certame> listCertame = new ArrayList<>();
    
    private List<TipoVaga> listTipoVaga = new ArrayList<>();

    private String dataAtual = "";

    private boolean dtIsento = false;

    //private List<Cargo> cargoList = new ArrayList<>();
    public CertameVisao() {
        super();
    }

    public String abrirCadastro() {
        try {
            certame = new Certame();
            listCertame = new ArrayList<>();
            listCertame = certameControle.findAll();

            return redirect("/admin/certame/formCertame.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public void salvar() {
        try {
            certameControle.salvar(certame);
            showFacesMessage("salvo com sucesso!!!", 2);
            certame = new Certame();
            listCertame = new ArrayList<>();
            listCertame = certameControle.findAll();

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
        }
    }

    public String editar(Certame aux) {
        try {
            certame = certameControle.pegaCertameId(aux.getId());

            return redirect("/admin/certame/formCertame.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public String listarCertamesAbertos() {
        try {
            listCertame = new ArrayList<>();
            listCertame = certameControle.findAllAbertos();
            return redirect("/sistema/usuario/formListaCertamesAbertos.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public String iniciarInscricaoCertames(Certame entity) {
        try {
            System.out.println("teste");
            pessoa = new Pessoa();
            HttpSession session = UtilSession.getSession();
            Integer aux = Integer.parseInt(session.getAttribute("userid").toString());
            
            pessoa = pessoaControle.pegaPessoaId(aux);
            certame = new Certame();
            certame = certameControle.pegaCertameId(entity.getId());
            inscricao = new Inscricao();
            inscricao.setIdCertame(certame);
            inscricao.setIdPessoa(pessoa);
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date dtAtual = new Date();
            formatador.format(dtAtual);
            //Date data1 = formatador.parse(dataAtual);
            //Date data2 = formatador.parse(certame.getDataFimIsencao().toString());
            //if (data1.compareTo(data2) > 0) {
             //   this.dtIsento = false;
           // }

            //System.out.println(dtAtual);
            System.out.println(certame.getDataFimIsencao());

            System.out.println(entity.getTitulo());
            System.out.println(pessoa.getNome());

            if (pessoa == null) {
                System.out.println("Candidato Não Localizado");
                showFacesMessage("Candidato não localizado!!!", 4);
                return null;
            }
            
            
            return redirect("/sistema/usuario/formInscricao.xhtml");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    
    public void getListaTipoVagas(final SelectEvent event){
        final Cargo tmp = (Cargo) event.getObject();
        
        System.out.println("Selecionou esse: "+tmp.getCargoVagasList());
    }

    public Certame getCertame() {
        return certame;
    }

    public void setCertame(Certame certame) {
        this.certame = certame;
    }

    public List<Certame> getListCertame() {
        return listCertame;
    }

    public void setListCertame(List<Certame> listCertame) {
        this.listCertame = listCertame;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public String getDataAtual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(dataAtual);
        //return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public boolean isDtIsento() {
        return dtIsento;
    }

    public void setDtIsento(boolean dtIsento) {
        this.dtIsento = dtIsento;
    }

    public List<TipoVaga> getListTipoVaga() {
        return listTipoVaga;
    }

    public void setListTipoVaga(List<TipoVaga> listTipoVaga) {
        this.listTipoVaga = listTipoVaga;
    }

    
    
}
