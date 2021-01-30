<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="Css.css">
    <script src="js1.js"></script>
    <meta charset="UTF-8">
    <title>Airplane Ticket</title>
    <h3 style="alignment: center">Airplane Ticket Form</h3>
</head>
<body>
<div>
    <form id="addForm" method="post">
        <label for="name">name</label>
        <input type="text" name="name" id="name">
        <label for="family">family</label>
        <input type="text" name="family" id="family">
        <label for="origin">origin</label>
        <input type="text" name="origin" id="origin">
        <br>
        <label for="destination">destination</label>
        <input type="text" name="destination" id="destination">
        <label for="date">date</label>
        <input type="date" name="date" id="date">
        <label for="flightNumber">flightNumber</label>
        <input type="number" name="flightNumber" id="flightNumber">
        <br>
        <label for="price">price</label>
        <input type="number" name="price" id="price">
    </form>
    <button id="createSubmit" onclick="createTicket()">buy</button>
    <p id="p0">
    </p>
</div>
<br>
<h4 style="align-content: center">Modify Ticket</h4>
<div style="width: 50%;">
    <p id="p1">
    </p>
    <form id="searchById1" action="modifyTicket" method="post"><br><br>
        <label for="id1">id</label>
        <input type="text" name="id1" id="id1">
    </form>
    <button id="searchById" onclick="searchTicketById()">search</button>
    <br>
    <button onclick="c()">show ticket</button>
    <br>
    <div id="form2" style="display: none">
        <form id="modifyForm" action="updateTicket" method="post">
            <label for="idNumber1">id</label>
            <input type="number" name="id" id="idNumber1">
            <label for="name1">name</label>
            <input type="text" name="name" id="name1">
            <br>
            <label for="family1">family</label>
            <input type="text" name="family" id="family1">
            <label for="origin1">origin</label>
            <input type="text" name="origin" id="origin1">
            <br>
            <label for="destination1">destination</label>
            <input type="text" name="destination" id="destination1">
            <label for="date1">date</label>
            <input type="date" name="date" id="date1">
            <br>
            <label for="flightNumber1">flightNumber</label>
            <input type="number" name="flightNumber" id="flightNumber1">
            <label for="price1">price</label>
            <input type="number" name="price" id="price1">
            <br>
        </form>
        <button id="modifySubmit" onclick="modifyTicket()">modify</button>
    </div>
</div>
<br>
<h4 style="alignment: center">Cancel Ticket</h4>
<div style="width: 50%;">
    <p id="p2">
    </p>
    <form action="deleteTicket" method="post"><br><br>
        <label for="id2">id</label>
        <input type="number" name="id2" id="id2">
    </form>
    <button id="cancelSubmit" onclick="cancelTicketById()">cancel</button>
</div>
<br>
<h4 style="alignment: center">Show Tickets</h4>
<div style="width: 50%;">
    <button id ="showTickets" onclick="showTickets()">show tickets</button>
    <div class="profile">
        <table id= "ticketdata" border="2">
            <thead>
            <th>id</th>
            <th>name</th>
            <th>family</th>
            <th>origin</th>
            <th>destination</th>
            <th>date</th>
            <th>flight number</th>
            <th>price</th>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>
<h4 style="alignment: center">Cancel Tickets</h4>
<div style="width: 50%;">
    <p id="p3">
    </p>
    <button id ="cancelTickets" onclick="cancelTickets()">cancel tickets</button>
</div>
</body>
</html>