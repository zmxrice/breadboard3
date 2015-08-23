
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
object d3back extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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

"""),format.raw/*10.1*/(""".link """),format.raw/*10.7*/("""{"""),format.raw/*10.8*/("""
  """),format.raw/*11.3*/("""stroke: #999;
  stroke-opacity: .6;
"""),format.raw/*13.1*/("""}"""),format.raw/*13.2*/("""

"""),format.raw/*15.1*/("""</style>
<body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.min.js"></script>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>

var width = 960,
    height = 500
    radius = 6;

var color = d3.scale.category20();

// nodes and links data to be rendered from server
var nodes = new Array(),
    links = new Array();

// not modified by d3 nodes and links
var nodescpy = new Array(),
    linkscpy = new Array();
// hashmap for faster lookup
var nodesMap = """),format.raw/*36.16*/("""{"""),format.raw/*36.17*/("""}"""),format.raw/*36.18*/(""",
    linksMap = """),format.raw/*37.16*/("""{"""),format.raw/*37.17*/("""}"""),format.raw/*37.18*/(""";

var force = d3.layout.force()
    .charge(-120)
    .linkDistance(30)
    .size([width, height]);

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height);

var node = svg.selectAll(".node"),
    link = svg.selectAll(".link");

d3.json("/myjson", function(error, graph) """),format.raw/*51.43*/("""{"""),format.raw/*51.44*/("""
  """),format.raw/*52.3*/("""if (error) throw error;
  nodes = graph.nodes;
  links = graph.links;
  //console.log(JSON.stringify(nodes));
  //console.log(JSON.stringify(links));
  // using jquery array deep copy
  nodescpy = $.extend(true, [], nodes);
  linkscpy = $.extend(true, [], links);
  for (var i=0; i < nodescpy.length; i++)"""),format.raw/*60.42*/("""{"""),format.raw/*60.43*/("""
    """),format.raw/*61.5*/("""nodesMap[nodescpy[i].id] = nodescpy[i];
  """),format.raw/*62.3*/("""}"""),format.raw/*62.4*/("""
  """),format.raw/*63.3*/("""for (var i=0; i < linkscpy.length; i++)"""),format.raw/*63.42*/("""{"""),format.raw/*63.43*/("""
    """),format.raw/*64.5*/("""var key = linkscpy[i].source + "_" + linkscpy[i].target;
    linksMap[key] = linkscpy[i];
  """),format.raw/*66.3*/("""}"""),format.raw/*66.4*/("""
  """),format.raw/*67.3*/("""//console.log(JSON.stringify(nodesMap));
  //console.log(JSON.stringify(linksMap));
  //console.log(linksMap["1_0"]);
  force
      .nodes(nodes)
      .links(links)
      .on("tick", tick);
  start();
"""),format.raw/*75.1*/("""}"""),format.raw/*75.2*/(""");

function start() """),format.raw/*77.18*/("""{"""),format.raw/*77.19*/("""
  """),format.raw/*78.3*/("""link = link.data(links);
  link.enter().append("line")
      .attr("class", "link");
  link.exit().remove();

  node = node.data(nodes);
  node.enter().append("circle")
      .attr("class", "node")
      .attr("r", 5)
      .call(force.drag);
  node.exit().remove();

  force.start();
"""),format.raw/*91.1*/("""}"""),format.raw/*91.2*/("""

"""),format.raw/*93.1*/("""function tick() """),format.raw/*93.17*/("""{"""),format.raw/*93.18*/("""
  """),format.raw/*94.3*/("""node.attr("cx", function(d) """),format.raw/*94.31*/("""{"""),format.raw/*94.32*/(""" """),format.raw/*94.33*/("""return d.x = Math.max(radius, Math.min(width - radius, d.x)); """),format.raw/*94.95*/("""}"""),format.raw/*94.96*/(""")
      .attr("cy", function(d) """),format.raw/*95.31*/("""{"""),format.raw/*95.32*/(""" """),format.raw/*95.33*/("""return d.y = Math.max(radius, Math.min(height - radius, d.y)); """),format.raw/*95.96*/("""}"""),format.raw/*95.97*/(""");

  link.attr("x1", function(d) """),format.raw/*97.31*/("""{"""),format.raw/*97.32*/(""" """),format.raw/*97.33*/("""return d.source.x; """),format.raw/*97.52*/("""}"""),format.raw/*97.53*/(""")
      .attr("y1", function(d) """),format.raw/*98.31*/("""{"""),format.raw/*98.32*/(""" """),format.raw/*98.33*/("""return d.source.y; """),format.raw/*98.52*/("""}"""),format.raw/*98.53*/(""")
      .attr("x2", function(d) """),format.raw/*99.31*/("""{"""),format.raw/*99.32*/(""" """),format.raw/*99.33*/("""return d.target.x; """),format.raw/*99.52*/("""}"""),format.raw/*99.53*/(""")
      .attr("y2", function(d) """),format.raw/*100.31*/("""{"""),format.raw/*100.32*/(""" """),format.raw/*100.33*/("""return d.target.y; """),format.raw/*100.52*/("""}"""),format.raw/*100.53*/(""");
"""),format.raw/*101.1*/("""}"""),format.raw/*101.2*/("""
"""),format.raw/*102.1*/("""function update()"""),format.raw/*102.18*/("""{"""),format.raw/*102.19*/("""
  """),format.raw/*103.3*/("""//console.log("+++++++++");
  //console.log(JSON.stringify(nodesMap));
  //console.log(JSON.stringify(nodescpy));
  //console.log(JSON.stringify(linkscpy));
  d3.json("/myjson", function(error, graph) """),format.raw/*107.45*/("""{"""),format.raw/*107.46*/("""
    """),format.raw/*108.5*/("""if (error) throw error;
    var tempNodes = graph.nodes;
    var tempLinks = graph.links;
    //not modifiable by d3
    var tempnodescpy = $.extend(true, [], tempNodes);
    var templinkscpy = $.extend(true, [], tempLinks);
    var tempNodesMap = """),format.raw/*114.24*/("""{"""),format.raw/*114.25*/("""}"""),format.raw/*114.26*/(""",
        tempLinksMap = """),format.raw/*115.24*/("""{"""),format.raw/*115.25*/("""}"""),format.raw/*115.26*/(""";
    for (var i=0; i < tempnodescpy.length; i++)"""),format.raw/*116.48*/("""{"""),format.raw/*116.49*/("""
      """),format.raw/*117.7*/("""tempNodesMap[tempnodescpy[i].id] = tempnodescpy[i];
    """),format.raw/*118.5*/("""}"""),format.raw/*118.6*/("""
    """),format.raw/*119.5*/("""for (var i=0; i < templinkscpy.length; i++)"""),format.raw/*119.48*/("""{"""),format.raw/*119.49*/("""
      """),format.raw/*120.7*/("""var key = templinkscpy[i].source + "_" + templinkscpy[i].target;
      tempLinksMap[key] = templinkscpy[i];
    """),format.raw/*122.5*/("""}"""),format.raw/*122.6*/("""
    """),format.raw/*123.5*/("""//console.log(JSON.stringify(tempLinks));
    //console.log(JSON.stringify(templinkscpy));
    //console.log(JSON.stringify(linksMap));
    //console.log(JSON.stringify(tempLinksMap));
    var i = 0;
    while (i < linkscpy.length)"""),format.raw/*128.32*/("""{"""),format.raw/*128.33*/("""
      """),format.raw/*129.7*/("""//console.log(i);
      //assume undirected graph
      var key1 = linkscpy[i].source + "_" + linkscpy[i].target;
      var key2 = linkscpy[i].target + "_" + linkscpy[i].source;
      if(tempLinksMap[key1] == undefined && tempLinksMap[key2] == undefined)"""),format.raw/*133.77*/("""{"""),format.raw/*133.78*/("""
        """),format.raw/*134.9*/("""console.log("deleting link " + key1);
        if(linksMap[key1] != undefined)"""),format.raw/*135.40*/("""{"""),format.raw/*135.41*/("""
          """),format.raw/*136.11*/("""delete linksMap[key1];
        """),format.raw/*137.9*/("""}"""),format.raw/*137.10*/("""else if(linksMap[key2] != undefined)"""),format.raw/*137.46*/("""{"""),format.raw/*137.47*/("""
          """),format.raw/*138.11*/("""delete linksMap[key2];
        """),format.raw/*139.9*/("""}"""),format.raw/*139.10*/("""
        """),format.raw/*140.9*/("""links.splice(i,1);
        linkscpy.splice(i,1);
        //start();
      """),format.raw/*143.7*/("""}"""),format.raw/*143.8*/("""
      """),format.raw/*144.7*/("""else"""),format.raw/*144.11*/("""{"""),format.raw/*144.12*/("""
        """),format.raw/*145.9*/("""i += 1;
      """),format.raw/*146.7*/("""}"""),format.raw/*146.8*/("""
    """),format.raw/*147.5*/("""}"""),format.raw/*147.6*/("""

    """),format.raw/*149.5*/("""for (var i=0; i < tempLinks.length; i++)"""),format.raw/*149.45*/("""{"""),format.raw/*149.46*/("""
      """),format.raw/*150.7*/("""//assume undirected graph
      var key1 = templinkscpy[i].source + "_" + templinkscpy[i].target;
      var key2 = templinkscpy[i].target + "_" + templinkscpy[i].source;
      if(linksMap[key1] == undefined && linksMap[key2] == undefined)"""),format.raw/*153.69*/("""{"""),format.raw/*153.70*/("""
        """),format.raw/*154.9*/("""console.log("adding link " + key1);
        linksMap[key1] = templinkscpy[i];
        links.push(tempLinks[i]);
        linkscpy.push(templinkscpy[i]);
        //start();
      """),format.raw/*159.7*/("""}"""),format.raw/*159.8*/("""
    """),format.raw/*160.5*/("""}"""),format.raw/*160.6*/("""

    """),format.raw/*162.5*/("""// if node not found in the tempNodesMap, then delete it from the node list
    var i = 0;
    while (i < nodescpy.length)"""),format.raw/*164.32*/("""{"""),format.raw/*164.33*/("""
      """),format.raw/*165.7*/("""if(tempNodesMap[nodescpy[i].id] == undefined)"""),format.raw/*165.52*/("""{"""),format.raw/*165.53*/("""
        """),format.raw/*166.9*/("""console.log("deleting node " + nodescpy[i].id);
        delete nodesMap[nodescpy[i].id];
        //console.log(JSON.stringify(nodesMap));
        nodes.splice(i,1);
        nodescpy.splice(i,1);
        //start();
      """),format.raw/*172.7*/("""}"""),format.raw/*172.8*/("""else"""),format.raw/*172.12*/("""{"""),format.raw/*172.13*/("""
        """),format.raw/*173.9*/("""i += 1;
      """),format.raw/*174.7*/("""}"""),format.raw/*174.8*/("""
    """),format.raw/*175.5*/("""}"""),format.raw/*175.6*/("""
    """),format.raw/*176.5*/("""// if new one added, then add to the nodes list
    for (var i=0; i < tempNodes.length; i++)"""),format.raw/*177.45*/("""{"""),format.raw/*177.46*/("""
      """),format.raw/*178.7*/("""if(nodesMap[tempnodescpy[i].id] == undefined)"""),format.raw/*178.52*/("""{"""),format.raw/*178.53*/("""
        """),format.raw/*179.9*/("""//console.log(JSON.stringify(tempNodes));
        console.log("adding node "+tempnodescpy[i].id);
        nodesMap[tempnodescpy[i].id] = tempnodescpy[i];
        nodes.push(tempNodes[i]);
        nodescpy.push(tempnodescpy[i]);
        //start();
      """),format.raw/*185.7*/("""}"""),format.raw/*185.8*/("""
    """),format.raw/*186.5*/("""}"""),format.raw/*186.6*/("""
    """),format.raw/*187.5*/("""//console.log(JSON.stringify(links));
    //console.log(links.length);

    start();
  """),format.raw/*191.3*/("""}"""),format.raw/*191.4*/(""");

"""),format.raw/*193.1*/("""}"""),format.raw/*193.2*/("""
"""),format.raw/*194.1*/("""</script>
<button onclick="update()">update</button>
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
                  DATE: Sat Jul 25 21:52:22 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/d3back.scala.html
                  HASH: 4ecd8dcfd5603cccf17ae8724b7b7853a15d5b0c
                  MATRIX: 581->0|661->54|688->55|717->58|780->95|807->96|836->98|869->104|897->105|927->108|990->144|1018->145|1047->147|1579->651|1608->652|1637->653|1682->670|1711->671|1740->672|2081->985|2110->986|2140->989|2473->1294|2502->1295|2534->1300|2603->1342|2631->1343|2661->1346|2728->1385|2757->1386|2789->1391|2908->1483|2936->1484|2966->1487|3195->1689|3223->1690|3272->1711|3301->1712|3331->1715|3643->2000|3671->2001|3700->2003|3744->2019|3773->2020|3803->2023|3859->2051|3888->2052|3917->2053|4007->2115|4036->2116|4096->2148|4125->2149|4154->2150|4245->2213|4274->2214|4336->2248|4365->2249|4394->2250|4441->2269|4470->2270|4530->2302|4559->2303|4588->2304|4635->2323|4664->2324|4724->2356|4753->2357|4782->2358|4829->2377|4858->2378|4919->2410|4949->2411|4979->2412|5027->2431|5057->2432|5088->2435|5117->2436|5146->2437|5192->2454|5222->2455|5253->2458|5483->2659|5513->2660|5546->2665|5823->2913|5853->2914|5883->2915|5937->2940|5967->2941|5997->2942|6075->2991|6105->2992|6140->2999|6224->3055|6253->3056|6286->3061|6358->3104|6388->3105|6423->3112|6563->3224|6592->3225|6625->3230|6885->3461|6915->3462|6950->3469|7233->3723|7263->3724|7300->3733|7406->3810|7436->3811|7476->3822|7535->3853|7565->3854|7630->3890|7660->3891|7700->3902|7759->3933|7789->3934|7826->3943|7928->4017|7957->4018|7992->4025|8025->4029|8055->4030|8092->4039|8134->4053|8163->4054|8196->4059|8225->4060|8259->4066|8328->4106|8358->4107|8393->4114|8660->4352|8690->4353|8727->4362|8932->4539|8961->4540|8994->4545|9023->4546|9057->4552|9208->4674|9238->4675|9273->4682|9347->4727|9377->4728|9414->4737|9662->4957|9691->4958|9724->4962|9754->4963|9791->4972|9833->4986|9862->4987|9895->4992|9924->4993|9957->4998|10078->5090|10108->5091|10143->5098|10217->5143|10247->5144|10284->5153|10565->5406|10594->5407|10627->5412|10656->5413|10689->5418|10804->5505|10833->5506|10865->5510|10894->5511|10923->5512
                  LINES: 22->1|26->5|26->5|27->6|29->8|29->8|31->10|31->10|31->10|32->11|34->13|34->13|36->15|57->36|57->36|57->36|58->37|58->37|58->37|72->51|72->51|73->52|81->60|81->60|82->61|83->62|83->62|84->63|84->63|84->63|85->64|87->66|87->66|88->67|96->75|96->75|98->77|98->77|99->78|112->91|112->91|114->93|114->93|114->93|115->94|115->94|115->94|115->94|115->94|115->94|116->95|116->95|116->95|116->95|116->95|118->97|118->97|118->97|118->97|118->97|119->98|119->98|119->98|119->98|119->98|120->99|120->99|120->99|120->99|120->99|121->100|121->100|121->100|121->100|121->100|122->101|122->101|123->102|123->102|123->102|124->103|128->107|128->107|129->108|135->114|135->114|135->114|136->115|136->115|136->115|137->116|137->116|138->117|139->118|139->118|140->119|140->119|140->119|141->120|143->122|143->122|144->123|149->128|149->128|150->129|154->133|154->133|155->134|156->135|156->135|157->136|158->137|158->137|158->137|158->137|159->138|160->139|160->139|161->140|164->143|164->143|165->144|165->144|165->144|166->145|167->146|167->146|168->147|168->147|170->149|170->149|170->149|171->150|174->153|174->153|175->154|180->159|180->159|181->160|181->160|183->162|185->164|185->164|186->165|186->165|186->165|187->166|193->172|193->172|193->172|193->172|194->173|195->174|195->174|196->175|196->175|197->176|198->177|198->177|199->178|199->178|199->178|200->179|206->185|206->185|207->186|207->186|208->187|212->191|212->191|214->193|214->193|215->194
                  -- GENERATED --
              */
          