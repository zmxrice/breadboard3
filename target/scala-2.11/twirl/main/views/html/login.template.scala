
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
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<html lang="en">
  <head>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="748044806775-mpbqu1h1ghd1p4mp7l9mq4c3b5sp97bb.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <title>Login</title>
  </head>
  <body>
    <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
    <script>
      var client_id = "748044806775-mpbqu1h1ghd1p4mp7l9mq4c3b5sp97bb.apps.googleusercontent.com";
      function onSignIn(googleUser) """),format.raw/*13.37*/("""{"""),format.raw/*13.38*/("""
        """),format.raw/*14.9*/("""// The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        var url = "https://www.googleapis.com/oauth2/v3/tokeninfo?id_token="+id_token;
        $.get( url, function( data ) """),format.raw/*17.38*/("""{"""),format.raw/*17.39*/("""
          """),format.raw/*18.11*/("""if(data.aud == client_id)"""),format.raw/*18.36*/("""{"""),format.raw/*18.37*/("""
            """),format.raw/*19.13*/("""console.log(data);
            console.log(data.sub);
          """),format.raw/*21.11*/("""}"""),format.raw/*21.12*/("""
        """),format.raw/*22.9*/("""}"""),format.raw/*22.10*/(""");
      """),format.raw/*23.7*/("""}"""),format.raw/*23.8*/("""
    """),format.raw/*24.5*/("""</script>

    <a href="#" onclick="signOut();">Sign out</a>
    <script>
      function signOut() """),format.raw/*28.26*/("""{"""),format.raw/*28.27*/("""
        """),format.raw/*29.9*/("""var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () """),format.raw/*30.42*/("""{"""),format.raw/*30.43*/("""
          """),format.raw/*31.11*/("""console.log('User signed out.');
        """),format.raw/*32.9*/("""}"""),format.raw/*32.10*/(""");
      """),format.raw/*33.7*/("""}"""),format.raw/*33.8*/("""
    """),format.raw/*34.5*/("""</script>
  </body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Jul 25 11:06:00 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/login.scala.html
                  HASH: b591e2ca49ad7a6e1390653c47984c31fceaa11b
                  MATRIX: 580->0|1241->633|1270->634|1306->643|1570->879|1599->880|1638->891|1691->916|1720->917|1761->930|1853->994|1882->995|1918->1004|1947->1005|1983->1014|2011->1015|2043->1020|2170->1119|2199->1120|2235->1129|2346->1212|2375->1213|2414->1224|2482->1265|2511->1266|2547->1275|2575->1276|2607->1281
                  LINES: 22->1|34->13|34->13|35->14|38->17|38->17|39->18|39->18|39->18|40->19|42->21|42->21|43->22|43->22|44->23|44->23|45->24|49->28|49->28|50->29|51->30|51->30|52->31|53->32|53->32|54->33|54->33|55->34
                  -- GENERATED --
              */
          