<html>
<head>
    <meta charset="UTF-8">
    <title>JavaProHW04</title>
    <style>
       <%@include file="/styles/w3.css" %>
    </style>
</head>
<body>
    <div class="w3-container w3-padding">

    <%
    if (request.getSession().getAttribute("inputDone") != null) {
        out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "<span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "<h5>'" + request.getSession().getAttribute("done") + "'</h5>\n</div>" );
                    request.getSession().removeAttribute("inputDone");
     }
     else if (request.getSession().getAttribute("wrongNumber") != null) {
             out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                         "<span onclick=\"this.parentElement.style.display='none'\"\n" +
                         "class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                         "<h5>'" + request.getSession().getAttribute("wrongNumber") + "'</h5>\n</div>" );
                         request.getSession().removeAttribute("wrongNumber");
          }
     %>

        <form method="post" action= "/input" class="w3-selection w3-light-grey w3-padding">
        <label>Enter your name:
            <input type="text" name="name" class="w3-input w3-border w3-round-large" style="width: 30%"><br />
        </label>
        <label>Enter your surname:
            <input type="text" name="surname" class="w3-input w3-border w3-round-large" style="width: 30%"><br />
        </label>
        <label>Enter your mobile phone number:
            <input type="text" name="phoneNumber" class="w3-input w3-border w3-round-large" style="width: 30%"><br />
        </label>
         <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Send</button>
        </form>
        </div>
</body>
</html>