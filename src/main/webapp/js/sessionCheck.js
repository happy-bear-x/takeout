var globalLastSessionTime = new Date();

calcSessionTime = function() {
	var now = new Date();
	var past = now - globalLastSessionTime;// ms
	if (past > 30 * 60 * 1000) {
		location.reload();
	}
}

setSessionTime = function() {
	globalLastSessionTime = new Date();
	// alert(globalLastSessionTime);
}

DWREngine.setPreHook(setSessionTime);
