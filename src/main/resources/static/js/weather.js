var stompClient = null;

function setConnected(connected) {
	var status = "disconnected";
	if (connected) {
		status = "connected";
	}
	document.getElementById('status').innerHTML = status;
}

function connect() {
	var socket = new SockJS('http://localhost:8080/weather');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/weatherinfo', function(weather) {
			showWeather(JSON.parse(weather.body));
		});
	});
}

function disconnect() {
	if (stompClient != null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendPlace() {
	var name = document.getElementById('place').value;
	stompClient.send("/meteosat/weather", {}, JSON.stringify({ 'place': name }));
}

function showWeather(wInfo) {
	var response = document.getElementById('weatherInfo');
	var newInfo = "<p>[" + wInfo.localDateTimeStr + "](" + wInfo.place + "): " + wInfo.type + "</p>"
	var content = response.innerHTML;
	response.innerHTML = content + newInfo;
}