//Aluno: Vinícius Henrique Giovanini
//Matricula: 692225
//Matéria: AEDS2

//ANOTACOES: PROGRAMA DEU 90% certo, uma linha deu errada

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class NoAN {
  public boolean cor;
  public String elemento;
  public NoAN esq, dir;

  public NoAN() {
    this(null);
  }

  public NoAN(String elemento) {
    this(elemento, false, null, null);
  }

  public NoAN(String elemento, boolean cor) {
    this(elemento, cor, null, null);
  }

  public NoAN(String elemento, boolean cor, NoAN esq, NoAN dir) {
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}

class Alvinegra {

  public static int palavrasCRESCENTES(String um, String dois) {

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

  private NoAN raiz; // Raiz da arvore.

  /**
   * Construtor da classe.
   */
  public Alvinegra() {
    raiz = null;
  }

  /**
   * Metodo publico iterativo para pesquisar elemento.
   * 
   * @param elemento Elemento que sera procurado.
   * @return <code>true</code> se o elemento existir,
   *         <code>false</code> em caso contrario.
   */
  public boolean pesquisar(String x) {
    return pesquisar(x, raiz);
  }

  /**
   * Metodo privado recursivo para pesquisar elemento.
   * 
   * @param elemento Elemento que sera procurado.
   * @param i        NoAN em analise.
   * @return <code>true</code> se o elemento existir,
   *         <code>false</code> em caso contrario.
   */
  private boolean pesquisar(String x, NoAN i) {
    int palavrasCRESCENTES = 100;

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
      resp = pesquisar(x, i.esq);
    } else {
      System.out.print("dir ");
      resp = pesquisar(x, i.dir);
    }
    return resp;
  }

  /**
   * Metodo publico iterativo para inserir elemento.
   * 
   * @param elemento Elemento a ser inserido.
   * @throws Exception Se o elemento existir.
   */
  public void inserir(String elemento) throws Exception {

    int palavrasCRESCENTES = 100;
    int palavrasCRESCENTES2 = 100;
    int palavrasCRESCENTES3 = 100;

    if (raiz != null) {

      palavrasCRESCENTES = palavrasCRESCENTES(elemento, raiz.elemento);

      if (raiz.dir != null) {
        palavrasCRESCENTES2 = palavrasCRESCENTES(elemento, raiz.dir.elemento);

      }

      if (raiz.esq != null) {
        palavrasCRESCENTES3 = palavrasCRESCENTES(elemento, raiz.esq.elemento);
      }

    }
    if (raiz == null) {
      raiz = new NoAN(elemento);
      // System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento +
      // ").");

      // Senao, se a arvore tiver um elemento
    } else if (raiz.esq == null && raiz.dir == null) {
      if (palavrasCRESCENTES == 0) {
        raiz.esq = new NoAN(elemento);
        // System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e
        // esq(" + raiz.esq.elemento + ").");
      } else {
        raiz.dir = new NoAN(elemento);
        // System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e
        // dir(" + raiz.dir.elemento + ").");
      }

      // Senao, se a arvore tiver dois elementos (raiz e dir)
    } else if (raiz.esq == null) {
      if (palavrasCRESCENTES == 0) {
        raiz.esq = new NoAN(elemento);
        // System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento +
        // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");

      } else if (palavrasCRESCENTES2 == 0) {
        raiz.esq = new NoAN(raiz.elemento);
        raiz.elemento = elemento;
        // System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento +
        // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");

      } else {
        raiz.esq = new NoAN(raiz.elemento);
        raiz.elemento = raiz.dir.elemento;
        raiz.dir.elemento = elemento;
        // System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento +
        // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
      }
      raiz.esq.cor = raiz.dir.cor = false;

      // Senao, se a arvore tiver dois elementos (raiz e esq)
    } else if (raiz.dir == null) {
      if (palavrasCRESCENTES == 1) {
        raiz.dir = new NoAN(elemento);
        // System.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento +
        // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");

      } else if (palavrasCRESCENTES3 == 1) {
        raiz.dir = new NoAN(raiz.elemento);
        raiz.elemento = elemento;
        // System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento +
        // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");

      } else {
        raiz.dir = new NoAN(raiz.elemento);
        raiz.elemento = raiz.esq.elemento;
        raiz.esq.elemento = elemento;
        // System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento +
        // "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
      }
      raiz.esq.cor = raiz.dir.cor = false;

      // Senao, a arvore tem tres ou mais elementos
    } else {
      // System.out.println("Arvore com tres ou mais elementos...");
      inserir(elemento, null, null, null, raiz, 100, 100);
    }

    raiz.cor = false;
  }

  private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {

    int palavrasCRESCENTES = 100;
    int palavrasCRESCENTES2 = 100;
    int palavrasCRESCENTES4 = 100;

    if (i != null) {

      if (pai != null && avo != null) {
        palavrasCRESCENTES = palavrasCRESCENTES(pai.elemento, avo.elemento);
      }

      if (pai != null) {
        palavrasCRESCENTES2 = palavrasCRESCENTES(i.elemento, pai.elemento);

      }

      if (avo != null && bisavo != null) {
        palavrasCRESCENTES4 = palavrasCRESCENTES(avo.elemento, bisavo.elemento);
      }

    }

    // Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
    if (pai.cor == true) {
      // 4 tipos de reequilibrios e acoplamento
      if (palavrasCRESCENTES == 1) { // rotacao a esquerda ou direita-esquerda
        if (palavrasCRESCENTES2 == 1) {
          avo = rotacaoEsq(avo);
        } else {
          avo = rotacaoDirEsq(avo);
        }
      } else { // rotacao a direita ou esquerda-direita
        if (palavrasCRESCENTES2 == 0) {
          avo = rotacaoDir(avo);
        } else {
          avo = rotacaoEsqDir(avo);
        }
      }
      if (bisavo == null) {
        raiz = avo;
      } else if (palavrasCRESCENTES4 == 0) {
        bisavo.esq = avo;
      } else {
        bisavo.dir = avo;
      }
      // reestabelecer as cores apos a rotacao
      avo.cor = false;
      avo.esq.cor = avo.dir.cor = true;
      // System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e
      // avo.esq / avo.dir("
      // + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
    } // if(pai.cor == true)
  }

  /**
   * Metodo privado recursivo para inserir elemento.
   * 
   * @param elemento Elemento a ser inserido.
   * @param avo      NoAN em analise.
   * @param pai      NoAN em analise.
   * @param i        NoAN em analise.
   * @throws Exception Se o elemento existir.
   */
  private void inserir(String elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i, int palavrasCRESCENTES,
      int palavrasCRESCENTES2) throws Exception {

    if (pai != null) {
      palavrasCRESCENTES = palavrasCRESCENTES(elemento, pai.elemento);
    }

    if (i != null) {
      palavrasCRESCENTES2 = palavrasCRESCENTES(elemento, i.elemento);
    }

    if (i == null) {
      if (palavrasCRESCENTES == 0) {
        i = pai.esq = new NoAN(elemento, true);
      } else {
        i = pai.dir = new NoAN(elemento, true);
      }
      if (pai.cor == true) {
        balancear(bisavo, avo, pai, i);
      }
    } else {
      // Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
      if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
        i.cor = true;
        i.esq.cor = i.dir.cor = false;
        if (i == raiz) {
          i.cor = false;
        } else if (pai.cor == true) {
          balancear(bisavo, avo, pai, i);
        }
      }
      if (palavrasCRESCENTES2 == 0) {
        inserir(elemento, avo, pai, i, i.esq, palavrasCRESCENTES, palavrasCRESCENTES2);
      } else if (palavrasCRESCENTES2 == 1) {
        inserir(elemento, avo, pai, i, i.dir, palavrasCRESCENTES, palavrasCRESCENTES2);
      } else {
        throw new Exception("Erro inserir (elemento repetido)!");
      }
    }
  }

  private NoAN rotacaoDir(NoAN no) {
    // System.out.println("Rotacao DIR(" + no.elemento + ")");
    NoAN noEsq = no.esq;
    NoAN noEsqDir = noEsq.dir;

    noEsq.dir = no;
    no.esq = noEsqDir;

    return noEsq;
  }

  private NoAN rotacaoEsq(NoAN no) {
    // System.out.println("Rotacao ESQ(" + no.elemento + ")");
    NoAN noDir = no.dir;
    NoAN noDirEsq = noDir.esq;

    noDir.esq = no;
    no.dir = noDirEsq;
    return noDir;
  }

  private NoAN rotacaoDirEsq(NoAN no) {
    // System.out.println("Fazendo Rotacao Dir Esq");
    no.dir = rotacaoDir(no.dir);
    return rotacaoEsq(no);
  }

  private NoAN rotacaoEsqDir(NoAN no) {
    // System.out.println("Fazendo Rotacao Esq Dir");
    no.esq = rotacaoEsq(no.esq);
    return rotacaoDir(no);
  }
}

class SerieALVI {

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

public class ArvoreAlvinegra {

  public static void main(String[] args) throws Exception {

    String entrada;
    String entrada2;
    entrada = MyIO.readLine();

    SerieALVI nt = new SerieALVI();
    Alvinegra arv = new Alvinegra();
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
      arv.inserir(nt.getNome());
      entrada = MyIO.readLine();

    }

    // QUANDO TERMINAR DE ADICIONAR ELEMENTOS NA LISTA VAI COMEÇAR A PESQUISA
    // -------------------------------SEGUNDA PARTE-------------------------//

    entrada2 = MyIO.readLine();
    while (!(entrada2.equals("FIM"))) {

      Boolean resp = false;

      System.out.print("raiz");
      System.out.print(" ");
      resp = arv.pesquisar(entrada2);
      if (resp == true) {
        System.out.println("SIM");
      } else {
        System.out.println("NAO");
      }
      entrada2 = MyIO.readLine();
    }

  }
}