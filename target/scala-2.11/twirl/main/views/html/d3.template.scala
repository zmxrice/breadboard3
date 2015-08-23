
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object d3 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<meta charset="utf-8">
<style>

.node """),format.raw/*5.7*/("""{"""),format.raw/*5.8*/("""
  """),format.raw/*6.3*/("""stroke: #fff;
  stroke-width: 1.5px;
"""),format.raw/*8.1*/("""}"""),format.raw/*8.2*/("""
"""),format.raw/*9.1*/(""".node[test = "33"]"""),format.raw/*9.19*/("""{"""),format.raw/*9.20*/("""
  """),format.raw/*10.3*/("""fill:red;
"""),format.raw/*11.1*/("""}"""),format.raw/*11.2*/("""
"""),format.raw/*12.1*/(""".link """),format.raw/*12.7*/("""{"""),format.raw/*12.8*/("""
  """),format.raw/*13.3*/("""stroke: #999;
  stroke-opacity: .6;
"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/("""
"""),format.raw/*16.1*/(""".link[target = "0"]"""),format.raw/*16.20*/("""{"""),format.raw/*16.21*/("""
  """),format.raw/*17.3*/("""stroke:red;
"""),format.raw/*18.1*/("""}"""),format.raw/*18.2*/("""
"""),format.raw/*19.1*/(""".test """),format.raw/*19.7*/("""{"""),format.raw/*19.8*/("""
  """),format.raw/*20.3*/("""fill: red;
"""),format.raw/*21.1*/("""}"""),format.raw/*21.2*/("""

"""),format.raw/*23.1*/("""</style>
<body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.min.js"></script>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>

var width = 960,
    height = 500
    radius = 6;

var color = d3.scale.category20();

// nodes and links data to be rendered from server
var nodes = [],
    links = [];

// not modified by d3 nodes and links
var nodescpy = [],
    linkscpy = [];
// hashmap for faster lookup
var nodesMap = """),format.raw/*44.16*/("""{"""),format.raw/*44.17*/("""}"""),format.raw/*44.18*/(""",
    linksMap = """),format.raw/*45.16*/("""{"""),format.raw/*45.17*/("""}"""),format.raw/*45.18*/(""";

var force = d3.layout.force()
    .charge(-120)
    .linkDistance(30)
    .size([width, height]);

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height);

var node = svg.selectAll(".node"),
    link = svg.selectAll(".link");

function newGraph()"""),format.raw/*59.20*/("""{"""),format.raw/*59.21*/("""
  """),format.raw/*60.3*/("""d3.json("/myjson", function(error, graph) """),format.raw/*60.45*/("""{"""),format.raw/*60.46*/("""
    """),format.raw/*61.5*/("""if (error) throw error;
    nodesMap = """),format.raw/*62.16*/("""{"""),format.raw/*62.17*/("""}"""),format.raw/*62.18*/(""";
    linksMap = """),format.raw/*63.16*/("""{"""),format.raw/*63.17*/("""}"""),format.raw/*63.18*/(""";
    nodes = graph.nodes;
    links = graph.links;
    //console.log(JSON.stringify(nodes));
    //console.log(JSON.stringify(links));
    // using jquery array deep copy
    nodescpy = $.extend(true, [], nodes);
    linkscpy = $.extend(true, [], links);
    for (var i=0; i < nodescpy.length; i++)"""),format.raw/*71.44*/("""{"""),format.raw/*71.45*/("""
      """),format.raw/*72.7*/("""nodesMap[nodescpy[i].id] = nodescpy[i];
    """),format.raw/*73.5*/("""}"""),format.raw/*73.6*/("""
    """),format.raw/*74.5*/("""for (var i=0; i < linkscpy.length; i++)"""),format.raw/*74.44*/("""{"""),format.raw/*74.45*/("""
      """),format.raw/*75.7*/("""var key = linkscpy[i].source + "_" + linkscpy[i].target;
      linksMap[key] = linkscpy[i];
    """),format.raw/*77.5*/("""}"""),format.raw/*77.6*/("""
    """),format.raw/*78.5*/("""//console.log(JSON.stringify(nodesMap));
    //console.log(JSON.stringify(linksMap));
    //console.log(linksMap["1_0"]);
    force
        .nodes(nodes)
        .links(links)
        .on("tick", tick);
    start();
  """),format.raw/*86.3*/("""}"""),format.raw/*86.4*/(""");
"""),format.raw/*87.1*/("""}"""),format.raw/*87.2*/("""

"""),format.raw/*89.1*/("""function start() """),format.raw/*89.18*/("""{"""),format.raw/*89.19*/("""
  """),format.raw/*90.3*/("""link = link.data(links);
  link.enter().append("line")
      .attr("class", "link")
      .each(function (d) """),format.raw/*93.26*/("""{"""),format.raw/*93.27*/("""
        """),format.raw/*94.9*/("""d3.select(this).attr(d)
      """),format.raw/*95.7*/("""}"""),format.raw/*95.8*/(""");
  link.exit().remove();

  node = node.data(nodes);
  //console.log(node);
  node.enter().append("circle")
      .attr("class", "node")
      .attr("r", 5)
      .each(function (d) """),format.raw/*103.26*/("""{"""),format.raw/*103.27*/("""
        """),format.raw/*104.9*/("""d3.select(this).attr(d)
      """),format.raw/*105.7*/("""}"""),format.raw/*105.8*/(""")
      .call(force.drag);
  node.exit().remove();

  force.start();
"""),format.raw/*110.1*/("""}"""),format.raw/*110.2*/("""

"""),format.raw/*112.1*/("""function tick() """),format.raw/*112.17*/("""{"""),format.raw/*112.18*/("""
  """),format.raw/*113.3*/("""node.attr("cx", function(d) """),format.raw/*113.31*/("""{"""),format.raw/*113.32*/(""" """),format.raw/*113.33*/("""return d.x = Math.max(radius, Math.min(width - radius, d.x)); """),format.raw/*113.95*/("""}"""),format.raw/*113.96*/(""")
      .attr("cy", function(d) """),format.raw/*114.31*/("""{"""),format.raw/*114.32*/(""" """),format.raw/*114.33*/("""return d.y = Math.max(radius, Math.min(height - radius, d.y)); """),format.raw/*114.96*/("""}"""),format.raw/*114.97*/(""");

  link.attr("x1", function(d) """),format.raw/*116.31*/("""{"""),format.raw/*116.32*/(""" """),format.raw/*116.33*/("""return d.source.x; """),format.raw/*116.52*/("""}"""),format.raw/*116.53*/(""")
      .attr("y1", function(d) """),format.raw/*117.31*/("""{"""),format.raw/*117.32*/(""" """),format.raw/*117.33*/("""return d.source.y; """),format.raw/*117.52*/("""}"""),format.raw/*117.53*/(""")
      .attr("x2", function(d) """),format.raw/*118.31*/("""{"""),format.raw/*118.32*/(""" """),format.raw/*118.33*/("""return d.target.x; """),format.raw/*118.52*/("""}"""),format.raw/*118.53*/(""")
      .attr("y2", function(d) """),format.raw/*119.31*/("""{"""),format.raw/*119.32*/(""" """),format.raw/*119.33*/("""return d.target.y; """),format.raw/*119.52*/("""}"""),format.raw/*119.53*/(""");
"""),format.raw/*120.1*/("""}"""),format.raw/*120.2*/("""

"""),format.raw/*122.1*/("""function update()"""),format.raw/*122.18*/("""{"""),format.raw/*122.19*/("""
  """),format.raw/*123.3*/("""//console.log("+++++++++");
  //console.log(JSON.stringify(nodesMap));
  //console.log(JSON.stringify(nodescpy));
  //console.log(JSON.stringify(linkscpy));
  d3.json("/myjson", function(error, graph) """),format.raw/*127.45*/("""{"""),format.raw/*127.46*/("""
    """),format.raw/*128.5*/("""if (error) throw error;
    var tempNodes = graph.nodes;
    var tempLinks = graph.links;
    //not modifiable by d3
    var tempnodescpy = $.extend(true, [], tempNodes);
    var templinkscpy = $.extend(true, [], tempLinks);
    var tempNodesMap = """),format.raw/*134.24*/("""{"""),format.raw/*134.25*/("""}"""),format.raw/*134.26*/(""",
        tempLinksMap = """),format.raw/*135.24*/("""{"""),format.raw/*135.25*/("""}"""),format.raw/*135.26*/(""";
    for (var i=0; i < tempnodescpy.length; i++)"""),format.raw/*136.48*/("""{"""),format.raw/*136.49*/("""
      """),format.raw/*137.7*/("""tempNodesMap[tempnodescpy[i].id] = tempnodescpy[i];
    """),format.raw/*138.5*/("""}"""),format.raw/*138.6*/("""
    """),format.raw/*139.5*/("""for (var i=0; i < templinkscpy.length; i++)"""),format.raw/*139.48*/("""{"""),format.raw/*139.49*/("""
      """),format.raw/*140.7*/("""var key = templinkscpy[i].source + "_" + templinkscpy[i].target;
      tempLinksMap[key] = templinkscpy[i];
    """),format.raw/*142.5*/("""}"""),format.raw/*142.6*/("""
    """),format.raw/*143.5*/("""//console.log(JSON.stringify(tempLinks));
    //console.log(JSON.stringify(templinkscpy));
    //console.log(JSON.stringify(linksMap));
    //console.log(JSON.stringify(tempLinksMap));
    // link deletion
    var i = 0;
    while (i < linkscpy.length)"""),format.raw/*149.32*/("""{"""),format.raw/*149.33*/("""
      """),format.raw/*150.7*/("""//console.log(i);
      //assume undirected graph
      var key1 = linkscpy[i].source + "_" + linkscpy[i].target;
      var key2 = linkscpy[i].target + "_" + linkscpy[i].source;
      if(tempLinksMap[key1] == undefined && tempLinksMap[key2] == undefined)"""),format.raw/*154.77*/("""{"""),format.raw/*154.78*/("""
        """),format.raw/*155.9*/("""console.log("deleting link " + key1);
        if(linksMap[key1] != undefined)"""),format.raw/*156.40*/("""{"""),format.raw/*156.41*/("""
          """),format.raw/*157.11*/("""delete linksMap[key1];
        """),format.raw/*158.9*/("""}"""),format.raw/*158.10*/("""else if(linksMap[key2] != undefined)"""),format.raw/*158.46*/("""{"""),format.raw/*158.47*/("""
          """),format.raw/*159.11*/("""delete linksMap[key2];
        """),format.raw/*160.9*/("""}"""),format.raw/*160.10*/("""
        """),format.raw/*161.9*/("""links.splice(i,1);
        linkscpy.splice(i,1);
        //start();
      """),format.raw/*164.7*/("""}"""),format.raw/*164.8*/("""
      """),format.raw/*165.7*/("""else"""),format.raw/*165.11*/("""{"""),format.raw/*165.12*/("""
        """),format.raw/*166.9*/("""i += 1;
      """),format.raw/*167.7*/("""}"""),format.raw/*167.8*/("""
    """),format.raw/*168.5*/("""}"""),format.raw/*168.6*/("""

    """),format.raw/*170.5*/("""// link addition
    for (var i=0; i < tempLinks.length; i++)"""),format.raw/*171.45*/("""{"""),format.raw/*171.46*/("""
      """),format.raw/*172.7*/("""//assume undirected graph
      var key1 = templinkscpy[i].source + "_" + templinkscpy[i].target;
      var key2 = templinkscpy[i].target + "_" + templinkscpy[i].source;
      if(linksMap[key1] == undefined && linksMap[key2] == undefined)"""),format.raw/*175.69*/("""{"""),format.raw/*175.70*/("""
        """),format.raw/*176.9*/("""console.log("adding link " + key1);
        linksMap[key1] = templinkscpy[i];
        links.push(tempLinks[i]);
        linkscpy.push(templinkscpy[i]);
        //start();
      """),format.raw/*181.7*/("""}"""),format.raw/*181.8*/("""
    """),format.raw/*182.5*/("""}"""),format.raw/*182.6*/("""

    """),format.raw/*184.5*/("""// if new node added, then add to the nodes list
    for (var i=0; i < tempNodes.length; i++)"""),format.raw/*185.45*/("""{"""),format.raw/*185.46*/("""
      """),format.raw/*186.7*/("""if(nodesMap[tempnodescpy[i].id] == undefined)"""),format.raw/*186.52*/("""{"""),format.raw/*186.53*/("""
        """),format.raw/*187.9*/("""//console.log(JSON.stringify(tempNodes));
        console.log("adding node "+tempnodescpy[i].id);
        nodesMap[tempnodescpy[i].id] = tempnodescpy[i];
        nodes.push(tempNodes[i]);
        nodescpy.push(tempnodescpy[i]);
        //start();
      """),format.raw/*193.7*/("""}"""),format.raw/*193.8*/("""
    """),format.raw/*194.5*/("""}"""),format.raw/*194.6*/("""

    """),format.raw/*196.5*/("""// if node not found in the tempNodesMap, then delete it from the node list
    var i = 0;
    while (i < nodescpy.length)"""),format.raw/*198.32*/("""{"""),format.raw/*198.33*/("""
      """),format.raw/*199.7*/("""if(tempNodesMap[nodescpy[i].id] == undefined)"""),format.raw/*199.52*/("""{"""),format.raw/*199.53*/("""
        """),format.raw/*200.9*/("""console.log("deleting node " + nodescpy[i].id);
        delete nodesMap[nodescpy[i].id];
        //console.log(JSON.stringify(nodesMap));
        nodes.splice(i,1);
        nodescpy.splice(i,1);
        //start();
      """),format.raw/*206.7*/("""}"""),format.raw/*206.8*/("""else"""),format.raw/*206.12*/("""{"""),format.raw/*206.13*/("""
        """),format.raw/*207.9*/("""i += 1;
      """),format.raw/*208.7*/("""}"""),format.raw/*208.8*/("""
    """),format.raw/*209.5*/("""}"""),format.raw/*209.6*/("""

    """),format.raw/*211.5*/("""//console.log(JSON.stringify(links));
    //console.log(links.length);
    console.log("++++++++++++++++++++++++++++++++++++++++");
    start();
  """),format.raw/*215.3*/("""}"""),format.raw/*215.4*/(""");

"""),format.raw/*217.1*/("""}"""),format.raw/*217.2*/("""
"""),format.raw/*218.1*/("""// create a new graph when loading the page
newGraph();
</script>
<button onclick="update()">update</button>
<button onclick="newGraph()">new</button>
<body>
<body>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Aug 04 14:06:52 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/d3.scala.html
                  HASH: d05b0b4981f716281720361515c88f869bdaf701
                  MATRIX: 577->0|657->54|684->55|713->58|776->95|803->96|830->97|875->115|903->116|933->119|970->129|998->130|1026->131|1059->137|1087->138|1117->141|1180->177|1208->178|1236->179|1283->198|1312->199|1342->202|1381->214|1409->215|1437->216|1470->222|1498->223|1528->226|1566->237|1594->238|1623->240|2119->708|2148->709|2177->710|2222->727|2251->728|2280->729|2598->1019|2627->1020|2657->1023|2727->1065|2756->1066|2788->1071|2855->1110|2884->1111|2913->1112|2958->1129|2987->1130|3016->1131|3343->1430|3372->1431|3406->1438|3477->1482|3505->1483|3537->1488|3604->1527|3633->1528|3667->1535|3790->1631|3818->1632|3850->1637|4095->1855|4123->1856|4153->1859|4181->1860|4210->1862|4255->1879|4284->1880|4314->1883|4451->1992|4480->1993|4516->2002|4573->2032|4601->2033|4814->2217|4844->2218|4881->2227|4939->2257|4968->2258|5065->2327|5094->2328|5124->2330|5169->2346|5199->2347|5230->2350|5287->2378|5317->2379|5347->2380|5438->2442|5468->2443|5529->2475|5559->2476|5589->2477|5681->2540|5711->2541|5774->2575|5804->2576|5834->2577|5882->2596|5912->2597|5973->2629|6003->2630|6033->2631|6081->2650|6111->2651|6172->2683|6202->2684|6232->2685|6280->2704|6310->2705|6371->2737|6401->2738|6431->2739|6479->2758|6509->2759|6540->2762|6569->2763|6599->2765|6645->2782|6675->2783|6706->2786|6936->2987|6966->2988|6999->2993|7276->3241|7306->3242|7336->3243|7390->3268|7420->3269|7450->3270|7528->3319|7558->3320|7593->3327|7677->3383|7706->3384|7739->3389|7811->3432|7841->3433|7876->3440|8016->3552|8045->3553|8078->3558|8359->3810|8389->3811|8424->3818|8707->4072|8737->4073|8774->4082|8880->4159|8910->4160|8950->4171|9009->4202|9039->4203|9104->4239|9134->4240|9174->4251|9233->4282|9263->4283|9300->4292|9402->4366|9431->4367|9466->4374|9499->4378|9529->4379|9566->4388|9608->4402|9637->4403|9670->4408|9699->4409|9733->4415|9823->4476|9853->4477|9888->4484|10155->4722|10185->4723|10222->4732|10427->4909|10456->4910|10489->4915|10518->4916|10552->4922|10674->5015|10704->5016|10739->5023|10813->5068|10843->5069|10880->5078|11161->5331|11190->5332|11223->5337|11252->5338|11286->5344|11437->5466|11467->5467|11502->5474|11576->5519|11606->5520|11643->5529|11891->5749|11920->5750|11953->5754|11983->5755|12020->5764|12062->5778|12091->5779|12124->5784|12153->5785|12187->5791|12362->5938|12391->5939|12423->5943|12452->5944|12481->5945
                  LINES: 22->1|26->5|26->5|27->6|29->8|29->8|30->9|30->9|30->9|31->10|32->11|32->11|33->12|33->12|33->12|34->13|36->15|36->15|37->16|37->16|37->16|38->17|39->18|39->18|40->19|40->19|40->19|41->20|42->21|42->21|44->23|65->44|65->44|65->44|66->45|66->45|66->45|80->59|80->59|81->60|81->60|81->60|82->61|83->62|83->62|83->62|84->63|84->63|84->63|92->71|92->71|93->72|94->73|94->73|95->74|95->74|95->74|96->75|98->77|98->77|99->78|107->86|107->86|108->87|108->87|110->89|110->89|110->89|111->90|114->93|114->93|115->94|116->95|116->95|124->103|124->103|125->104|126->105|126->105|131->110|131->110|133->112|133->112|133->112|134->113|134->113|134->113|134->113|134->113|134->113|135->114|135->114|135->114|135->114|135->114|137->116|137->116|137->116|137->116|137->116|138->117|138->117|138->117|138->117|138->117|139->118|139->118|139->118|139->118|139->118|140->119|140->119|140->119|140->119|140->119|141->120|141->120|143->122|143->122|143->122|144->123|148->127|148->127|149->128|155->134|155->134|155->134|156->135|156->135|156->135|157->136|157->136|158->137|159->138|159->138|160->139|160->139|160->139|161->140|163->142|163->142|164->143|170->149|170->149|171->150|175->154|175->154|176->155|177->156|177->156|178->157|179->158|179->158|179->158|179->158|180->159|181->160|181->160|182->161|185->164|185->164|186->165|186->165|186->165|187->166|188->167|188->167|189->168|189->168|191->170|192->171|192->171|193->172|196->175|196->175|197->176|202->181|202->181|203->182|203->182|205->184|206->185|206->185|207->186|207->186|207->186|208->187|214->193|214->193|215->194|215->194|217->196|219->198|219->198|220->199|220->199|220->199|221->200|227->206|227->206|227->206|227->206|228->207|229->208|229->208|230->209|230->209|232->211|236->215|236->215|238->217|238->217|239->218
                  -- GENERATED --
              */
          