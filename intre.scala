
// Interpretation of Fopix programs

// TODO : To finish !

package trac.fopix

import trac.javix.AST.{Ificmp, Instruction}

object Interp {

  import scala.annotation.tailrec
  import scala.collection.mutable.{Map => MutableMap}
  import trac._
  import trac.fopix.AST._
  import trac.PrimOp._

  type Address = Int

  type Block = Array[Result]
  type Memory = MutableMap[Address,Block]


  type Env = Map[Ident,Result]  // immutable map of variables
  type Defs = Map[FunIdent, (List[Ident], Expr)]

  sealed abstract class Result {
    // Customized pretty-print of interpretation results
    override def toString : String =
      this match {
        case RUnit => "()"
        case RInt(n) => n.toString
        case RStr(s) => "\""+s+"\""
        case RBool(b) => b.toString
        case RBlk(a) => "@" + a.toString
        case RFun(f,args) => f + args.mkString("(", ",", ")")
      }
  }

  case object RUnit                                extends Result
  case class RInt (n:Int)                          extends Result
  case class RStr (s:String)                       extends Result
  case class RBool (b:Boolean)                     extends Result
  case class RBlk (a:Address)                      extends Result
  case class RFun (f:FunIdent, args:List[Result])  extends Result

  def getInt (r:Result,msg:String) : Int =
    r match {
      case RInt(n) => n
      case _ => throw new Invalid(msg + " is not an integer")
    }

  // NB: in RFun, args is empty unless you try to accept partial application
  // and over-applications

  // Global mutable elements for interpretation :

  var allPrints : List[String] = List()
  var memsize = 0
  val mem : Memory = MutableMap.empty

  def reset () : Unit = {
    allPrints = List()
    memsize = 0
    mem.clear()
  }

  def eval (p:Program) : String = {
    reset()
    val initEnv : Env = Map.empty
    eval(initEnv,p)
    StringContext.processEscapes(allPrints.reverse.mkString)
  }

  def eval (env:Env,p:Program) : Env =
    p match {
      case Nil => env
      case Val(x,e) :: p => eval(env + (x -> eval(env,e)), p)
      case Def(_,_,_) :: p => eval(env,p)
    }

  def eval(env:Env,e:Expr) : Result =
    e match {
      case Num(n) => RInt(n)
      case Str(s) => RStr(s)
      case Var(v) => env(v)
      case Fun(f) => RFun(f,List())
      case Op(o,e1,e2) => binop(o,eval(env,e1),eval(env,e2))
      case If(e1,e2,e3) => evalIf(env,e1,e2,e3)//***Done***//
      case Let(x,e1,e2) => eval(env + (x -> eval(env,e1)), e2)//***Done***//
      case Prim(p,l) => prim(p,l.map(eval(env,_)))
      case Call(e,l) => evalCall(eval(env,e),l.map(eval(env,_))) //***To DO***//
    }

  //*******for if***************//
  def evalIf(env: Env, e1 : Expr,e2 : Expr,e3 : Expr): Result = eval(env, e1) match {
    case RBool(true) =>eval(env, e2)
    case RBool(false) =>eval(env, e3)
    case _ => throw new Invalid("Error in condition, Boolean required!!")
  }
  //********end if**********//

  //*********for call ********//
  def evalCall(result : Result, l: List[Result]): Result = result match{
    case RFun(f,l) => RFun(f,l)
    case _ => throw new Invalid("It's not a function call !!")
  }




  //*********end call*************//
  def binop(o:BinOp.T,r1:Result,r2:Result) : Result = {
    val msg = "Binop argument"
    val n1 = getInt(r1,msg)
    val n2 = getInt(r2,msg)
    if (BinOp.isArith(o))
      RInt(IntOp.eval(BinOp.toArith(o),n1,n2))
    else
      RBool(CompOp.eval(BinOp.toCmp(o),n1,n2))
  }

  def prim(p:PrimOp.T,args:List[Result]) : Result =
    (p,args) match {
      case (Printint,List(RInt(n))) => allPrints = n.toString :: allPrints; RUnit
      case (Printstr,List(RStr(s))) => allPrints = s :: allPrints; RUnit
      //case (New,List()) =>
      //case (Set,List()) =>
     // case (Get,List()) =>
      //case (Cat,List(RStr(s1), RStr(s2))) =>  RStr(s1) + RStr(s2)
      //case (Tuple,List(el)) =>
      case _ => throw new Invalid("Unsupported primitive call (TODO ? bad arg ?)")
    }

}