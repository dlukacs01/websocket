var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    // $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/output', function (message) {
            showMessage(
                JSON.parse(message.body).user,
                JSON.parse(message.body).content
            );
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/input", {}, JSON.stringify({
        'username': $("#username").val(), 'body': $("#body").val()
    }));

    // https://stackoverflow.com/questions/8701812/clear-form-after-submission-with-jquery
    $('#websocketform').each(function () {
        this.reset();
    });
}

function showMessage(user, message) {
    $("#messages").append(
        "<tr>" +
        "<td id='col1'>" + user + "</td>" +
        "<td id='col2'>" + message + "</td>" +
        "</tr>"
    );
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendMessage();
    });
});