//Aluno: Vinícius Henrique Giovanini
//Matricula: 692225
//Matéria: AEDS2

//ANOTACOES: O métodos pesquisar está errado pois ele tem que conferir cada subarvore

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class NoARVARV {
  public String elemento; // Conteudo do no.
  public NoARVARV esq, dir; // Filhos da esq e dir.
  public ArvoreArvoreBinaria subarvore;

  /**
   * Construtor da classe.
   * 
   * @param elemento Conteudo do no.
   */
  public NoARVARV(String elemento) {
    this(elemento, null, null, null);
  }

  /**
   * Construtor da classe.
   * 
   * @param elemento Conteudo do no.
   * @param esq      No da esquerda.
   * @param dir      No da direita.
   */
  public NoARVARV(String elemento, NoARVARV esq, NoARVARV dir, ArvoreArvoreBinaria subraiz) {
    this.subarvore = subraiz;
    this.elemento = elemento;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}

class ArvoreArvoreBinaria {

  // Essa classe é a classe de operacoes da arvore binaria, ela pega a árvore e
  // faz insercao remocao e pesquisa, e todas elas de String, usando a minha
  // funcao palavras crescentes, coloquei um int pra receber a comparacao do x com
  // i.elemento no inicio de toda a funcao de remocao insercao e pesquisa, dessa
  // forma, ele analisa se uma palavra é maior que a outra na ordem alfabetica e
  // faz else if a partir disso

  public int palavrasCRESCENTES(String um, String dois) {

    // Essa função analisa sempre as 2 palavras posicao por posicao.
    // Ela faz isso pegando o tamanho da string menor e analisando todas as letras
    // das 2 string até esse numero, para o for nao comparar a letra que tem a mais
    // na string maior com vazio.
    // Depois ele tem que sempre ignorar letras de espaços que não são comparados.
    // Ai ele pega sempre a letra na posicao 0 da string 1 com a letra da posicao 0
    // da string 2, se a primeira letra que aparecer diferente da string 2 com a
    // string 1 for menor que a letra diferente da string 1, ele transforma em true
    // a resposta, deixando a palavra presente na casa dois da função habilidade
    // para ser trocado com a string presente na casa um, isso quer dizer que ordem
    // alfabetica, a string dois vem antes da string um.
    // Se for achando as letras diferentes e string1 < string2 ele termina a funcao
    // pois não precisa ser feita a troca

    char[] letraSTR1 = new char[50];
    letraSTR1 = um.toCharArray();
    int valorSTR1 = 0;
    char[] letraSTR2 = new char[50];
    letraSTR2 = dois.toCharArray();
    int valorSTR2 = 0;
    int resp = 0;
    boolean testaro2 = false;

    int valormenor = 1000;

    int tam1 = um.length();
    int tam2 = dois.length();
    int tamanhofor = 0;

    if (tam1 < tam2) {

      tamanhofor = tam1;

    }

    if (tam2 < tam1) {

      tamanhofor = tam2;

    }

    if (tam1 == tam2) {

      tamanhofor = tam1;

    }

    for (int i = 0; i < tamanhofor; i++) {

      if (letraSTR1[i] != ' ' && letraSTR2[i] != ' ') {

        valorSTR1 = (int) letraSTR1[i];
        valorSTR2 = (int) letraSTR2[i];
      }

      if (valorSTR1 != valorSTR2) {

        if (valorSTR1 > valorSTR2) {

          if (valormenor > valorSTR2) {

            valormenor = valorSTR2;
            resp = 1;
            i = letraSTR2.length;
          }
        }

        if (valorSTR1 < valorSTR2) {

          i = tamanhofor;
          resp = 0;
          testaro2 = true;
        }
      }
    }

    if (tam1 == tam2 && testaro2 == false) {

      if (resp == 0) {

        resp = 2;

      }

    }

    return resp;

  }

  private NoARVARV raiz; // Raiz da arvore.

  /**
   * Construtor da classe.
   */
  public ArvoreArvoreBinaria() {
    raiz = null;

  }

  public boolean pesquisar(String x, int palavrasCRESCENTES) {
    return pesquisar(x, raiz, palavrasCRESCENTES);
  }

  private boolean pesquisar(String x, NoARVARV i, int palavrasCRESCENTES) {

    if (i != null) {
      char letra = x.charAt(0);
      String letrastr = String.valueOf(letra);
      palavrasCRESCENTES = palavrasCRESCENTES(letrastr, i.elemento);

    }

    boolean resp;
    if (i == null) {
      resp = false;

    } else if (palavrasCRESCENTES == 2) {

      resp = pesquisar2(x, i.subarvore.raiz, palavrasCRESCENTES);

    } else if (palavrasCRESCENTES == 0) {
      System.out.print("ESQ ");
      resp = pesquisar(x, i.esq, palavrasCRESCENTES);

    } else {
      System.out.print("DIR ");
      resp = pesquisar(x, i.dir, palavrasCRESCENTES);
    }
    return resp;

  }

  public boolean pesquisar2(String x, int palavrasCRESCENTES) {
    return pesquisar2(x, raiz.subarvore.raiz, palavrasCRESCENTES);
  }

  private boolean pesquisar2(String x, NoARVARV i, int palavrasCRESCENTES) {

    if (i != null) {

      palavrasCRESCENTES = palavrasCRESCENTES(x, i.elemento);

    }

    boolean resp;
    if (i == null) {
      resp = false;

    } else if (palavrasCRESCENTES == 2) {

      resp = true;

    } else if (palavrasCRESCENTES == 0) {
      System.out.print("esq ");
      resp = pesquisar2(x, i.esq, palavrasCRESCENTES);

    } else {
      System.out.print("dir ");
      resp = pesquisar2(x, i.dir, palavrasCRESCENTES);
    }
    return resp;

  }

  public void inserir(String x) throws Exception {
    raiz = inserir(x, raiz, 0);
  }

  private NoARVARV inserir(String x, NoARVARV i, int palavrasCRESCENTES)
      throws Exception {

    if (i != null) {
      palavrasCRESCENTES = palavrasCRESCENTES(i.elemento, x);
    }

    if (i == null) {
      i = new NoARVARV(x);

    } else if (palavrasCRESCENTES == 1) {
      // System.out.println("INSERIU A ESQUERDA");
      i.esq = inserir(x, i.esq, palavrasCRESCENTES);

    } else if (palavrasCRESCENTES == 0) {
      // System.out.println("INSERIU A DIREITA");
      i.dir = inserir(x, i.dir, palavrasCRESCENTES);

    } else {
      throw new Exception("Erro ao inserir!");
    }

    return i;
  }

  public void inserirSubarvore(String x, ArvoreArvoreBinaria arv) throws Exception {
    arv.raiz = inserirSubarvore(x, arv.raiz, 0);
  }

  private NoARVARV inserirSubarvore(String x, NoARVARV i, int palavrasCRESCENTES)
      throws Exception {

    if (i != null) {
      palavrasCRESCENTES = palavrasCRESCENTES(i.elemento, x);
    }

    if (i == null) {

      i = new NoARVARV(x);

    } else if (palavrasCRESCENTES == 1) {
      // System.out.println("INSERIU A ESQUERDA");
      i.esq = inserirSubarvore(x, i.esq, palavrasCRESCENTES);

    } else if (palavrasCRESCENTES == 0) {
      // System.out.println("INSERIU A DIREITA");
      i.dir = inserirSubarvore(x, i.dir, palavrasCRESCENTES);

    } else {
      throw new Exception("Erro ao inserir!");
    }

    return i;
  }

  public void inserirARV2(String x) throws Exception {
    raiz = inserirARV2(x, raiz, 0);
  }

  private NoARVARV inserirARV2(String x, NoARVARV i, int palavrasCRESCENTES) throws Exception {

    char letra = x.charAt(0);
    String letrastr = String.valueOf(letra);

    palavrasCRESCENTES = palavrasCRESCENTES(i.elemento, letrastr);

    if (palavrasCRESCENTES == 2) {

      if (i.subarvore == null) {
        i.subarvore = new ArvoreArvoreBinaria();
        inserirSubarvore(x, i.subarvore);

      } else {
        inserirSubarvore(x, i.subarvore);
      }

    } else if (palavrasCRESCENTES == 1) {
      // System.out.print("esq ");
      inserirARV2(x, i.esq, palavrasCRESCENTES);

    } else {
      // System.out.print("dir ");
      inserirARV2(x, i.dir, palavrasCRESCENTES);
    }

    return i;
  }

  public boolean pesquisarCerto(String id) {
    System.out.print("raiz ");
    return pesquisarCerto(raiz, id, 100);
  }

  private boolean pesquisarCerto(NoARVARV i, String nome, int palavrasCRESCENTES) {
    boolean resp = false;
    NoARVARV e = null;
    if (i != null && i.subarvore != null) {
      e = i.subarvore.raiz;
      palavrasCRESCENTES = palavrasCRESCENTES(nome, e.elemento);

    }

    if (i == null) {

      resp = false;

    } else if (pesquisarCerto2(e, nome, 100) == true) {

      resp = true;

    } else {

      System.out.print("esq ");
      if (i.esq != null) {
        resp = pesquisarCerto(i.esq, nome, 100);
      }

      if (resp == false) {
        System.out.print("dir ");
        if (i.dir != null) {
          resp = pesquisarCerto(i.dir, nome, 100);
        }

      }
    }

    return resp;
  }
  /*
   * private boolean pesquisarCerto(NoARVARV i, String nome, int
   * palavrasCRESCENTES) {
   * boolean resp = false;
   * NoARVARV e = null;
   * if (i != null && i.subarvore != null) {
   * e = i.subarvore.raiz;
   * palavrasCRESCENTES = palavrasCRESCENTES(nome, e.elemento);
   * 
   * }
   * 
   * if (palavrasCRESCENTES == 2) {
   * 
   * resp = true;
   * 
   * } else if (palavrasCRESCENTES == 1 || palavrasCRESCENTES == 0) {
   * 
   * resp = pesquisarCerto2(e, nome, 100);
   * 
   * }
   * 
   * if (resp == false) {
   * 
   * if (i.esq != null) {
   * System.out.print("esq ");
   * resp = pesquisarCerto(i.esq, nome, 100);
   * }
   * 
   * if (resp == false) {
   * 
   * if (i.dir != null) {
   * System.out.print("dir ");
   * resp = pesquisarCerto(i.dir, nome, 100);
   * }
   * 
   * }
   * }
   * 
   * return resp;
   * }
   */

  public boolean pesquisarCerto2(NoARVARV e, String nome, int palavrasCRESCENTES) {
    boolean resp = false;

    if (e != null) {

      palavrasCRESCENTES = palavrasCRESCENTES(nome, e.elemento);

    }

    if (palavrasCRESCENTES == 2) {

      resp = true;

    } else {

      System.out.print("ESQ ");
      if (e != null) {
        if (e.esq != null) {
          resp = pesquisarCerto(e.esq, nome, 100);
        }
      }

      if (resp == false) {
        System.out.print("DIR ");
        if (e != null) {
          if (e.dir != null) {
            resp = pesquisarCerto(e.dir, nome, 100);
          }
        }

      }
    }

    return resp;

  }

}

class SerieARVOREARVORE {

  private String nome;
  private String formato;
  private String duracao;
  private String pais;
  private String idioma;
  private String emissora;
  private String transmissao;
  private int ntemp;
  private String receberntemp;
  private int nepisodio;
  private String recebernepisodio;
  public String juntado;

  // NA CLASSE TODAS RECEBEM A STRING TODA SUJA PELO SET NOME E MANDA PRO GETNOME,
  // QUANDO É ACIONADO O BUSCAR NO MAIS, O MÉTODO BUSCAR PEGA A STRING SUJA E
  // COMECA A LIMPAR, E ELE LIMPA SEMPRE ENTRE > < DEIXANDO SOMENTE O CONTÉUDO
  // DENTRO DESSE ELEMENTOS PRESENTE NA STRING, ELE FAZ ESSA "LIMPEZA", COPIANDO
  // OS ELEMENTOS DENTRO DE > < PARA OUTRO ARRAY.

  // ------------------------------NOME------------------------------//

  public String getNome() {
    return this.nome;
  }

  public void setNome(String recebernome) {
    this.nome = recebernome;
  }

  public void buscanome() {

    String buscar = getNome();// MANDOU A STRING SUJA QUE ESTAVA EM GETNOME PARA A VARIAVEL BUSCAR
    char[] vetor = buscar.toCharArray();// SETOU ESSE VETOR COM CADA POSICAO UM ELEMENTO PRESENTE NA STRING SUJA
    char[] vetorreceber = new char[buscar.length()];// SETOU UM VETOR VAZIO COM O TAMANHO DO VETOR SUJO
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {// CADA MÉTODO TEM SUA ESPECIFICAÇÃO NESSA PARTE, O MÉTODO BUSCAR NOME
                                               // BUSCAR O NOME ATÉ ENCONTRAR UMA "/", QUANDO ELE ENCONTRA UMA BARRA
                                               // ELE
                                               // FINALIZA A BUSCA PARA ECONOMIZAR PROCESSOS, E NESSE MÉTODO É
                                               // IGNORADO
                                               // PARENTESES.

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '(' && vetor[k] != ')' && vetor[k] != '>') {// QUANDO É ENCONTRADO UM VALOR
                                                                                      // ENTRE > < ESSE VALOR É
                                                                                      // COPIADO
                                                                                      // PARA A PRIMEIRA POSICAO DO
                                                                                      // VETORRECEBER, ISSO OCORRE
                                                                                      // POIS
                                                                                      // SE NÃO FOR FEITO ISSO A
                                                                                      // STRING
                                                                                      // VAI FICAR NA POSICAO ONDE FOI
                                                                                      // ACHADA QUE GERALMENTE NÃO É A
                                                                                      // PRIMEIRA POSIÇÃO

        vetorreceber[contador] = vetor[k];
        contador++;
      }

      if (vetor[k] == '/') {

        k = buscar.length() - 1;

      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {// ESSE FOR ESTÁ PRESENTE EM TODOS OS MÉTODOS, ELE É ENCARREGADO DE
                                                   // CONTAR QUANTAS POSIÇÕES DO VETOR ESTÁ PRESENTE ALGUM TIPO DE
                                                   // VALOR, POIS COMO FOI
                                                   // FEITO NO ÍNICIO O VETOR RECEBER FOI SETADO COM A QUANTIDADE DE
                                                   // POSICOES PRESENTE NA STRING SUJA, QUANDO ELA FOI LIMPADA E FOI
                                                   // COPIADO PARA ESSE VETOR FICOU SOBRANDO AS POSIÇÕES NÃO COPIADAS,
                                                   // E
                                                   // DESSA FORMA O CONTADORF, CONTA QUANTAS POSIÇÕES ESTÃO COM VALOR
                                                   // NO
                                                   // VETOR RECEBER.

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {// DEPOIS DE CONTAR A QUANTIDADE DE POSICOES SEM ESTAR VAZIA, ESSE FOR VAI
                                         // FAZER EXATAMENTE O LOOP DE QUANTIDADE DE VALORES VALIDOS, JÁ QUE OS
                                         // VALORES
                                         // DO VETOR RECBER FORAM COPIADOS PARA A POSICAO 1,2,3 ASSIM EM DIANTE, É SO
                                         // COPIAR ESSAS POSIÇÕES INICIAIS PARA OUTRO VETOR, E QUANDO ACABAR OS
                                         // VALORES
                                         // VALIDOS O FOR VAI ACABAR, FICANDO PRESENTE NO VETOR FINAL SOMENTE VALORES
                                         // VALIDOS.

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);// ESSE COMANDO VAI PEGAR A STRING LIMPA E COM POSIÇÕES OCUPADAS POR
                                                // VALORES VALIDOS E VAI CONVERTER EM STRING
    this.nome = receber;// AQUI VAI RETORNAR PRA VARIAVEL/OBJ NOME QUE VAI PARA O MÉTODO GETNOME

  }

  // ------------------------------FORMATO------------------------------//

  public String getFormato() {
    return this.formato;
  }

  public void setFormato(String receberFormato) {
    this.formato = receberFormato;
  }

  public void buscaformato() {// BUSCA DA MESMA MANEIRA DO QUE NOME BUSCA

    String buscar = getFormato();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '(' && vetor[k] != ')' && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    this.formato = receber;

  }

  // ------------------------------DURAÇÃO------------------------------//

  public String getDuracao() {
    return this.duracao;
  }

  public void setDuracao(String receberDuracao) {
    this.duracao = receberDuracao;
  }

  public void buscaduracao() {// BUSCA DURAÇÃO TEM UMA DIFERENÇA, LA NO FINAL DO MÉTODO

    String buscar = getDuracao();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();// ESSE COMANDO ELEMINA QUALQUER TIPO DE ESPAÇO PRESENTE NO COMEÇO OU NO FINAL
                             // DA STRING E DEPOIS RETORNA PARA A VARIAVEL DURAÇÃO
    this.duracao = receber;
  }

  // ------------------------------Pais de Origem------------------------------//

  public String getPais() {
    return this.pais;
  }

  public void setPais(String receberPais) {
    this.pais = receberPais;
  }

  public void buscapais() {

    String buscar = getPais();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<' || vetor[k] == '&') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>' && vetor[k] != '&' && vetor[k] != '#' & vetor[k] != '1'
          && vetor[k] != '6'
          && vetor[k] != '0' && vetor[k] != ';') {// AQUI TEM UMA DIFERENÇA NA LINHA PEGADA QUANDO SE SETA PAIS DE
                                                  // ORIGEM DE CARACTERES INDESEJADOS ENTRE > <, DESSA FORMA COLOQUEI
                                                  // NO
                                                  // IF TODOS ELES PARA SEREM IGNORADOS COMO POR EXEMPLO >&#160;<

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();

    this.pais = receber;
  }

  // ------------------------------Idioma------------------------------//
  public String getIdioma() {
    return this.idioma;
  }

  public void setIdioma(String receberIdioma) {
    this.idioma = receberIdioma;
  }

  public void buscaidioma() {

    String buscar = getIdioma();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();
    this.idioma = receber;
  }

  // ------------------------------Emissora_de_TV------------------------------//
  public String getEmissora() {
    return this.emissora;
  }

  public void setEmissora(String receberEmissora) {
    this.emissora = receberEmissora;
  }

  public void buscaemissora() {

    String buscar = getEmissora();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;
    int receberk = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    /*
     * int tamanhostring = getEmissora().length();
     * 
     * if (tamanhostring <= 300) {
     * 
     * receberk = 0;
     * 
     * }
     * 
     * if (tamanhostring >= 300) { receberk = 620; }
     */

    for (int k = receberk; k < buscar.length(); k++) {

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();
    this.emissora = receber;
  }

  // ------------------------------Transmissao_Original------------------------------//
  public String getTrasmissao() {
    return this.transmissao;
  }

  public void setTrasmissao(String receberTrasmissao) {
    this.transmissao = receberTrasmissao;
  }

  public void buscatrasmissao() {

    String buscar = getTrasmissao();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<' || vetor[k] == '&') {

        marcador = false;

      }

      if (vetor[k] == '>' || vetor[k] == '(') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();
    this.transmissao = receber;
  }

  // ------------------------------Número_de_Temporadas------------------------------//

  // ESSE MÉTODO AQUI É DIFERENTE DOS OUTROS, POIS ELE SE TRATADA DE NUMERO
  // INTEIRO PARA SER RETORNADO, DESSA FORMA, ELE RECEBE A STRING SUJA COM
  // SETNTEMPORADAS E SO PODE SER ACESSADA COM GETNTEMPORADAS, DESSA FORMA FOI
  // CRIADO MAIS UM GETNTEMPORADAS COM VALOR INT, O PQ VAI SER EXPLICADO NO FINAL
  // DO MÉTODO

  public String getNtemporadas() {
    return this.receberntemp;
  }

  public void setNtemporadas(String receberNtemporadas) {
    this.receberntemp = receberNtemporadas;
  }

  public int getNtemporadasINTEIRO() {
    return this.ntemp;
  }

  public void buscaNtemporadas() {// DESSA FORMA ELE VAI FAZER A BUSCA

    String buscar = getNtemporadas();// AQUI VAI SER MANDADO A STRING SUJA
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<' || vetor[k] == '&') {// TODO VEZ QUE VETOR NA POSICAO K FOR IGUAL A < OU & ELE VAI PARAR DE
                                               // SALVAR O VALOR CONTIDO LOGO APOS

        marcador = false;

      }

      if (vetor[k] == '>' || vetor[k] == '(') {// TODA VEZ QUE O VETOR FOR IGUAL A > OU ( ELE VAI COMECAR A SALVAR OS
                                               // VALORES QUE VEM EM SEGUIDA (NA VDD ELE BOTA O MARCADOR COMO TRUE,
                                               // DIZENDO ASSIM QUE PODE COMECAR A SALVAR)

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {// PARA EVITAR SALVAR O > COLOQUEI QUE SE O CARACTER PRESENTE NO VETOR
                                                // FOR IGUAL AO > ELE N SALVAR, DESSA FORMA ELE SO VAI COMEÇAR A
                                                // SALVAR
                                                // NO PROXIMO LOOP. E ELE VAI PEGAR O CARACTER APTO A SER SALVO E
                                                // SALVAR
                                                // NA PRIMEIRA POSIÇÃO DO VETOR RECEBER, E ASSIM POR DIANTE.

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadu = 0;

    // AQUI É DIFERENTE TAMBÉM

    for (int j = 0; j < 2; j++) {

      if (vetorreceber[j] == '0' || vetorreceber[j] == '1' || vetorreceber[j] == '2' || vetorreceber[j] == '3'
          || vetorreceber[j] == '4' || vetorreceber[j] == '5' || vetorreceber[j] == '6' || vetorreceber[j] == '7'
          || vetorreceber[j] == '8' || vetorreceber[j] == '9') {// PARA RETIRAR AS POSICÕES VAZIAS, JA QUE QUEREMOS
                                                                // SOMENTE UM NUMERO, SE O VETOR RECEBER TIVER ALGUEM
                                                                // NUMERO, O CONTADOR VAI SER ACIONADO

        contadu++;

      }

    }

    char[] vetorfinal = new char[contadu];// ABRI O VETOR FINAL QUE VAI TER O TAMANHO IGUAL A QUANTIDADE DE CARACTERES
                                          // PRESENTE NO VETOR RECEBER QUE FOI SETADO NO FOR ACIMA

    for (int v = 0; v < vetorfinal.length; v++) {// ESSE FOR VAI SER EXECUTADO SÓ ATÉ A QUANTIDADE DE CARACTERES
                                                 // PRESENTE NO VETOR RECEBER QUE FOI CONTADO COM CONTADU

      vetorfinal[v] = vetorreceber[v]; // JA QUE OS CARACTERES ESTÃO NA PRIMEIRA POSICAO EM VETOR RECEBER, VAI PASSAR
                                       // PARA VETOR FINAL TAMBÉM NA PRIMEIRA POSICAO PORÉM VETOR RECEBER ESTÁ COM
                                       // POSICÕES DE TODOS OS CARACTERES DA STRING SUJA, E AGORA QUEREMOS UM VETOR
                                       // SOMENTE COM POSIÇÕES DO CARACTERES DESEJADOS

    }

    String receber = String.valueOf(vetorfinal);// CONVERTER A STRING VETOR FINAL PARA STRING RECEBER
    int intconvertido = Integer.valueOf(receber);// AQUI QUE VEM O DIFERENCIAL, ESSE MÉTODO TEM QUE SER RETORNADO INT,
                                                 // DESSA FORMA PEGAMOS O VALOR PRESENTE NA STRING RECEBER QUE É UM
                                                 // CARACTER NUMERICO E CONVERTEMOS PARA INT, MANDANDO PARA
                                                 // INTCONVERTIDO.
    this.ntemp = intconvertido; // LOGO EM SEGUIDA RETORNARMOS O NUMERO INTEIRO PARA O NTEMP, QUE SO PODE SER
                                // ACESSADO COM GETNTEMPO, POIS É UM ATRIBUTO PRIVADO
  }
  // ------------------------------Número_de_Episodios------------------------------//

  // O NÚMERO DE EP USA A LOGICA EXPLICADA ACIMA, POIS TAMBÉM REQUER UM NUMERO
  // INTEIRO PARA SER RETORNADO.

  public String getNepisodio() {
    return this.recebernepisodio;
  }

  public void setNepisodio(String receberNepisodio) {
    this.recebernepisodio = receberNepisodio;
  }

  public int getNepisodioINTEIRO() {
    return this.nepisodio;
  }

  public void buscaNepisodio() {

    String buscar = getNepisodio();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    for (int k = 0; k < 54; k++) {

      if (vetor[k] == '<' || vetor[k] == '&') {

        marcador = false;

      }

      if (vetor[k] == '>' || vetor[k] == '(') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadu = 0;

    for (int j = 0; j < 3; j++) {

      if (vetorreceber[j] == '0' || vetorreceber[j] == '1' || vetorreceber[j] == '2' || vetorreceber[j] == '3'
          || vetorreceber[j] == '4' || vetorreceber[j] == '5' || vetorreceber[j] == '6' || vetorreceber[j] == '7'
          || vetorreceber[j] == '8' || vetorreceber[j] == '9') {

        contadu++;

      }

    }

    char[] vetorfinal = new char[contadu];

    for (int v = 0; v < vetorfinal.length; v++) {

      vetorfinal[v] = vetorreceber[v];

    }

    String receber = String.valueOf(vetorfinal);
    int intconvertido = Integer.valueOf(receber);
    this.nepisodio = intconvertido;
  }

  public void juntar() {

    String ntempconvert;
    String nepconvert;

    juntado = getNome();
    juntado += " ";
    juntado += getFormato();
    juntado += " ";
    juntado += getDuracao();
    juntado += " ";
    juntado += getPais();
    juntado += " ";
    juntado += getIdioma();
    juntado += " ";
    juntado += getEmissora();
    juntado += " ";
    juntado += getTrasmissao();
    juntado += " ";
    ntempconvert = Integer.toString(getNtemporadasINTEIRO());
    juntado += ntempconvert;
    juntado += " ";
    nepconvert = Integer.toString(getNepisodioINTEIRO());
    juntado += nepconvert;

  }

}

public class arvorearvore {

  public static void primeiraarvore(ArvoreArvoreBinaria arv1) throws Exception {

    arv1.inserir("D");
    arv1.inserir("R");
    arv1.inserir("Z");
    arv1.inserir("X");
    arv1.inserir("V");
    arv1.inserir("B");
    arv1.inserir("F");
    arv1.inserir("P");
    arv1.inserir("U");
    arv1.inserir("I");
    arv1.inserir("G");
    arv1.inserir("E");
    arv1.inserir("J");
    arv1.inserir("L");
    arv1.inserir("H");
    arv1.inserir("T");
    arv1.inserir("A");
    arv1.inserir("W");
    arv1.inserir("S");
    arv1.inserir("O");
    arv1.inserir("M");
    arv1.inserir("N");
    arv1.inserir("K");
    arv1.inserir("C");
    arv1.inserir("Y");
    arv1.inserir("Q");

  }

  public static void main(String[] args) throws Exception {

    String entrada;

    SerieARVOREARVORE nt = new SerieARVOREARVORE();
    ArvoreArvoreBinaria arv1 = new ArvoreArvoreBinaria();

    primeiraarvore(arv1);

    entrada = MyIO.readLine();

    while (!(entrada.equals("FIM"))) {

      try {

        // MEU DIRETORIO
        // "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/"

        BufferedReader in = new BufferedReader(new FileReader("/tmp/series/" + entrada));

        String str;
        while ((str = in.readLine()) != null) {

          if (str.contains("firstHeading")) {

            nt.setNome(str);
            nt.buscanome();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Formato</td>")) {// BUSCAR
                                                                                                                     // O
                                                                                                                     // FORMATO
            str = in.readLine();
            nt.setFormato(str);
            nt.buscaformato();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Duração</td>")) {// BUSCAR
                                                                                                                     // A
                                                                                                                     // DURAÇÃO

            str = in.readLine();
            nt.setDuracao(str);
            nt.buscaduracao();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">País de origem</td>")) {// BUSCAR
                                                                                                                            // O
                                                                                                                            // PAIS
                                                                                                                            // DE
                                                                                                                            // ORIGEM
            str = in.readLine();
            nt.setPais(str);
            nt.buscapais();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Idioma original</td>")) {// BUSCAR
                                                                                                                             // O
                                                                                                                             // IDIOMA

            str = in.readLine();
            nt.setIdioma(str);
            nt.buscaidioma();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Emissora de televisão original</td>")) {// BUSCAR
                                                                                                                                            // A
                                                                                                                                            // EMISSORA
            str = in.readLine();
            nt.setEmissora(str);
            nt.buscaemissora();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Transmissão original</td>")) {// BUSCAR
                                                                                                                                  // A
                                                                                                                                  // TRANSMISSAO
            str = in.readLine();
            nt.setTrasmissao(str);
            nt.buscatrasmissao();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de temporadas</td>")) {// BUSCAR
                                                                                                                               // O
                                                                                                                               // NUMERO
                                                                                                                               // DE
                                                                                                                               // TEMPORADAS
            str = in.readLine();
            nt.setNtemporadas(str);
            nt.buscaNtemporadas();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de episódios</td>")) {// BUSCAR
                                                                                                                              // O
                                                                                                                              // NUMERO
                                                                                                                              // DE
                                                                                                                              // EPISODIOS
            str = in.readLine();
            nt.setNepisodio(str);
            nt.buscaNepisodio();

          }

        }
        in.close();

      } catch (IOException e) { // CASO NAO ENCONTRE O ARQUIVO RETORNA O ERRO
        System.out.println("ERROR IOEXCEPTION");
      }
      arv1.inserirARV2(nt.getNome());
      entrada = MyIO.readLine();

    }

    // QUANDO TERMINAR DE ADICIONAR ELEMENTOS NA LISTA VAI COMEÇAR A PESQUISA
    // -------------------------------SEGUNDA PARTE-------------------------//

    String entrada3 = " ";

    entrada3 = MyIO.readLine();

    while (!(entrada3.equals("FIM"))) {

      Boolean receber = false;

      // System.out.print("raiz ");

      receber = arv1.pesquisarCerto(entrada3);

      if (receber == true) {

        System.out.println("SIM");

      } else {
        System.out.println("NAO");
      }

      entrada3 = MyIO.readLine();

    }

  }

}

/*
 * System.out.print("raiz");
 * System.out.print(" ");
 * 
 * boolean receber = arv1.pesquisar(entrada3, 100);
 * 
 * if (receber == true) {
 * 
 * System.out.println("SIM");
 * 
 * } else {
 * System.out.println("NAO");
 * }
 * 
 * entrada3 = MyIO.readLine();
 */