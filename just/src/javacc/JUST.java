/* Generated By:JavaCC: Do not edit this line. JUST.java */
package javacc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class JUST implements JUSTConstants {
  public static void main(String args []) throws ParseException
  {
    FileInputStream fis = null;
        try {
                fis = new FileInputStream(new File("./just_sources/test1.just"));
        } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }

    JUST parser = new JUST(fis);

    while (true)
    {
      System.out.println("Reading from input...");
      try
      {
        switch (JUST.one_line())
        {
          case 0 :
          System.out.println("OK.");
          break;
          case 1 :
          System.out.println("Goodbye.");
          break;
          default :
          break;
        }
      }
      catch (Exception e)
      {
        System.out.println("NOK.");
        System.out.println(e.getMessage());
        JUST.ReInit(System.in);
      }
      catch (Error e)
      {
        System.out.println("Oops.");
        System.out.println(e.getMessage());
        break;
      }
    }
  }

  static final public int one_line() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PROGRAM:
      CompilationUnit();
      jj_consume_token(SEMICOLON);
    {if (true) return 0;}
      break;
    case SEMICOLON:
      jj_consume_token(SEMICOLON);
    {if (true) return 1;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/*Ab hier einfach die Regeln aus den Folien Abschreiben:
CompilationUnit ="program" ident "{" Definition "}".
Definition={ VarDef| FuncDef}.
VarDef=Type ident[ Init] ";".
Init="=" number.
Type="void" | "int" | "boolean".
FuncDef=FuncHeadBlock.
FuncHead=Type ident "(" [ FormParList] ")".
FormParList=["byref"] Type ident{"," ["byref"] Type ident}.
Block="{" { VarDef| Stat} "}".
Stat=AssignStat| CallStat| IfStat| WhileStat| ReturnStat| Block | ";".


AssignStat=ident "=" Expr";".
CallStat=Call ";".
Call=ident "(" [ ActParList] ")".
ActParList=Expr{ "," Expr}.
IfStat="if" "(" Expr ")" Stat [ "else" Stat ].
WhileStat="while" "(" Expr")" Stat.
ReturnStat="return" [ Expr] ";" .
Expr=OrExpr.
OrExpr=AndExpr{ "||" AndExpr}.
AndExpr=RelExpr{ "&&" RelExpr}.
RelExpr=SimpleExpr[ ("==" | "!=" | "<" | "<=" | ">" | ">=") SimpleExpr].
SimpleExpr=["+" | "-"] Term { ("+" | "-") Term }.
Term=NotFact{ ("*" | "/") NotFact}.
NotFact=["!"] Fact.
Fact=number| ident["(" [ ActParList] ")" ]| "(" Expr")".*/
  static final public void CompilationUnit() throws ParseException {
    jj_consume_token(PROGRAM);
    jj_consume_token(IDENT);
    jj_consume_token(LEFTCURLYBRACKET);
    Definition();
    jj_consume_token(RIGHTTCURLYBRACKET);
  }

  static final public void Definition() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VOID:
      case INT:
      case BOOL:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      if (jj_2_1(2)) {
        VarDef();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case VOID:
        case INT:
        case BOOL:
          FuncDef();
          break;
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  static final public void VarDef() throws ParseException {
    Type();
    jj_consume_token(IDENT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
      Init();
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(SEMICOLON);
  }

  static final public void Init() throws ParseException {
    jj_consume_token(ASSIGN);
    jj_consume_token(NUMBER);
  }

  static final public void Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VOID:
      jj_consume_token(VOID);
      break;
    case INT:
      jj_consume_token(INT);
      break;
    case BOOL:
      jj_consume_token(BOOL);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void FuncDef() throws ParseException {
    FuncHead();
    Block();
  }

  static final public void FuncHead() throws ParseException {
    Type();
    jj_consume_token(IDENT);
    jj_consume_token(LEFTBRACKET);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VOID:
    case INT:
    case BOOL:
    case BYREF:
      FormParList();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    jj_consume_token(RIGHTBRACKET);
  }

  static final public void FormParList() throws ParseException {
    formPar();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COLON:
      case VOID:
      case INT:
      case BOOL:
      case BYREF:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COLON:
        jj_consume_token(COLON);
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
      formPar();
    }
  }

  static final public void formPar() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BYREF:
      jj_consume_token(BYREF);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    Type();
    jj_consume_token(IDENT);
  }

  static final public void Block() throws ParseException {
    jj_consume_token(LEFTCURLYBRACKET);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LEFTCURLYBRACKET:
      case SEMICOLON:
      case VOID:
      case INT:
      case BOOL:
      case RETURN:
      case IF:
      case WHILE:
      case IDENT:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VOID:
      case INT:
      case BOOL:
        VarDef();
        break;
      case LEFTCURLYBRACKET:
      case SEMICOLON:
      case RETURN:
      case IF:
      case WHILE:
      case IDENT:
        Stat();
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(RIGHTTCURLYBRACKET);
  }

  static final public void Stat() throws ParseException {
    if (jj_2_2(2)) {
      AssignStat();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENT:
        CallStat();
        break;
      case IF:
        IfStat();
        break;
      case WHILE:
        WhileStat();
        break;
      case RETURN:
        ReturnStat();
        break;
      case LEFTCURLYBRACKET:
        Block();
        break;
      case SEMICOLON:
        jj_consume_token(SEMICOLON);
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void AssignStat() throws ParseException {
    jj_consume_token(IDENT);
    jj_consume_token(ASSIGN);
    Expr();
    jj_consume_token(SEMICOLON);
  }

  static final public void CallStat() throws ParseException {
    Call();
    jj_consume_token(SEMICOLON);
  }

  static final public void Call() throws ParseException {
    jj_consume_token(IDENT);
    jj_consume_token(LEFTBRACKET);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
    case NOT:
    case LEFTBRACKET:
    case IDENT:
    case NUMBER:
      ActParList();
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
    jj_consume_token(RIGHTBRACKET);
  }

  static final public void ActParList() throws ParseException {
    Expr();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COLON:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_4;
      }
      jj_consume_token(COLON);
      Expr();
    }
  }

  static final public void IfStat() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(LEFTBRACKET);
    Expr();
    jj_consume_token(RIGHTBRACKET);
    Stat();
    if (jj_2_3(2)) {
      jj_consume_token(ELSE);
      Stat();
    } else {
      ;
    }
  }

  static final public void WhileStat() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(LEFTBRACKET);
    Expr();
    jj_consume_token(RIGHTBRACKET);
    Stat();
  }

  static final public void ReturnStat() throws ParseException {
    jj_consume_token(RETURN);
    Expr();
    jj_consume_token(SEMICOLON);
  }

  static final public void Expr() throws ParseException {
    OrExpr();
  }

  static final public void OrExpr() throws ParseException {
    AndExpr();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_5;
      }
      jj_consume_token(OR);
      AndExpr();
    }
  }

  static final public void AndExpr() throws ParseException {
    RelExpr();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_6;
      }
      jj_consume_token(AND);
      RelExpr();
    }
  }

  static final public void RelExpr() throws ParseException {
    SimpleExpr();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQUALS:
    case NQ:
    case GT:
    case GET:
    case LT:
    case LET:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUALS:
        jj_consume_token(EQUALS);
        break;
      case NQ:
        jj_consume_token(NQ);
        break;
      case GT:
        jj_consume_token(GT);
        break;
      case GET:
        jj_consume_token(GET);
        break;
      case LT:
        jj_consume_token(LT);
        break;
      case LET:
        jj_consume_token(LET);
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      SimpleExpr();
      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
  }

  static final public void SimpleExpr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    Term();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        Term();
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Term() throws ParseException {
    NotFact();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
      case DIVIDE:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_8;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
        jj_consume_token(MULTIPLY);
        break;
      case DIVIDE:
        jj_consume_token(DIVIDE);
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      NotFact();
    }
  }

  static final public void NotFact() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      jj_consume_token(NOT);
      break;
    default:
      jj_la1[24] = jj_gen;
      ;
    }
    Fact();
  }

  static final public void Fact() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case IDENT:
      jj_consume_token(IDENT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LEFTBRACKET:
        jj_consume_token(LEFTBRACKET);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
        case MINUS:
        case NOT:
        case LEFTBRACKET:
        case IDENT:
        case NUMBER:
          ActParList();
          break;
        default:
          jj_la1[25] = jj_gen;
          ;
        }
        jj_consume_token(RIGHTBRACKET);
        break;
      default:
        jj_la1[26] = jj_gen;
        ;
      }
      break;
    case LEFTBRACKET:
      jj_consume_token(LEFTBRACKET);
      Expr();
      jj_consume_token(RIGHTBRACKET);
      break;
    default:
      jj_la1[27] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_3R_22() {
    if (jj_scan_token(LEFTCURLYBRACKET)) return true;
    return false;
  }

  static private boolean jj_3R_15() {
    if (jj_3R_20()) return true;
    return false;
  }

  static private boolean jj_3R_20() {
    if (jj_scan_token(WHILE)) return true;
    return false;
  }

  static private boolean jj_3_3() {
    if (jj_scan_token(ELSE)) return true;
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3R_19() {
    if (jj_scan_token(IF)) return true;
    return false;
  }

  static private boolean jj_3R_14() {
    if (jj_3R_19()) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_3R_22()) return true;
    return false;
  }

  static private boolean jj_3R_23() {
    if (jj_scan_token(IDENT)) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(28)) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_scan_token(30)) return true;
    }
    }
    return false;
  }

  static private boolean jj_3R_18() {
    if (jj_3R_23()) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_3R_21()) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    if (jj_scan_token(IDENT)) return true;
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  static private boolean jj_3R_11() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) {
    jj_scanpos = xsp;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_scan_token(26)) return true;
    }
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3R_9() {
    if (jj_3R_12()) return true;
    if (jj_scan_token(IDENT)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_9()) return true;
    return false;
  }

  static private boolean jj_3R_21() {
    if (jj_scan_token(RETURN)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public JUSTTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[28];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xc000000,0x70000000,0x70000000,0x200,0x70000000,0xf0000000,0xf2000000,0x2000000,0x80000000,0x74200000,0x74200000,0x4200000,0x90060,0x2000000,0x20000,0x40000,0xfc00,0xfc00,0x60,0x60,0x60,0x60,0x180,0x180,0x10000,0x90060,0x80000,0x80000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1b,0x1b,0x1b,0x30,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x30,0x0,0x30,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[3];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public JUST(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JUST(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JUSTTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public JUST(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JUSTTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public JUST(JUSTTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(JUSTTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[41];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 28; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 41; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 3; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
