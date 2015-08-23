package models

import scala.collection.mutable
import scala.util.Random

object Graph {
  val E: EdgeMap = new EdgeMap()
  val V: VertexMap = new VertexMap()
  def add(e: Edge): Unit =  E.put(new VertexPair(e.v1, e.v2), e)
  def add(e: (Vertex, Vertex)): Unit = add(new Edge(e._1, e._2))
  def add(v: Vertex): Unit =  V.put(v.id, v)
  def v(id: String): Option[Vertex] = V.get(id)
  def e(vp: VertexPair): Option[Edge] = E.get(vp)
  def e(vp: (Vertex, Vertex)): Option[Edge] = E.get(new VertexPair(vp._1, vp._2))
  //change empty to clear
  def empty = {V.clear; E.clear}
  def nextId = Stream.from(1) dropWhile(id => V contains id.toString)
  def addVertices(n: Int): Unit =
    nextId take n foreach (id => add(new Vertex(id.toString)))
  def ring() = {
    E.empty
    val shuffledV = util.Random.shuffle(V.values)
    shuffledV ++ Seq(shuffledV.head) sliding 2 foreach {
      case List(v1, v2) => add(v1, v2)
    }
  }
  def random(k: Double):Unit = {
    E.empty
    V.values.toList.combinations(2) foreach {
      case List(v1, v2) =>
        if (Random.nextDouble() < k) add(v1, v2)
    }
  }
  def random():Unit = {
    random(Random.nextDouble())
  }
}

class EdgeMap() extends mutable.HashMap[VertexPair, Edge] {
  def get(vp: (Vertex, Vertex)): Option[Edge] = get(new VertexPair(vp._1, vp._2))
  def each(f: (Edge) => Any) = foreach { case (key, value) => f(value) }
}

class VertexMap() extends mutable.HashMap[String, Vertex] {
  def each(f: (Vertex) => Any) = foreach { case (key, value) => f(value) }
}

trait Element {
  val props: mutable.HashMap[String,Any] = new mutable.HashMap[String, Any]
  def apply(key: String, value: Any): Unit = props.put(key, value)
  def apply(key: String): Any = props.get(key)
}

class Vertex(val id: String) extends Element {
  var score = 0
  var text = ""
  // Variables defined within this object will be visible only to the player who owns the vertex
  object secret {
    var text = "ssh, it's a secret"
  }

  def ->(that: Vertex):Edge = new Edge(this, that)
  override def toString: String = s"$id"
}

object Vertex {
  def apply(id: String):Vertex = new Vertex(id)
}

case class VertexPair(v1: Vertex, v2: Vertex) {
  override def hashCode = {
    // VertexPairs are equal if they contain the
    // same two vertices regardless of order
    def x = Math.min(v1.hashCode(), v2.hashCode())
    def y = Math.max(v1.hashCode(), v2.hashCode())
    41 * (41 + x) + y
  }

  override def equals(that: Any): Boolean = that match {
    case that: VertexPair => this.hashCode == that.hashCode
    case _ => false
  }
  override def toString:String = s"($v1, $v2)"
}

class Edge (val v1: Vertex, val v2: Vertex) extends Element {
  // An edge may appear differently to the vertex on either side
  // v1Props/v2Props override props for the v1/v2 Vertex respectively
  val v1Props: mutable.HashMap[String,Any] = new mutable.HashMap[String, Any]
  val v2Props: mutable.HashMap[String,Any] = new mutable.HashMap[String, Any]
  def put(v: Vertex, key: String, value: Any) = (if (v == v1) v1Props else v2Props).put(key, value)
  def get(key: String) : Any = props.get(key)
  def get(v: Vertex, key: String) : Any = {
    def vProps = if (v == v1) v1Props else v2Props
    if(vProps.contains(key)) vProps.get(key) else props.get(key)
  }
  override def toString: String = s"${v1.id},${v2.id}"
}
/*def G = Graph
val mark = G.add(Vertex("mark"))
G.addVertices(10)
G.nextId
G.random()
G.E
*/

// arr(i) = 0 === arr.update(i, 0)
// def update(idx: Int, value: T)

// when the core graph changes all player view graphs need to be updated
// () is an empty expression that returns Unit
// DynamicVariable <- Thread Local State
