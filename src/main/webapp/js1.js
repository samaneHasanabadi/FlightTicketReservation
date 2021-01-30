function c(){
    document.getElementById("form2").style.display = "inline-block";
}
    function c2(){
    document.getElementById("form3").style.display = "inline-block";
}
function createTicket(){
    console.log("begin");
    $("#createSubmit").click(function(){
    var $form = $("#addForm");
    var formData = getFormData($form);
    function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
    indexed_array[n['name']] = n['value'];
});

    return indexed_array;
}
    var response = "";
    $.ajax({
    url: 'http://localhost:8080/Welcome/api/tickets',
    type : "POST",
    //dataType : 'json',
    contentType: 'application/json',
    data: JSON.stringify(formData),
    //data : JSON.stringify($("#addForm").serialize()),
    success : function(result) {
    $("#p0").append(JSON.stringify(result));
},
    error: function(xhr, resp, text) {
    console.log(xhr, resp, text);
    response = text;
}
});
    //document.getElementById("p0").innerHTML = JSON.stringify(response);
});
    console.log("end");
};
function searchTicketById(){
    console.log("begin");
    $("#searchById").click(function(){
    var ticketId = parseInt($("#id1").val());
    $.ajax({
    url: 'http://localhost:8080/Welcome/api/tickets/'+ticketId,
    type : "GET",
    success : function(data, status) {
    console.log(data);
    console.log(status);
    console.log("succeed");
    $("#idNumber1").val(data.id);
    $("#name1").val(data.name);
    $("#family1").val(data.family);
    $("#origin1").val(data.origin);
    $("#destination1").val(data.destination);
    $("#date1").val(data.date);
    $("#price1").val(data.price);
    $("#flightNumber1").val(data.flightNumber);
},
    error: function(xhr, resp, text) {
    console.log(xhr, resp, text);
}
});
});
    console.log("end");
};
function modifyTicket(){
    console.log("begin");
    $("#modifySubmit").click(function(){
    var $form = $("#modifyForm");
    var formData = getFormData($form);
    function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
    indexed_array[n['name']] = n['value'];
});

    return indexed_array;
}
    var ticketId = parseInt($("#id1").val());
    $.ajax({
    url: 'http://localhost:8080/Welcome/api/tickets/'+ticketId,
    type : "PUT",
    dataType : 'json',
    contentType: 'application/json',
    data: JSON.stringify(formData),
    success : function(result) {
    $("#p1").append(result);
},
    error: function(xhr, resp, text) {
    console.log(xhr, resp, text);
}
});
});
    console.log("end");
}
function cancelTicketById(){
    console.log("begin");
    $("#cancelSubmit").click(function(){
    var ticketId = parseInt($("#id2").val());
    $.ajax({
    url: 'http://localhost:8080/Welcome/api/tickets/'+ticketId,
    type : "DELETE",
    success : function(data) {
    $("#p2").append(data);
},
    error: function(xhr, resp, text) {
    console.log(xhr, resp, text);
}
});
});
    console.log("end");
};
function showTickets() {
    $("#showTickets").click(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/Welcome/api/tickets",
            success: function (data) {
                $(function() {
                    $.each(data, function(i, f) {
                        var dateFormat = JSON.stringify(f.date);
                        var res = dateFormat.split("-");
                        var day = (res[2].split("\""))[0];
                        var month = res[1];
                        var year = (res[0].split("\""))[1];
                        var newDate = month + "/" + day + "/" + year;
                        var tblRow = "<tr>"+  "<td>" + f.id + "</td>"  + "<td>" + f.name + "</td>" +
                            "<td>" + f.family + "</td>" + "<td>" + f.origin + "</td>" +
                            "<td>" + f.destination + "</td>" + "<td>" + newDate + "</td>" +
                            "<td>" + f.flightNumber + "</td>" + "<td>" + f.price + "</td>"+"</tr>"
                        $(tblRow).appendTo("#ticketdata tbody");
                    });
                });
            }
        });
    });
    console.log("end");
};
function cancelTickets(){
    console.log("begin");
    $("#cancelTickets").click(function(){
    $.ajax({
    url: 'http://localhost:8080/Welcome/api/tickets',
    type : "DELETE",
    success : function(data) {
    $("#p3").append(data);
},
    error: function(xhr, resp, text) {
    console.log(xhr, resp, text);
}
});
});
    console.log("end");
};
function showTickets2() {
    $("#showTickets2").click(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/Welcome/api/tickets",
            success: function (data) {
                $(function() {
                    $.each(data, function(i, f) {
                        var dateFormat = JSON.stringify(f.date);
                        var res = dateFormat.split("-");
                        var day = (res[2].split("\""))[0];
                        var month = res[1];
                        var year = (res[0].split("\""))[1];
                        var newDate = month + "/" + day + "/" + year;
                        var tblRow = "<tr>"+  "<td style=\"display: none\">" + f.id + "</td>"  +
                            "<td>" + f.name + "</td>" +
                            "<td>" + f.family + "</td>" + "<td>" + f.origin + "</td>" +
                            "<td>" + f.destination + "</td>" + "<td>" + newDate + "</td>" +
                            "<td>" + f.flightNumber + "</td>" + "<td>" + f.price + "</td>" +
                            "<td><button type=\"button\" class=\"btn btn-success btn-sm pt-1\">Edit" +
                            "</button><button type=\"button\" class=\"btn btn-danger btn-sm pt-1\">" +
                            "Delete</button></td>"+"</tr>";
                        $(tblRow).appendTo("#ticketdata tbody");
                    });
                });
            }
        });
    });
    console.log("end");
};