const url = 'http://localhost:8081/fermate'

$(document).ready(function () {
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            var table = ""
            $.each(result, function (idx, obj) {
                table += "<tr>";
                table += "<td>" + obj.id + "</td>";
                table += "<td>" + obj.nome + "</td>";
                table += "<td>" + obj.zona + "</td>";
                table += "</tr>"
            });
            $("#fermate").html(table);
            console.log(result)
        },
        error: function (result) {
            console.log("Server not found")
        }
    })
})