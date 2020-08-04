<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>VEXOM-You Marketing Place</title>
    <link rel="shortcut icon" href="/IMG/logo.png" />

    <link rel="stylesheet" href="/CSS/style.css" />
  </head>
  <body>
    <div class="wrapper">
      <%@ include file="Partials/sidebar.jsp" %>
      <main class="content">
        <%@ include file="Partials/navbar.jsp" %>
        <div class="main-container text-light">
          <div style="position: relative; top: 10rem">
            <h3>Terms and Conditions</h3>
            <p style="font-size: 32;">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ut,
              maiores modi, placeat ratione in fugiat eveniet ducimus, assumenda
              ab reiciendis mollitia laboriosam eius. Voluptas quia laborum
              provident aliquid tempore doloribus. Lorem ipsum dolor sit amet
              consectetur, adipisicing elit. Velit consequatur voluptates
              facilis ipsa consequuntur quibusdam explicabo quis harum aliquam.
              Nostrum, expedita reiciendis labore ex molestiae maxime amet
              repellat tempora dolore? Lorem, ipsum dolor sit amet consectetur
              adipisicing elit. Repellendus doloremque iste nostrum. Iste modi,
              adipisci minus id doloribus totam saepe nam consequatur quas
              voluptatem nemo, a eos, inventore earum maiores! Lorem ipsum dolor
              sit amet consectetur adipisicing elit. Rem cumque suscipit ipsa
              laboriosam distinctio aliquid, eaque inventore itaque blanditiis.
              Cum laudantium reprehenderit obcaecati accusantium veritatis iste
              iusto eligendi possimus officiis!
            </p>
            <form action="/sec/BeASeller" method="POST">
              <input type="submit" class="btn btn-success"/>
              <input
                type="hidden"
                name="${_csrf.parameterName}"
                value="${_csrf.token}"
              />
            </form>
          </div>
        </div>
      </main>
    </div>
    <div id="overlay" class="overlay"></div>
    <script type="application/javascript" src="/JS/bundle.js"></script>
  </body>
</html>
